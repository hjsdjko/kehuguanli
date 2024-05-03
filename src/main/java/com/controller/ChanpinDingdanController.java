
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 产品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpinDingdan")
public class ChanpinDingdanController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinDingdanController.class);

    private static final String TABLE_NAME = "chanpinDingdan";

    @Autowired
    private ChanpinDingdanService chanpinDingdanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaozuorizhiService caozuorizhiService;//操作日志
    @Autowired
    private ChanpinService chanpinService;//产品
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private KehuService kehuService;//客户
    @Autowired
    private KehuFankuiService kehuFankuiService;//反馈建议
    @Autowired
    private KehuFuwuService kehuFuwuService;//客户服务
    @Autowired
    private KehuLiushiService kehuLiushiService;//客户流失
    @Autowired
    private KehuZoufangService kehuZoufangService;//客户走访
    @Autowired
    private MenuService menuService;//菜单
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = chanpinDingdanService.queryPage(params);

        //字典表数据转换
        List<ChanpinDingdanView> list =(List<ChanpinDingdanView>)page.getList();
        for(ChanpinDingdanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"列表查询",list.toString());
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinDingdanEntity chanpinDingdan = chanpinDingdanService.selectById(id);
        if(chanpinDingdan !=null){
            //entity转view
            ChanpinDingdanView view = new ChanpinDingdanView();
            BeanUtils.copyProperties( chanpinDingdan , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(chanpinDingdan.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 产品
            //级联表
            ChanpinEntity chanpin = chanpinService.selectById(chanpinDingdan.getChanpinId());
            if(chanpin != null){
            BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChanpinId(chanpin.getId());
            }
            //级联表 客户
            //级联表
            KehuEntity kehu = kehuService.selectById(chanpinDingdan.getKehuId());
            if(kehu != null){
            BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKehuId(kehu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
    caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"单条数据查看",view.toString());
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChanpinDingdanEntity chanpinDingdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpinDingdan:{}",this.getClass().getName(),chanpinDingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            chanpinDingdan.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChanpinDingdanEntity> queryWrapper = new EntityWrapper<ChanpinDingdanEntity>()
            .eq("yuangong_id", chanpinDingdan.getYuangongId())
            .eq("chanpin_id", chanpinDingdan.getChanpinId())
            .eq("kehu_id", chanpinDingdan.getKehuId())
            .eq("chanpin_dingdan_xiaoshou_types", chanpinDingdan.getChanpinDingdanXiaoshouTypes())
            .eq("chanpin_dingdan_xiaoshoufangshi_types", chanpinDingdan.getChanpinDingdanXiaoshoufangshiTypes())
            .eq("chanpin_dingdan_kuaidigongsi", chanpinDingdan.getChanpinDingdanKuaidigongsi())
            .eq("chanpin_dingdan_danhao", chanpinDingdan.getChanpinDingdanDanhao())
            .eq("chanpin_dingdan_number", chanpinDingdan.getChanpinDingdanNumber())
            .eq("chanpin_dingdan_types", chanpinDingdan.getChanpinDingdanTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinDingdanEntity chanpinDingdanEntity = chanpinDingdanService.selectOne(queryWrapper);
        if(chanpinDingdanEntity==null){
            chanpinDingdan.setInsertTime(new Date());
            chanpinDingdan.setCreateTime(new Date());
            chanpinDingdanService.insert(chanpinDingdan);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"新增",chanpinDingdan.toString());
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinDingdanEntity chanpinDingdan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chanpinDingdan:{}",this.getClass().getName(),chanpinDingdan.toString());
        ChanpinDingdanEntity oldChanpinDingdanEntity = chanpinDingdanService.selectById(chanpinDingdan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            chanpinDingdan.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(chanpinDingdan.getChanpinDingdanContent()) || "null".equals(chanpinDingdan.getChanpinDingdanContent())){
                chanpinDingdan.setChanpinDingdanContent(null);
        }

            chanpinDingdanService.updateById(chanpinDingdan);//根据id更新
            List<String> strings = caozuorizhiService.clazzDiff(chanpinDingdan, oldChanpinDingdanEntity, request,new String[]{"updateTime"});
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"修改",strings.toString());
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChanpinDingdanEntity> oldChanpinDingdanList =chanpinDingdanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chanpinDingdanService.deleteBatchIds(Arrays.asList(ids));

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"删除",oldChanpinDingdanList.toString());
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yuangongId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ChanpinDingdanEntity> chanpinDingdanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChanpinDingdanEntity chanpinDingdanEntity = new ChanpinDingdanEntity();
//                            chanpinDingdanEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            chanpinDingdanEntity.setChanpinId(Integer.valueOf(data.get(0)));   //产品 要改的
//                            chanpinDingdanEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            chanpinDingdanEntity.setChanpinDingdanUuidNumber(data.get(0));                    //销售编号 要改的
//                            chanpinDingdanEntity.setChanpinDingdanXiaoshouTypes(Integer.valueOf(data.get(0)));   //销售类型 要改的
//                            chanpinDingdanEntity.setChanpinDingdanXiaoshoufangshiTypes(Integer.valueOf(data.get(0)));   //销售方式 要改的
//                            chanpinDingdanEntity.setChanpinDingdanKuaidigongsi(data.get(0));                    //快递公司 要改的
//                            chanpinDingdanEntity.setChanpinDingdanDanhao(data.get(0));                    //快递单号 要改的
//                            chanpinDingdanEntity.setChanpinDingdanNumber(Integer.valueOf(data.get(0)));   //销售数量 要改的
//                            chanpinDingdanEntity.setChanpinDingdanJine(data.get(0));                    //销售金额 要改的
//                            chanpinDingdanEntity.setChanpinDingdanTime(sdf.parse(data.get(0)));          //销售时间 要改的
//                            chanpinDingdanEntity.setChanpinDingdanTypes(Integer.valueOf(data.get(0)));   //销售状态 要改的
//                            chanpinDingdanEntity.setChanpinDingdanContent("");//详情和图片
//                            chanpinDingdanEntity.setInsertTime(date);//时间
//                            chanpinDingdanEntity.setCreateTime(date);//时间
                            chanpinDingdanList.add(chanpinDingdanEntity);


                            //把要查询是否重复的字段放入map中
                                //销售编号
                                if(seachFields.containsKey("chanpinDingdanUuidNumber")){
                                    List<String> chanpinDingdanUuidNumber = seachFields.get("chanpinDingdanUuidNumber");
                                    chanpinDingdanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chanpinDingdanUuidNumber = new ArrayList<>();
                                    chanpinDingdanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chanpinDingdanUuidNumber",chanpinDingdanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //销售编号
                        List<ChanpinDingdanEntity> chanpinDingdanEntities_chanpinDingdanUuidNumber = chanpinDingdanService.selectList(new EntityWrapper<ChanpinDingdanEntity>().in("chanpin_dingdan_uuid_number", seachFields.get("chanpinDingdanUuidNumber")));
                        if(chanpinDingdanEntities_chanpinDingdanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChanpinDingdanEntity s:chanpinDingdanEntities_chanpinDingdanUuidNumber){
                                repeatFields.add(s.getChanpinDingdanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [销售编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chanpinDingdanService.insertBatch(chanpinDingdanList);
                        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"批量新增",chanpinDingdanList.toString());
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}


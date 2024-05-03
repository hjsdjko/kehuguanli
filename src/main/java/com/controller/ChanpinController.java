
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
 * 产品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpin")
public class ChanpinController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinController.class);

    private static final String TABLE_NAME = "chanpin";

    @Autowired
    private ChanpinService chanpinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaozuorizhiService caozuorizhiService;//操作日志
    @Autowired
    private ChanpinDingdanService chanpinDingdanService;//产品订单
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
        PageUtils page = chanpinService.queryPage(params);

        //字典表数据转换
        List<ChanpinView> list =(List<ChanpinView>)page.getList();
        for(ChanpinView c:list){
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
        ChanpinEntity chanpin = chanpinService.selectById(id);
        if(chanpin !=null){
            //entity转view
            ChanpinView view = new ChanpinView();
            BeanUtils.copyProperties( chanpin , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChanpinEntity chanpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChanpinEntity> queryWrapper = new EntityWrapper<ChanpinEntity>()
            .eq("chanpin_name", chanpin.getChanpinName())
            .eq("chanpin_danwei", chanpin.getChanpinDanwei())
            .eq("chanpin_types", chanpin.getChanpinTypes())
            .eq("chanpin_cangku", chanpin.getChanpinCangku())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinEntity chanpinEntity = chanpinService.selectOne(queryWrapper);
        if(chanpinEntity==null){
            chanpin.setInsertTime(new Date());
            chanpin.setCreateTime(new Date());
            chanpinService.insert(chanpin);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"新增",chanpin.toString());
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinEntity chanpin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());
        ChanpinEntity oldChanpinEntity = chanpinService.selectById(chanpin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chanpin.getChanpinPhoto()) || "null".equals(chanpin.getChanpinPhoto())){
                chanpin.setChanpinPhoto(null);
        }
        if("".equals(chanpin.getChanpinContent()) || "null".equals(chanpin.getChanpinContent())){
                chanpin.setChanpinContent(null);
        }

            chanpinService.updateById(chanpin);//根据id更新
            List<String> strings = caozuorizhiService.clazzDiff(chanpin, oldChanpinEntity, request,new String[]{"updateTime"});
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"修改",strings.toString());
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChanpinEntity> oldChanpinList =chanpinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chanpinService.deleteBatchIds(Arrays.asList(ids));

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"删除",oldChanpinList.toString());
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
            List<ChanpinEntity> chanpinList = new ArrayList<>();//上传的东西
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
                            ChanpinEntity chanpinEntity = new ChanpinEntity();
//                            chanpinEntity.setChanpinName(data.get(0));                    //产品名称 要改的
//                            chanpinEntity.setChanpinUuidNumber(data.get(0));                    //产品编号 要改的
//                            chanpinEntity.setChanpinPhoto("");//详情和图片
//                            chanpinEntity.setChanpinDanwei(data.get(0));                    //单位 要改的
//                            chanpinEntity.setChanpinTypes(Integer.valueOf(data.get(0)));   //产品类型 要改的
//                            chanpinEntity.setChanpinOldMoney(data.get(0));                    //产品原价 要改的
//                            chanpinEntity.setChanpinNewMoney(data.get(0));                    //现价 要改的
//                            chanpinEntity.setChanpinCangku(data.get(0));                    //所属仓库 要改的
//                            chanpinEntity.setChanpinContent("");//详情和图片
//                            chanpinEntity.setInsertTime(date);//时间
//                            chanpinEntity.setCreateTime(date);//时间
                            chanpinList.add(chanpinEntity);


                            //把要查询是否重复的字段放入map中
                                //产品编号
                                if(seachFields.containsKey("chanpinUuidNumber")){
                                    List<String> chanpinUuidNumber = seachFields.get("chanpinUuidNumber");
                                    chanpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chanpinUuidNumber = new ArrayList<>();
                                    chanpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chanpinUuidNumber",chanpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //产品编号
                        List<ChanpinEntity> chanpinEntities_chanpinUuidNumber = chanpinService.selectList(new EntityWrapper<ChanpinEntity>().in("chanpin_uuid_number", seachFields.get("chanpinUuidNumber")));
                        if(chanpinEntities_chanpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChanpinEntity s:chanpinEntities_chanpinUuidNumber){
                                repeatFields.add(s.getChanpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [产品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chanpinService.insertBatch(chanpinList);
                        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"批量新增",chanpinList.toString());
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


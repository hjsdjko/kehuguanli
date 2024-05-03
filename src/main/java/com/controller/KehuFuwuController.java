
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
 * 客户服务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kehuFuwu")
public class KehuFuwuController {
    private static final Logger logger = LoggerFactory.getLogger(KehuFuwuController.class);

    private static final String TABLE_NAME = "kehuFuwu";

    @Autowired
    private KehuFuwuService kehuFuwuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaozuorizhiService caozuorizhiService;//操作日志
    @Autowired
    private ChanpinService chanpinService;//产品
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
        PageUtils page = kehuFuwuService.queryPage(params);

        //字典表数据转换
        List<KehuFuwuView> list =(List<KehuFuwuView>)page.getList();
        for(KehuFuwuView c:list){
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
        KehuFuwuEntity kehuFuwu = kehuFuwuService.selectById(id);
        if(kehuFuwu !=null){
            //entity转view
            KehuFuwuView view = new KehuFuwuView();
            BeanUtils.copyProperties( kehuFuwu , view );//把实体数据重构到view中
            //级联表 客户
            //级联表
            KehuEntity kehu = kehuService.selectById(kehuFuwu.getKehuId());
            if(kehu != null){
            BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody KehuFuwuEntity kehuFuwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kehuFuwu:{}",this.getClass().getName(),kehuFuwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KehuFuwuEntity> queryWrapper = new EntityWrapper<KehuFuwuEntity>()
            .eq("kehu_id", kehuFuwu.getKehuId())
            .eq("kehu_fuwu_name", kehuFuwu.getKehuFuwuName())
            .eq("kehu_fuwu_types", kehuFuwu.getKehuFuwuTypes())
            .eq("fuwu_time", new SimpleDateFormat("yyyy-MM-dd").format(kehuFuwu.getFuwuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuFuwuEntity kehuFuwuEntity = kehuFuwuService.selectOne(queryWrapper);
        if(kehuFuwuEntity==null){
            kehuFuwu.setKehuFuwuZhuangtaiTypes(1);
            kehuFuwu.setInsertTime(new Date());
            kehuFuwu.setCreateTime(new Date());
            kehuFuwuService.insert(kehuFuwu);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"新增",kehuFuwu.toString());
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KehuFuwuEntity kehuFuwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kehuFuwu:{}",this.getClass().getName(),kehuFuwu.toString());
        KehuFuwuEntity oldKehuFuwuEntity = kehuFuwuService.selectById(kehuFuwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(kehuFuwu.getKehuFuwuFile()) || "null".equals(kehuFuwu.getKehuFuwuFile())){
                kehuFuwu.setKehuFuwuFile(null);
        }
        if("".equals(kehuFuwu.getKehuFuwuContent()) || "null".equals(kehuFuwu.getKehuFuwuContent())){
                kehuFuwu.setKehuFuwuContent(null);
        }
        if("".equals(kehuFuwu.getKehuFuwuFankuiContent()) || "null".equals(kehuFuwu.getKehuFuwuFankuiContent())){
                kehuFuwu.setKehuFuwuFankuiContent(null);
        }

        kehuFuwu.setKehuFuwuZhuangtaiTypes(2);
            kehuFuwuService.updateById(kehuFuwu);//根据id更新
            List<String> strings = caozuorizhiService.clazzDiff(kehuFuwu, oldKehuFuwuEntity, request,new String[]{"updateTime"});
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"修改",strings.toString());
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KehuFuwuEntity> oldKehuFuwuList =kehuFuwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        kehuFuwuService.deleteBatchIds(Arrays.asList(ids));

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"删除",oldKehuFuwuList.toString());
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
            List<KehuFuwuEntity> kehuFuwuList = new ArrayList<>();//上传的东西
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
                            KehuFuwuEntity kehuFuwuEntity = new KehuFuwuEntity();
//                            kehuFuwuEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            kehuFuwuEntity.setKehuFuwuUuidNumber(data.get(0));                    //客户服务编号 要改的
//                            kehuFuwuEntity.setKehuFuwuName(data.get(0));                    //客户服务标题 要改的
//                            kehuFuwuEntity.setKehuFuwuFile(data.get(0));                    //服务附件 要改的
//                            kehuFuwuEntity.setKehuFuwuTypes(Integer.valueOf(data.get(0)));   //客户服务类型 要改的
//                            kehuFuwuEntity.setFuwuTime(sdf.parse(data.get(0)));          //客户服务日期 要改的
//                            kehuFuwuEntity.setKehuFuwuContent("");//详情和图片
//                            kehuFuwuEntity.setInsertTime(date);//时间
//                            kehuFuwuEntity.setKehuFuwuZhuangtaiTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            kehuFuwuEntity.setFuwuXiangxiTime(sdf.parse(data.get(0)));          //服务时间 要改的
//                            kehuFuwuEntity.setKehuFuwuFankuiContent("");//详情和图片
//                            kehuFuwuEntity.setCreateTime(date);//时间
                            kehuFuwuList.add(kehuFuwuEntity);


                            //把要查询是否重复的字段放入map中
                                //客户服务编号
                                if(seachFields.containsKey("kehuFuwuUuidNumber")){
                                    List<String> kehuFuwuUuidNumber = seachFields.get("kehuFuwuUuidNumber");
                                    kehuFuwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kehuFuwuUuidNumber = new ArrayList<>();
                                    kehuFuwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kehuFuwuUuidNumber",kehuFuwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //客户服务编号
                        List<KehuFuwuEntity> kehuFuwuEntities_kehuFuwuUuidNumber = kehuFuwuService.selectList(new EntityWrapper<KehuFuwuEntity>().in("kehu_fuwu_uuid_number", seachFields.get("kehuFuwuUuidNumber")));
                        if(kehuFuwuEntities_kehuFuwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KehuFuwuEntity s:kehuFuwuEntities_kehuFuwuUuidNumber){
                                repeatFields.add(s.getKehuFuwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [客户服务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kehuFuwuService.insertBatch(kehuFuwuList);
                        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"批量新增",kehuFuwuList.toString());
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


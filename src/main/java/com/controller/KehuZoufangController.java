
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
 * 客户走访
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kehuZoufang")
public class KehuZoufangController {
    private static final Logger logger = LoggerFactory.getLogger(KehuZoufangController.class);

    private static final String TABLE_NAME = "kehuZoufang";

    @Autowired
    private KehuZoufangService kehuZoufangService;


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
    private KehuFuwuService kehuFuwuService;//客户服务
    @Autowired
    private KehuLiushiService kehuLiushiService;//客户流失
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
        PageUtils page = kehuZoufangService.queryPage(params);

        //字典表数据转换
        List<KehuZoufangView> list =(List<KehuZoufangView>)page.getList();
        for(KehuZoufangView c:list){
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
        KehuZoufangEntity kehuZoufang = kehuZoufangService.selectById(id);
        if(kehuZoufang !=null){
            //entity转view
            KehuZoufangView view = new KehuZoufangView();
            BeanUtils.copyProperties( kehuZoufang , view );//把实体数据重构到view中
            //级联表 客户
            //级联表
            KehuEntity kehu = kehuService.selectById(kehuZoufang.getKehuId());
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
    public R save(@RequestBody KehuZoufangEntity kehuZoufang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kehuZoufang:{}",this.getClass().getName(),kehuZoufang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KehuZoufangEntity> queryWrapper = new EntityWrapper<KehuZoufangEntity>()
            .eq("kehu_id", kehuZoufang.getKehuId())
            .eq("kehu_zoufang_name", kehuZoufang.getKehuZoufangName())
            .eq("kehu_zoufang_types", kehuZoufang.getKehuZoufangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuZoufangEntity kehuZoufangEntity = kehuZoufangService.selectOne(queryWrapper);
        if(kehuZoufangEntity==null){
            kehuZoufang.setInsertTime(new Date());
            kehuZoufang.setCreateTime(new Date());
            kehuZoufangService.insert(kehuZoufang);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"新增",kehuZoufang.toString());
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KehuZoufangEntity kehuZoufang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kehuZoufang:{}",this.getClass().getName(),kehuZoufang.toString());
        KehuZoufangEntity oldKehuZoufangEntity = kehuZoufangService.selectById(kehuZoufang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(kehuZoufang.getKehuZoufangFile()) || "null".equals(kehuZoufang.getKehuZoufangFile())){
                kehuZoufang.setKehuZoufangFile(null);
        }
        if("".equals(kehuZoufang.getKehuZoufangContent()) || "null".equals(kehuZoufang.getKehuZoufangContent())){
                kehuZoufang.setKehuZoufangContent(null);
        }

            kehuZoufangService.updateById(kehuZoufang);//根据id更新
            List<String> strings = caozuorizhiService.clazzDiff(kehuZoufang, oldKehuZoufangEntity, request,new String[]{"updateTime"});
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"修改",strings.toString());
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KehuZoufangEntity> oldKehuZoufangList =kehuZoufangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        kehuZoufangService.deleteBatchIds(Arrays.asList(ids));

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"删除",oldKehuZoufangList.toString());
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
            List<KehuZoufangEntity> kehuZoufangList = new ArrayList<>();//上传的东西
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
                            KehuZoufangEntity kehuZoufangEntity = new KehuZoufangEntity();
//                            kehuZoufangEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            kehuZoufangEntity.setKehuZoufangUuidNumber(data.get(0));                    //客户走访编号 要改的
//                            kehuZoufangEntity.setKehuZoufangName(data.get(0));                    //客户走访标题 要改的
//                            kehuZoufangEntity.setKehuZoufangFile(data.get(0));                    //走访附件 要改的
//                            kehuZoufangEntity.setKehuZoufangTypes(Integer.valueOf(data.get(0)));   //客户走访类型 要改的
//                            kehuZoufangEntity.setFuwuTime(sdf.parse(data.get(0)));          //客户走访时间 要改的
//                            kehuZoufangEntity.setKehuZoufangContent("");//详情和图片
//                            kehuZoufangEntity.setInsertTime(date);//时间
//                            kehuZoufangEntity.setCreateTime(date);//时间
                            kehuZoufangList.add(kehuZoufangEntity);


                            //把要查询是否重复的字段放入map中
                                //客户走访编号
                                if(seachFields.containsKey("kehuZoufangUuidNumber")){
                                    List<String> kehuZoufangUuidNumber = seachFields.get("kehuZoufangUuidNumber");
                                    kehuZoufangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kehuZoufangUuidNumber = new ArrayList<>();
                                    kehuZoufangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kehuZoufangUuidNumber",kehuZoufangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //客户走访编号
                        List<KehuZoufangEntity> kehuZoufangEntities_kehuZoufangUuidNumber = kehuZoufangService.selectList(new EntityWrapper<KehuZoufangEntity>().in("kehu_zoufang_uuid_number", seachFields.get("kehuZoufangUuidNumber")));
                        if(kehuZoufangEntities_kehuZoufangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KehuZoufangEntity s:kehuZoufangEntities_kehuZoufangUuidNumber){
                                repeatFields.add(s.getKehuZoufangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [客户走访编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kehuZoufangService.insertBatch(kehuZoufangList);
                        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"批量新增",kehuZoufangList.toString());
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


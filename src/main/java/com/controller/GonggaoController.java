
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
 * 公告
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gonggao")
public class GonggaoController {
    private static final Logger logger = LoggerFactory.getLogger(GonggaoController.class);

    private static final String TABLE_NAME = "gonggao";

    @Autowired
    private GonggaoService gonggaoService;


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
        PageUtils page = gonggaoService.queryPage(params);

        //字典表数据转换
        List<GonggaoView> list =(List<GonggaoView>)page.getList();
        for(GonggaoView c:list){
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
        GonggaoEntity gonggao = gonggaoService.selectById(id);
        if(gonggao !=null){
            //entity转view
            GonggaoView view = new GonggaoView();
            BeanUtils.copyProperties( gonggao , view );//把实体数据重构到view中
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
    public R save(@RequestBody GonggaoEntity gonggao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gonggao:{}",this.getClass().getName(),gonggao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GonggaoEntity> queryWrapper = new EntityWrapper<GonggaoEntity>()
            .eq("gonggao_name", gonggao.getGonggaoName())
            .eq("gonggao_types", gonggao.getGonggaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GonggaoEntity gonggaoEntity = gonggaoService.selectOne(queryWrapper);
        if(gonggaoEntity==null){
            gonggao.setInsertTime(new Date());
            gonggao.setCreateTime(new Date());
            gonggaoService.insert(gonggao);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"新增",gonggao.toString());
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GonggaoEntity gonggao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gonggao:{}",this.getClass().getName(),gonggao.toString());
        GonggaoEntity oldGonggaoEntity = gonggaoService.selectById(gonggao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(gonggao.getGonggaoFile()) || "null".equals(gonggao.getGonggaoFile())){
                gonggao.setGonggaoFile(null);
        }
        if("".equals(gonggao.getGonggaoContent()) || "null".equals(gonggao.getGonggaoContent())){
                gonggao.setGonggaoContent(null);
        }

            gonggaoService.updateById(gonggao);//根据id更新
            List<String> strings = caozuorizhiService.clazzDiff(gonggao, oldGonggaoEntity, request,new String[]{"updateTime"});
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"修改",strings.toString());
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GonggaoEntity> oldGonggaoList =gonggaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        gonggaoService.deleteBatchIds(Arrays.asList(ids));

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"删除",oldGonggaoList.toString());
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
            List<GonggaoEntity> gonggaoList = new ArrayList<>();//上传的东西
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
                            GonggaoEntity gonggaoEntity = new GonggaoEntity();
//                            gonggaoEntity.setGonggaoName(data.get(0));                    //公告名称 要改的
//                            gonggaoEntity.setGonggaoFile(data.get(0));                    //附件 要改的
//                            gonggaoEntity.setGonggaoTypes(Integer.valueOf(data.get(0)));   //公告类型 要改的
//                            gonggaoEntity.setGonggaoTime(sdf.parse(data.get(0)));          //公告执行时间 要改的
//                            gonggaoEntity.setGonggaoContent("");//详情和图片
//                            gonggaoEntity.setInsertTime(date);//时间
//                            gonggaoEntity.setCreateTime(date);//时间
                            gonggaoList.add(gonggaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        gonggaoService.insertBatch(gonggaoList);
                        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"批量新增",gonggaoList.toString());
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


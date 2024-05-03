package com.dao;

import com.entity.ChanpinDingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinDingdanView;

/**
 * 产品订单 Dao 接口
 *
 * @author 
 */
public interface ChanpinDingdanDao extends BaseMapper<ChanpinDingdanEntity> {

   List<ChanpinDingdanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

package com.dao;

import com.entity.KehuFankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KehuFankuiView;

/**
 * 反馈建议 Dao 接口
 *
 * @author 
 */
public interface KehuFankuiDao extends BaseMapper<KehuFankuiEntity> {

   List<KehuFankuiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

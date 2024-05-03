package com.entity.vo;

import com.entity.GonggaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公告
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gonggao")
public class GonggaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 公告名称
     */

    @TableField(value = "gonggao_name")
    private String gonggaoName;


    /**
     * 附件
     */

    @TableField(value = "gonggao_file")
    private String gonggaoFile;


    /**
     * 公告类型
     */

    @TableField(value = "gonggao_types")
    private Integer gonggaoTypes;


    /**
     * 公告执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "gonggao_time")
    private Date gonggaoTime;


    /**
     * 公告详情
     */

    @TableField(value = "gonggao_content")
    private String gonggaoContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：公告名称
	 */
    public String getGonggaoName() {
        return gonggaoName;
    }


    /**
	 * 获取：公告名称
	 */

    public void setGonggaoName(String gonggaoName) {
        this.gonggaoName = gonggaoName;
    }
    /**
	 * 设置：附件
	 */
    public String getGonggaoFile() {
        return gonggaoFile;
    }


    /**
	 * 获取：附件
	 */

    public void setGonggaoFile(String gonggaoFile) {
        this.gonggaoFile = gonggaoFile;
    }
    /**
	 * 设置：公告类型
	 */
    public Integer getGonggaoTypes() {
        return gonggaoTypes;
    }


    /**
	 * 获取：公告类型
	 */

    public void setGonggaoTypes(Integer gonggaoTypes) {
        this.gonggaoTypes = gonggaoTypes;
    }
    /**
	 * 设置：公告执行时间
	 */
    public Date getGonggaoTime() {
        return gonggaoTime;
    }


    /**
	 * 获取：公告执行时间
	 */

    public void setGonggaoTime(Date gonggaoTime) {
        this.gonggaoTime = gonggaoTime;
    }
    /**
	 * 设置：公告详情
	 */
    public String getGonggaoContent() {
        return gonggaoContent;
    }


    /**
	 * 获取：公告详情
	 */

    public void setGonggaoContent(String gonggaoContent) {
        this.gonggaoContent = gonggaoContent;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

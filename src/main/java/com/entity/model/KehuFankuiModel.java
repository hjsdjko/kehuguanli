package com.entity.model;

import com.entity.KehuFankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 反馈建议
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KehuFankuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 客户反馈编号
     */
    private String kehuFankuiUuidNumber;


    /**
     * 客户反馈标题
     */
    private String kehuFankuiName;


    /**
     * 反馈附件
     */
    private String kehuFankuiFile;


    /**
     * 客户反馈类型
     */
    private Integer kehuFankuiTypes;


    /**
     * 客户反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuTime;


    /**
     * 客户反馈内容
     */
    private String kehuFankuiContent;


    /**
     * 反馈状态
     */
    private Integer kehuFankuizhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：客户反馈编号
	 */
    public String getKehuFankuiUuidNumber() {
        return kehuFankuiUuidNumber;
    }


    /**
	 * 设置：客户反馈编号
	 */
    public void setKehuFankuiUuidNumber(String kehuFankuiUuidNumber) {
        this.kehuFankuiUuidNumber = kehuFankuiUuidNumber;
    }
    /**
	 * 获取：客户反馈标题
	 */
    public String getKehuFankuiName() {
        return kehuFankuiName;
    }


    /**
	 * 设置：客户反馈标题
	 */
    public void setKehuFankuiName(String kehuFankuiName) {
        this.kehuFankuiName = kehuFankuiName;
    }
    /**
	 * 获取：反馈附件
	 */
    public String getKehuFankuiFile() {
        return kehuFankuiFile;
    }


    /**
	 * 设置：反馈附件
	 */
    public void setKehuFankuiFile(String kehuFankuiFile) {
        this.kehuFankuiFile = kehuFankuiFile;
    }
    /**
	 * 获取：客户反馈类型
	 */
    public Integer getKehuFankuiTypes() {
        return kehuFankuiTypes;
    }


    /**
	 * 设置：客户反馈类型
	 */
    public void setKehuFankuiTypes(Integer kehuFankuiTypes) {
        this.kehuFankuiTypes = kehuFankuiTypes;
    }
    /**
	 * 获取：客户反馈时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 设置：客户反馈时间
	 */
    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 获取：客户反馈内容
	 */
    public String getKehuFankuiContent() {
        return kehuFankuiContent;
    }


    /**
	 * 设置：客户反馈内容
	 */
    public void setKehuFankuiContent(String kehuFankuiContent) {
        this.kehuFankuiContent = kehuFankuiContent;
    }
    /**
	 * 获取：反馈状态
	 */
    public Integer getKehuFankuizhuangtaiTypes() {
        return kehuFankuizhuangtaiTypes;
    }


    /**
	 * 设置：反馈状态
	 */
    public void setKehuFankuizhuangtaiTypes(Integer kehuFankuizhuangtaiTypes) {
        this.kehuFankuizhuangtaiTypes = kehuFankuizhuangtaiTypes;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

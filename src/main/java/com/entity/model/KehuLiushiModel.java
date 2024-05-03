package com.entity.model;

import com.entity.KehuLiushiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户流失
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KehuLiushiModel implements Serializable {
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
     * 客户流失编号
     */
    private String kehuLiushiUuidNumber;


    /**
     * 客户流失标题
     */
    private String kehuLiushiName;


    /**
     * 流失附件
     */
    private String kehuLiushiFile;


    /**
     * 客户流失类型
     */
    private Integer kehuLiushiTypes;


    /**
     * 客户流失时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuTime;


    /**
     * 客户流失详情
     */
    private String kehuLiushiContent;


    /**
     * 上传时间
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
	 * 获取：客户流失编号
	 */
    public String getKehuLiushiUuidNumber() {
        return kehuLiushiUuidNumber;
    }


    /**
	 * 设置：客户流失编号
	 */
    public void setKehuLiushiUuidNumber(String kehuLiushiUuidNumber) {
        this.kehuLiushiUuidNumber = kehuLiushiUuidNumber;
    }
    /**
	 * 获取：客户流失标题
	 */
    public String getKehuLiushiName() {
        return kehuLiushiName;
    }


    /**
	 * 设置：客户流失标题
	 */
    public void setKehuLiushiName(String kehuLiushiName) {
        this.kehuLiushiName = kehuLiushiName;
    }
    /**
	 * 获取：流失附件
	 */
    public String getKehuLiushiFile() {
        return kehuLiushiFile;
    }


    /**
	 * 设置：流失附件
	 */
    public void setKehuLiushiFile(String kehuLiushiFile) {
        this.kehuLiushiFile = kehuLiushiFile;
    }
    /**
	 * 获取：客户流失类型
	 */
    public Integer getKehuLiushiTypes() {
        return kehuLiushiTypes;
    }


    /**
	 * 设置：客户流失类型
	 */
    public void setKehuLiushiTypes(Integer kehuLiushiTypes) {
        this.kehuLiushiTypes = kehuLiushiTypes;
    }
    /**
	 * 获取：客户流失时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 设置：客户流失时间
	 */
    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 获取：客户流失详情
	 */
    public String getKehuLiushiContent() {
        return kehuLiushiContent;
    }


    /**
	 * 设置：客户流失详情
	 */
    public void setKehuLiushiContent(String kehuLiushiContent) {
        this.kehuLiushiContent = kehuLiushiContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：上传时间
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

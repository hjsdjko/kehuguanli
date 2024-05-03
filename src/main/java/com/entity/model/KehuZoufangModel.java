package com.entity.model;

import com.entity.KehuZoufangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户走访
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KehuZoufangModel implements Serializable {
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
     * 客户走访编号
     */
    private String kehuZoufangUuidNumber;


    /**
     * 客户走访标题
     */
    private String kehuZoufangName;


    /**
     * 走访附件
     */
    private String kehuZoufangFile;


    /**
     * 客户走访类型
     */
    private Integer kehuZoufangTypes;


    /**
     * 客户走访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuTime;


    /**
     * 客户走访内容
     */
    private String kehuZoufangContent;


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
	 * 获取：客户走访编号
	 */
    public String getKehuZoufangUuidNumber() {
        return kehuZoufangUuidNumber;
    }


    /**
	 * 设置：客户走访编号
	 */
    public void setKehuZoufangUuidNumber(String kehuZoufangUuidNumber) {
        this.kehuZoufangUuidNumber = kehuZoufangUuidNumber;
    }
    /**
	 * 获取：客户走访标题
	 */
    public String getKehuZoufangName() {
        return kehuZoufangName;
    }


    /**
	 * 设置：客户走访标题
	 */
    public void setKehuZoufangName(String kehuZoufangName) {
        this.kehuZoufangName = kehuZoufangName;
    }
    /**
	 * 获取：走访附件
	 */
    public String getKehuZoufangFile() {
        return kehuZoufangFile;
    }


    /**
	 * 设置：走访附件
	 */
    public void setKehuZoufangFile(String kehuZoufangFile) {
        this.kehuZoufangFile = kehuZoufangFile;
    }
    /**
	 * 获取：客户走访类型
	 */
    public Integer getKehuZoufangTypes() {
        return kehuZoufangTypes;
    }


    /**
	 * 设置：客户走访类型
	 */
    public void setKehuZoufangTypes(Integer kehuZoufangTypes) {
        this.kehuZoufangTypes = kehuZoufangTypes;
    }
    /**
	 * 获取：客户走访时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 设置：客户走访时间
	 */
    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 获取：客户走访内容
	 */
    public String getKehuZoufangContent() {
        return kehuZoufangContent;
    }


    /**
	 * 设置：客户走访内容
	 */
    public void setKehuZoufangContent(String kehuZoufangContent) {
        this.kehuZoufangContent = kehuZoufangContent;
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

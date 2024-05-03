package com.entity.model;

import com.entity.KehuFuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KehuFuwuModel implements Serializable {
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
     * 客户服务编号
     */
    private String kehuFuwuUuidNumber;


    /**
     * 客户服务标题
     */
    private String kehuFuwuName;


    /**
     * 服务附件
     */
    private String kehuFuwuFile;


    /**
     * 客户服务类型
     */
    private Integer kehuFuwuTypes;


    /**
     * 客户服务日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuTime;


    /**
     * 客户服务内容
     */
    private String kehuFuwuContent;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 状态
     */
    private Integer kehuFuwuZhuangtaiTypes;


    /**
     * 服务时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuXiangxiTime;


    /**
     * 客户反馈
     */
    private String kehuFuwuFankuiContent;


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
	 * 获取：客户服务编号
	 */
    public String getKehuFuwuUuidNumber() {
        return kehuFuwuUuidNumber;
    }


    /**
	 * 设置：客户服务编号
	 */
    public void setKehuFuwuUuidNumber(String kehuFuwuUuidNumber) {
        this.kehuFuwuUuidNumber = kehuFuwuUuidNumber;
    }
    /**
	 * 获取：客户服务标题
	 */
    public String getKehuFuwuName() {
        return kehuFuwuName;
    }


    /**
	 * 设置：客户服务标题
	 */
    public void setKehuFuwuName(String kehuFuwuName) {
        this.kehuFuwuName = kehuFuwuName;
    }
    /**
	 * 获取：服务附件
	 */
    public String getKehuFuwuFile() {
        return kehuFuwuFile;
    }


    /**
	 * 设置：服务附件
	 */
    public void setKehuFuwuFile(String kehuFuwuFile) {
        this.kehuFuwuFile = kehuFuwuFile;
    }
    /**
	 * 获取：客户服务类型
	 */
    public Integer getKehuFuwuTypes() {
        return kehuFuwuTypes;
    }


    /**
	 * 设置：客户服务类型
	 */
    public void setKehuFuwuTypes(Integer kehuFuwuTypes) {
        this.kehuFuwuTypes = kehuFuwuTypes;
    }
    /**
	 * 获取：客户服务日期
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 设置：客户服务日期
	 */
    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 获取：客户服务内容
	 */
    public String getKehuFuwuContent() {
        return kehuFuwuContent;
    }


    /**
	 * 设置：客户服务内容
	 */
    public void setKehuFuwuContent(String kehuFuwuContent) {
        this.kehuFuwuContent = kehuFuwuContent;
    }
    /**
	 * 获取：安排时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：安排时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：状态
	 */
    public Integer getKehuFuwuZhuangtaiTypes() {
        return kehuFuwuZhuangtaiTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setKehuFuwuZhuangtaiTypes(Integer kehuFuwuZhuangtaiTypes) {
        this.kehuFuwuZhuangtaiTypes = kehuFuwuZhuangtaiTypes;
    }
    /**
	 * 获取：服务时间
	 */
    public Date getFuwuXiangxiTime() {
        return fuwuXiangxiTime;
    }


    /**
	 * 设置：服务时间
	 */
    public void setFuwuXiangxiTime(Date fuwuXiangxiTime) {
        this.fuwuXiangxiTime = fuwuXiangxiTime;
    }
    /**
	 * 获取：客户反馈
	 */
    public String getKehuFuwuFankuiContent() {
        return kehuFuwuFankuiContent;
    }


    /**
	 * 设置：客户反馈
	 */
    public void setKehuFuwuFankuiContent(String kehuFuwuFankuiContent) {
        this.kehuFuwuFankuiContent = kehuFuwuFankuiContent;
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

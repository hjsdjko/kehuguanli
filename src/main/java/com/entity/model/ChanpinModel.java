package com.entity.model;

import com.entity.ChanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 产品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 产品名称
     */
    private String chanpinName;


    /**
     * 产品编号
     */
    private String chanpinUuidNumber;


    /**
     * 产品照片
     */
    private String chanpinPhoto;


    /**
     * 单位
     */
    private String chanpinDanwei;


    /**
     * 产品类型
     */
    private Integer chanpinTypes;


    /**
     * 产品原价
     */
    private Double chanpinOldMoney;


    /**
     * 现价
     */
    private Double chanpinNewMoney;


    /**
     * 所属仓库
     */
    private String chanpinCangku;


    /**
     * 产品介绍
     */
    private String chanpinContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 设置：产品名称
	 */
    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 获取：产品编号
	 */
    public String getChanpinUuidNumber() {
        return chanpinUuidNumber;
    }


    /**
	 * 设置：产品编号
	 */
    public void setChanpinUuidNumber(String chanpinUuidNumber) {
        this.chanpinUuidNumber = chanpinUuidNumber;
    }
    /**
	 * 获取：产品照片
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }


    /**
	 * 设置：产品照片
	 */
    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 获取：单位
	 */
    public String getChanpinDanwei() {
        return chanpinDanwei;
    }


    /**
	 * 设置：单位
	 */
    public void setChanpinDanwei(String chanpinDanwei) {
        this.chanpinDanwei = chanpinDanwei;
    }
    /**
	 * 获取：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 设置：产品类型
	 */
    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 获取：产品原价
	 */
    public Double getChanpinOldMoney() {
        return chanpinOldMoney;
    }


    /**
	 * 设置：产品原价
	 */
    public void setChanpinOldMoney(Double chanpinOldMoney) {
        this.chanpinOldMoney = chanpinOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getChanpinNewMoney() {
        return chanpinNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setChanpinNewMoney(Double chanpinNewMoney) {
        this.chanpinNewMoney = chanpinNewMoney;
    }
    /**
	 * 获取：所属仓库
	 */
    public String getChanpinCangku() {
        return chanpinCangku;
    }


    /**
	 * 设置：所属仓库
	 */
    public void setChanpinCangku(String chanpinCangku) {
        this.chanpinCangku = chanpinCangku;
    }
    /**
	 * 获取：产品介绍
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 设置：产品介绍
	 */
    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

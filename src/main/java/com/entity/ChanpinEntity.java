package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 产品
 *
 * @author 
 * @email
 */
@TableName("chanpin")
public class ChanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChanpinEntity() {

	}

	public ChanpinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 产品名称
     */
    @ColumnInfo(comment="产品名称",type="varchar(200)")
    @TableField(value = "chanpin_name")

    private String chanpinName;


    /**
     * 产品编号
     */
    @ColumnInfo(comment="产品编号",type="varchar(200)")
    @TableField(value = "chanpin_uuid_number")

    private String chanpinUuidNumber;


    /**
     * 产品照片
     */
    @ColumnInfo(comment="产品照片",type="varchar(200)")
    @TableField(value = "chanpin_photo")

    private String chanpinPhoto;


    /**
     * 单位
     */
    @ColumnInfo(comment="单位",type="varchar(200)")
    @TableField(value = "chanpin_danwei")

    private String chanpinDanwei;


    /**
     * 产品类型
     */
    @ColumnInfo(comment="产品类型",type="int(11)")
    @TableField(value = "chanpin_types")

    private Integer chanpinTypes;


    /**
     * 产品原价
     */
    @ColumnInfo(comment="产品原价",type="decimal(10,2)")
    @TableField(value = "chanpin_old_money")

    private Double chanpinOldMoney;


    /**
     * 现价
     */
    @ColumnInfo(comment="现价",type="decimal(10,2)")
    @TableField(value = "chanpin_new_money")

    private Double chanpinNewMoney;


    /**
     * 所属仓库
     */
    @ColumnInfo(comment="所属仓库",type="varchar(200)")
    @TableField(value = "chanpin_cangku")

    private String chanpinCangku;


    /**
     * 产品介绍
     */
    @ColumnInfo(comment="产品介绍",type="longtext")
    @TableField(value = "chanpin_content")

    private String chanpinContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Chanpin{" +
            ", id=" + id +
            ", chanpinName=" + chanpinName +
            ", chanpinUuidNumber=" + chanpinUuidNumber +
            ", chanpinPhoto=" + chanpinPhoto +
            ", chanpinDanwei=" + chanpinDanwei +
            ", chanpinTypes=" + chanpinTypes +
            ", chanpinOldMoney=" + chanpinOldMoney +
            ", chanpinNewMoney=" + chanpinNewMoney +
            ", chanpinCangku=" + chanpinCangku +
            ", chanpinContent=" + chanpinContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

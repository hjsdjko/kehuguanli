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
 * 客户
 *
 * @author 
 * @email
 */
@TableName("kehu")
public class KehuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuEntity() {

	}

	public KehuEntity(T t) {
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
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 客户编号
     */
    @ColumnInfo(comment="客户编号",type="varchar(200)")
    @TableField(value = "kehu_uuid_number")

    private String kehuUuidNumber;


    /**
     * 客户姓名
     */
    @ColumnInfo(comment="客户姓名",type="varchar(200)")
    @TableField(value = "kehu_name")

    private String kehuName;


    /**
     * 客户手机号
     */
    @ColumnInfo(comment="客户手机号",type="varchar(200)")
    @TableField(value = "kehu_phone")

    private String kehuPhone;


    /**
     * 客户身份证号
     */
    @ColumnInfo(comment="客户身份证号",type="varchar(200)")
    @TableField(value = "kehu_id_number")

    private String kehuIdNumber;


    /**
     * 客户照片
     */
    @ColumnInfo(comment="客户照片",type="varchar(200)")
    @TableField(value = "kehu_photo")

    private String kehuPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 客户邮箱
     */
    @ColumnInfo(comment="客户邮箱",type="varchar(200)")
    @TableField(value = "kehu_email")

    private String kehuEmail;


    /**
     * 住址
     */
    @ColumnInfo(comment="住址",type="varchar(200)")
    @TableField(value = "kehu_address")

    private String kehuAddress;


    /**
     * 行业
     */
    @ColumnInfo(comment="行业",type="int(11)")
    @TableField(value = "hangye_types")

    private Integer hangyeTypes;


    /**
     * 职位
     */
    @ColumnInfo(comment="职位",type="int(11)")
    @TableField(value = "zhiwei_types")

    private Integer zhiweiTypes;


    /**
     * 地区
     */
    @ColumnInfo(comment="地区",type="int(11)")
    @TableField(value = "diqu_types")

    private Integer diquTypes;


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
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 设置：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：客户编号
	 */
    public String getKehuUuidNumber() {
        return kehuUuidNumber;
    }
    /**
	 * 设置：客户编号
	 */

    public void setKehuUuidNumber(String kehuUuidNumber) {
        this.kehuUuidNumber = kehuUuidNumber;
    }
    /**
	 * 获取：客户姓名
	 */
    public String getKehuName() {
        return kehuName;
    }
    /**
	 * 设置：客户姓名
	 */

    public void setKehuName(String kehuName) {
        this.kehuName = kehuName;
    }
    /**
	 * 获取：客户手机号
	 */
    public String getKehuPhone() {
        return kehuPhone;
    }
    /**
	 * 设置：客户手机号
	 */

    public void setKehuPhone(String kehuPhone) {
        this.kehuPhone = kehuPhone;
    }
    /**
	 * 获取：客户身份证号
	 */
    public String getKehuIdNumber() {
        return kehuIdNumber;
    }
    /**
	 * 设置：客户身份证号
	 */

    public void setKehuIdNumber(String kehuIdNumber) {
        this.kehuIdNumber = kehuIdNumber;
    }
    /**
	 * 获取：客户照片
	 */
    public String getKehuPhoto() {
        return kehuPhoto;
    }
    /**
	 * 设置：客户照片
	 */

    public void setKehuPhoto(String kehuPhoto) {
        this.kehuPhoto = kehuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：客户邮箱
	 */
    public String getKehuEmail() {
        return kehuEmail;
    }
    /**
	 * 设置：客户邮箱
	 */

    public void setKehuEmail(String kehuEmail) {
        this.kehuEmail = kehuEmail;
    }
    /**
	 * 获取：住址
	 */
    public String getKehuAddress() {
        return kehuAddress;
    }
    /**
	 * 设置：住址
	 */

    public void setKehuAddress(String kehuAddress) {
        this.kehuAddress = kehuAddress;
    }
    /**
	 * 获取：行业
	 */
    public Integer getHangyeTypes() {
        return hangyeTypes;
    }
    /**
	 * 设置：行业
	 */

    public void setHangyeTypes(Integer hangyeTypes) {
        this.hangyeTypes = hangyeTypes;
    }
    /**
	 * 获取：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }
    /**
	 * 设置：职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 获取：地区
	 */
    public Integer getDiquTypes() {
        return diquTypes;
    }
    /**
	 * 设置：地区
	 */

    public void setDiquTypes(Integer diquTypes) {
        this.diquTypes = diquTypes;
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
        return "Kehu{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", kehuUuidNumber=" + kehuUuidNumber +
            ", kehuName=" + kehuName +
            ", kehuPhone=" + kehuPhone +
            ", kehuIdNumber=" + kehuIdNumber +
            ", kehuPhoto=" + kehuPhoto +
            ", sexTypes=" + sexTypes +
            ", kehuEmail=" + kehuEmail +
            ", kehuAddress=" + kehuAddress +
            ", hangyeTypes=" + hangyeTypes +
            ", zhiweiTypes=" + zhiweiTypes +
            ", diquTypes=" + diquTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

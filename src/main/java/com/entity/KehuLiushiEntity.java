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
 * 客户流失
 *
 * @author 
 * @email
 */
@TableName("kehu_liushi")
public class KehuLiushiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuLiushiEntity() {

	}

	public KehuLiushiEntity(T t) {
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
     * 客户
     */
    @ColumnInfo(comment="客户",type="int(11)")
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 客户流失编号
     */
    @ColumnInfo(comment="客户流失编号",type="varchar(200)")
    @TableField(value = "kehu_liushi_uuid_number")

    private String kehuLiushiUuidNumber;


    /**
     * 客户流失标题
     */
    @ColumnInfo(comment="客户流失标题",type="varchar(200)")
    @TableField(value = "kehu_liushi_name")

    private String kehuLiushiName;


    /**
     * 流失附件
     */
    @ColumnInfo(comment="流失附件",type="varchar(200)")
    @TableField(value = "kehu_liushi_file")

    private String kehuLiushiFile;


    /**
     * 客户流失类型
     */
    @ColumnInfo(comment="客户流失类型",type="int(11)")
    @TableField(value = "kehu_liushi_types")

    private Integer kehuLiushiTypes;


    /**
     * 客户流失时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="客户流失时间",type="timestamp")
    @TableField(value = "fuwu_time")

    private Date fuwuTime;


    /**
     * 客户流失详情
     */
    @ColumnInfo(comment="客户流失详情",type="text")
    @TableField(value = "kehu_liushi_content")

    private String kehuLiushiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
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
        return "KehuLiushi{" +
            ", id=" + id +
            ", kehuId=" + kehuId +
            ", kehuLiushiUuidNumber=" + kehuLiushiUuidNumber +
            ", kehuLiushiName=" + kehuLiushiName +
            ", kehuLiushiFile=" + kehuLiushiFile +
            ", kehuLiushiTypes=" + kehuLiushiTypes +
            ", fuwuTime=" + DateUtil.convertString(fuwuTime,"yyyy-MM-dd") +
            ", kehuLiushiContent=" + kehuLiushiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

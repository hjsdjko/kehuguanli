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
 * 客户走访
 *
 * @author 
 * @email
 */
@TableName("kehu_zoufang")
public class KehuZoufangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuZoufangEntity() {

	}

	public KehuZoufangEntity(T t) {
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
     * 客户走访编号
     */
    @ColumnInfo(comment="客户走访编号",type="varchar(200)")
    @TableField(value = "kehu_zoufang_uuid_number")

    private String kehuZoufangUuidNumber;


    /**
     * 客户走访标题
     */
    @ColumnInfo(comment="客户走访标题",type="varchar(200)")
    @TableField(value = "kehu_zoufang_name")

    private String kehuZoufangName;


    /**
     * 走访附件
     */
    @ColumnInfo(comment="走访附件",type="varchar(200)")
    @TableField(value = "kehu_zoufang_file")

    private String kehuZoufangFile;


    /**
     * 客户走访类型
     */
    @ColumnInfo(comment="客户走访类型",type="int(11)")
    @TableField(value = "kehu_zoufang_types")

    private Integer kehuZoufangTypes;


    /**
     * 客户走访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="客户走访时间",type="timestamp")
    @TableField(value = "fuwu_time")

    private Date fuwuTime;


    /**
     * 客户走访内容
     */
    @ColumnInfo(comment="客户走访内容",type="text")
    @TableField(value = "kehu_zoufang_content")

    private String kehuZoufangContent;


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
        return "KehuZoufang{" +
            ", id=" + id +
            ", kehuId=" + kehuId +
            ", kehuZoufangUuidNumber=" + kehuZoufangUuidNumber +
            ", kehuZoufangName=" + kehuZoufangName +
            ", kehuZoufangFile=" + kehuZoufangFile +
            ", kehuZoufangTypes=" + kehuZoufangTypes +
            ", fuwuTime=" + DateUtil.convertString(fuwuTime,"yyyy-MM-dd") +
            ", kehuZoufangContent=" + kehuZoufangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

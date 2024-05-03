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
 * 反馈建议
 *
 * @author 
 * @email
 */
@TableName("kehu_fankui")
public class KehuFankuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuFankuiEntity() {

	}

	public KehuFankuiEntity(T t) {
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
     * 客户反馈编号
     */
    @ColumnInfo(comment="客户反馈编号",type="varchar(200)")
    @TableField(value = "kehu_fankui_uuid_number")

    private String kehuFankuiUuidNumber;


    /**
     * 客户反馈标题
     */
    @ColumnInfo(comment="客户反馈标题",type="varchar(200)")
    @TableField(value = "kehu_fankui_name")

    private String kehuFankuiName;


    /**
     * 反馈附件
     */
    @ColumnInfo(comment="反馈附件",type="varchar(200)")
    @TableField(value = "kehu_fankui_file")

    private String kehuFankuiFile;


    /**
     * 客户反馈类型
     */
    @ColumnInfo(comment="客户反馈类型",type="int(11)")
    @TableField(value = "kehu_fankui_types")

    private Integer kehuFankuiTypes;


    /**
     * 客户反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="客户反馈时间",type="timestamp")
    @TableField(value = "fuwu_time")

    private Date fuwuTime;


    /**
     * 客户反馈内容
     */
    @ColumnInfo(comment="客户反馈内容",type="text")
    @TableField(value = "kehu_fankui_content")

    private String kehuFankuiContent;


    /**
     * 反馈状态
     */
    @ColumnInfo(comment="反馈状态",type="int(11)")
    @TableField(value = "kehu_fankuizhuangtai_types")

    private Integer kehuFankuizhuangtaiTypes;


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
        return "KehuFankui{" +
            ", id=" + id +
            ", kehuId=" + kehuId +
            ", kehuFankuiUuidNumber=" + kehuFankuiUuidNumber +
            ", kehuFankuiName=" + kehuFankuiName +
            ", kehuFankuiFile=" + kehuFankuiFile +
            ", kehuFankuiTypes=" + kehuFankuiTypes +
            ", fuwuTime=" + DateUtil.convertString(fuwuTime,"yyyy-MM-dd") +
            ", kehuFankuiContent=" + kehuFankuiContent +
            ", kehuFankuizhuangtaiTypes=" + kehuFankuizhuangtaiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

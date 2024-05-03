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
 * 客户服务
 *
 * @author 
 * @email
 */
@TableName("kehu_fuwu")
public class KehuFuwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuFuwuEntity() {

	}

	public KehuFuwuEntity(T t) {
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
     * 客户服务编号
     */
    @ColumnInfo(comment="客户服务编号",type="varchar(200)")
    @TableField(value = "kehu_fuwu_uuid_number")

    private String kehuFuwuUuidNumber;


    /**
     * 客户服务标题
     */
    @ColumnInfo(comment="客户服务标题",type="varchar(200)")
    @TableField(value = "kehu_fuwu_name")

    private String kehuFuwuName;


    /**
     * 服务附件
     */
    @ColumnInfo(comment="服务附件",type="varchar(200)")
    @TableField(value = "kehu_fuwu_file")

    private String kehuFuwuFile;


    /**
     * 客户服务类型
     */
    @ColumnInfo(comment="客户服务类型",type="int(11)")
    @TableField(value = "kehu_fuwu_types")

    private Integer kehuFuwuTypes;


    /**
     * 客户服务日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="客户服务日期",type="date")
    @TableField(value = "fuwu_time")

    private Date fuwuTime;


    /**
     * 客户服务内容
     */
    @ColumnInfo(comment="客户服务内容",type="text")
    @TableField(value = "kehu_fuwu_content")

    private String kehuFuwuContent;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="安排时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 状态
     */
    @ColumnInfo(comment="状态",type="int(11)")
    @TableField(value = "kehu_fuwu_zhuangtai_types")

    private Integer kehuFuwuZhuangtaiTypes;


    /**
     * 服务时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="服务时间",type="date")
    @TableField(value = "fuwu_xiangxi_time")

    private Date fuwuXiangxiTime;


    /**
     * 客户反馈
     */
    @ColumnInfo(comment="客户反馈",type="text")
    @TableField(value = "kehu_fuwu_fankui_content")

    private String kehuFuwuFankuiContent;


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
        return "KehuFuwu{" +
            ", id=" + id +
            ", kehuId=" + kehuId +
            ", kehuFuwuUuidNumber=" + kehuFuwuUuidNumber +
            ", kehuFuwuName=" + kehuFuwuName +
            ", kehuFuwuFile=" + kehuFuwuFile +
            ", kehuFuwuTypes=" + kehuFuwuTypes +
            ", fuwuTime=" + DateUtil.convertString(fuwuTime,"yyyy-MM-dd") +
            ", kehuFuwuContent=" + kehuFuwuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", kehuFuwuZhuangtaiTypes=" + kehuFuwuZhuangtaiTypes +
            ", fuwuXiangxiTime=" + DateUtil.convertString(fuwuXiangxiTime,"yyyy-MM-dd") +
            ", kehuFuwuFankuiContent=" + kehuFuwuFankuiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

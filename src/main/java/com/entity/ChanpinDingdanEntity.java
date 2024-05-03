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
 * 产品订单
 *
 * @author 
 * @email
 */
@TableName("chanpin_dingdan")
public class ChanpinDingdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChanpinDingdanEntity() {

	}

	public ChanpinDingdanEntity(T t) {
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
     * 产品
     */
    @ColumnInfo(comment="产品",type="int(11)")
    @TableField(value = "chanpin_id")

    private Integer chanpinId;


    /**
     * 客户
     */
    @ColumnInfo(comment="客户",type="int(11)")
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 销售编号
     */
    @ColumnInfo(comment="销售编号",type="varchar(200)")
    @TableField(value = "chanpin_dingdan_uuid_number")

    private String chanpinDingdanUuidNumber;


    /**
     * 销售类型
     */
    @ColumnInfo(comment="销售类型",type="int(11)")
    @TableField(value = "chanpin_dingdan_xiaoshou_types")

    private Integer chanpinDingdanXiaoshouTypes;


    /**
     * 销售方式
     */
    @ColumnInfo(comment="销售方式",type="int(11)")
    @TableField(value = "chanpin_dingdan_xiaoshoufangshi_types")

    private Integer chanpinDingdanXiaoshoufangshiTypes;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "chanpin_dingdan_kuaidigongsi")

    private String chanpinDingdanKuaidigongsi;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "chanpin_dingdan_danhao")

    private String chanpinDingdanDanhao;


    /**
     * 销售数量
     */
    @ColumnInfo(comment="销售数量",type="int(11)")
    @TableField(value = "chanpin_dingdan_number")

    private Integer chanpinDingdanNumber;


    /**
     * 销售金额
     */
    @ColumnInfo(comment="销售金额",type="decimal(10,2)")
    @TableField(value = "chanpin_dingdan_jine")

    private Double chanpinDingdanJine;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="销售时间",type="timestamp")
    @TableField(value = "chanpin_dingdan_time")

    private Date chanpinDingdanTime;


    /**
     * 销售状态
     */
    @ColumnInfo(comment="销售状态",type="int(11)")
    @TableField(value = "chanpin_dingdan_types")

    private Integer chanpinDingdanTypes;


    /**
     * 销售备注
     */
    @ColumnInfo(comment="销售备注",type="longtext")
    @TableField(value = "chanpin_dingdan_content")

    private String chanpinDingdanContent;


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
	 * 获取：产品
	 */
    public Integer getChanpinId() {
        return chanpinId;
    }
    /**
	 * 设置：产品
	 */

    public void setChanpinId(Integer chanpinId) {
        this.chanpinId = chanpinId;
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
	 * 获取：销售编号
	 */
    public String getChanpinDingdanUuidNumber() {
        return chanpinDingdanUuidNumber;
    }
    /**
	 * 设置：销售编号
	 */

    public void setChanpinDingdanUuidNumber(String chanpinDingdanUuidNumber) {
        this.chanpinDingdanUuidNumber = chanpinDingdanUuidNumber;
    }
    /**
	 * 获取：销售类型
	 */
    public Integer getChanpinDingdanXiaoshouTypes() {
        return chanpinDingdanXiaoshouTypes;
    }
    /**
	 * 设置：销售类型
	 */

    public void setChanpinDingdanXiaoshouTypes(Integer chanpinDingdanXiaoshouTypes) {
        this.chanpinDingdanXiaoshouTypes = chanpinDingdanXiaoshouTypes;
    }
    /**
	 * 获取：销售方式
	 */
    public Integer getChanpinDingdanXiaoshoufangshiTypes() {
        return chanpinDingdanXiaoshoufangshiTypes;
    }
    /**
	 * 设置：销售方式
	 */

    public void setChanpinDingdanXiaoshoufangshiTypes(Integer chanpinDingdanXiaoshoufangshiTypes) {
        this.chanpinDingdanXiaoshoufangshiTypes = chanpinDingdanXiaoshoufangshiTypes;
    }
    /**
	 * 获取：快递公司
	 */
    public String getChanpinDingdanKuaidigongsi() {
        return chanpinDingdanKuaidigongsi;
    }
    /**
	 * 设置：快递公司
	 */

    public void setChanpinDingdanKuaidigongsi(String chanpinDingdanKuaidigongsi) {
        this.chanpinDingdanKuaidigongsi = chanpinDingdanKuaidigongsi;
    }
    /**
	 * 获取：快递单号
	 */
    public String getChanpinDingdanDanhao() {
        return chanpinDingdanDanhao;
    }
    /**
	 * 设置：快递单号
	 */

    public void setChanpinDingdanDanhao(String chanpinDingdanDanhao) {
        this.chanpinDingdanDanhao = chanpinDingdanDanhao;
    }
    /**
	 * 获取：销售数量
	 */
    public Integer getChanpinDingdanNumber() {
        return chanpinDingdanNumber;
    }
    /**
	 * 设置：销售数量
	 */

    public void setChanpinDingdanNumber(Integer chanpinDingdanNumber) {
        this.chanpinDingdanNumber = chanpinDingdanNumber;
    }
    /**
	 * 获取：销售金额
	 */
    public Double getChanpinDingdanJine() {
        return chanpinDingdanJine;
    }
    /**
	 * 设置：销售金额
	 */

    public void setChanpinDingdanJine(Double chanpinDingdanJine) {
        this.chanpinDingdanJine = chanpinDingdanJine;
    }
    /**
	 * 获取：销售时间
	 */
    public Date getChanpinDingdanTime() {
        return chanpinDingdanTime;
    }
    /**
	 * 设置：销售时间
	 */

    public void setChanpinDingdanTime(Date chanpinDingdanTime) {
        this.chanpinDingdanTime = chanpinDingdanTime;
    }
    /**
	 * 获取：销售状态
	 */
    public Integer getChanpinDingdanTypes() {
        return chanpinDingdanTypes;
    }
    /**
	 * 设置：销售状态
	 */

    public void setChanpinDingdanTypes(Integer chanpinDingdanTypes) {
        this.chanpinDingdanTypes = chanpinDingdanTypes;
    }
    /**
	 * 获取：销售备注
	 */
    public String getChanpinDingdanContent() {
        return chanpinDingdanContent;
    }
    /**
	 * 设置：销售备注
	 */

    public void setChanpinDingdanContent(String chanpinDingdanContent) {
        this.chanpinDingdanContent = chanpinDingdanContent;
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
        return "ChanpinDingdan{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", chanpinId=" + chanpinId +
            ", kehuId=" + kehuId +
            ", chanpinDingdanUuidNumber=" + chanpinDingdanUuidNumber +
            ", chanpinDingdanXiaoshouTypes=" + chanpinDingdanXiaoshouTypes +
            ", chanpinDingdanXiaoshoufangshiTypes=" + chanpinDingdanXiaoshoufangshiTypes +
            ", chanpinDingdanKuaidigongsi=" + chanpinDingdanKuaidigongsi +
            ", chanpinDingdanDanhao=" + chanpinDingdanDanhao +
            ", chanpinDingdanNumber=" + chanpinDingdanNumber +
            ", chanpinDingdanJine=" + chanpinDingdanJine +
            ", chanpinDingdanTime=" + DateUtil.convertString(chanpinDingdanTime,"yyyy-MM-dd") +
            ", chanpinDingdanTypes=" + chanpinDingdanTypes +
            ", chanpinDingdanContent=" + chanpinDingdanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

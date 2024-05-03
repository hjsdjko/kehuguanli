package com.entity.vo;

import com.entity.ChanpinDingdanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 产品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chanpin_dingdan")
public class ChanpinDingdanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 产品
     */

    @TableField(value = "chanpin_id")
    private Integer chanpinId;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 销售编号
     */

    @TableField(value = "chanpin_dingdan_uuid_number")
    private String chanpinDingdanUuidNumber;


    /**
     * 销售类型
     */

    @TableField(value = "chanpin_dingdan_xiaoshou_types")
    private Integer chanpinDingdanXiaoshouTypes;


    /**
     * 销售方式
     */

    @TableField(value = "chanpin_dingdan_xiaoshoufangshi_types")
    private Integer chanpinDingdanXiaoshoufangshiTypes;


    /**
     * 快递公司
     */

    @TableField(value = "chanpin_dingdan_kuaidigongsi")
    private String chanpinDingdanKuaidigongsi;


    /**
     * 快递单号
     */

    @TableField(value = "chanpin_dingdan_danhao")
    private String chanpinDingdanDanhao;


    /**
     * 销售数量
     */

    @TableField(value = "chanpin_dingdan_number")
    private Integer chanpinDingdanNumber;


    /**
     * 销售金额
     */

    @TableField(value = "chanpin_dingdan_jine")
    private Double chanpinDingdanJine;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chanpin_dingdan_time")
    private Date chanpinDingdanTime;


    /**
     * 销售状态
     */

    @TableField(value = "chanpin_dingdan_types")
    private Integer chanpinDingdanTypes;


    /**
     * 销售备注
     */

    @TableField(value = "chanpin_dingdan_content")
    private String chanpinDingdanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：产品
	 */
    public Integer getChanpinId() {
        return chanpinId;
    }


    /**
	 * 获取：产品
	 */

    public void setChanpinId(Integer chanpinId) {
        this.chanpinId = chanpinId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：销售编号
	 */
    public String getChanpinDingdanUuidNumber() {
        return chanpinDingdanUuidNumber;
    }


    /**
	 * 获取：销售编号
	 */

    public void setChanpinDingdanUuidNumber(String chanpinDingdanUuidNumber) {
        this.chanpinDingdanUuidNumber = chanpinDingdanUuidNumber;
    }
    /**
	 * 设置：销售类型
	 */
    public Integer getChanpinDingdanXiaoshouTypes() {
        return chanpinDingdanXiaoshouTypes;
    }


    /**
	 * 获取：销售类型
	 */

    public void setChanpinDingdanXiaoshouTypes(Integer chanpinDingdanXiaoshouTypes) {
        this.chanpinDingdanXiaoshouTypes = chanpinDingdanXiaoshouTypes;
    }
    /**
	 * 设置：销售方式
	 */
    public Integer getChanpinDingdanXiaoshoufangshiTypes() {
        return chanpinDingdanXiaoshoufangshiTypes;
    }


    /**
	 * 获取：销售方式
	 */

    public void setChanpinDingdanXiaoshoufangshiTypes(Integer chanpinDingdanXiaoshoufangshiTypes) {
        this.chanpinDingdanXiaoshoufangshiTypes = chanpinDingdanXiaoshoufangshiTypes;
    }
    /**
	 * 设置：快递公司
	 */
    public String getChanpinDingdanKuaidigongsi() {
        return chanpinDingdanKuaidigongsi;
    }


    /**
	 * 获取：快递公司
	 */

    public void setChanpinDingdanKuaidigongsi(String chanpinDingdanKuaidigongsi) {
        this.chanpinDingdanKuaidigongsi = chanpinDingdanKuaidigongsi;
    }
    /**
	 * 设置：快递单号
	 */
    public String getChanpinDingdanDanhao() {
        return chanpinDingdanDanhao;
    }


    /**
	 * 获取：快递单号
	 */

    public void setChanpinDingdanDanhao(String chanpinDingdanDanhao) {
        this.chanpinDingdanDanhao = chanpinDingdanDanhao;
    }
    /**
	 * 设置：销售数量
	 */
    public Integer getChanpinDingdanNumber() {
        return chanpinDingdanNumber;
    }


    /**
	 * 获取：销售数量
	 */

    public void setChanpinDingdanNumber(Integer chanpinDingdanNumber) {
        this.chanpinDingdanNumber = chanpinDingdanNumber;
    }
    /**
	 * 设置：销售金额
	 */
    public Double getChanpinDingdanJine() {
        return chanpinDingdanJine;
    }


    /**
	 * 获取：销售金额
	 */

    public void setChanpinDingdanJine(Double chanpinDingdanJine) {
        this.chanpinDingdanJine = chanpinDingdanJine;
    }
    /**
	 * 设置：销售时间
	 */
    public Date getChanpinDingdanTime() {
        return chanpinDingdanTime;
    }


    /**
	 * 获取：销售时间
	 */

    public void setChanpinDingdanTime(Date chanpinDingdanTime) {
        this.chanpinDingdanTime = chanpinDingdanTime;
    }
    /**
	 * 设置：销售状态
	 */
    public Integer getChanpinDingdanTypes() {
        return chanpinDingdanTypes;
    }


    /**
	 * 获取：销售状态
	 */

    public void setChanpinDingdanTypes(Integer chanpinDingdanTypes) {
        this.chanpinDingdanTypes = chanpinDingdanTypes;
    }
    /**
	 * 设置：销售备注
	 */
    public String getChanpinDingdanContent() {
        return chanpinDingdanContent;
    }


    /**
	 * 获取：销售备注
	 */

    public void setChanpinDingdanContent(String chanpinDingdanContent) {
        this.chanpinDingdanContent = chanpinDingdanContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

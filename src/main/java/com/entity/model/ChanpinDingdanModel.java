package com.entity.model;

import com.entity.ChanpinDingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 产品订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinDingdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 产品
     */
    private Integer chanpinId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 销售编号
     */
    private String chanpinDingdanUuidNumber;


    /**
     * 销售类型
     */
    private Integer chanpinDingdanXiaoshouTypes;


    /**
     * 销售方式
     */
    private Integer chanpinDingdanXiaoshoufangshiTypes;


    /**
     * 快递公司
     */
    private String chanpinDingdanKuaidigongsi;


    /**
     * 快递单号
     */
    private String chanpinDingdanDanhao;


    /**
     * 销售数量
     */
    private Integer chanpinDingdanNumber;


    /**
     * 销售金额
     */
    private Double chanpinDingdanJine;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chanpinDingdanTime;


    /**
     * 销售状态
     */
    private Integer chanpinDingdanTypes;


    /**
     * 销售备注
     */
    private String chanpinDingdanContent;


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

    }

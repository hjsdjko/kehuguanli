package com.entity.vo;

import com.entity.ChanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 产品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chanpin")
public class ChanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 产品名称
     */

    @TableField(value = "chanpin_name")
    private String chanpinName;


    /**
     * 产品编号
     */

    @TableField(value = "chanpin_uuid_number")
    private String chanpinUuidNumber;


    /**
     * 产品照片
     */

    @TableField(value = "chanpin_photo")
    private String chanpinPhoto;


    /**
     * 单位
     */

    @TableField(value = "chanpin_danwei")
    private String chanpinDanwei;


    /**
     * 产品类型
     */

    @TableField(value = "chanpin_types")
    private Integer chanpinTypes;


    /**
     * 产品原价
     */

    @TableField(value = "chanpin_old_money")
    private Double chanpinOldMoney;


    /**
     * 现价
     */

    @TableField(value = "chanpin_new_money")
    private Double chanpinNewMoney;


    /**
     * 所属仓库
     */

    @TableField(value = "chanpin_cangku")
    private String chanpinCangku;


    /**
     * 产品介绍
     */

    @TableField(value = "chanpin_content")
    private String chanpinContent;


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
	 * 设置：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 获取：产品名称
	 */

    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 设置：产品编号
	 */
    public String getChanpinUuidNumber() {
        return chanpinUuidNumber;
    }


    /**
	 * 获取：产品编号
	 */

    public void setChanpinUuidNumber(String chanpinUuidNumber) {
        this.chanpinUuidNumber = chanpinUuidNumber;
    }
    /**
	 * 设置：产品照片
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }


    /**
	 * 获取：产品照片
	 */

    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 设置：单位
	 */
    public String getChanpinDanwei() {
        return chanpinDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setChanpinDanwei(String chanpinDanwei) {
        this.chanpinDanwei = chanpinDanwei;
    }
    /**
	 * 设置：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 获取：产品类型
	 */

    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 设置：产品原价
	 */
    public Double getChanpinOldMoney() {
        return chanpinOldMoney;
    }


    /**
	 * 获取：产品原价
	 */

    public void setChanpinOldMoney(Double chanpinOldMoney) {
        this.chanpinOldMoney = chanpinOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getChanpinNewMoney() {
        return chanpinNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setChanpinNewMoney(Double chanpinNewMoney) {
        this.chanpinNewMoney = chanpinNewMoney;
    }
    /**
	 * 设置：所属仓库
	 */
    public String getChanpinCangku() {
        return chanpinCangku;
    }


    /**
	 * 获取：所属仓库
	 */

    public void setChanpinCangku(String chanpinCangku) {
        this.chanpinCangku = chanpinCangku;
    }
    /**
	 * 设置：产品介绍
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 获取：产品介绍
	 */

    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
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

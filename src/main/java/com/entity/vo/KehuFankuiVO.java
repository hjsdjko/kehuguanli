package com.entity.vo;

import com.entity.KehuFankuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 反馈建议
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kehu_fankui")
public class KehuFankuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 客户反馈编号
     */

    @TableField(value = "kehu_fankui_uuid_number")
    private String kehuFankuiUuidNumber;


    /**
     * 客户反馈标题
     */

    @TableField(value = "kehu_fankui_name")
    private String kehuFankuiName;


    /**
     * 反馈附件
     */

    @TableField(value = "kehu_fankui_file")
    private String kehuFankuiFile;


    /**
     * 客户反馈类型
     */

    @TableField(value = "kehu_fankui_types")
    private Integer kehuFankuiTypes;


    /**
     * 客户反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwu_time")
    private Date fuwuTime;


    /**
     * 客户反馈内容
     */

    @TableField(value = "kehu_fankui_content")
    private String kehuFankuiContent;


    /**
     * 反馈状态
     */

    @TableField(value = "kehu_fankuizhuangtai_types")
    private Integer kehuFankuizhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：客户反馈编号
	 */
    public String getKehuFankuiUuidNumber() {
        return kehuFankuiUuidNumber;
    }


    /**
	 * 获取：客户反馈编号
	 */

    public void setKehuFankuiUuidNumber(String kehuFankuiUuidNumber) {
        this.kehuFankuiUuidNumber = kehuFankuiUuidNumber;
    }
    /**
	 * 设置：客户反馈标题
	 */
    public String getKehuFankuiName() {
        return kehuFankuiName;
    }


    /**
	 * 获取：客户反馈标题
	 */

    public void setKehuFankuiName(String kehuFankuiName) {
        this.kehuFankuiName = kehuFankuiName;
    }
    /**
	 * 设置：反馈附件
	 */
    public String getKehuFankuiFile() {
        return kehuFankuiFile;
    }


    /**
	 * 获取：反馈附件
	 */

    public void setKehuFankuiFile(String kehuFankuiFile) {
        this.kehuFankuiFile = kehuFankuiFile;
    }
    /**
	 * 设置：客户反馈类型
	 */
    public Integer getKehuFankuiTypes() {
        return kehuFankuiTypes;
    }


    /**
	 * 获取：客户反馈类型
	 */

    public void setKehuFankuiTypes(Integer kehuFankuiTypes) {
        this.kehuFankuiTypes = kehuFankuiTypes;
    }
    /**
	 * 设置：客户反馈时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 获取：客户反馈时间
	 */

    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 设置：客户反馈内容
	 */
    public String getKehuFankuiContent() {
        return kehuFankuiContent;
    }


    /**
	 * 获取：客户反馈内容
	 */

    public void setKehuFankuiContent(String kehuFankuiContent) {
        this.kehuFankuiContent = kehuFankuiContent;
    }
    /**
	 * 设置：反馈状态
	 */
    public Integer getKehuFankuizhuangtaiTypes() {
        return kehuFankuizhuangtaiTypes;
    }


    /**
	 * 获取：反馈状态
	 */

    public void setKehuFankuizhuangtaiTypes(Integer kehuFankuizhuangtaiTypes) {
        this.kehuFankuizhuangtaiTypes = kehuFankuizhuangtaiTypes;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

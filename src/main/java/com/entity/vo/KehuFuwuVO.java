package com.entity.vo;

import com.entity.KehuFuwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kehu_fuwu")
public class KehuFuwuVO implements Serializable {
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
     * 客户服务编号
     */

    @TableField(value = "kehu_fuwu_uuid_number")
    private String kehuFuwuUuidNumber;


    /**
     * 客户服务标题
     */

    @TableField(value = "kehu_fuwu_name")
    private String kehuFuwuName;


    /**
     * 服务附件
     */

    @TableField(value = "kehu_fuwu_file")
    private String kehuFuwuFile;


    /**
     * 客户服务类型
     */

    @TableField(value = "kehu_fuwu_types")
    private Integer kehuFuwuTypes;


    /**
     * 客户服务日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwu_time")
    private Date fuwuTime;


    /**
     * 客户服务内容
     */

    @TableField(value = "kehu_fuwu_content")
    private String kehuFuwuContent;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 状态
     */

    @TableField(value = "kehu_fuwu_zhuangtai_types")
    private Integer kehuFuwuZhuangtaiTypes;


    /**
     * 服务时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwu_xiangxi_time")
    private Date fuwuXiangxiTime;


    /**
     * 客户反馈
     */

    @TableField(value = "kehu_fuwu_fankui_content")
    private String kehuFuwuFankuiContent;


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
	 * 设置：客户服务编号
	 */
    public String getKehuFuwuUuidNumber() {
        return kehuFuwuUuidNumber;
    }


    /**
	 * 获取：客户服务编号
	 */

    public void setKehuFuwuUuidNumber(String kehuFuwuUuidNumber) {
        this.kehuFuwuUuidNumber = kehuFuwuUuidNumber;
    }
    /**
	 * 设置：客户服务标题
	 */
    public String getKehuFuwuName() {
        return kehuFuwuName;
    }


    /**
	 * 获取：客户服务标题
	 */

    public void setKehuFuwuName(String kehuFuwuName) {
        this.kehuFuwuName = kehuFuwuName;
    }
    /**
	 * 设置：服务附件
	 */
    public String getKehuFuwuFile() {
        return kehuFuwuFile;
    }


    /**
	 * 获取：服务附件
	 */

    public void setKehuFuwuFile(String kehuFuwuFile) {
        this.kehuFuwuFile = kehuFuwuFile;
    }
    /**
	 * 设置：客户服务类型
	 */
    public Integer getKehuFuwuTypes() {
        return kehuFuwuTypes;
    }


    /**
	 * 获取：客户服务类型
	 */

    public void setKehuFuwuTypes(Integer kehuFuwuTypes) {
        this.kehuFuwuTypes = kehuFuwuTypes;
    }
    /**
	 * 设置：客户服务日期
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 获取：客户服务日期
	 */

    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 设置：客户服务内容
	 */
    public String getKehuFuwuContent() {
        return kehuFuwuContent;
    }


    /**
	 * 获取：客户服务内容
	 */

    public void setKehuFuwuContent(String kehuFuwuContent) {
        this.kehuFuwuContent = kehuFuwuContent;
    }
    /**
	 * 设置：安排时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：安排时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：状态
	 */
    public Integer getKehuFuwuZhuangtaiTypes() {
        return kehuFuwuZhuangtaiTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setKehuFuwuZhuangtaiTypes(Integer kehuFuwuZhuangtaiTypes) {
        this.kehuFuwuZhuangtaiTypes = kehuFuwuZhuangtaiTypes;
    }
    /**
	 * 设置：服务时间
	 */
    public Date getFuwuXiangxiTime() {
        return fuwuXiangxiTime;
    }


    /**
	 * 获取：服务时间
	 */

    public void setFuwuXiangxiTime(Date fuwuXiangxiTime) {
        this.fuwuXiangxiTime = fuwuXiangxiTime;
    }
    /**
	 * 设置：客户反馈
	 */
    public String getKehuFuwuFankuiContent() {
        return kehuFuwuFankuiContent;
    }


    /**
	 * 获取：客户反馈
	 */

    public void setKehuFuwuFankuiContent(String kehuFuwuFankuiContent) {
        this.kehuFuwuFankuiContent = kehuFuwuFankuiContent;
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

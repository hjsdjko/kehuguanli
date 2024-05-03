package com.entity.vo;

import com.entity.KehuLiushiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户流失
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kehu_liushi")
public class KehuLiushiVO implements Serializable {
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
     * 客户流失编号
     */

    @TableField(value = "kehu_liushi_uuid_number")
    private String kehuLiushiUuidNumber;


    /**
     * 客户流失标题
     */

    @TableField(value = "kehu_liushi_name")
    private String kehuLiushiName;


    /**
     * 流失附件
     */

    @TableField(value = "kehu_liushi_file")
    private String kehuLiushiFile;


    /**
     * 客户流失类型
     */

    @TableField(value = "kehu_liushi_types")
    private Integer kehuLiushiTypes;


    /**
     * 客户流失时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwu_time")
    private Date fuwuTime;


    /**
     * 客户流失详情
     */

    @TableField(value = "kehu_liushi_content")
    private String kehuLiushiContent;


    /**
     * 上传时间
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
	 * 设置：客户流失编号
	 */
    public String getKehuLiushiUuidNumber() {
        return kehuLiushiUuidNumber;
    }


    /**
	 * 获取：客户流失编号
	 */

    public void setKehuLiushiUuidNumber(String kehuLiushiUuidNumber) {
        this.kehuLiushiUuidNumber = kehuLiushiUuidNumber;
    }
    /**
	 * 设置：客户流失标题
	 */
    public String getKehuLiushiName() {
        return kehuLiushiName;
    }


    /**
	 * 获取：客户流失标题
	 */

    public void setKehuLiushiName(String kehuLiushiName) {
        this.kehuLiushiName = kehuLiushiName;
    }
    /**
	 * 设置：流失附件
	 */
    public String getKehuLiushiFile() {
        return kehuLiushiFile;
    }


    /**
	 * 获取：流失附件
	 */

    public void setKehuLiushiFile(String kehuLiushiFile) {
        this.kehuLiushiFile = kehuLiushiFile;
    }
    /**
	 * 设置：客户流失类型
	 */
    public Integer getKehuLiushiTypes() {
        return kehuLiushiTypes;
    }


    /**
	 * 获取：客户流失类型
	 */

    public void setKehuLiushiTypes(Integer kehuLiushiTypes) {
        this.kehuLiushiTypes = kehuLiushiTypes;
    }
    /**
	 * 设置：客户流失时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 获取：客户流失时间
	 */

    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 设置：客户流失详情
	 */
    public String getKehuLiushiContent() {
        return kehuLiushiContent;
    }


    /**
	 * 获取：客户流失详情
	 */

    public void setKehuLiushiContent(String kehuLiushiContent) {
        this.kehuLiushiContent = kehuLiushiContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
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

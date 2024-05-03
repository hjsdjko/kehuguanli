package com.entity.vo;

import com.entity.KehuZoufangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户走访
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kehu_zoufang")
public class KehuZoufangVO implements Serializable {
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
     * 客户走访编号
     */

    @TableField(value = "kehu_zoufang_uuid_number")
    private String kehuZoufangUuidNumber;


    /**
     * 客户走访标题
     */

    @TableField(value = "kehu_zoufang_name")
    private String kehuZoufangName;


    /**
     * 走访附件
     */

    @TableField(value = "kehu_zoufang_file")
    private String kehuZoufangFile;


    /**
     * 客户走访类型
     */

    @TableField(value = "kehu_zoufang_types")
    private Integer kehuZoufangTypes;


    /**
     * 客户走访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwu_time")
    private Date fuwuTime;


    /**
     * 客户走访内容
     */

    @TableField(value = "kehu_zoufang_content")
    private String kehuZoufangContent;


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
	 * 设置：客户走访编号
	 */
    public String getKehuZoufangUuidNumber() {
        return kehuZoufangUuidNumber;
    }


    /**
	 * 获取：客户走访编号
	 */

    public void setKehuZoufangUuidNumber(String kehuZoufangUuidNumber) {
        this.kehuZoufangUuidNumber = kehuZoufangUuidNumber;
    }
    /**
	 * 设置：客户走访标题
	 */
    public String getKehuZoufangName() {
        return kehuZoufangName;
    }


    /**
	 * 获取：客户走访标题
	 */

    public void setKehuZoufangName(String kehuZoufangName) {
        this.kehuZoufangName = kehuZoufangName;
    }
    /**
	 * 设置：走访附件
	 */
    public String getKehuZoufangFile() {
        return kehuZoufangFile;
    }


    /**
	 * 获取：走访附件
	 */

    public void setKehuZoufangFile(String kehuZoufangFile) {
        this.kehuZoufangFile = kehuZoufangFile;
    }
    /**
	 * 设置：客户走访类型
	 */
    public Integer getKehuZoufangTypes() {
        return kehuZoufangTypes;
    }


    /**
	 * 获取：客户走访类型
	 */

    public void setKehuZoufangTypes(Integer kehuZoufangTypes) {
        this.kehuZoufangTypes = kehuZoufangTypes;
    }
    /**
	 * 设置：客户走访时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 获取：客户走访时间
	 */

    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 设置：客户走访内容
	 */
    public String getKehuZoufangContent() {
        return kehuZoufangContent;
    }


    /**
	 * 获取：客户走访内容
	 */

    public void setKehuZoufangContent(String kehuZoufangContent) {
        this.kehuZoufangContent = kehuZoufangContent;
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

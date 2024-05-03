package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChanpinDingdanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 产品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chanpin_dingdan")
public class ChanpinDingdanView extends ChanpinDingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 销售类型的值
	*/
	@ColumnInfo(comment="销售类型的字典表值",type="varchar(200)")
	private String chanpinDingdanXiaoshouValue;
	/**
	* 销售方式的值
	*/
	@ColumnInfo(comment="销售方式的字典表值",type="varchar(200)")
	private String chanpinDingdanXiaoshoufangshiValue;
	/**
	* 销售状态的值
	*/
	@ColumnInfo(comment="销售状态的字典表值",type="varchar(200)")
	private String chanpinDingdanValue;

	//级联表 产品
		/**
		* 产品名称
		*/

		@ColumnInfo(comment="产品名称",type="varchar(200)")
		private String chanpinName;
		/**
		* 产品编号
		*/

		@ColumnInfo(comment="产品编号",type="varchar(200)")
		private String chanpinUuidNumber;
		/**
		* 产品照片
		*/

		@ColumnInfo(comment="产品照片",type="varchar(200)")
		private String chanpinPhoto;
		/**
		* 单位
		*/

		@ColumnInfo(comment="单位",type="varchar(200)")
		private String chanpinDanwei;
		/**
		* 产品类型
		*/
		@ColumnInfo(comment="产品类型",type="int(11)")
		private Integer chanpinTypes;
			/**
			* 产品类型的值
			*/
			@ColumnInfo(comment="产品类型的字典表值",type="varchar(200)")
			private String chanpinValue;
		/**
		* 产品原价
		*/
		@ColumnInfo(comment="产品原价",type="decimal(10,2)")
		private Double chanpinOldMoney;
		/**
		* 现价
		*/
		@ColumnInfo(comment="现价",type="decimal(10,2)")
		private Double chanpinNewMoney;
		/**
		* 所属仓库
		*/

		@ColumnInfo(comment="所属仓库",type="varchar(200)")
		private String chanpinCangku;
		/**
		* 产品介绍
		*/

		@ColumnInfo(comment="产品介绍",type="longtext")
		private String chanpinContent;
	//级联表 客户
					 
		/**
		* 客户 的 员工
		*/
		@ColumnInfo(comment="员工",type="int(11)")
		private Integer kehuYuangongId;
		/**
		* 客户编号
		*/

		@ColumnInfo(comment="客户编号",type="varchar(200)")
		private String kehuUuidNumber;
		/**
		* 客户姓名
		*/

		@ColumnInfo(comment="客户姓名",type="varchar(200)")
		private String kehuName;
		/**
		* 客户手机号
		*/

		@ColumnInfo(comment="客户手机号",type="varchar(200)")
		private String kehuPhone;
		/**
		* 客户身份证号
		*/

		@ColumnInfo(comment="客户身份证号",type="varchar(200)")
		private String kehuIdNumber;
		/**
		* 客户照片
		*/

		@ColumnInfo(comment="客户照片",type="varchar(200)")
		private String kehuPhoto;
		/**
		* 客户邮箱
		*/

		@ColumnInfo(comment="客户邮箱",type="varchar(200)")
		private String kehuEmail;
		/**
		* 住址
		*/

		@ColumnInfo(comment="住址",type="varchar(200)")
		private String kehuAddress;
		/**
		* 行业
		*/
		@ColumnInfo(comment="行业",type="int(11)")
		private Integer hangyeTypes;
			/**
			* 行业的值
			*/
			@ColumnInfo(comment="行业的字典表值",type="varchar(200)")
			private String hangyeValue;
		/**
		* 职位
		*/
		@ColumnInfo(comment="职位",type="int(11)")
		private Integer zhiweiTypes;
			/**
			* 职位的值
			*/
			@ColumnInfo(comment="职位的字典表值",type="varchar(200)")
			private String zhiweiValue;
		/**
		* 地区
		*/
		@ColumnInfo(comment="地区",type="int(11)")
		private Integer diquTypes;
			/**
			* 地区的值
			*/
			@ColumnInfo(comment="地区的字典表值",type="varchar(200)")
			private String diquValue;
	//级联表 员工
		/**
		* 员工编号
		*/

		@ColumnInfo(comment="员工编号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ChanpinDingdanView() {

	}

	public ChanpinDingdanView(ChanpinDingdanEntity chanpinDingdanEntity) {
		try {
			BeanUtils.copyProperties(this, chanpinDingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 销售类型的值
	*/
	public String getChanpinDingdanXiaoshouValue() {
		return chanpinDingdanXiaoshouValue;
	}
	/**
	* 设置： 销售类型的值
	*/
	public void setChanpinDingdanXiaoshouValue(String chanpinDingdanXiaoshouValue) {
		this.chanpinDingdanXiaoshouValue = chanpinDingdanXiaoshouValue;
	}
	//当前表的
	/**
	* 获取： 销售方式的值
	*/
	public String getChanpinDingdanXiaoshoufangshiValue() {
		return chanpinDingdanXiaoshoufangshiValue;
	}
	/**
	* 设置： 销售方式的值
	*/
	public void setChanpinDingdanXiaoshoufangshiValue(String chanpinDingdanXiaoshoufangshiValue) {
		this.chanpinDingdanXiaoshoufangshiValue = chanpinDingdanXiaoshoufangshiValue;
	}
	//当前表的
	/**
	* 获取： 销售状态的值
	*/
	public String getChanpinDingdanValue() {
		return chanpinDingdanValue;
	}
	/**
	* 设置： 销售状态的值
	*/
	public void setChanpinDingdanValue(String chanpinDingdanValue) {
		this.chanpinDingdanValue = chanpinDingdanValue;
	}


	//级联表的get和set 产品

		/**
		* 获取： 产品名称
		*/
		public String getChanpinName() {
			return chanpinName;
		}
		/**
		* 设置： 产品名称
		*/
		public void setChanpinName(String chanpinName) {
			this.chanpinName = chanpinName;
		}

		/**
		* 获取： 产品编号
		*/
		public String getChanpinUuidNumber() {
			return chanpinUuidNumber;
		}
		/**
		* 设置： 产品编号
		*/
		public void setChanpinUuidNumber(String chanpinUuidNumber) {
			this.chanpinUuidNumber = chanpinUuidNumber;
		}

		/**
		* 获取： 产品照片
		*/
		public String getChanpinPhoto() {
			return chanpinPhoto;
		}
		/**
		* 设置： 产品照片
		*/
		public void setChanpinPhoto(String chanpinPhoto) {
			this.chanpinPhoto = chanpinPhoto;
		}

		/**
		* 获取： 单位
		*/
		public String getChanpinDanwei() {
			return chanpinDanwei;
		}
		/**
		* 设置： 单位
		*/
		public void setChanpinDanwei(String chanpinDanwei) {
			this.chanpinDanwei = chanpinDanwei;
		}
		/**
		* 获取： 产品类型
		*/
		public Integer getChanpinTypes() {
			return chanpinTypes;
		}
		/**
		* 设置： 产品类型
		*/
		public void setChanpinTypes(Integer chanpinTypes) {
			this.chanpinTypes = chanpinTypes;
		}


			/**
			* 获取： 产品类型的值
			*/
			public String getChanpinValue() {
				return chanpinValue;
			}
			/**
			* 设置： 产品类型的值
			*/
			public void setChanpinValue(String chanpinValue) {
				this.chanpinValue = chanpinValue;
			}

		/**
		* 获取： 产品原价
		*/
		public Double getChanpinOldMoney() {
			return chanpinOldMoney;
		}
		/**
		* 设置： 产品原价
		*/
		public void setChanpinOldMoney(Double chanpinOldMoney) {
			this.chanpinOldMoney = chanpinOldMoney;
		}

		/**
		* 获取： 现价
		*/
		public Double getChanpinNewMoney() {
			return chanpinNewMoney;
		}
		/**
		* 设置： 现价
		*/
		public void setChanpinNewMoney(Double chanpinNewMoney) {
			this.chanpinNewMoney = chanpinNewMoney;
		}

		/**
		* 获取： 所属仓库
		*/
		public String getChanpinCangku() {
			return chanpinCangku;
		}
		/**
		* 设置： 所属仓库
		*/
		public void setChanpinCangku(String chanpinCangku) {
			this.chanpinCangku = chanpinCangku;
		}

		/**
		* 获取： 产品介绍
		*/
		public String getChanpinContent() {
			return chanpinContent;
		}
		/**
		* 设置： 产品介绍
		*/
		public void setChanpinContent(String chanpinContent) {
			this.chanpinContent = chanpinContent;
		}
	//级联表的get和set 客户
		/**
		* 获取：客户 的 员工
		*/
		public Integer getKehuYuangongId() {
			return kehuYuangongId;
		}
		/**
		* 设置：客户 的 员工
		*/
		public void setKehuYuangongId(Integer kehuYuangongId) {
			this.kehuYuangongId = kehuYuangongId;
		}

		/**
		* 获取： 客户编号
		*/
		public String getKehuUuidNumber() {
			return kehuUuidNumber;
		}
		/**
		* 设置： 客户编号
		*/
		public void setKehuUuidNumber(String kehuUuidNumber) {
			this.kehuUuidNumber = kehuUuidNumber;
		}

		/**
		* 获取： 客户姓名
		*/
		public String getKehuName() {
			return kehuName;
		}
		/**
		* 设置： 客户姓名
		*/
		public void setKehuName(String kehuName) {
			this.kehuName = kehuName;
		}

		/**
		* 获取： 客户手机号
		*/
		public String getKehuPhone() {
			return kehuPhone;
		}
		/**
		* 设置： 客户手机号
		*/
		public void setKehuPhone(String kehuPhone) {
			this.kehuPhone = kehuPhone;
		}

		/**
		* 获取： 客户身份证号
		*/
		public String getKehuIdNumber() {
			return kehuIdNumber;
		}
		/**
		* 设置： 客户身份证号
		*/
		public void setKehuIdNumber(String kehuIdNumber) {
			this.kehuIdNumber = kehuIdNumber;
		}

		/**
		* 获取： 客户照片
		*/
		public String getKehuPhoto() {
			return kehuPhoto;
		}
		/**
		* 设置： 客户照片
		*/
		public void setKehuPhoto(String kehuPhoto) {
			this.kehuPhoto = kehuPhoto;
		}

		/**
		* 获取： 客户邮箱
		*/
		public String getKehuEmail() {
			return kehuEmail;
		}
		/**
		* 设置： 客户邮箱
		*/
		public void setKehuEmail(String kehuEmail) {
			this.kehuEmail = kehuEmail;
		}

		/**
		* 获取： 住址
		*/
		public String getKehuAddress() {
			return kehuAddress;
		}
		/**
		* 设置： 住址
		*/
		public void setKehuAddress(String kehuAddress) {
			this.kehuAddress = kehuAddress;
		}
		/**
		* 获取： 行业
		*/
		public Integer getHangyeTypes() {
			return hangyeTypes;
		}
		/**
		* 设置： 行业
		*/
		public void setHangyeTypes(Integer hangyeTypes) {
			this.hangyeTypes = hangyeTypes;
		}


			/**
			* 获取： 行业的值
			*/
			public String getHangyeValue() {
				return hangyeValue;
			}
			/**
			* 设置： 行业的值
			*/
			public void setHangyeValue(String hangyeValue) {
				this.hangyeValue = hangyeValue;
			}
		/**
		* 获取： 职位
		*/
		public Integer getZhiweiTypes() {
			return zhiweiTypes;
		}
		/**
		* 设置： 职位
		*/
		public void setZhiweiTypes(Integer zhiweiTypes) {
			this.zhiweiTypes = zhiweiTypes;
		}


			/**
			* 获取： 职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}
		/**
		* 获取： 地区
		*/
		public Integer getDiquTypes() {
			return diquTypes;
		}
		/**
		* 设置： 地区
		*/
		public void setDiquTypes(Integer diquTypes) {
			this.diquTypes = diquTypes;
		}


			/**
			* 获取： 地区的值
			*/
			public String getDiquValue() {
				return diquValue;
			}
			/**
			* 设置： 地区的值
			*/
			public void setDiquValue(String diquValue) {
				this.diquValue = diquValue;
			}
	//级联表的get和set 员工

		/**
		* 获取： 员工编号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 员工编号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ChanpinDingdanView{" +
			", chanpinDingdanXiaoshouValue=" + chanpinDingdanXiaoshouValue +
			", chanpinDingdanXiaoshoufangshiValue=" + chanpinDingdanXiaoshoufangshiValue +
			", chanpinDingdanValue=" + chanpinDingdanValue +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			", chanpinName=" + chanpinName +
			", chanpinUuidNumber=" + chanpinUuidNumber +
			", chanpinPhoto=" + chanpinPhoto +
			", chanpinDanwei=" + chanpinDanwei +
			", chanpinOldMoney=" + chanpinOldMoney +
			", chanpinNewMoney=" + chanpinNewMoney +
			", chanpinCangku=" + chanpinCangku +
			", chanpinContent=" + chanpinContent +
			", kehuUuidNumber=" + kehuUuidNumber +
			", kehuName=" + kehuName +
			", kehuPhone=" + kehuPhone +
			", kehuIdNumber=" + kehuIdNumber +
			", kehuPhoto=" + kehuPhoto +
			", kehuEmail=" + kehuEmail +
			", kehuAddress=" + kehuAddress +
			"} " + super.toString();
	}
}

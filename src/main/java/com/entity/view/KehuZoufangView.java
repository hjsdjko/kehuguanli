package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KehuZoufangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 客户走访
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kehu_zoufang")
public class KehuZoufangView extends KehuZoufangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 客户走访类型的值
	*/
	@ColumnInfo(comment="客户走访类型的字典表值",type="varchar(200)")
	private String kehuZoufangValue;

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
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer sexTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String sexValue;
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



	public KehuZoufangView() {

	}

	public KehuZoufangView(KehuZoufangEntity kehuZoufangEntity) {
		try {
			BeanUtils.copyProperties(this, kehuZoufangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 客户走访类型的值
	*/
	public String getKehuZoufangValue() {
		return kehuZoufangValue;
	}
	/**
	* 设置： 客户走访类型的值
	*/
	public void setKehuZoufangValue(String kehuZoufangValue) {
		this.kehuZoufangValue = kehuZoufangValue;
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
		* 获取： 性别
		*/
		public Integer getSexTypes() {
			return sexTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
		}


			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
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


	@Override
	public String toString() {
		return "KehuZoufangView{" +
			", kehuZoufangValue=" + kehuZoufangValue +
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

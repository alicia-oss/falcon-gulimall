package com.gulimail.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.gulimail.common.validator.group.AddGroup;
import com.gulimail.common.validator.group.UpdateGroup;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

/**
 * 品牌
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:13
 */
@NoArgsConstructor
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank
	private String logo;
	/**
	 * 介绍
	 */
	@NotBlank
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull
	private Integer sort;

}

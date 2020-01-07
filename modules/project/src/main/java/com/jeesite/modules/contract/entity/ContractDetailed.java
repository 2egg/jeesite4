/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.contract.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.jeesite.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;

/**
 * 合同明细表Entity
 * @author hlj
 * @version 2019-11-06
 */
@Table(name="contract_detailed", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="htbh", attrName="htbh", label="合同编号"),
		@Column(name="xmmc", attrName="xmmc", label="项目名称"),
		@Column(name="wtdw", attrName="wtdw", label="委托单位"),
		@Column(name="htlx", attrName="htlx", label="合同类型"),
		@Column(name="sx", attrName="sx", label="属性"),
		@Column(name="nf", attrName="nf", label="年份"),
		@Column(name="yf", attrName="yf", label="月份"),
		@Column(name="ssbm", attrName="ssbm.officeCode", label="所属部门"),
		@Column(name="zgld", attrName="zgld.userCode", label="主管领导"),
		@Column(name="bmjl", attrName="bmjl.userCode", label="部门经理"),
		@Column(name="fzr", attrName="fzr.userCode", label="负责人"),
		@Column(name="xxqs", attrName="xxqs", label="信息缺失"),
		@Column(name="htbz", attrName="htbz", label="合同备注"),
		@Column(name="sfbz", attrName="sfbz", label="收费标准"),
		@Column(name="fkfs", attrName="fkfs", label="付款方式"),
		@Column(name="ywfw", attrName="ywfw", label="业务范围", comment="业务范围(委托内容)"),
		@Column(name="fwzq", attrName="fwzq", label="服务周期"),
		@Column(name="djr", attrName="djr", label="登记人"),
		@Column(name="djrq", attrName="djrq", label="登记日期"),
		@Column(name="gdrq", attrName="gdrq", label="归档日期"),
		@Column(name="qdrq", attrName="qdrq", label="签订日期"),
		@Column(name="gcgm", attrName="gcgm", label="工程规模m2"),
		@Column(name="tze", attrName="tze", label="投资额", comment="投资额（万元）"),
		@Column(name="htje", attrName="htje", label="合同金额"),
		@Column(name="yjje", attrName="yjje", label="业绩金额"),
		@Column(name="yfje", attrName="yfje", label="应发金额"),
		@Column(name="yhs", attrName="yhs", label="印花税"),
		@Column(name="lxr", attrName="lxr", label="联系人"),
		@Column(name="dh", attrName="dh", label="电话"),
		@Column(name="zfqk", attrName="zfqk", label="支付情况"),
		@Column(name="cyr", attrName="cyr", label="参与人"),
		@Column(name="bcxy", attrName="bcxy", label="补充协议"),
		@Column(name="htfw", attrName="htfw", label="合同范围"),
		@Column(name="date", attrName="date", label="写入时间"),
		@Column(name="uuid", attrName="uuid", label="网盘id"),
		@Column(name="bj", attrName="bj", label="标记"),
		@Column(name="lxjd", attrName="lxjd", label="履行进度"),
		@Column(name="txrq", attrName="txrq", label="填写日期"),
		@Column(name="xmjd", attrName="xmjd", label="项目进度"),
		@Column(name="gdjd", attrName="gdjd", label="归档进度"),
		@Column(name="szss", attrName="szss", label="所在省市"),
		@Column(name="szsq", attrName="szsq", label="所在市区"),
		@Column(name="xmlx", attrName="xmlx", label="项目类型"),
		@Column(name="htfzr", attrName="htfzr", label="合同负责人"),
	}, joinTable={
		@JoinTable(type=Type.LEFT_JOIN, entity=Office.class, attrName="ssbm", alias="u9",
			on="u9.office_code = a.ssbm", columns={
				@Column(name="office_code", label="机构编码", isPK=true),
				@Column(name="office_name", label="机构名称", isQuery=false),
		}),
	
		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="zgld", alias="u10",
			on="u10.user_code = a.zgld", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),

		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="bmjl", alias="u11",
			on="u11.user_code = a.bmjl", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),

		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="fzr", alias="u12",
			on="u12.user_code = a.fzr", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
	}, orderBy="a.id DESC"
)
public class ContractDetailed extends DataEntity<ContractDetailed> {
	
	private static final long serialVersionUID = 1L;
	private String htbh;		// 合同编号
	private String xmmc;		// 项目名称
	private String wtdw;		// 委托单位
	private String htlx;		// 合同类型
	private String sx;		// 属性
	private String nf;		// 年份
	private String yf;		// 月份
	private Office ssbm;		// 所属部门
	private User zgld;		// 主管领导
	private User bmjl;		// 部门经理
	private User fzr;		// 负责人
	private String xxqs;		// 信息缺失
	private String htbz;		// 合同备注
	private String sfbz;		// 收费标准
	private String fkfs;		// 付款方式
	private String ywfw;		// 业务范围(委托内容)
	private String fwzq;		// 服务周期
	private String djr;		// 登记人
	private Date djrq;		// 登记日期
	private Date gdrq;		// 归档日期
	private Date qdrq;		// 签订日期
	private String gcgm;		// 工程规模m2
	private Double tze;		// 投资额（万元）
	private Double htje;		// 合同金额
	private Double yjje;		// 业绩金额
	private Double yfje;		// 应发金额
	private String yhs;		// 印花税
	private String lxr;		// 联系人
	private String dh;		// 电话
	private String zfqk;		// 支付情况
	private String cyr;		// 参与人
	private String bcxy;		// 补充协议
	private String htfw;		// 合同范围
	private Date date;		// 写入时间
	private String uuid;		// 网盘id
	private String bj;		// 标记
	private String lxjd;		// 履行进度
	private Date txrq;		// 填写日期
	private String xmjd;		// 项目进度
	private String gdjd;		// 归档进度
	private String szss;		// 所在省市
	private String szsq;		// 所在市区
	private String xmlx;		// 项目类型
	private String htfzr;		// 合同负责人
	
	public ContractDetailed() {
		this(null);
	}

	public ContractDetailed(String id){
		super(id);
	}
	
	@Length(min=0, max=50, message="合同编号长度不能超过 50 个字符")
	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}
	
	@NotBlank(message="项目名称不能为空")
	@Length(min=0, max=500, message="项目名称长度不能超过 500 个字符")
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@NotBlank(message="委托单位不能为空")
	@Length(min=0, max=500, message="委托单位长度不能超过 500 个字符")
	public String getWtdw() {
		return wtdw;
	}

	public void setWtdw(String wtdw) {
		this.wtdw = wtdw;
	}
	
	@Length(min=0, max=20, message="合同类型长度不能超过 20 个字符")
	public String getHtlx() {
		return htlx;
	}

	public void setHtlx(String htlx) {
		this.htlx = htlx;
	}
	
	@Length(min=0, max=10, message="属性长度不能超过 10 个字符")
	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}
	
	@Length(min=0, max=10, message="年份长度不能超过 10 个字符")
	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}
	
	@Length(min=0, max=5, message="月份长度不能超过 5 个字符")
	public String getYf() {
		return yf;
	}

	public void setYf(String yf) {
		this.yf = yf;
	}
	
	public Office getSsbm() {
		return ssbm;
	}

	public void setSsbm(Office ssbm) {
		this.ssbm = ssbm;
	}
	
	public User getZgld() {
		return zgld;
	}

	public void setZgld(User zgld) {
		this.zgld = zgld;
	}
	
	public User getBmjl() {
		return bmjl;
	}

	public void setBmjl(User bmjl) {
		this.bmjl = bmjl;
	}
	
	public User getFzr() {
		return fzr;
	}

	public void setFzr(User fzr) {
		this.fzr = fzr;
	}
	
	@Length(min=0, max=500, message="信息缺失长度不能超过 500 个字符")
	public String getXxqs() {
		return xxqs;
	}

	public void setXxqs(String xxqs) {
		this.xxqs = xxqs;
	}
	
	@Length(min=0, max=1000, message="合同备注长度不能超过 1000 个字符")
	public String getHtbz() {
		return htbz;
	}

	public void setHtbz(String htbz) {
		this.htbz = htbz;
	}
	
	@Length(min=0, max=3000, message="收费标准长度不能超过 3000 个字符")
	public String getSfbz() {
		return sfbz;
	}

	public void setSfbz(String sfbz) {
		this.sfbz = sfbz;
	}
	
	@Length(min=0, max=3000, message="付款方式长度不能超过 3000 个字符")
	public String getFkfs() {
		return fkfs;
	}

	public void setFkfs(String fkfs) {
		this.fkfs = fkfs;
	}
	
	@Length(min=0, max=1000, message="业务范围长度不能超过 1000 个字符")
	public String getYwfw() {
		return ywfw;
	}

	public void setYwfw(String ywfw) {
		this.ywfw = ywfw;
	}
	
	@Length(min=0, max=3000, message="服务周期长度不能超过 3000 个字符")
	public String getFwzq() {
		return fwzq;
	}

	public void setFwzq(String fwzq) {
		this.fwzq = fwzq;
	}
	
	@Length(min=0, max=255, message="登记人长度不能超过 255 个字符")
	public String getDjr() {
		return djr;
	}

	public void setDjr(String djr) {
		this.djr = djr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGdrq() {
		return gdrq;
	}

	public void setGdrq(Date gdrq) {
		this.gdrq = gdrq;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getQdrq() {
		return qdrq;
	}

	public void setQdrq(Date qdrq) {
		this.qdrq = qdrq;
	}
	
	@Length(min=0, max=100, message="工程规模m2长度不能超过 100 个字符")
	public String getGcgm() {
		return gcgm;
	}

	public void setGcgm(String gcgm) {
		this.gcgm = gcgm;
	}
	
	public Double getTze() {
		return tze;
	}

	public void setTze(Double tze) {
		this.tze = tze;
	}
	
	public Double getHtje() {
		return htje;
	}

	public void setHtje(Double htje) {
		this.htje = htje;
	}
	
	public Double getYjje() {
		return yjje;
	}

	public void setYjje(Double yjje) {
		this.yjje = yjje;
	}
	
	public Double getYfje() {
		return yfje;
	}

	public void setYfje(Double yfje) {
		this.yfje = yfje;
	}
	
	@Length(min=0, max=200, message="印花税长度不能超过 200 个字符")
	public String getYhs() {
		return yhs;
	}

	public void setYhs(String yhs) {
		this.yhs = yhs;
	}
	
	@Length(min=0, max=50, message="联系人长度不能超过 50 个字符")
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	
	@Length(min=0, max=100, message="电话长度不能超过 100 个字符")
	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}
	
	@Length(min=0, max=20, message="支付情况长度不能超过 20 个字符")
	public String getZfqk() {
		return zfqk;
	}

	public void setZfqk(String zfqk) {
		this.zfqk = zfqk;
	}
	
	@Length(min=0, max=64, message="参与人长度不能超过 64 个字符")
	public String getCyr() {
		return cyr;
	}

	public void setCyr(String cyr) {
		this.cyr = cyr;
	}
	
	@Length(min=0, max=20, message="补充协议长度不能超过 20 个字符")
	public String getBcxy() {
		return bcxy;
	}

	public void setBcxy(String bcxy) {
		this.bcxy = bcxy;
	}
	
	@Length(min=0, max=1000, message="合同范围长度不能超过 1000 个字符")
	public String getHtfw() {
		return htfw;
	}

	public void setHtfw(String htfw) {
		this.htfw = htfw;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Length(min=0, max=100, message="标记长度不能超过 100 个字符")
	public String getBj() {
		return bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}
	
	@Length(min=0, max=50, message="履行进度长度不能超过 50 个字符")
	public String getLxjd() {
		return lxjd;
	}

	public void setLxjd(String lxjd) {
		this.lxjd = lxjd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTxrq() {
		return txrq;
	}

	public void setTxrq(Date txrq) {
		this.txrq = txrq;
	}
	
	@Length(min=0, max=100, message="项目进度长度不能超过 100 个字符")
	public String getXmjd() {
		return xmjd;
	}

	public void setXmjd(String xmjd) {
		this.xmjd = xmjd;
	}
	
	@Length(min=0, max=100, message="归档进度长度不能超过 100 个字符")
	public String getGdjd() {
		return gdjd;
	}

	public void setGdjd(String gdjd) {
		this.gdjd = gdjd;
	}
	
	@Length(min=0, max=100, message="所在省市长度不能超过 100 个字符")
	public String getSzss() {
		return szss;
	}

	public void setSzss(String szss) {
		this.szss = szss;
	}
	
	@Length(min=0, max=100, message="所在市区长度不能超过 100 个字符")
	public String getSzsq() {
		return szsq;
	}

	public void setSzsq(String szsq) {
		this.szsq = szsq;
	}
	
	@Length(min=0, max=100, message="项目类型长度不能超过 100 个字符")
	public String getXmlx() {
		return xmlx;
	}

	public void setXmlx(String xmlx) {
		this.xmlx = xmlx;
	}
	
	@Length(min=0, max=64, message="合同负责人长度不能超过 64 个字符")
	public String getHtfzr() {
		return htfzr;
	}

	public void setHtfzr(String htfzr) {
		this.htfzr = htfzr;
	}
	
}
package com.fj.webauto.db.po;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fj.webauto.browser.BaseBase;

public class MyCase {

	public int id;
	public String casename;
	public String owner;
	public String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date createtime;
	public Date updatetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCasename() {
		return casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "MyCase [id=" + id + ", casename=" + casename + ", owner=" + owner + ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
	}

}

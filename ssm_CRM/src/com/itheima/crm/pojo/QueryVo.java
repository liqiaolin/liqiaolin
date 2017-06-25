
package com.itheima.crm.pojo;

public class QueryVo {

	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	//因为分页查,所以要把当前页和开始页,一页个数传过去
	private Integer strat;
	private Integer nubersize;
	private Integer page;
	
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public Integer getStrat() {
		return strat;
	}
	public void setStrat(Integer strat) {
		this.strat = strat;
	}
	public Integer getNubersize() {
		return nubersize;
	}
	public void setNubersize(Integer nubersize) {
		this.nubersize = nubersize;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	
	

}

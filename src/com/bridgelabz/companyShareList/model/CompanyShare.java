package com.bridgelabz.companyShareList.model;

import java.util.List;

import com.bridgelabz.util.CustomLinkedList;

public class CompanyShare {

	private String name;
	private Long share;
	private List<CompanyShare> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getShare() {
		return share;
	}

	public void setShare(Long share) {
		this.share = share;
	}

	public List<CompanyShare> getList() {
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setList(CustomLinkedList linkedList) {
		this.list = (List<CompanyShare>) linkedList;
	}

	@Override
	public String toString() {
		return "name  : " + name + "\n" + "share: " + share + "\n";
	}
}
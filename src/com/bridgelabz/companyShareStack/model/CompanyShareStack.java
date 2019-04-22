package com.bridgelabz.companyShareStack.model;

public class CompanyShareStack {
	private String name;
	private long share;
	private long value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getShare() {
		return share;
	}

	public void setShare(long share) {
		this.share = share;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "name  : " + name + "\n" + "share: " + share + "\n"+"value : "+value+"\n";
	}
}

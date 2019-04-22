package com.bridgelabz.companyShareStack.main;

import com.bridgelabz.companyShareStack.dataImpl.CompanyShareStackImpl;

public class CompanyShareStackApp {

	public static void main(String[] args) throws Exception {
		CompanyShareStackImpl stock=new CompanyShareStackImpl();
		stock.fileRead();

	}

}

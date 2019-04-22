package com.bridgelabz.companyShareQueue.main;

import com.bridgelabz.companyShareQueue.dataImpl.CompanyShareQueueImpl;

public class CompanyShareQueueApp {

	public static void main(String[] args) throws Exception {
		CompanyShareQueueImpl shares = new CompanyShareQueueImpl();
		shares.fileRead();

	}

}

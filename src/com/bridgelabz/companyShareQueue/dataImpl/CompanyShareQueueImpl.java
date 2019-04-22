package com.bridgelabz.companyShareQueue.dataImpl;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.companyShareQueue.data.CompanyShareQueueMngmt;
import com.bridgelabz.companyShareStack.model.CompanyShareStack;
import com.bridgelabz.oops.exception.CustomException;
import com.bridgelabz.util.CustomLinkedList;
import com.bridgelabz.util.QueueLinkedList;

public class CompanyShareQueueImpl implements CompanyShareQueueMngmt {
	CompanyShareStack shares = new CompanyShareStack();
	QueueLinkedList<CompanyShareStack> queue = new QueueLinkedList<CompanyShareStack>();
	CustomLinkedList<CompanyShareStack> list = new CustomLinkedList<CompanyShareStack>();

	JSONArray jsonArray;
	JSONObject jobject = new JSONObject();

	public void fileRead() throws Exception {
		JSONParser parser = new JSONParser();

		try {
			jsonArray = (JSONArray) parser.parse(new FileReader(
					"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/companyShareStack/modal/companyShareStack.json"));

			for (Object obj : jsonArray) {
				CompanyShareStack comShare = new CompanyShareStack();
				jobject = (JSONObject) obj;
				String name = (String) jobject.get("name");
				long share = (Long) jobject.get("share");
				long value = (Long) jobject.get("value");
				comShare.setName(name);
				comShare.setShare(share);
				comShare.setValue(value);
				queue.insert(comShare);
				System.out.println(queue.toString());
			}
		} catch (Exception e) {
			throw new CustomException("Exception occured while reading your file", e);
		}
	}

	@Override
	public void sell(String name) {

	}

	@Override
	public void purchase(String name, long share, long value) {
		CompanyShareStack stock = new CompanyShareStack();
		stock.setName(name);
		stock.setShare(share);
		stock.setValue(value);
		list.add(stock);
		queue.insert(stock);

	}

}

package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.OutgoingAmount;
import com.jpmorgan.trader.mockdata.MockData;
//Separate DAO Interface is created. In real time it would be extending Spring JPA Repository interface.
//Separate DAO IMPL would not be required as we would be using Spring JPA Repository
//Spring JSP Repository add its own implementation runtime with methods like...save(),fetch(),getBy<PropertyName>() etc
//So this IMPL won't be required.
//Here it is added as we are not using spring jpa repository for now and we are getting the mock data
public class OutgoingAmountDaoImpl implements OutgoingAmountDao {
	@Override
	public List<OutgoingAmount> fetchAll() {
		return MockData.getOutgoingAmountEveryDay();
	}

	@Override
	public void saveAll(List<OutgoingAmount> outgoingAmountList) {
		MockData.saveOutgoingAmountEveryDay(outgoingAmountList);
	}
}

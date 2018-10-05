package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingEntityRank;
import com.jpmorgan.trader.mockdata.MockDataBase;
//Separate DAO Interface is created. In real time it would be extending Spring JPA Repository interface.
//Separate DAO IMPL would not be required as we would be using Spring JPA Repository
//Spring JSP Repository add its own implementation runtime with methods like...save(),fetch(),getBy<PropertyName>() etc
//So this IMPL won't be required.
//Here it is added as we are not using spring jpa repository for now and we are getting the mock data
public class IncomingEntityRankDaoImpl implements IncomingEntityRankDao {
	@Override
	public List<IncomingEntityRank> fetchAll() {
		return MockDataBase.getIncomingEntityRankEveryDay();
	}

	@Override
	public void saveAll(List<IncomingEntityRank> incomingEntityRankList) {
		MockDataBase.saveIncomingEntityRankEveryDay(incomingEntityRankList);
	}
}

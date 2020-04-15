package com.reactiveworks.stocktrade;

import java.util.List;

import com.reactiveworks.stocktrade.dao.IStockTradeDao;
import com.reactiveworks.stocktrade.dao.StockTradeDaoFactory;
import com.reactiveworks.stocktrade.db.exceptions.DBOperationFailureException;
import com.reactiveworks.stocktrade.db.exceptions.DataBaseAccessException;
import com.reactiveworks.stocktrade.db.exceptions.InvalidDBRecordFormatException;
import com.reactiveworks.stocktrade.db.exceptions.OperationNotSupportedException;
import com.reactiveworks.stocktrade.model.StockTrade;

public class Test {
	
	public static void main(String[] args) throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException, OperationNotSupportedException {
		
		IStockTradeDao stockTradeDao=StockTradeDaoFactory.getInstance();
		IStockTradeDao stockTradeDao2 = StockTradeDaoFactory.getInstance("csv");
		List<StockTrade> stockTradeRecords = stockTradeDao2.getStockTradeRecords();
		for(int i=0;i<stockTradeRecords.size();i++)
		stockTradeDao.createStockTradeRecord(stockTradeRecords.get(i));
	}

}

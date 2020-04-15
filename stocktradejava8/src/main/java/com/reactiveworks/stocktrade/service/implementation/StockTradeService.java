package com.reactiveworks.stocktrade.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.reactiveworks.stocktrade.dao.IStockTradeDao;
import com.reactiveworks.stocktrade.dao.StockTradeDaoFactory;
import com.reactiveworks.stocktrade.db.exceptions.DBOperationFailureException;
import com.reactiveworks.stocktrade.db.exceptions.DataBaseAccessException;
import com.reactiveworks.stocktrade.db.exceptions.InvalidDBRecordFormatException;
import com.reactiveworks.stocktrade.model.StockTrade;
import com.reactiveworks.stocktrade.service.IStockTradeService;

public class StockTradeService implements IStockTradeService{

	/**
	 * Gets the list of stocktrade objects.
	 * @return the list of stocktrade objects.
	 */
	@Override
	public List<StockTrade> readStockTrades() throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		  IStockTradeDao stockTradeDaoObj=StockTradeDaoFactory.getInstance() ;
		  List<StockTrade> stockTradeObjList = stockTradeDaoObj.getStockTradeRecords();
		return stockTradeObjList;
	}

	 /**
	  * Finds the stocktrade object which has max volume.
	  * @param stockTradeObjList list of stocktrade objects.
	  * @return the stocktrade object with the max volume.
	  */
	@Override
	public StockTrade getMaxVolumeTrade(List<StockTrade> stockTradeObjList) {
		StockTrade stockTradeObj = stockTradeObjList.stream()
				.max((stockTrdObj1,stockTrdObj2)->(stockTrdObj1.getVolume()>stockTrdObj2.getVolume()?1:(stockTrdObj1.getVolume()<stockTrdObj2.getVolume())?-1:0)).get();
		return stockTradeObj;
	}

	/**
	 * Finds the stocktrade object which has min volume.
	 * @param stockTradeObjList list of stocktrade objects.
	 * @return the stocktrade object which has min volume.
	 */
	@Override
	public StockTrade getMinVolumeTrade(List<StockTrade> stockTradeObjList) {
		StockTrade stockTradeObj = stockTradeObjList.stream()
				.max((stockTrdObj1,stockTrdObj2)->(stockTrdObj1.getVolume()>stockTrdObj2.getVolume()?-1:(stockTrdObj1.getVolume()<stockTrdObj2.getVolume())?1:0)).get();
		return stockTradeObj;
	}

	/**
	 * Computes the daily trading difference.
	 * @param stockTradeObjList the list of stocktrade objects.
	 * @return the map which contains the difference of open vs High with Date being the Key
	 */
	@Override
	public Map<Date, Double> getDailyTradingDifferential(List<StockTrade> stockTradeObjList) {
		
		Map<Date, Double> dailyTradingDiff = stockTradeObjList.stream().collect(Collectors.toMap(m->m.getDate(), m->(m.getHigh()-m.getLow())));
		return dailyTradingDiff;
	}
  
}
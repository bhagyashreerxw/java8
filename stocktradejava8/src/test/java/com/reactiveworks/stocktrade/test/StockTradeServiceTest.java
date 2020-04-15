package com.reactiveworks.stocktrade.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import com.reactiveworks.stocktrade.db.exceptions.DBOperationFailureException;
import com.reactiveworks.stocktrade.db.exceptions.DataBaseAccessException;
import com.reactiveworks.stocktrade.db.exceptions.InvalidDBRecordFormatException;
import com.reactiveworks.stocktrade.model.StockTrade;
import com.reactiveworks.stocktrade.service.implementation.StockTradeService;

/**
 * Class for testing StockTradeService
 */
public class StockTradeServiceTest {

	/**
	 * Tests the working of getStockTrades() in positive scenario.
	 * 
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getStockTradeListVerification()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		int expectedStockTrdListSize = 481;
		int actualStockTrdListSize = stockTradesList.size();
		assertEquals(expectedStockTrdListSize, actualStockTrdListSize);
	}

	/**
	 * Tests the working of getStockTrades() in negative scenario.
	 * 
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getStockTradeListVerificationFailTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		int expectedStockTrdListSize = 480;
		int actualStockTrdListSize = stockTradesList.size();
		assertTrue(expectedStockTrdListSize != actualStockTrdListSize);
	}

	/**
	 * Checks the working of getMaxVolumeTrade() in positive scenario.
	 * 
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getMaxVolumeTradeServiceTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		double expectedMaxVolume = stockTradesList
				.stream().max(
						(stockTrdObj1,
								stockTrdObj2) -> ((stockTrdObj1.getVolume() > stockTrdObj2.getVolume()) ? 1
										: (stockTrdObj1.getVolume() < stockTrdObj2.getVolume()) ? -1 : 0))
				.get().getVolume();
		double actualMaxVolume = stockTrdServiceObj.getMaxVolumeTrade(stockTradesList).getVolume();
		assertTrue(expectedMaxVolume == actualMaxVolume);

	}

	/**
	 * Tests the working of getMaxVolumeTrade() in negative scenario.
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getMaxVolumeTradeServiceFailTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		double expectedMaxVolume = stockTradesList.stream()
				.max((stockTrdObj1,
						stockTrdObj2) -> ((stockTrdObj1.getVolume() > stockTrdObj2.getVolume()) ? 1
								: (stockTrdObj1.getVolume() < stockTrdObj2.getVolume()) ? -1 : 0))
				.get().getVolume() - 1;
		double actualMaxVolume = stockTrdServiceObj.getMaxVolumeTrade(stockTradesList).getVolume();
		assertTrue(expectedMaxVolume != actualMaxVolume);

	}

	/**
	 * Tests the working of getMinVolumeTradeService() in positive scenario.
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getMinVolumeTradeServiceTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		double expectedMaxVolume = stockTradesList
				.stream().max(
						(stockTrdObj1,
								stockTrdObj2) -> ((stockTrdObj1.getVolume() > stockTrdObj2.getVolume()) ? -1
										: (stockTrdObj1.getVolume() < stockTrdObj2.getVolume()) ? 1 : 0))
				.get().getVolume();
		double actualMaxVolume = stockTrdServiceObj.getMinVolumeTrade(stockTradesList).getVolume();
		assertTrue(expectedMaxVolume == actualMaxVolume);
	}

	/**
	 * Tests the working of getMinVolumeTradeService() in negative scenario.
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getMinVolumeTradeServiceFailTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		double expectedMaxVolume = stockTradesList
				.stream().max(
						(stockTrdObj1,
								stockTrdObj2) -> ((stockTrdObj1.getVolume() > stockTrdObj2.getVolume()) ? -1
										: (stockTrdObj1.getVolume() < stockTrdObj2.getVolume()) ? 1 : 0))
				.get().getVolume() - 1;
		double actualMaxVolume = stockTrdServiceObj.getMinVolumeTrade(stockTradesList).getVolume();
		assertTrue(expectedMaxVolume != actualMaxVolume);
	}

	/**
	 * Tests the working of getDailyTradingDifferential() in positive scenario.
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getDailyTradingDifferentialServiceTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		int expectedStockTrdListSize = 481;
		int actualStockTrdListSize = stockTradesList.size();
		assertTrue(expectedStockTrdListSize == actualStockTrdListSize);
	}

	/**
	 * Tests the working of getDailyTradingDifferential() in negative scenario.
	 * @throws InvalidDBRecordFormatException when the format of database record is
	 *                                        invalid.
	 * @throws DataBaseAccessException        when unable to access the database.
	 * @throws DBOperationFailureException    when database operation fails.
	 */
	@Test
	public void getDailyTradingDifferentialServiceFailTest()
			throws DBOperationFailureException, DataBaseAccessException, InvalidDBRecordFormatException {
		StockTradeService stockTrdServiceObj = new StockTradeService();
		List<StockTrade> stockTradesList = stockTrdServiceObj.readStockTrades();
		int expectedStockTrdListSize = 480;
		int actualStockTrdListSize = stockTradesList.size();
		assertTrue(expectedStockTrdListSize != actualStockTrdListSize);
	}

}
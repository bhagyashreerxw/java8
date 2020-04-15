package com.reactiveworks.stocktrade.dao.implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.reactiveworks.stocktrade.dao.IStockTradeDao;
import com.reactiveworks.stocktrade.db.exceptions.DBOperationFailureException;
import com.reactiveworks.stocktrade.db.exceptions.DataBaseAccessException;
import com.reactiveworks.stocktrade.db.exceptions.InvalidDBRecordFormatException;
import com.reactiveworks.stocktrade.db.exceptions.OperationNotSupportedException;
import com.reactiveworks.stocktrade.model.StockTrade;

/**
 * CSV implementation of the stockTradeDao.
 */
public class StockTradeDaoCSVImpl implements IStockTradeDao {
	private static final Logger LOGGER_OBJ = Logger.getLogger("StockTradeDaoCSVImpl.class");
	private static final String FILE_NAME = "CISCO.txt";

	/**
	 * Reads the information from the CSV file and creates the list of stockTrade
	 * objects.
	 * 
	 * @return the list of stockTrade objects.
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        CSV file.
	 * @throws InvalidDBRecordFormatException when the format of the CSV record is
	 *                                        invalid.
	 * @throws DBOperationFailureException    when operation on csv file fails.
	 */
	public List<StockTrade> getStockTradeRecords()
			throws DataBaseAccessException, InvalidDBRecordFormatException, DBOperationFailureException {
		LOGGER_OBJ.debug("execution of getStockTradeRecords() method started.");

		File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

		List<StockTrade> stockTrdList = null;

		try (Stream<String> line = Files.lines(Paths.get(file.toURI()))) {

			stockTrdList = line.skip(1).map(strLine -> {
				try {

					return parseStockCSVLine(strLine);

				} catch (InvalidDBRecordFormatException invalidStockTrdExp) {
					LOGGER_OBJ.error("format of the stocktrade in "+strLine +" is invalid" , invalidStockTrdExp);
				}
				return null;

			}).collect(Collectors.toList());

		} catch (IOException ioExp) {
			LOGGER_OBJ.error("unable to access the csv file ");
			throw new DataBaseAccessException("unable to access the DB " + FILE_NAME + ioExp);
		}

		LOGGER_OBJ.debug("execution of getStockTradeRecords() method completed.");
		return stockTrdList;
	}

	/**
	 * converts one line in csv file to the stockTrade object.
	 * 
	 * @param strLine string in each line of the csv file.
	 * @return the stockTrade object.
	 * @throws InvalidStockTradeFormatException when the format of the stockTrade is
	 *                                          invalid.
	 * @throws InvalidDBRecordFormatException when format of the db record is invalid.
	 */
	private StockTrade parseStockCSVLine(String strLine) throws InvalidDBRecordFormatException {
		LOGGER_OBJ.debug("execution of parseStockCSVLine() method started.");
		StockTrade stockTradeObj = new StockTrade();
		String stockInfo[] = strLine.split(",");
		stockTradeObj.setSecurity(stockInfo[0]);
		Date date;
		try {
			date = new SimpleDateFormat("MM/dd/yyyy").parse(stockInfo[1]);
			stockTradeObj.setDate(date);
			stockTradeObj.setOpen(Double.parseDouble(stockInfo[2]));
			stockTradeObj.setHigh(Double.parseDouble(stockInfo[3]));
			stockTradeObj.setLow(Double.parseDouble(stockInfo[4]));
			stockTradeObj.setClose(Double.parseDouble(stockInfo[5]));
			stockTradeObj.setVolume(Double.parseDouble(stockInfo[6]));
			stockTradeObj.setAdjClose(Double.parseDouble(stockInfo[7]));
		} catch (NumberFormatException numformatexp) {
			LOGGER_OBJ.error("number format of the stocktrade field in "+strLine+" is invalid.");
			throw new InvalidDBRecordFormatException("invalid number format.", numformatexp);
		} catch (ParseException parseExp) {
			LOGGER_OBJ.error("date format of the stocktrade field in "+strLine+" is invalid.");
			throw new InvalidDBRecordFormatException("invalid date format.", parseExp);
		}
		LOGGER_OBJ.debug("parseStockCSVLine() method execution completed.");
		return stockTradeObj;

	}

	/**
	 * Creates the stockTrade record in the database.
	 * 
	 * @throws OperationNotSupportedException when the operation is not supported by
	 *                                        the database.
	 */
	public void createStockTradeRecord(StockTrade stockTradeObj) throws OperationNotSupportedException {

		throw new OperationNotSupportedException("creating a record in the database is not supported.");
	}

	/**
	 * Deletes the stockTrade records from the database.
	 * 
	 * @throws OperationNotSupportedException when DB operation is not supported.
	 */
	public void deleteStockTradeRecord(int stockTradeId) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("deleting a record from the database is not supported.");
	}

	/**
	 * updates the record in the database.
	 * 
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        CSV file.
	 * @throws InvalidDBRecordFormatException when the format of the CSV record is
	 *                                        invalid.
	 * @throws DBOperationFailureException    when operation on csv file fails.
	 */
	@Override
	public void updateStockTradeRecord(int stockTrdId, double volume) throws OperationNotSupportedException {

		throw new OperationNotSupportedException("deleting a record from the database is not supported.");

	}

}
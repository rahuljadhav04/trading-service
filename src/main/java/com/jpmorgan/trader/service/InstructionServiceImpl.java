package com.jpmorgan.trader.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.jpmorgan.trader.dao.InstructionDao;
import com.jpmorgan.trader.dao.InstructionDaoImpl;
import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.util.TradingDateUtils;
/**
 * This class would save the instruction into database.
 * IF the trade is successful it would save it with the settlement date and trade amount
 * 
 * @author Administrative
 *
 */
public class InstructionServiceImpl implements InstructionService {
	private InstructionDao instructionDao = new InstructionDaoImpl();
	private CacheService cacheService = new CacheServiceImpl();

	@Override
	public void saveInstruction(Instruction instruction) {
		Map<String, String> currencyToWeekEndMap = cacheService.getCurrencyToWeekEndMap();
		Date settlementDate = getActualSettlementDate(instruction.getSettlementDate(),
				currencyToWeekEndMap.get(instruction.getCurrency()));
		instruction.setActualSettlementDate(settlementDate);
		instruction.setAmountOfTradeInUSD(calculateAmountOfTradeInUSD(instruction));
		instructionDao.saveInstruction(instruction);
	}

	private BigDecimal calculateAmountOfTradeInUSD(Instruction instruction) {
		return instruction.getAgreedFx().multiply(instruction.getPricePerUnit())
				.multiply(new BigDecimal(instruction.getUnits()));
	}

	@Override
	/**
	 * This would get the currency to weekend map. and it has logic to get next working date if settlement day is in weekend
	 */
	public Date getActualSettlementDate(Date settlementDate, String weekEnd) {
		String day = TradingDateUtils.getDayFromDate(settlementDate);
		while (weekEnd.contains(day)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(settlementDate);
			calendar.add(Calendar.DATE, 1);
			settlementDate = calendar.getTime();
			day = TradingDateUtils.getDayFromDate(settlementDate);
		}
		return settlementDate;
	}
}

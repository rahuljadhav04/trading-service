package com.jpmorgan.trader.mockdata;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.jpmorgan.trader.domain.CurrencyToWeekEndMapping;
import com.jpmorgan.trader.domain.IncomingAmount;
import com.jpmorgan.trader.domain.IncomingEntityRank;
import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.OutgoingAmount;
import com.jpmorgan.trader.domain.OutgoingEntityRank;
import com.jpmorgan.trader.value.EntityRankKey;
import com.jpmorgan.trader.value.Message;

public class MockData {
	private static List<Instruction> instructionList = new ArrayList<>();

	private static List<OutgoingAmount> outgoingAmountEveryDay = new ArrayList<>();
	private static List<IncomingAmount> incomingAmountEveryDay = new ArrayList<>();
	private static List<IncomingEntityRank> incomingEntityRankEveryDay = new ArrayList<>();
	private static List<OutgoingEntityRank> outcomingEntityRankEveryDay = new ArrayList<>();
	// Add data here if you want to test with more data
	private static String[][] inputInstructionData = {
			{ "foo", "B", "0.50", "SGP", "2016/01/01", "2016/01/02", "200", "100.25" },
			{ "bar", "S", "0.22", "AED", "2016/01/05", "2016/01/07", "450", "150.5" } };

	private static List<Message> inputMessages = new ArrayList<>();

	public static List<CurrencyToWeekEndMapping> getCurrencyToWeekEndMap() {
		List<CurrencyToWeekEndMapping> currencyToWeekEndMappingList = new ArrayList<CurrencyToWeekEndMapping>();
		currencyToWeekEndMappingList.add(new CurrencyToWeekEndMapping("SGP", "SAT,SUN"));
		currencyToWeekEndMappingList.add(new CurrencyToWeekEndMapping("AED", "FRI,SAT"));
		currencyToWeekEndMappingList.add(new CurrencyToWeekEndMapping("SAR", "FRI,SAT"));

		return currencyToWeekEndMappingList;
	}

	public static Instruction getInstruction(String[] message) throws ParseException {
		Instruction instruction = new Instruction();
		instruction.setEntityName(message[0]);
		instruction.setAction(message[1]);
		instruction.setAgreedFx(new BigDecimal(message[2]));
		instruction.setCurrency(message[3]);
		instruction.setInstructionDate(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(message[4]));
		instruction.setSettlementDate(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(message[5]));
		instruction.setUnits(new Long(message[6]));
		instruction.setPricePerUnit(new BigDecimal(message[7]));
		return instruction;
	}

	public static void addInstruction(Instruction instruction) {
		instructionList.add(instruction);
	}

	public static List<Instruction> getInstructionList() {
		return instructionList;
	}

	public static List<OutgoingAmount> retrieveOutgoingAmountEveryDay() {
		List<OutgoingAmount> tradeAmountValueList = new ArrayList<>();
		// here group by action and date and sum the amount for action "B"
		// Here java 8 feature of Group By, sum etc, can be used
		// not doing it due to time constraint
		Map<Date, BigDecimal> outgoingAmountEveryDayMap = new HashMap<>();
		for (Instruction instruction : instructionList) {
			if ("B".equals(instruction.getAction())) {
				if (outgoingAmountEveryDayMap.get(instruction.getActualSettlementDate()) == null) {
					outgoingAmountEveryDayMap.put(instruction.getActualSettlementDate(),
							instruction.getAmountOfTradeInUSD());
				} else {
					outgoingAmountEveryDayMap.get(instruction.getActualSettlementDate())
							.add(instruction.getAmountOfTradeInUSD());
				}
			}
		}
		outgoingAmountEveryDayMap.forEach((key, value) -> tradeAmountValueList.add(new OutgoingAmount(value, key)));
		return tradeAmountValueList;
	}

	public static List<IncomingAmount> retrieveIncomingAmountEveryDay() {
		List<IncomingAmount> tradeAmountValueList = new ArrayList<>();
		// here group by action and date and sum the amount for action "S"
		// Here java 8 feature of Group By, sum etc, can be used
		// not doing it due to time constraint
		Map<Date, BigDecimal> incomingAmountEveryDayMap = new HashMap<>();
		for (Instruction instruction : instructionList) {
			if ("S".equals(instruction.getAction())) {
				if (incomingAmountEveryDayMap.get(instruction.getActualSettlementDate()) == null) {
					incomingAmountEveryDayMap.put(instruction.getActualSettlementDate(),
							instruction.getAmountOfTradeInUSD());
				} else {
					incomingAmountEveryDayMap.get(instruction.getActualSettlementDate())
							.add(instruction.getAmountOfTradeInUSD());
				}
			}
		}
		incomingAmountEveryDayMap.forEach((key, value) -> tradeAmountValueList.add(new IncomingAmount(value, key)));
		return tradeAmountValueList;
	}

	public static List<IncomingEntityRank> retrieveIncomingEntityRankEveryDay() {
		List<IncomingEntityRank> entityRankList = new ArrayList<>();
		// here group by action,date and entity and rank the entity for action "B"
		// Here java 8 feature of Group By, sum, max, order by etc, can be used
		// not doing it due to time constraint
		Map<EntityRankKey, BigDecimal> incomingEntityRankEveryDayMap = new HashMap<>();
		for (Instruction instruction : instructionList) {
			if ("B".equals(instruction.getAction())) {
				EntityRankKey entityRankKey = new EntityRankKey(instruction.getEntityName(),
						instruction.getActualSettlementDate());
				if (incomingEntityRankEveryDayMap.get(entityRankKey) == null) {
					incomingEntityRankEveryDayMap.put(entityRankKey, instruction.getAmountOfTradeInUSD());
				} else {
					incomingEntityRankEveryDayMap.get(entityRankKey).add(instruction.getAmountOfTradeInUSD());
				}
			}
		}

		incomingEntityRankEveryDayMap = incomingEntityRankEveryDayMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		final AtomicInteger rank = new AtomicInteger(0);
		incomingEntityRankEveryDayMap.forEach((key, value) -> entityRankList
				.add(new IncomingEntityRank(key.getEntityName(), key.getDate(), rank.incrementAndGet())));
		return entityRankList;
	}

	public static List<OutgoingEntityRank> retrieveOutgoingEntityRankEveryDay() {
		List<OutgoingEntityRank> entityRankList = new ArrayList<>();
		// here group by action,date and entity and rank the entity for action "S"
		// Here java 8 feature of Group By, sum, max, order by etc, can be used
		// not doing it due to time constraint
		Map<EntityRankKey, BigDecimal> outgoingEntityRankEveryDayMap = new HashMap<>();
		for (Instruction instruction : instructionList) {
			if ("S".equals(instruction.getAction())) {
				EntityRankKey entityRankKey = new EntityRankKey(instruction.getEntityName(),
						instruction.getActualSettlementDate());
				if (outgoingEntityRankEveryDayMap.get(entityRankKey) == null) {
					outgoingEntityRankEveryDayMap.put(entityRankKey, instruction.getAmountOfTradeInUSD());
				} else {
					outgoingEntityRankEveryDayMap.get(entityRankKey).add(instruction.getAmountOfTradeInUSD());
				}
			}
		}

		outgoingEntityRankEveryDayMap = outgoingEntityRankEveryDayMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		final AtomicInteger rank = new AtomicInteger(0);
		outgoingEntityRankEveryDayMap.forEach((key, value) -> entityRankList
				.add(new OutgoingEntityRank(key.getEntityName(), key.getDate(), rank.incrementAndGet())));
		return entityRankList;
	}

	public static void saveOutgoingAmountEveryDay(List<OutgoingAmount> tradeAmountValueList) {
		outgoingAmountEveryDay = tradeAmountValueList;
	}

	public static void saveIncomingAmountEveryDay(List<IncomingAmount> tradeAmountValueList) {
		incomingAmountEveryDay = tradeAmountValueList;
	}

	public static void saveIncomingEntityRankEveryDay(List<IncomingEntityRank> entityRankList) {
		incomingEntityRankEveryDay = entityRankList;
	}

	public static void saveOutgoingEntityRankEveryDay(List<OutgoingEntityRank> entityRankList) {
		outcomingEntityRankEveryDay = entityRankList;
	}

	public static List<OutgoingAmount> getOutgoingAmountEveryDay() {
		return outgoingAmountEveryDay;
	}

	public static List<IncomingAmount> getIncomingAmountEveryDay() {
		return incomingAmountEveryDay;
	}

	public static List<IncomingEntityRank> getIncomingEntityRankEveryDay() {
		return incomingEntityRankEveryDay;
	}

	public static List<OutgoingEntityRank> getOutcomingEntityRankEveryDay() {
		return outcomingEntityRankEveryDay;
	}

	public static String[][] getInputInstructionData() {
		return inputInstructionData;
	}

	public static List<Message> getInputMessages() {

		for (int count = 0; count < inputInstructionData.length; count++) {
			Message message = new Message();
			message.setJsonString(inputInstructionData[count]);
			inputMessages.add(message);
		}
		return inputMessages;
	}

}
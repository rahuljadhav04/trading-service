package com.jpmorgan.trader.listener;

import java.text.ParseException;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.mockdata.MockData;
import com.jpmorgan.trader.service.InstructionService;
import com.jpmorgan.trader.service.InstructionServiceImpl;
import com.jpmorgan.trader.value.Message;
/**
 * This can be JMS listener in real time listening to instructions received
 * 
 * Here it is just having one method to receive instruction from main class. But in real time, it can have JMS listner annotation
 * which can have queue name etc.
 * @author Administrative
 *
 */
public class InstructionListner {

	// Use JMSListener annotation here so this method will get automatically called
	// when message sent to JMS Queue
	public void onMessage(Message message) throws ParseException {
		String[] jsonString = message.getJsonString();
		// Use JSONUtils to convert json into java object Instruction
		Instruction instruction = MockData.getInstruction(jsonString);
		InstructionService instructionService = new InstructionServiceImpl();
		instructionService.saveInstruction(instruction);
	}
}

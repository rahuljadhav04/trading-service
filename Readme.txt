PROBLEM STATEMENT
==================
The problem

1. Instruction Received from different clients
2. Show the report of trades - incoming/outgoing amount, rank, settlement date etc

SOLUTION APPROACH
=================

There are three components to solution.
A) InstructionListener Component

1. Instructions sent to Listener in method calls. In real world,JMS queue would be used to receive instructions from different clients
2. The instruction message is converted into Instruction object and saved into database
3. Instruction is converted into order with order status and saved to database.
4. Order is converted into Trade if order is successful and trade is saved to database.
5. The settlement Date in the trade is set according to logic of currency and weekend

B) Report Data Saver Component

1. In real world, there can be Batch job created using ControlM or any other tool. Here it is a method call.
2. In real world, batch job would run daily to fire query to group by, sum etc, and save data into report format into database.
3. This database can be different database than above instruction database. It can be dedicated to report data and analysis.
4. Instruction, Order, Trade data is combined into one table TradeDetails i.e. 
   de-normalize to avoid JOIN QUERIES and improve performance for report generation and display.

C) Report Generator

1) It can be web service or simple link on web page
2) It will fetch the data from report database and can write to Excel object using POI package. Here, it is printing to console.
3) The excel objects can be written to file from file system or can be written to Http response stream.

HOW TO RUN THIS PROGRAM
=====================
1. Import project in eclipse as maven project
2. Right click on project -> Maven -> Update Project
3. Open "Application.java" and right click in eclipse and run as Java Application
4. It should display report values as expected
5. To add one more instruction, just add one more row in MockDataBase.java for String[][] inputInstructionData.
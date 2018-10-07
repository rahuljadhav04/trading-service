PROBLEM STATEMENT
==================
The problem

1. Instruction Received from different clients
2. Show the report of trades - incoming/outgoing amount, rank, settlement date etc

SOLUTION APPROACH
=================

There are below components to solution.
A) InstructionFileProcessor Component

1. The set of instructions can be uploaded to any folder with .ins file extension.
2. The folder is polled by file processor component for new file for every second.(value can be configured in yml file)
3. If the file is empty or file extension is not .ins then that file is deleted and appropriate message is displayed.
4. If the file is non-empty with .ins instructions then each instruction is validated for date, number, number of values in a row etc.
5. Valid instructions are sent to InstructionProcessor component
6. Processed instructions are written to .success file and moved to success folder
7. Invalid instructions are written to .error file and moved to error folder
8. The .ins file for which processing is complete is moved to done folder

A) InstructionProcessor Component
1. Valid instructions are received and processed here. The instructions will be processed in parallel as they are independent.
2. The instruction message is converted into Instruction object and saved into database
3. Instruction is converted into order with order status and saved to database.
4. If orders are successful then they are saved as trades into database.(here in memory)
5. The settlement Date in the trade is set according to logic of currency and weekend.

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
3. Open "TradingServiceApplication.java" and right click in eclipse and run as Java Application or Spring Boot App
4. It should display report values as expected
5. By default, it is polling to folder "./src/main/resources/instruction/input/"
6. This can be changed by editing application-dev.yml file
7. By default, instruction1.ins file is present at "./src/main/resources/instruction/upload/". It gets copied to "./src/main/resources/instruction/input/"
folder when the spring boot starts. This will only happen on DEV environment because InstructionInputLoader is set with @Profile("dev"). This class will not be loaded on PROD
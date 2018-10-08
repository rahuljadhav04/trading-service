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
7. Invalid instructions are written to .error file with error message appened to each instruction and moved to error folder
8. The .ins file for which processing is complete is moved to done folder

B) InstructionProcessor Component
1. Valid instructions are received and processed here. The instructions will be processed in parallel as they are independent.
2. The instruction message is converted into Instruction object and saved into database
3. Instruction is converted into order with order status and saved to database.
4. If orders are successful then they are saved as trades into database.(here in memory)
5. The settlement Date in the trade is set according to logic of currency and weekend.

C) Report Data Saver Component

1. In real world, there can be Batch job created using ControlM or any other tool. 
2. Here it is a method call where data is saved in different format in  memory.
2. In real world, batch job would run daily to fire query to group by, sum etc, and save data into report format into database.
3. This database can be different database than above instruction database. It can be dedicated to report data and analysis.
4. Instruction, Order, Trade data is combined into one table TradeDetails i.e. 
   de-normalize to avoid JOIN QUERIES and improve performance for report generation and display.

D) Report Generator

1) In real world, it can be web service or simple link on web page
2) It will fetch the data from report database and can write to Excel object using POI package. 
3) Here, it is simple method call and data is printed to console.
3) The excel objects can be written to file from file system or can be written to Http response stream.

HOW TO RUN THIS PROGRAM
=====================
1. Import project in eclipse or STS as maven project
2. Right click on project -> Maven -> Update Project
3. Open "TradingServiceApplication.java" and right click in eclipse and run as Java Application or Spring Boot App
4. It should display report values as expected for instruction1.ins file
5. By default, it is polling to folder "./src/main/resources/instruction/input/"
6. This can be changed by editing application-dev.yml file.
7. By default, instruction1.ins file is present at "./src/main/resources/instruction/upload/". It gets copied to "./src/main/resources/instruction/input/"
folder when the spring boot starts. This will only happen on DEV environment because InstructionInputLoader is set with @Profile("dev"). This class will not be loaded on PROD
8. For testing with more files, you can place .ins file with new name at "./src/main/resources/instruction/input/"
9. To run all the junits, run TradingServiceTestSuite.java. Open file in eclipse and run as junit4

Technology Stack used:
1. For file polling and reading - Spring Integration DSL
2. For dependency injection - Spring IOC
3. For Auto configuration - Spring Boot
4. For parallel processing of instructions - parallel stream collection APIs and Lambda expression of java 8
5. No persistent database is used. MockDatabase class is used with static members to keep data in memory
6. Since no database or external service call is used, the Mocito framework us not used while writing junits
7. For copying instruction1.ins file to polling folder only on DEV environment on startup - Spring Profiles feature is used.
8. For logging purpose, SLF4J logging is used with implementation as Log4J

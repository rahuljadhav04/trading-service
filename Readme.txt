PROBLEM STATEMENT
==================
The problem

1. Instruction Received from different clients
2. Show the report of instructions

SOLUTION APPROACH
=================

There are three components to solution.
A) InstructionListener Component

1. JMS queue would be used to receive instructions from different clients
2. The JMS message is converted into Instruction object and saved into database
3. While saving Instruction object into database, its actual settlement date is set according to weekend and currency combination. 
Also the total amount is set before saving to database.

B) Report Data Saver Component

1. Batch job would be created using ControlM or any other tool. 
2. This batch job would run daily to fire query to group by, sum etc, and save data into report format into database.
3. This database can be different database than above instruction database. It can be dedicated to report data and analysis.

C) Report Generator

1) It can be web service or simple link on web page
2) It will fetch the data from report database and write to Excel object using POI package.
3) The excel objects can be written to file from file system or can be written to Http response stream.

HOW TO RUN THIS PROGRAM
=====================
1. Import project in eclipse as maven project
2. Right click on project -> Maven -> Update Project
3. Open "Application.java" and right click in eclipse and run as Java Application
4. It should display report values as expected
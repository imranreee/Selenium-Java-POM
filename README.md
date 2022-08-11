# Project Information
* Language: `Jave`
* Project Type: `Maven`
* Design Pattern: `Page Object Model(POM)` with `Page factory`, and  `Data Driven`
* Framework: [Selenium](https://www.selenium.dev/), and [TestNG](http://testng.org/doc/documentation-main.html)
* Reporting System: [Extend Report](http://extentreports.com/), and [Allue Report](http://allure.qatools.ru/)

# Prerequisite to use Framework 
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)
* [Maven](https://maven.apache.org/download.cgi) for allure report
* [Maven Central](https://maven.apache.org/download.cgi) for allure report

# Covered Test Cases
### PSCC001_ValidateLandingPage 
- Validate the PaySear logo, and page title 
- Validate the See Reports and chat button
- Validate the action of See Rates button

### PSCC002_ValidateBuySellAmountBox
* Scroll the page to the Online currency exchange calculator section and check the default value of sell box 
* Put value in SELL input box and chek BUY box is empty or not and vice versa 
* Validate the action of See Rates button
    
### PSCC003_ValidateLossCalculation
* Check tha action of the Filter button 
* Check the loss calculation

### PSCC004_ValidateRateCurrencyDependOnCountry
* Scroll to the bottom of the page 
* Select all county one after another and check all related check

### PSCC005_ValidateTheCurrencyListOnThePage
* Validate Currency and Country list of the page 

### PSCC006_ValidateTheFAQSection
* Validate the FAQ section and the expand button 

# Extent Report Screenshots 
### Details Page
![Details Page](/report_ss/ER_SS_01.png "Details Page")
### Overview Page
![Overview Page](/report_ss/ER_SS_02.png "Overview Page")

# Allure Report Screenshots 
### Overview Page
![Overview Page](/report_ss/AR01.png "Overview Page")
### Suites Page
![Suites Page](/report_ss/AR02.png "Suites Page")
### Graphs Page
![Graphs Page](/report_ss/AR03.png "Graphs Page")
### Timeline Page
![Timeline Page](/report_ss/AR04.png "Timeline Page")
### Behaviors Page
![Behaviors Page](/report_ss/AR05.png "Behaviors Page")
### Packages Page
![Packages Page](/report_ss/AR06.png "Packages Page")

# Related Video 
### Automation framework structure

[![IMAGE ALT TEXT](/report_ss/p5.png)](https://www.loom.com/share/7f203db157864ad683714a6d8d34b6d5 "Video Title")


### Run automation Test Cases

[![IMAGE ALT TEXT](/report_ss/p5.png)](https://www.loom.com/share/1fb8aa70003a47af9b343a36ffb3a5b8 "Video Title")

### Automation Test result view and analysis 

[![IMAGE ALT TEXT](/report_ss/p5.png)](https://www.loom.com/share/5014a6f67ea843d4925ac7ce758219c9 "Video Title")







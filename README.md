# Selenium | TestNG | ExtentReport | POM
Introduction:
---------------
This Test Automation Framework is created using Java + Selenium + TestNG which can be used to test UI. Implemented with Page Object Model (POM) to support the scalability. I tried to make it S.O.L.I.D compliant and used OOP (Inheritance).

Stack
---------------
<img src="https://brandslogos.com/wp-content/uploads/images/large/java-logo-1.png?raw=true?raw=true" width="120" height="90" /><img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/Selenium_Logo.png?raw=true" width="100" height="90"/>&nbsp;&nbsp;<img src="https://www.extentreports.com/wp-content/uploads/2018/09/Extent_logomark_transparentbg.png?raw=true" width="80" height="80" />


Prerequisites:
---------------
*	Java jdk-1.8 or higher
*	Apache Maven 3 or higher
*	Please refer for any help in Maven.
* 	http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* 	http://www.tutorialspoint.com/maven/maven_environment_setup.htm

Execution
---------------
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

```
git clone git@github.com:rehmanuet/selenium-java.git
mvn clean install
mvn clean test -Dsurefire.suiteXmlFiles=TestNG.xml
```

Folder Structure
---------------
```
.
├── extentreport         # Test Report
├── src                  # Source files
├───├── main             
│   	├── extent       # ExtentReport Manager for reporting
│   	└── utils        # Common Utilities
├───├── test             # Test files
│   	├── listeners    # TestNG Listners
│   	├── pages        # Page Objects
│       ├── tests        # Automated tests
│   	└── resources     
├── pom.xml              
├── TestNG.xml
├── README.md
└── Testcases_Documentation.xlsx
```

Coverage
---------------
This framework covers the both positive and negative testcases.
Documentation of testcases could be found on [Google Sheets](https://docs.google.com/spreadsheets/d/12pL45y5Ohvd8vjA2EM-PhUlueiagqOwMAfx8m90_cKY/edit?usp=sharing) as well as within project i.e `Testcases_Documentation.xlsx` </br>
Test Application: [www.saucedemo.com](https://www.saucedemo.com/)

#### Test Cases Breakdown
|    <sub>Pages/Screens</sub>  |    <sub>Test cases</sub> |
| :-:  | :-: |
|    <b> <sub>Login</sub> </b>   | <sub>3</sub>  |
|    <b> <sub>Inventory</sub> </b>   | <sub>3</sub>  |
<b><sub>Sub Total Test cases</sub></b>|    <b><sub>6</b></sub> |

Sample Testcase
---------------
Negative testcase: Verify if a user cannot login with a valid username and an invalid password and get an error message.
```
    public void tc003_verifyInvalidLogin() {
        ExtentTestManager.startTest("TC002-VerifyInvalidLogin", "Verification of Login with invalid credentials");
        try {
            page.getInstance(LoginPage.class).doLogin(INVALID_USERNAME, INVALID_PASSWORD);
            page.getInstance(LoginPage.class).checkLoginError(getMessage(LOGIN_ERROR_MESSAGE));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Error Message Displayed Successfully");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }
```

Result
---------------
<img src="https://github.com/rehmanuet/DataEssential/blob/master/er.png?raw=true?raw=true" width="1100" height="500" />

_contact:`rehmanuet[at]yahoo[dot]com`_ *or* _[LinkedIn](https://www.linkedin.com/in/rehmanuet/)_

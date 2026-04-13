# Sapaad Website Automation — Selenium + Java + Cucumber

Automated end-to-end test suite for the [Sapaad](https://www.sapaad.com) website covering trial registration, schedule demo, and pricing page flows.

**Tech Stack:** Java · Selenium 3 · Cucumber (BDD) · TestNG · Maven · WebDriverManager

---

## Project Structure

```
sapaad_website/
├── src/
│   ├── main/java/sapaad_website/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   ├── Config.java          # WebDriver setup (Chrome / Firefox)
│       │   │   └── FWutility.java       # Screenshot utility
│       │   ├── pages/
│       │   │   ├── HomePage.java
│       │   │   ├── SapaadTrailPage.java
│       │   │   ├── PricingPage.java
│       │   │   └── ScheduledemoPage.java
│       │   └── StepDefinition/
│       │       ├── Hooks.java           # @Before / @After (browser open/close)
│       │       ├── trail.java           # Trial form steps
│       │       ├── PricingSteps.java    # Pricing page steps
│       │       ├── Scheduledemosteps.java
│       │       ├── userapplieswithsameemail.java
│       │       └── runnerClass.java     # Cucumber runner
│       └── resources/feature/
│           ├── trail.feature
│           ├── pricingpage.feature
│           └── scheduledemo.feature
├── Snapshots/                           # Auto-captured on test failure
└── pom.xml
```

---

## Prerequisites

| Tool | Version |
|------|---------|
| Java JDK | 11 or higher |
| Maven | 3.6+ |
| Chrome or Firefox | Latest |
| IDE (optional) | Eclipse / IntelliJ |

> **No manual driver download needed** — `WebDriverManager` handles it automatically.

---

## Setup

```bash
# Clone the repository
git clone https://github.com/syedjawad123/MyWebsite.git
cd MyWebsite/sapaad_website

# Install dependencies
mvn clean install -DskipTests
```

---

## Running Tests

### Run all tests (default: Chrome, Staging environment)
```bash
mvn test
```

### Run with a specific browser
```bash
# Chrome
mvn test -Dbrowser=ch

# Firefox
mvn test -Dbrowser=ff
```

### Run against a specific environment
```bash
# Staging (default)
mvn test -Denv=stg

# QA
mvn test -Denv=qa

# Production
mvn test -Denv=prd
```

### Run by tag
```bash
# Run only smoke tests
mvn test -Dcucumber.filter.tags="@smoketest"

# Run pricing tests
mvn test -Dcucumber.filter.tags="@test"
```

---

## Test Scenarios

### Trial Registration (`trail.feature`)
- ✅ User applies for trial with a valid email and form details
- ✅ User applies for trial with an existing email — verifies duplicate email error message

### Pricing Page (`pricingpage.feature`)
- ✅ User selects a monthly plan with single outlet and add-ons
- ✅ User toggles to yearly plan with multiple outlets and add-ons

### Schedule Demo (`scheduledemo.feature`)
- ✅ User fills the schedule demo form with role, restaurant type, outlets, and contact details

---

## Reports

After test execution, reports are generated at:

| Format | Path |
|--------|------|
| HTML | `target/HtmlReports/index.html` |
| JSON | `target/Jsonreports/report.json` |
| JUnit XML | `target/JunitReports/report.xml` |

Open the HTML report in a browser for a full visual summary.

---

## Screenshots

Failure screenshots are automatically captured and saved to the `Snapshots/` folder with the scenario name as the filename.

---

## Design Patterns Used

- **Page Object Model (POM)** — UI interactions are encapsulated in page classes under `pages/`
- **BDD with Cucumber** — Test scenarios written in Gherkin for readability
- **Hooks** — `@Before` / `@After` manage browser lifecycle and screenshot capture
- **Data-Driven Testing** — Scenario Outlines with `Examples` tables for parameterised inputs

---

## Author

**Syed Jawad Ur Rahaman** — QA Engineer  
[syed.jawad469@gmail.com](mailto:syed.jawad469@gmail.com) · [LinkedIn](#) · [GitHub](https://github.com/syedjawad123)

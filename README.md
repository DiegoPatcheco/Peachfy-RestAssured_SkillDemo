# Peachfy-RestAssured_SkillDemo

## Overview
Peachfy-RestAssured_SkillDemo is a project developed to ensure reliable and efficient testing of RESTful APIs. It demonstrates proficiency in Java, REST API testing, RestAssured, TestNG, JSON/XML handling, and CI/CD integration—highlighting strong automation, debugging, and backend testing skills.

## Features
- Built using **RestAssured** and **TestNG** for API test automation.
- Integrated with **Maven Wrapper** for simplified build and dependency management.
- CI/CD enabled via **GitHub Actions** for automated test execution.
- Automatically generates detailed test reports using **Allure Report**.

## Prerequisites
Ensure the following dependencies and tools are installed before using the project:
- [Amazon Corretto JDK 17.0.14](https://aws.amazon.com/corretto/)
- [Maven](https://maven.apache.org/install.html) (optional if using Maven Wrapper)
- [Git](https://git-scm.com/downloads)
- RestAssured, JSON Schema Validator, TestNG, and Allure libraries (managed through Maven)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/DiegoPatcheco/Peachfy-RestAssured_SkillDemo.git
   ```
2. Navigate into the project directory:
   ```sh
   cd Peachfy-RestAssured_SkillDemo
   ```
3. Install dependencies and build the project using Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```

## Running Tests
To execute the test suite:
```sh
./mvnw clean test
```

You can also run a predefined suite using the script:
```sh
./runSuite.sh
```

## Allure Report
- The **Allure Report** is automatically generated after each test execution.
- To view the report locally, use:
  ```sh
  ./openAllure.sh
  ```

## CI/CD Integration
- The project is integrated with **GitHub Actions** to run tests on every push and pull request.
- Allure reports and test results are uploaded as artifacts and can be accessed via the GitHub Actions tab.

## Contributing
Contributions are welcome. To contribute:
1. Fork this repository.
2. Create a feature branch.
3. Commit your changes.
4. Push your branch and submit a pull request.

## Author
Developed by [Diego Patcheco](https://github.com/DiegoPatcheco).


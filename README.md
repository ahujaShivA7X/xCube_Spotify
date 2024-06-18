# Appium Cucumber Framework

## Overview

This project is a test automation framework built using Java, Appium, Cucumber, JUnit, and Maven. It is designed to automate mobile application testing on Android devices (here, spotify for xCube). The framework includes integration with Extent Reports for detailed test reporting and Slack for real-time notifications and also CI/CD pipeline integration with Azure.

## Features

- **Appium**: For mobile automation.
- **Cucumber**: For behavior-driven development (BDD).
- **TestNG**: For test execution and management.
- **Extent Reports**: For detailed and customizable test reports.
- **Slack Integration**: For real-time notifications of test results.
- **Page Object Model (POM)**: For maintaining a clean separation of test logic and page-specific code.
- **Maven**: For project management and build automation.

## Prerequisites

- **Java Development Kit (JDK) 8+**
- **Maven**
- **Appium Server**
- **Android SDK**
- **Node.js and NPM**
- **An Android Emulator**



## Setup

1. **Clone the repository**:
    ```bash
    https://github.com/ahujaShivA7X/xCube_Spotify.git
    cd xCube_Spotify
    ```

2. **Install dependencies**:
    ```bash
    mvn clean install
    ```

3. **Configure Appium and Android SDK**:
    - Ensure Appium server is running.
    - Ensure Android SDK is installed and environment variables are set.

4. **Set up Slack webhook URL**:
    - Replace the placeholder URL in `SlackIntegration.java` with your actual Slack webhook URL.

## Running the Tests

1. **Start Appium Server and Emulator**:
   The tests are designed to automatically run the emulator and appium server on setup


2. **Execute tests**:
    ```bash
    mvn test
    ```
   OR use TestRunner to run it manually

## Extent Reports

- After the test execution, an Extent Report will be generated at `test-output/extent.html`.
- The report provides detailed insights into the test execution, including pass/fail status, screenshots, and logs.

## Slack Integration

- Real-time notifications will be sent to the specified Slack channel upon test completion.
- Configure your Slack webhook URL in `SlackIntegration.java`:

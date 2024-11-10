# Mobile Automation Task
## Requirements
- Java Development Kit (JDK) 8 or newer
- Maven
- Appium Server
- Android SDK
- Android device or emulator

## Setup
1. Clone the repository:
   ```bash
   git clone <repository-link>
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Start Appium Server:
   - Run Appium Server at `http://localhost:4723/wd/hub`.

4. Update driver settings:
   - In `DriverFactory.java`, update `DEVICE_NAME` and `APP` with your device info and app path.

## Run Tests
```bash
mvn test
```

## Notes
- Framework designed with Page Object Model (POM) for reusability and maintainability.
- Data is loaded from `testData.properties` to avoid hardcoding.
- Comments added for behavior explanation.
- All dependencies are included to ensure the project runs on other machines.

# JANKins

## Overview
This project is an attempt at a continuous integration tool, like Jenkins, however it will be much simplier, and not complete the software dev life cycle. The project to start will be solely about building the application, testing it, and then if all tests pass commiting it, and pushing it github.com.

## Features
- [ ] compile the application with a command
- [ ] if the code compiles test the application with the same command
- [ ] push the results to github if tests succeed

## User Stories
As a Developer I would like a process the builds, tests, and commits and pushes my code with only one step by me so that my devlopement process will be quicker and I never push borken code.

## Tech Stack
- [x] JavaSE 8
- [x] JavaEE 7:
  - [x] Servlet
- [ ] PostgreSQL
- [x] Maven 3
- [ ] JUnit 5
- [ ] Docker
- [ ] Amazon Web Services
- [x] Git SCM

## Usage
### Run
```mvn exec:java```

### Clean
```mvn clean```

### Test
```mvn test```

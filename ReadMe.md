# JANKins

## Overview
This project is an attempt at a continuous integration tool, like Jenkins, however it will be much simplier, and not complete the software dev life cycle. The project to start will be solely about building the application, testing it, and then if all tests pass commiting it, and pushing it github.com.

## Features
- [ ] watch the repository for a commit

- [ ] pull code from repository to server when repo is updated
  - [ ] compile the application from commit
    - [ ] works with maven java projects
  - [ ] if the code compiles test the application with the same command
    - [ ] works with maven, java projects

- [ ] push the results to github if tests succeed

## User Stories
As a Developer I would like a process the builds, tests, and pushes my code to git hub when I commit my code if all of the previous steps succeed so that my devlopement process will be quicker and I never push borken code.

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

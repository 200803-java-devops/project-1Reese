# JANKins

## Overview
This project is an attempt at a continuous integration tool, like Jenkins, however it will be much simplier, and not complete the software dev life cycle. The project to start will be solely about building the application, testing it, and then if all tests pass commiting it, and pushing it github.com.

## Features
- [x] watch the repository for a commit

- [x] Acess git repository from local server when repo is updated
  - [x] compile the application from commit
    - [x] works with maven java projects
    - [ ] notify developer of results
  - [x] if the code compiles test the application
    - [x] works with maven, java projects
    - [ ] notify devloper of results

- [x] push the results to github if tests succeed
  -[ ] notify developer of results

## User Stories
As a Developer I would like a process the builds my code when I commit so that I know not to push commits with compilation errors.

As a Devloper I would like a process that tests my code when I commit so that I Know not to push a commit that doesn't pass my unit tests.

As a developer I would like a process that pushes my code to git hub when I commit my code if it passes comilation and tests so that my devlopement process will be quicker and I never push borken code.

As a Developer I would like to be notified when my tests fail after commitng, so that I can be aware I have broken Tests.

As a developer I would like to be notified when my build fails after commiting so that I can be aware my code did not compile.

As a Developer I would like to be notified of the results of a auto push when I commit working code.

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

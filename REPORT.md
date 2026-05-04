# SOFTWARE ENGINEERING & DEVOPS LAB
## Laboratory Project Report
### DevOps-Based Case Study with Automated CI/CD Pipeline

**Case Study:** Smart Parking Slot Booking System  
**Student Name:** MOHAMMED ABDUL AFNAN  
**Academic Year:** 2025 - 2026  
**Repository:** (Add your GitHub URL after push)

---

## Chapter 1: Introduction

The Smart Parking Slot Booking System is a simple Java Maven project that demonstrates slot management and booking operations. This project is integrated with core DevOps practices including Git version control, JUnit testing, Jenkins pipeline, Docker containerization, and Ansible deployment automation.

### 1.1 Objectives
- Develop a simple Smart Parking Slot Booking System in Java
- Implement unit tests using JUnit
- Configure Maven for build and dependency management
- Add CI pipeline using Jenkins
- Create Dockerfile to containerize the app
- Add Ansible playbook for deployment
- Maintain source code in Git and push to GitHub

### 1.2 Tools and Technologies
- Java 11
- Maven 3.x
- JUnit 4.13.2
- Git
- Jenkins
- Docker
- Ansible

## Chapter 2: System Development

### 2.1 Project Structure
- `pom.xml`
- `src/main/java/com/smartparking/model/ParkingSlot.java`
- `src/main/java/com/smartparking/model/Booking.java`
- `src/main/java/com/smartparking/service/ParkingService.java`
- `src/main/java/com/smartparking/Main.java`
- `src/test/java/com/smartparking/service/ParkingServiceTest.java`
- `Dockerfile`
- `Jenkinsfile`
- `deploy.yml`

### 2.2 Class Descriptions
- `ParkingSlot`: Slot entity with id, type, and availability
- `Booking`: Booking entity with booking id, vehicle number, and slot
- `ParkingService`: Handles slot CRUD, booking, cancellation
- `Main`: Demonstrates simple execution flow
- `ParkingServiceTest`: Contains unit tests

## Chapter 3: UML Diagrams

UML source files are available in `docs/uml`:
- `usecase.puml`
- `class.puml`
- `sequence.puml`
- `deployment.puml`

## Chapter 4: Bug Identification & Test Cases

Detailed table is available in: `docs/bugs-and-testcases.md`

## Chapter 5: Version Control - Git

### 5.1 Git Commands Used
```bash
git init
git add .
git commit -m "Initial commit: Smart Parking Slot Booking System"
git branch -M main
git remote add origin <your-github-repo-url>
git push -u origin main
```

### 5.2 Expected Output
- Repository initialized
- Files staged and committed
- Code pushed to GitHub main branch

## Chapter 6: Build Tool - Maven

Use this command:
```bash
mvn clean compile test package
```
Expected result:
- Project compiles
- JUnit tests execute
- JAR generated in `target/`

## Chapter 7: Continuous Integration - Jenkins

Jenkins pipeline stages in `Jenkinsfile`:
1. Clone
2. Build
3. Test
4. Package
5. Docker Build
6. Docker Run

## Chapter 8: Configuration Management - Ansible

Ansible playbook file: `deploy.yml`

Use:
```bash
ansible-playbook deploy.yml
```

## Chapter 9: Containerization - Docker

Build and run:
```bash
docker build -t smart-parking-slot-booking-system:latest .
docker run -d --name smart-parking-app smart-parking-slot-booking-system:latest
```

## Chapter 10: Conclusion

This project demonstrates a complete yet simple DevOps workflow for a Java-based Smart Parking Slot Booking System. It covers development, UML, testing, CI/CD basics, containerization, and deployment automation as required in the lab instructions.

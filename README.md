# Student Management System  

A Java-based project developed in Semester 2 that implements a Student Management System. The system uses JDBC for MySQL database connectivity, managed via XAMPP, and provides functionalities for adding, updating, searching, removing, and viewing student records.  

## Features  
- Add new student records.  
- Remove student records (by ID or name).  
- Search student details (by ID or name).  
- Update student details (name, contact, course, percentage).  
- View all student records.  

---

## Getting Started  

Welcome to the VS Code Java world. Here is a guideline to help you get started with writing Java code in Visual Studio Code.  

### Folder Structure  

The workspace contains two folders by default, where:  
- `src`: the folder to maintain sources.  
- `lib`: the folder to maintain dependencies.  

Meanwhile, the compiled output files will be generated in the `bin` folder by default.  

If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.  

### Dependency Management  

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).  

---

## Prerequisites  
- **Java JDK** (Version 8 or above).  
- **XAMPP** (for MySQL database management).  

## Setup Instructions  

1. Clone the repository:  
   ```bash
   git clone https://github.com/yourusername/StudentManagementSystem.git
2. Import the project into Visual Studio Code or your preferred IDE.
3. Use XAMPP to start MySQL and create the required database and table:
    CREATE DATABASE individual_project;
    USE individual_project;
    CREATE TABLE studentinfo (
      sid INT AUTO_INCREMENT PRIMARY KEY,
      sname VARCHAR(50),
      sage INT,
      sgender VARCHAR(10),
      scontact BIGINT,
      scourse VARCHAR(50),
      spercent INT
  );
4. Update the dburl, dbuser, and dbpass variables in the code to match your XAMPP MySQL configuration.

## Usage
1. Run the program in Visual Studio Code.
2. Follow the menu prompts to interact with the system.

## Technologies Used
1. Java (JDBC for database connectivity).
2. MySQL (managed via XAMPP).

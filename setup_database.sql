# USE <your_database_name>

CREATE TABLE Checklist(
    name VARCHAR(50) PRIMARY KEY,
    profileId INT NOT NULL,
    repeatEvery VARCHAR(50) NOT NULL
);

CREATE TABLE ChecklistItem(
    id INT PRIMARY KEY AUTO_INCREMENT,
    checklistName VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    lastCompletedDate DATE,
    excludeDays VARCHAR(25)
);
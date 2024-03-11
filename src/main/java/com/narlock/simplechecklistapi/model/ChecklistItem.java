package com.narlock.simplechecklistapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ChecklistItem")
public class ChecklistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String checklistName;
    private String name;
    private String description;
    private LocalDate lastCompletedDate;
    private String excludeDays;

    public ChecklistItem(String checklistName, String name, String description, LocalDate lastCompletedDate, String excludeDays) {
        this.checklistName = checklistName;
        this.name = name;
        this.description = description;
        this.lastCompletedDate = lastCompletedDate;
        this.excludeDays = excludeDays;
    }
}

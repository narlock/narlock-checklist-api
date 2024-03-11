package com.narlock.simplechecklistapi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ChecklistItemRequest {
    private String checklistName;
    private String name;
    private String description;
    private LocalDate lastCompletedDate;
    private String excludeDays;

    public ChecklistItem toChecklistItem() {
        return new ChecklistItem(checklistName, name, description, lastCompletedDate, excludeDays);
    }
}

package com.narlock.simplechecklistapi.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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

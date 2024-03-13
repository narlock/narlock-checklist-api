package com.narlock.simplechecklistapi.controller;

import com.narlock.simplechecklistapi.model.ChecklistItem;
import com.narlock.simplechecklistapi.model.ChecklistItemRequest;
import com.narlock.simplechecklistapi.service.SimpleChecklistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/checklist-item")
@RequiredArgsConstructor
public class ItemController {

  private final SimpleChecklistService simpleChecklistService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ChecklistItem createChecklistItem(@RequestBody ChecklistItemRequest checklistItemRequest) {
    return simpleChecklistService.createChecklistItem(checklistItemRequest);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ChecklistItem getChecklistItem(@PathVariable("id") Integer id) {
    return simpleChecklistService.getChecklistItem(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ChecklistItem updateChecklistItem(
      @PathVariable("id") Integer id, @RequestBody ChecklistItemRequest checklistItemRequest) {
    return simpleChecklistService.updateChecklistItem(id, checklistItemRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteChecklistItem(@PathVariable("id") Integer id) {
    simpleChecklistService.deleteChecklistItem(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ChecklistItem> getChecklistItemsByChecklistName(
      @RequestParam("checklistName") String checklistName) {
    return simpleChecklistService.getChecklistItemsByChecklistName(checklistName);
  }
}

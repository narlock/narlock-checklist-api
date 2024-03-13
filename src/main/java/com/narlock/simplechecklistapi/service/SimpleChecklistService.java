package com.narlock.simplechecklistapi.service;

import com.narlock.simplechecklistapi.model.Checklist;
import com.narlock.simplechecklistapi.model.ChecklistItem;
import com.narlock.simplechecklistapi.model.ChecklistItemRequest;
import com.narlock.simplechecklistapi.model.error.NotFoundException;
import com.narlock.simplechecklistapi.repository.ChecklistItemRepository;
import com.narlock.simplechecklistapi.repository.ChecklistRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleChecklistService {

  private final ChecklistRepository checklistRepository;
  private final ChecklistItemRepository checklistItemRepository;

  // List
  public Checklist createChecklist(Checklist checklist) {
    checklistRepository.saveNewChecklist(
        checklist.getName(), checklist.getProfileId(), checklist.getRepeatEvery());
    List<Checklist> checklists =
        checklistRepository.findByProfileIdAndName(checklist.getProfileId(), checklist.getName());

    if (checklists.size() > 1) {
      throw new RuntimeException(
          "Unexpected result from backend - more then one result for checklist "
              + checklist.getName());
    }

    if (!checklists.isEmpty()) {
      return checklists.get(0);
    }

    throw new NotFoundException("No checklist found for name " + checklist.getName());
  }

  public Checklist getChecklist(String name, Integer profileId) {
    List<Checklist> checklists = checklistRepository.findByProfileIdAndName(profileId, name);

    if (checklists.size() > 1) {
      throw new RuntimeException(
          "Unexpected result from backend - more then one result for checklist " + name);
    }

    if (!checklists.isEmpty()) {
      return checklists.get(0);
    }

    throw new NotFoundException("No checklist found for name " + name);
  }

  public Checklist updateChecklistRepeat(String name, Integer profileId, String repeatDays) {
    Checklist checklist = new Checklist(name, profileId, repeatDays);
    return checklistRepository.save(checklist);
  }

  public void deleteChecklist(String name, Integer profileId) {
    checklistRepository.deleteByProfileIdAndName(profileId, name);
  }

  // Item

  public ChecklistItem createChecklistItem(ChecklistItemRequest checklistItemRequest) {
    ChecklistItem checklistItem = checklistItemRequest.toChecklistItem();
    return checklistItemRepository.save(checklistItem);
  }

  public ChecklistItem getChecklistItem(Integer id) {
    Optional<ChecklistItem> checklistItemOptional = checklistItemRepository.findById(id);
    if (checklistItemOptional.isPresent()) {
      return checklistItemOptional.get();
    }

    throw new NotFoundException("No checklist item found for id " + id);
  }

  public ChecklistItem updateChecklistItem(Integer id, ChecklistItemRequest checklistItemRequest) {
    ChecklistItem checklistItem = checklistItemRequest.toChecklistItem();
    checklistItem.setId(id);
    return checklistItemRepository.save(checklistItem);
  }

  public void deleteChecklistItem(Integer id) {
    checklistItemRepository.deleteById(id);
  }

  public List<ChecklistItem> getChecklistItemsByChecklistName(String checklistName) {
    return checklistItemRepository.findByChecklistName(checklistName);
  }
}

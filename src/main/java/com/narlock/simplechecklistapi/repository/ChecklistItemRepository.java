package com.narlock.simplechecklistapi.repository;

import com.narlock.simplechecklistapi.model.ChecklistItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, Integer> {

  @Query("SELECT c FROM ChecklistItem c WHERE c.checklistName = :checklistName")
  List<ChecklistItem> findByChecklistName(@Param("checklistName") String checklistName);
}

package com.narlock.simplechecklistapi.repository;

import com.narlock.simplechecklistapi.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, Integer> {
}

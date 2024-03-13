package com.narlock.simplechecklistapi.repository;

import com.narlock.simplechecklistapi.model.Checklist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ChecklistRepository extends JpaRepository<Checklist, String> {
  @Modifying
  @Transactional
  @Query(
      "INSERT INTO Checklist(name, profileId, repeatEvery) VALUES (:name, :profileId, :repeatEvery)")
  void saveNewChecklist(
      @Param("name") String name,
      @Param("profileId") Integer profileId,
      @Param("repeatEvery") String repeatEvery);

  List<Checklist> findByProfileIdAndName(Integer profileId, String name);

  @Modifying
  @Transactional
  @Query("DELETE FROM Checklist c WHERE c.profileId = :profileId AND c.name = :name")
  void deleteByProfileIdAndName(@Param("profileId") Integer profileId, @Param("name") String name);
}

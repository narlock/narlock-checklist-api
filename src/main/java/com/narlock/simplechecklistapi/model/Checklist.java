package com.narlock.simplechecklistapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private Integer profileId;

    // DAY, WEEK, MONTH (DAY by default)
    private String repeatEvery;

    public Checklist(Integer profileId, String repeatEvery) {
        this.profileId = profileId;
        this.repeatEvery = repeatEvery;
    }
}

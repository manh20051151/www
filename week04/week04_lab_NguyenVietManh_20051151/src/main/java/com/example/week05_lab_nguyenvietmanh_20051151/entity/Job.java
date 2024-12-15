package com.example.week05_lab_nguyenvietmanh_20051151.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Table(name = "job")
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ElementCollection
    @CollectionTable(name = "job_skill", joinColumns = @JoinColumn(name = "job_id"))
    @MapKeyJoinColumn(name = "skill_id")
    @Column(name = "required_level")
    private Map<Skill, Integer> requiredSkills = new HashMap<>();

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Skill, Integer> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Map<Skill, Integer> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}

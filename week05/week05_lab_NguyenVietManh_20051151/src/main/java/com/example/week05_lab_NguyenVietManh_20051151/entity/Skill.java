package com.example.week05_lab_NguyenVietManh_20051151.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_type")
    private Byte skillType;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_desc")
    private String skillDesc;

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs;

    @ManyToMany(mappedBy = "skills")
    private List<Candidate> candidates;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Skill skill = (Skill) obj;
        return Objects.equals(id, skill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

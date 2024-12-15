package com.example.week05_lab_NguyenVietManh_20051151.repository;

import com.example.week05_lab_NguyenVietManh_20051151.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoSkill extends JpaRepository<Skill, Long> {
}

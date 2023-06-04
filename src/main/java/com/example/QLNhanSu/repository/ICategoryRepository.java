package com.example.QLNhanSu.repository;

import com.example.QLNhanSu.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICategoryRepository extends JpaRepository<PhongBan, Long> {
}

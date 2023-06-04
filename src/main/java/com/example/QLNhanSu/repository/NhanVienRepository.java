package com.example.QLNhanSu.repository;

import com.example.QLNhanSu.entity.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NhanVienRepository extends JpaRepository<NHANVIEN, Long> {
}

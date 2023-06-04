package com.example.QLNhanSu.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Ma_Phong;

    @Column(name = "Ten_Phong")
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan")
    private List<NHANVIEN> nhanVien;
}

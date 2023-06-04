package com.example.QLNhanSu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class NHANVIEN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_NV")
    private int maNv;

    public int getMaNv() {
        return maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public String getTEN_NV() {
        return TEN_NV;
    }

    public void setTEN_NV(String TEN_NV) {
        this.TEN_NV = TEN_NV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    @Column(name = "TEN_NV")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 100, min = 1, message = "Title must be less than 50 characters")
    private String TEN_NV;

    @Column(name = "Gioi_tinh")
    private String gioiTinh;

    @Column(name = "Noi_sinh")
    @NotNull(message = "Noi sinh")
    private String noiSinh;

    @Column(name = "Luong")
    @NotNull(message = "Luong khong duoc de trong")
    private String luong;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;
}
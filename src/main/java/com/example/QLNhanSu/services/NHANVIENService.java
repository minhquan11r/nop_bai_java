package com.example.QLNhanSu.services;

import com.example.QLNhanSu.entity.NHANVIEN;
import com.example.QLNhanSu.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NHANVIENService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public List<NHANVIEN> getAllNhanviens(){
        return  nhanVienRepository.findAll();
    }
    public NHANVIEN getNhanVienyId(Long Ma_NV){
        return nhanVienRepository.findById(Ma_NV).orElse(null);
    }
    public void addNhanVien(NHANVIEN NHANVIEN){
        nhanVienRepository.save(NHANVIEN);
    }
    public void deleteNhanVienById(Long id) {
        nhanVienRepository.deleteById(id);
    }
    public void updateNhanVien(NHANVIEN NHANVIEN){
        nhanVienRepository.save(NHANVIEN);
    }
}

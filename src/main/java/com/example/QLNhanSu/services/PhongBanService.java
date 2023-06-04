package com.example.QLNhanSu.services;

import com.example.QLNhanSu.entity.PhongBan;
import com.example.QLNhanSu.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    public List<PhongBan> getAllCategories(){
        return  iCategoryRepository.findAll();
    }
    public PhongBan getCategoryById(Long Ma_Phong){
        return iCategoryRepository.findById(Ma_Phong).orElse(null);
    }
    public PhongBan saveCategory(PhongBan phongBan){
        return  iCategoryRepository.save(phongBan);
    }
    public void deleteCategory(Long Ma_Phong){
        iCategoryRepository.deleteById(Ma_Phong);
    }

}

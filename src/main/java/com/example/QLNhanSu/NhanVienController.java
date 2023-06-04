package com.example.QLNhanSu;

import com.example.QLNhanSu.entity.NHANVIEN;
import com.example.QLNhanSu.services.NHANVIENService;
import com.example.QLNhanSu.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NHANVIENService NHANVIENService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanViens(Model model){
        List<NHANVIEN> nhanViens = NHANVIENService.getAllNhanviens();
        model.addAttribute("nhanVien", nhanViens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVien(Model model) {
        model.addAttribute("nhanVien", new NHANVIEN());
        model.addAttribute("phongban", phongBanService.getAllCategories());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien") NHANVIEN nhanVien, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("nhanVien", new NHANVIEN());
            model.addAttribute("phongban", phongBanService.getAllCategories());
            return "nhanvien/add";
        }
        NHANVIENService.addNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") Long id) {
        NHANVIENService.deleteNhanVienById(id);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editNHANVIEN(@PathVariable("id") long MA_NV, Model model){
        NHANVIEN editNHANVIEN = NHANVIENService.getNhanVienyId(MA_NV);
        if(editNHANVIEN != null){
            model.addAttribute("nhanVien", editNHANVIEN);
            model.addAttribute("phongban", phongBanService.getAllCategories());
            return "nhanvien/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editNHANVIEN(@Valid @ModelAttribute("nhanvien") NHANVIEN updateNHANVIEN, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("phongban", phongBanService.getAllCategories());
            return "nhanvien/edit";
        }
        NHANVIENService.getAllNhanviens().stream()
                .filter(nhanVien -> nhanVien.getMaNv() == updateNHANVIEN.getMaNv())
                .findFirst()
                .ifPresent(nhanVien -> {
                    nhanVien.setMaNv(updateNHANVIEN.getMaNv());
                    nhanVien.setNoiSinh(updateNHANVIEN.getNoiSinh());
                    nhanVien.setLuong(updateNHANVIEN.getLuong());
                    nhanVien.setGioiTinh(updateNHANVIEN.getGioiTinh());
                    nhanVien.setPhongBan(updateNHANVIEN.getPhongBan());
                    NHANVIENService.updateNhanVien(nhanVien);
                });
        return "redirect:/nhanvien";
    }
}

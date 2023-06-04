package com.example.QLNhanSu.validator;

import com.example.QLNhanSu.entity.PhongBan;
import com.example.QLNhanSu.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, PhongBan> {
    @Override
    public boolean isValid(PhongBan phongBan, ConstraintValidatorContext context){
        return phongBan != null && phongBan.getMa_Phong() !=null;
    }
}

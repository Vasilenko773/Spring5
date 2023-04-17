package com.example.spring5.validation;

import com.example.spring5.jpa.user.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class UserInfoValidator implements ConstraintValidator<UserInfo, User> {


    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value.getFirstname()) || StringUtils.hasText(value.getLastname());
    }
}
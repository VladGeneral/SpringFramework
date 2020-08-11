package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if (str != null) {
            for (String tempPrefix : coursePrefix){
                result = str.startsWith(tempPrefix);
                if (result){
                    break;
                }
            }
        } else {
            result = true;
        }
        return result;
    }
}

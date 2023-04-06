package org.example.Project2Boot.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.validation.Errors;


import java.util.Set;

public interface PersonValidators extends Validator {
    boolean supports(Class<?> aClass);

    void validate (Object o, Errors errors);

    <T> Set<ConstraintViolation<T>> validate(T t, Class<?>... classes);

    <T> Set<ConstraintViolation<T>> validateProperty(T t, String s, Class<?>... classes);

    <T> Set<ConstraintViolation<T>> validateValue(Class<T> aClass, String s, Object o, Class<?>... classes);

    BeanDescriptor getConstraintsForClass(Class<?> aClass);

    <T> T unwrap(Class<T> aClass);

    ExecutableValidator forExecutables();
}

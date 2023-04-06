package org.example.Project2Boot.util;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.example.Project2Boot.models.Person;
import org.example.Project2Boot.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Set;

@Component
public class PersonValidator implements PersonValidators {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (peopleService.getPersonByFullName(person.getName()).isPresent())
            errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validate(T t, Class<?>... classes) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T t, String s, Class<?>... classes) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> aClass, String s, Object o, Class<?>... classes) {
        return null;
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> aClass) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }
}


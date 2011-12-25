/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.Instituce;

/**
 *
 * @author car nikolaj
 * Slouzi k validovani formulare instituce
 */
//zajistuje validaci formulare pro pridani nove instituce
public class InstituceFormValidator implements Validator {

    /**
     *
     * @param aClass
     * @return
     */
    //urcuje na kterou tridu bude validator pripojen
    public boolean supports(Class aClass) {
        return Instituce.class.equals(aClass);
    }

    /**
     * 
     * @param obj
     * @param errors
     * metoda starajici se o samostatnou validaci
     */
    public void validate(Object obj, Errors errors) {
        //	Instituce instituce = (Instituce) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazev", "field.required", "Název musí být vyplněn!");
    }
}

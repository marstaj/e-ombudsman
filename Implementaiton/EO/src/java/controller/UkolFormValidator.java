/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Ukol;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author car nikolaj
 */
//trida starajici se o validaci formulare pro zadavani novych ukolu
public class UkolFormValidator implements Validator {

    /**
     *
     * @param aClass
     * @return
     */
    public boolean supports(Class aClass) {
        return Ukol.class.equals(aClass);
    }

    /**
     *
     * @param obj
     * @param errors
     */
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nadpis", "field.required", "Nadpis musí být vyplněno!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textUkolu", "field.required", "Text musí být vyplněn!");

    }
}

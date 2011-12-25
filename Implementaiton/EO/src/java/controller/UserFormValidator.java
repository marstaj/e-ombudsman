/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.Uzivatel;

/**
 *
 * @author car nikolaj
 */
//trida starajici se o validaci formulare pro pridani noveho uzivatele
public class UserFormValidator implements Validator {

    /**
     *
     * @param aClass
     * @return
     */
    public boolean supports(Class aClass) {
        return Uzivatel.class.equals(aClass);
    }

    /**
     *
     * @param obj
     * @param errors
     */
    public void validate(Object obj, Errors errors) {
        Uzivatel user = (Uzivatel) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "field.required", "Login musí být vyplněn!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heslo", "field.required", "Heslo musí být vyplněno!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jmeno", "field.required", "Jméno musí být vyplněno!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prijmeni", "field.required", "Příimení musí být vyplněno!");

        if (!errors.hasFieldErrors("jmeno")) {
            if (user.getJmeno().matches("[A-z]{2,20}$") == false) {
                errors.rejectValue("jmeno", "spatny_tvar", "Špatný tvar jména.");
            }
        }
        if (!errors.hasFieldErrors("prijmeni")) {
            if (user.getPrijmeni().matches("[A-z]{2,20}$") == false) {
                errors.rejectValue("prijmeni", "spatny_tvar", "Špatný tvar příjmení.");
            }
        }

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Resitel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//import model.Uzivatel;
/**
 *
 * @author car nikolaj
 */
//trida starajici se o validaci formulare k pridani noveho resitele
public class ResitelFormValidator implements Validator {

    /**
     *
     * @param aClass
     * @return
     */
    public boolean supports(Class aClass) {
        return Resitel.class.equals(aClass);
    }

    /**
     *
     * @param obj
     * @param errors
     */
    public void validate(Object obj, Errors errors) {
        Resitel user = (Resitel) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "field.required", "Jméno musí být vyplněno!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heslo", "field.required", "Přihlašovací jméno musí být vyplněno!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jmeno", "field.required", "Heslo musí být vyplněno!");

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

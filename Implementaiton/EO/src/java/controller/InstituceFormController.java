/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.Instituce;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 * Slouzi k ukladani novych instituci do databaze
 */
public class InstituceFormController extends SimpleFormController {

    /**
    Konstruktor tridy
     */
    public InstituceFormController() {
        setCommandClass(Instituce.class);
        setCommandName("instituce");
        setSuccessView("instituce");
        setFormView("new_instituce_form");
    }

    /**
     *
     * @param command
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Instituce instituce = (Instituce) command;
        // uklada data z formulare jako novy zaznam do tabulky v databazi
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(instituce);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //urcuje ktera stranka se nacte po uspesnem provedeni ulozeni
        return new ModelAndView(new RedirectView("instituce.htm"));
    }
}

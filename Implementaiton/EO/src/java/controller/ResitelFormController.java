/**
 *
 * @author car nikolaj
 */
package controller;

import model.Resitel;
import model.HibernateUtil;

import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 */
//trida starajici se o ukladani dat z formulare do databaze
public class ResitelFormController extends SimpleFormController {

    /**
     *
     */
    //konstruktor
    public ResitelFormController() {
        setCommandClass(Resitel.class);
        setCommandName("resitel");
        setSuccessView("resitel");
        setFormView("new_resitel_form");
    }

    /**
     *
     * @param command
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Resitel user = (Resitel) command;
        try {
            //zalozeni session do databaze
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            user.setStavUctu("aktivní");
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView(new RedirectView("resitel.htm"));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/** 
 *
 * @author car nikolaj
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HibernateUtil;
import model.Uzivatel;
import org.hibernate.Session;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 */
//trida starajici se o ukladani dat z formulare do databaze
public class UserFormController extends SimpleFormController {

    /**
     *
     */
    public UserFormController() {
        setCommandClass(Uzivatel.class);
        setCommandName("user");
        setSuccessView("user");
        setFormView("new_user_form");
    }

    /**
     *
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Uzivatel user = (Uzivatel) command;
        int idInst = 9999;
        HttpSession ses = request.getSession();
        if (ses.getAttribute("idInst") != null) {
            idInst = (Integer) ses.getAttribute("idInst");
        }
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            user.setStavUctu("existuje");
            user.setInstituceId(idInst);
            user.setRoleId(1);
            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView(new RedirectView("user.htm"));
    }
}

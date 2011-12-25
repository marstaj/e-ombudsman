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
import model.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author car nikolaj
 */
//trida starajici se o vypis uzivatelu
public class UserController implements Controller {

    /**
     *
     * @param hsr
     * @param hsr1
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr,
            HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("user");
        String out = "Výpis uživatelů: ";
        HttpSession ses = hsr.getSession();
        int idInst = 0;

        if (ses.getAttribute("idInst") != null) {
            idInst = (Integer) ses.getAttribute("idInst");
        }


        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List result = session.createQuery("from Uzivatel where stavUctu ='aktivní' and instituceId=" + idInst).list();
            mv.addObject("users", result);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        HttpSession hsn = hsr.getSession();
        if (hsn.getAttribute("userLoggedIn") != null) {
            int userId = (Integer) hsn.getAttribute("userLoggedIn");
            mv.addObject("userId", userId);
        }
        if (hsn.getAttribute("isOmbudsman") != null) {
            int userId = (Integer) hsn.getAttribute("isOmbudsman");
            mv.addObject("userId", userId);
        }
        if (hsn.getAttribute("isAdmin") != null) {
            int userId = (Integer) hsn.getAttribute("isAdmin");
            mv.addObject("userId", userId);
        }
        if (ses.getAttribute("isOmbudsman") != null) {
            mv.addObject("isOmbudsman", true);
        } else {
            mv.addObject("isOmbudsman", false);
        }
        if (ses.getAttribute("isAdmin") != null) {
            mv.addObject("isAdmin", true);
        } else {
            mv.addObject("isAdmin", false);
        }
        return mv;
    }
}

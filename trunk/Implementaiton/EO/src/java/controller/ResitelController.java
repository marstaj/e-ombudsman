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
public class ResitelController implements Controller {

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
        ModelAndView mv = new ModelAndView("resitel");
        String out = "Výpis řešitelů: ";
        int idInst = 0;
        HttpSession ses = hsr.getSession();
        //parsuje data z url
        if (ses.getAttribute("idInst") != null) {
            idInst = (Integer) ses.getAttribute("idInst");
        }
        //pridava do pohledu konretni id ukolu (pouziva se u prirazovani ukolu ombudsmanem)
        if (hsr.getParameter("ukolID") != null) {
            String strIdUkol = hsr.getParameter("ukolID");
            int IdUkol = Integer.parseInt(strIdUkol);

            mv.addObject("ukolID", IdUkol);
        }

        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List result = session.createQuery("from Resitel where stavUctu ='aktivní' and instituceId=" + idInst).list();
            mv.addObject("resitele", result);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);

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
        HttpSession hsn = hsr.getSession();
        if (hsn.getAttribute("userLoggedIn") != null) {
            int userId = (Integer) hsn.getAttribute("userLoggedIn");
            mv.addObject("userId", userId);
        }



        return mv;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import model.HibernateUtil;

import model.Ukol;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author car nikolaj
 * trida starajici se o prijeti ukolu resitelem
 */
//
public class PotvrzeniController implements Controller {

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

        ModelAndView mv = new ModelAndView("potvrzeni");
        HttpSession ses = hsr.getSession();
        int resId = 9999;
        //pokud je prihlaseny uzivatel resitelem
        if (ses.getAttribute("isResitel") != null) {
            resId = (Integer) ses.getAttribute("isResitel");
        }

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Ukol ukol2 = new Ukol();
            session.beginTransaction();
            //seznam ukolu cekajicich na potvrzeni konretním resitelem
            List seznam = session.createQuery("from Ukol where resitelId=" + resId + " and stavUkolu = 'existuje, přirazen rešiteli'").list();
            for (int i = 0; i < seznam.size(); i++) {
                ukol2 = (Ukol) seznam.get(i);
            }
            mv.addObject("ukoly", seznam);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}

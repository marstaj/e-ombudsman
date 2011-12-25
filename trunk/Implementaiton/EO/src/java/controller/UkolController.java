/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
//trida starajici se o zobrazovani ukolu z databaze
public class UkolController implements Controller {

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
        ModelAndView mv = new ModelAndView("ukol");
        String out = "Výpis ukolu: ";
        HttpSession ses = hsr.getSession();
        int idInst = 0;
        //parsovani dat z url
        if (ses.getAttribute("idInst") != null) {
            idInst = (Integer) ses.getAttribute("idInst");
        }
        if (ses.getAttribute("isOmbudsman") != null) {
            mv.addObject("isOmbudsman", true);
        } else {
            mv.addObject("isOmbudsman", false);
        }
        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //vybery dat z databaze
            List result = session.createQuery("from Ukol where resitelId < 1 and instituceId=" + idInst).list();

            List result2 = session.createQuery("from Ukol where resitelId > 0 and stavUkolu='řešen' and instituceId=" + idInst).list();
             List result3 = session.createQuery("from Ukol where stavUkolu='neschvalen' and instituceId=" + idInst).list();
            List resitele = session.createQuery("from Resitel where instituceId=" + idInst).list();
            List uzivatele = session.createQuery("from Uzivatel where instituceId=" + idInst).list();
            List kategorie = session.createQuery("from Kategorie where instituceId=" + idInst).list();
            //ulozeni do pohledu
            mv.addObject("volne", result);
            mv.addObject("resene", result2);
            mv.addObject("nesplnene", result3);
            mv.addObject("resitele", resitele);
            mv.addObject("uzivatele", uzivatele);
            mv.addObject("kategorie", kategorie);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        return mv;
    }
}

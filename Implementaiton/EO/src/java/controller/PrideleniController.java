/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
//import model.ReseniUkolu;
import model.Ukol;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 * trida zajistuje prideleni ukolu resitelum.Provadi ombudsman
 */
//
public class PrideleniController implements Controller {

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

        ModelAndView mv = new ModelAndView(new RedirectView("ukol.htm"));
        // parsovani udaju z url
        String strIdRes = hsr.getParameter("resID");
        String strIdUkol = hsr.getParameter("ukolID");

        int IdUkol = Integer.parseInt(strIdUkol);
        int IdRes = Integer.parseInt(strIdRes);
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            Ukol ukol2 = new Ukol();
            session.beginTransaction();
            //vyber konkretniho ukolu z databaze
            List seznam = session.createQuery("from Ukol where id=" + IdUkol).list();
            for (int i = 0; i < seznam.size(); i++) {
                ukol2 = (Ukol) seznam.get(i);
            }
            //uprava stavu ukolu a nastaveni id resitele
            ukol2.setStavUkolu("existuje, přirazen rešiteli");
            ukol2.setResitelId(IdRes);
            session.saveOrUpdate(ukol2);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}

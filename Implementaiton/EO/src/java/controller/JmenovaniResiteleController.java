/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.Resitel;
import model.Uzivatel;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 * zajistuje traformaci obycejneho klienta na resitele
 */
public class JmenovaniResiteleController extends SimpleFormController {

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

        ModelAndView mv = new ModelAndView(new RedirectView("user.htm"));
        //parsuje id uzivatele z url
        String strIdUser = hsr.getParameter("userID");

        int userId = Integer.parseInt(strIdUser);

        try {
            Uzivatel user2 = new Uzivatel();
            Resitel res = new Resitel();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List seznam = session.createQuery("from Uzivatel where id=" + userId).list();
            for (int i = 0; i < seznam.size(); i++) {
                user2 = (Uzivatel) seznam.get(i);

            }
            //vytvareni noveho resitele z uzivatele
            res.setJmeno(user2.getJmeno());
            res.setHeslo(user2.getHeslo());
            res.setLogin(user2.getLogin());
            res.setPrijmeni(user2.getPrijmeni());
            res.setStavUctu(user2.getStavUctu());
            res.setKategorieId(1);
            //maze uzivatele z databaze
            session.createQuery("delete from Uzivatel where id=" + userId).executeUpdate();
            session.save(res);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}

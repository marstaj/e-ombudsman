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
import model.Resitel;
import model.Ukol;
import model.Uzivatel;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 */
//trida starajici se o mazani dat z databaze
public class SmazaniController implements Controller {

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
        // parsuje data z url
        String strId = hsr.getParameter("Id");
        int id = Integer.parseInt(strId);
        String strPriznak = hsr.getParameter("priznak");
        int priznak = Integer.parseInt(strPriznak);
        //podle priznaku rozhodne o jakou entitu z databaze se jedna
        String tabulka = "";
        String strana = "";
        if (priznak == 1) {
            tabulka = "Uzivatel";
            strana = "user";
        }
        if (priznak == 2) {
            tabulka = "Resitel";
            strana = "resitel";
        }
        if (priznak == 3) {
            tabulka = "Ukol";
            strana = "ukol";
        }



        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            if (tabulka.equals("Uzivatel")) {
                Uzivatel user2 = new Uzivatel();
                session.beginTransaction();
                List seznam = session.createQuery("from Uzivatel where id=" + id).list();
                for (int i = 0; i < seznam.size(); i++) {
                    user2 = (Uzivatel) seznam.get(i);

                }

                user2.setStavUctu("blokovan");


                session.saveOrUpdate(user2);
                session.getTransaction().commit();
            }
            if (tabulka.equals("Resitel")) {
                Resitel res2 = new Resitel();
                session.beginTransaction();

                List seznam = session.createQuery("from Resitel where id=" + id).list();
                for (int i = 0; i < seznam.size(); i++) {
                    res2 = (Resitel) seznam.get(i);
                }

                res2.setStavUctu("blokovan");
                session.saveOrUpdate(res2);
                session.getTransaction().commit();

            }
            if (tabulka.equals("Ukol")) {
                Ukol ukol = new Ukol();
                session.beginTransaction();

                List seznam = session.createQuery("from Ukol where id=" + id).list();
                for (int i = 0; i < seznam.size(); i++) {
                    ukol = (Ukol) seznam.get(i);
                }

                ukol.setStavUkolu("neschvalen");
                session.saveOrUpdate(ukol);
                session.getTransaction().commit();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //vrati pohled na konretni stranku v systemu
        return new ModelAndView(new RedirectView(strana + ".htm"));
    }
}

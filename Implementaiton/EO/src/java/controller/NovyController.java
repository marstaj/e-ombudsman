/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author car nikolaj
 * Slouzi k potvrzeni ukolu
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import java.util.List;
import model.Ukol;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

public class NovyController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr,
            HttpServletResponse hsr1) throws Exception {

        Ukol ukol2 = new Ukol();
        int IdUkol = 0;
        //parsovani id z url
        if (hsr.getParameter("ukolID") != null) {
            String strIdUkol = hsr.getParameter("ukolID");
            IdUkol = Integer.parseInt(strIdUkol);

        }

        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //vyber konretniho ukolu z databaze
            List result = session.createQuery("from Ukol where id=" + IdUkol).list();

            for (int i = 0; i < result.size(); i++) {
                ukol2 = (Ukol) result.get(i);
            }
            //zmeni stav konretniho ukolu na reseny
            ukol2.setStavUkolu("řešen");
            ukol2.setDatumPrijeti(ukol2.getDatumPrijeti());
            session.saveOrUpdate(ukol2);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView(new RedirectView("ukol.htm"));
    }
}

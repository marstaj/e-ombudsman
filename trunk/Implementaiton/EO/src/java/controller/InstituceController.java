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
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author car nikolaj
 * Slouzi k vypisu Instituci
 */
public class InstituceController implements Controller {

    /**
     *
     * @param hsr
     * @param hsr1
     * @return
     * @throws Exception
     * 
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr,
            HttpServletResponse hsr1) throws Exception {
        //urcuje na kterou stranku controller odkazuje
        ModelAndView mv = new ModelAndView("instituce");
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //nacteni dat z databaze pomoci SQL dotazu
            List result = session.createQuery("from Instituce").list();
            //ulozeni dat do pohledu
            mv.addObject("instituce", result);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}

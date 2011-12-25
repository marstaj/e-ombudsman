/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HibernateUtil;
import model.Ukol;
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
public class UkolFormController extends SimpleFormController {

    /**
     *
     */
    //kontruktor tridy
    public UkolFormController() {
        setCommandClass(Ukol.class);
        setCommandName("ukol");
        setSuccessView("ukol");
        setFormView("new_ukol_form");
    }
    //trida ktera vrati aktualni datum

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
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
        Ukol ukol = (Ukol) command;

        //parsovani dat z url
        HttpSession ses = request.getSession();
        int userId = 9999;
        if (ses.getAttribute("userLoggedIn") != null) {
            userId = (Integer) ses.getAttribute("userLoggedIn");
        }
        int idInst = 9999;
        if (ses.getAttribute("idInst") != null) {
            idInst = (Integer) ses.getAttribute("idInst");
        }


        try {
            //ulozeni ukolu do databaze
            ukol.setDatumPrijeti(getDate());
            ukol.setDatumSplneni("*****");
            ukol.setStavUkolu("vytvoren");
            ukol.setUzivatelId(userId);
            ukol.setInstituceId(idInst);
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(ukol);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView(new RedirectView("ukol.htm"));
    }
}

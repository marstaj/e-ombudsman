/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * trida starajici se o korektni prihlaseni do systemu
 * @author car nikolaj
 */
import org.hibernate.Session;
import org.springframework.web.servlet.mvc.SimpleFormController;
import model.HibernateUtil;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Uzivatel;
import model.Login;
import model.Resitel;
import org.springframework.validation.BindException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author car nikolaj
 */
@SuppressWarnings("deprecation")

public class LoginController extends SimpleFormController {

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

        Login login = (Login) command;
        String username = login.getLogin();
        String heslo = login.getHeslo();
        int userId = 0;
        int resId = 0;
        Uzivatel uzivatel = new Uzivatel();
        Resitel resitel = new Resitel();
        int idInst = 0;
        //parsovani id z url
        if (request.getParameter("ID") != null) {
            String strId = request.getParameter("ID");
            idInst = Integer.parseInt(strId);

        }
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //vybrani uzivatelu a resitelu z databaze
            List uzivatele = session.createQuery("from Uzivatel where instituceId=" + idInst).list();
            List resitele = session.createQuery("from Resitel where instituceId=" + idInst).list();
            session.getTransaction().commit();

            //porovnani prihlasovacich udaju s udaji z databaze
            for (int i = 0; i < uzivatele.size(); i++) {
                Uzivatel user = (Uzivatel) uzivatele.get(i);
                if (user.getLogin().equals(username) && user.getHeslo().equals(heslo)) {
                    userId = user.getId();
                    uzivatel = user;
                    break;
                }
            }
            for (int i = 0; i < resitele.size(); i++) {
                Resitel res = (Resitel) resitele.get(i);
                if (res.getLogin().equals(username) && res.getHeslo().equals(heslo)) {
                    resId = res.getId();
                    resitel = res;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //podte atributu prihlaseneho uzivatele mu nastavi odpovidajici prava v systemu
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession hts = request.getSession();
        if (username.equals("Ombudsman")) {
            // ulozeni atributu do session
            hts.setAttribute("isOmbudsman", userId);
        }
        if (idInst != 0) {
            hts.setAttribute("idInst", idInst);
        }
        if (username.equals("Admin")) {
            // ulozeni atributu do session
            hts.setAttribute("isAdmin", userId);
        }

        if (resId != 0) {
            String messageStatus = "Byl/a jste úspěšně přihlášen/a jako " + resitel.getJmeno();
            String messageLink = "Můžete pokračovat <a href=\"hlavni_strana.htm\">zde</a>";

            //ulozeni atributu do session
            hts.setAttribute("isResitel", resId);

            ModelAndView modelAndView = new ModelAndView("succesfullLogin");
            modelAndView.addObject("messageStatus", messageStatus);
            modelAndView.addObject("messageLink", messageLink);

            return modelAndView;

        }


        if (userId != 0) {
            String messageStatus = "Byl/a jste úspěšně přihlášen/a jako " + uzivatel.getJmeno();
            String messageLink = "Můžete pokračovat <a href=\"hlavni_strana.htm\">zde</a>";

            // ulozeni atributu do session
            hts.setAttribute("userLoggedIn", userId);

            ModelAndView modelAndView = new ModelAndView("succesfullLogin");
            modelAndView.addObject("messageStatus", messageStatus);
            modelAndView.addObject("messageLink", messageLink);

            return modelAndView;

        } else {
            //pokud se prihlaseni nezdarilo system o tom vypise zpravu
            String messageStatus = "Přihlášení se nezdařilo:";
            String messageLink = "Můžete se registrovat <a href=\"new_user_form.htm\">zde</a>, nebo se vratit k přihlášení <a href=\"login.htm\">zde</a>";
            //     ModelAndView modelAndView = new ModelAndView(new RedirectView("succsesfullLogin.htm"));
            ModelAndView modelAndView = new ModelAndView("succesfullLogin");
            modelAndView.addObject("messageStatus", messageStatus);
            modelAndView.addObject("messageLink", messageLink);
            return modelAndView;
        }



    }
}

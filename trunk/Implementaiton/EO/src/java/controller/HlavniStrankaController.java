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
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author car nikolaj
 */
public class HlavniStrankaController implements Controller {

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
        //urcuje na kterou stranku controller odkazuje
        ModelAndView mv = new ModelAndView("hlavni_strana");
        HttpSession ses = hsr.getSession();

        //testuje jaky uzivatel je prihlasen pomoci atributu v HttpSession
        //Admin
        if (ses.getAttribute("isAdmin") != null) {
            mv.addObject("isAdmin", true);
        } else {
            mv.addObject("isAdmin", false);
        }
        //Ombudsman
        if (ses.getAttribute("isOmbudsman") != null) {
            mv.addObject("isOmbudsman", true);
        } else {
            mv.addObject("isOmbudsman", false);
        }
        //Resitel
        if (ses.getAttribute("isResitel") != null) {
            mv.addObject("isResitel", true);
        } else {
            mv.addObject("isResitel", false);
        }
        //Klient (prihlaseny uzivatel)
        if (ses.getAttribute("userLoggedIn") != null) {
            mv.addObject("userLoggedIn", true);
        } else {
            mv.addObject("userLoggedIn", false);
        }

        return mv;
    }
}

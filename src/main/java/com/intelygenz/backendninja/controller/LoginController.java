package com.intelygenz.backendninja.controller;

import com.intelygenz.backendninja.constant.ViewConstant;
import com.intelygenz.backendninja.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);


    @GetMapping("/")
    public String redirectToLogin() {
        LOG.info("METHOD: redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("METHOD: showLoginForm() -- PARAMS: error = " + error + "logout" + logout);
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredential());
        LOG.info("Returning to login view");
        return ViewConstant.LOGIN;
    }

    /* Al ser un PostMapping, el user va por ModelAttribute
     *
     * https://www.arquitecturajava.com/spring-mvc-modelattribute/
     */

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {
        LOG.info("METHOD: logincheck() -- PARAMS: " + userCredential.toString());

        if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
            LOG.info("Returning to contacts view");
            return "redirect:/contacts/showcontacts";
        }
        LOG.info("Redirect to login?errors");
        return "redirect:/login?error";
    }

}

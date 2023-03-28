package com.example.demo.Misc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ErrorHandlerController  implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        System.out.println(status.toString());
        if (status.toString().equals("403")){

            return "redirect:/login?403";
        }
        if (status.toString().equals("404")){
            return "redirect:/?404";
        }

        System.out.println(status.toString());
        return "Welcome.html";
    }
}

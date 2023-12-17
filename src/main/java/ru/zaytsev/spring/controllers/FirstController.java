package ru.zaytsev.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {


        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("c") String c,
                             Model model
    ) {
        double result;

        switch (c) {
            case "add":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = (double) a / b;
                break;
            default:
                result = 0;
                break;
        }
        // if (c.equals("+")) result = a+b;
//        else if(c.equals("-")) result = a-b;
//        else if (c.equals("*")) result = a*b;
//        else if (c.equals("/")) result = (double) a / b;
//        else result = 0;
        model.addAttribute("message", "Result: " + a + c + b + "=" + result);

        return "first/calculator";
    }

}

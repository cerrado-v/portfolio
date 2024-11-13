package com.example.portfolio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@CrossOrigin("*")
@Controller
public class PortfolioController {
 
    @GetMapping("/employee")
    public String forward() { 
        return "employee/index";
    }

    @GetMapping("/portfolio")
    public String homePage(){
        return "navs/index";
    }

    @GetMapping("/ToDoList")
    public String todoPage() {
        return "todo/Index";
    }

    @GetMapping("/shop")
    public String shopPage() {
        return "shop/Index";
    }

    @GetMapping("/tasks")
    public String todoPage2() {
        return "todo/Index";
    }

    @GetMapping("/projects/blogs")
    public String blogsPage() {
        return "navs/blogs";
    }
    
    

}

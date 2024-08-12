package com.example.appSpring.controller;

import com.example.appSpring.model.Trainee;
import com.example.appSpring.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class TraineeController {

    //    @PostMapping("/add-trainee")
//    public String addTrainee(@RequestParam("id") int id,
//                             @RequestParam("name") String name,
//                             @RequestParam("location") String location,
//                             Model model){
//        Trainee t1 = new Trainee(id,name,location);
//        model.addAttribute("trainee",t1);
//        return "show-info.jsp";
//    }
    @Autowired
    private TraineeRepository trepo;

    @PostMapping("/add-trainee")
    public ModelAndView addTrainee(@ModelAttribute Trainee trainee) {
        trepo.addTrainee(trainee);
        System.out.println(trainee);
        ModelAndView mv = new ModelAndView("show-info.jsp");
        mv.addObject("trainee", trainee);
        return mv;
    }

    @GetMapping("/find-trainee")
    public String getTrainee(@RequestParam("id") int id, Model m) {

        Trainee t = trepo.getById(id);
        m.addAttribute("trainee", t);
        System.out.println(t);

        if (t == null) {
            m.addAttribute("id", id);
            return "show-error.jsp";
        }
        return "show-info.jsp";

//            System.out.println("Trainee doesn't exist");
    }

    @GetMapping("/remove-trainee")
    public String removeTrainee(@RequestParam("id") int id, Model m) {
        Trainee t = trepo.deleteId(id);
        m.addAttribute("trainee",t);
        return "show-info.jsp";
    }

}
//    @GetMapping("/show-trainee")
//    public String showAllTrainee(Model m){
//
//        try{
//                List<Trainee> all = trepo.getAll();
//                for(Trainee t:all){
//                    System.out.println(t);
//                }
//                return "error.html";
//
//        }catch(Exception ex){
//            return "error.html";
//        }
//    }
//
//    @PostMapping("/show-trainee")
//    public String showAllTrainee(Model m) {
//        try {
//            List<Trainee> all = trepo.getAll();
//            m.addAttribute("traineeList", all);
//            return "show-all.jsp";  // Return the JSP page that displays the list
//        } catch (Exception ex) {
//            return "error.html";
//        }
//    }


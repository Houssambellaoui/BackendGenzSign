//package com.prod.Barid.controller.ncn;
//
//import com.pfa.restapi.model.Ville;
//import com.pfa.restapi.service.EmailService;
//import com.pfa.restapi.service.VilleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController()
//@RequestMapping("/api/ncn/villes")
//public class NCNVilleController {
//
//    @Autowired
//    private VilleService villeService;
////    @Autowired
////    private EmailService emailService;
//
//    @GetMapping("/getAllVilles")
//    public List<Ville> getAllVilles(){
//        try {
////            System.out.println("### try send mail");
//            return villeService.getAllVilles().stream().filter(v -> !v.getCommunes().isEmpty()).toList();
//        } catch (Exception e){
//            return null;
//        }
//    }
//}

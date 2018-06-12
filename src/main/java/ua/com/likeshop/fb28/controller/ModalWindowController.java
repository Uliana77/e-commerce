//package ua.com.likeshop.fb28.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import ua.com.likeshop.fb28.entity.ModalWindow;
//import ua.com.likeshop.fb28.repository.ModalWindowRepository;
//
//import java.util.List;
//
//
//@RestController
//public class ModalWindowController {
//    @Autowired
//    ModalWindowRepository modalWindowRepository;
//
//
//
//    @PostMapping ("cartsM")
//    public String saveModalWindow(@RequestBody ModalWindow inf){
//        modalWindowRepository.save(inf);
//        return "save";
//    }
//
//
//}

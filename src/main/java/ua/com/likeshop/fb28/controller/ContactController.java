package ua.com.likeshop.fb28.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.likeshop.fb28.entity.Contact;
import ua.com.likeshop.fb28.repository.ContactRepository;

import java.util.List;


@RestController
public class ContactController {
    @Autowired
    ContactRepository contactRepository;



    @PostMapping ("contacts")
    public String saveContact(@RequestBody Contact mes){
        contactRepository.save(mes);
        return "save";
    }

}
package ua.com.likeshop.fb28.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.likeshop.fb28.entity.Product;
import ua.com.likeshop.fb28.repository.ProductRepisitory;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class CartController {

    public static final String CART_IDS = "cartIds";
    //    @Query(nativeQuery = true, value = "SELECT id FROM shop.product")
//    public List<TypePatternQuestions.Question> fineByID(List<Integer> ids);
    @Autowired
    ProductRepisitory productRepisitory;

//add to cart when you click buy
    @PostMapping("/cart")
    public List<Long> addToCart(@RequestParam ("id") Long id, HttpSession session){
        List<Long> cartIds = (List<Long>) session.getAttribute(CART_IDS);
        if(cartIds == null){
            cartIds = new ArrayList<>();
        }
        cartIds.add(id);
        session.setAttribute("cartIds",cartIds);
        return cartIds;
    }

    @GetMapping("/cart")
    public Iterable<Product> getCart(HttpSession session) {
        List<Long> ids = (List<Long>) session.getAttribute(CART_IDS);
        if(ids == null)
            return Collections.emptyList();//витягнути з сесії і ділити на ліст
        List<Product> result = productRepisitory.getProductsByIds(ids);
        return result;
    }


//    public static List<Long> convertation(String string) {
//        if(string == null)
//            return Collections.emptyList();
//        //    String string = "1,2,3,4,5";
//        List<Long> list = new ArrayList<>();
//        for (String retval : string.split(",")) {
//            Long c = Long.parseLong(retval);
//            list.add(c);
//        }
//        return list;
//        //  System.out.println(list);
//    }

    @DeleteMapping("/cart/{id}")
    public String deleteCart(@PathVariable ("id") Long id, HttpSession session) {
    //    session.removeAttribute(session.getId());
        List<Long> ids = (List<Long>) session.getAttribute(CART_IDS);
        if(ids == null){
            return "delete";
        }
        ids.remove(id);
        return "ok";
    }
//    public  static String conv (List<Long> longs) {
//
//        String str = new String();
//        if ( longs != null ) {
//            for (Long retval2 : longs) {
//                String s = longs.toString();
//                str.split(",");
//                str  = s;



//
//    @PutMapping("/cart/{id}")
//    public String
            }

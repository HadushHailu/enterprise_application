package app.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

    @GetMapping(value = "/shop")
    public ResponseEntity<?> getShop(){
        return new ResponseEntity<String>("Viewing shop",HttpStatus.OK);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<?> getOrders(){
        return new ResponseEntity<String>("Viewing orders",HttpStatus.OK);
    }

    @GetMapping(value = "/payments")
    public ResponseEntity<?> getPayments(){
        return new ResponseEntity<String>("Viewing payments",HttpStatus.OK);
    }
}

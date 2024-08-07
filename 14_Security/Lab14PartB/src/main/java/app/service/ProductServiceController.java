package app.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class ProductServiceController {

    @GetMapping(value = "/shop")
    public ResponseEntity<?> getShop(){
        return new ResponseEntity<String>("Viewing shop",HttpStatus.OK);
    }

    @GetMapping(value = "/orders")
//    @PreAuthorize("hasAnyRole('sales','finance', 'manager', 'topmanager')")
    public ResponseEntity<?> getOrders(){
        return new ResponseEntity<String>("Viewing orders",HttpStatus.OK);
    }

    @GetMapping(value = "/payments")
//    @PreAuthorize("hasAnyRole('finance','manager', 'topmanager')")
    public ResponseEntity<?> getPayments(){
        return new ResponseEntity<String>("Viewing payments",HttpStatus.OK);
    }

    @GetMapping(value = "/manager")
//    @PreAuthorize("hasAnyRole('manager', 'topmanager')")
    public ResponseEntity<?> getManager(){
        return new ResponseEntity<String>("Viewing manager",HttpStatus.OK);
    }

    @GetMapping(value = "/topmanager")
//    @PreAuthorize("hasAnyRole('topmanager')")
    public ResponseEntity<?> getTopManager(){
        return new ResponseEntity<String>("Viewing top manager",HttpStatus.OK);
    }

}

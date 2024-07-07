package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService implements IProductService{
    ProductDAO productDAO;
    IEmailSender emailSender;

    private String email = "user@gmail.com";

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setEmailSender(IEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addProduct(String productId, String name, double unitPrice) {
        Product product = new Product(productId, name, unitPrice);
        productDAO.save(product);
        emailSender.sendEmail(email, "Welcome " + name + " as a new product");
    }
}

package specification;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {
    public static Specification<Customer> livesInAmsterdam() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("address").get("city"), "Amsterdam");
    }
}

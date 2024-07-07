package specification;

import domain.CD;
import domain.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CDSpecification {
    public static Specification<CD> fromCDArtist(String artist) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("artist"), artist);
    }

    public static Specification<CD> fromCDPriceGreaterThan(double minPrice) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), minPrice);
    }
}

package specification;

import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecification {
    public static Specification<Order> hasStatusClosed() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("status"), "closed");
        };
    }
}

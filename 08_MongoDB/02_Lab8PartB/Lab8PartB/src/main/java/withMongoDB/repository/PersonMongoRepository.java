package withMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import withMongoDB.domain.Person;


@Repository
public interface PersonMongoRepository extends MongoRepository<Person, Long> {
}

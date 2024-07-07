package repositories;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CDRepository extends JpaRepository<CD, Long>, JpaSpecificationExecutor<CD> {
    public List<CD> findByPriceLessThan(Double price);
    public List<CD> findByArtist(@Param("artist") String artist);

    @Query("SELECT cd FROM CD cd WHERE cd.artist = :artist AND cd.price > :amount")
    public List<CD> findCDsByArtistAndPriceGreaterThan(@Param("artist") String artist, @Param("amount") double amount);

    @Query(value = "select * from product p where p.product_type='cd-type' and p.name='U2'", nativeQuery = true)
    public List<CD> findCDU2();
}

package ftn.devops.accommodation.repository;

import ftn.devops.accommodation.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Integer> {
    @Query("""
            select a from Accommodation a
            where upper(a.address) like upper(concat('%', ?1, '%')) and a.minGuestNumber <= ?2 and a.maxGuestNumber >= ?2""")
    List<Accommodation> searchAccommodations(String address, int guestNumber);

}

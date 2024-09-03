package ftn.devops.accommodation.repository;

import ftn.devops.accommodation.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability,Integer> {
    @Query("""
            select a from Availability a
            where upper(a.accommodation.address) like upper(concat('%', ?1, '%')) and a.accommodation.minGuestNumber <= ?2 and a.accommodation.maxGuestNumber >= ?2 and a.startDate < ?3 and a.endDate > ?4""")
    List<Availability> searchAvailability(String address, int guestNumber, LocalDateTime startDate,LocalDateTime endDate);


}

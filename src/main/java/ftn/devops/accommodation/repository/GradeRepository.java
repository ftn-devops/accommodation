package ftn.devops.accommodation.repository;

import ftn.devops.accommodation.entity.AccommodationGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<AccommodationGrade,Integer> {
}

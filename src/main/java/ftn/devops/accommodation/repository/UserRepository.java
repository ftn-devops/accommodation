package ftn.devops.accommodation.repository;

import ftn.devops.accommodation.entity.view.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {
}

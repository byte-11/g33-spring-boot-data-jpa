package uz.pdp.g33springbootdatajpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.g33springbootdatajpa.domain.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}

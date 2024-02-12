package pl.gduraj.schoolmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gduraj.schoolmanagement.dto.StudentDto;
import pl.gduraj.schoolmanagement.entities.User;
import pl.gduraj.schoolmanagement.enums.UserRole;

import java.util.List;
import java.util.Optional;

/**
 * @author grzeg
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);

    List<User> findAllByRole(UserRole userRole);
}

package pl.gduraj.schoolmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gduraj.schoolmanagement.entities.Fee;

/**
 * @author grzeg
 */
@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
}

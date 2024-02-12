package pl.gduraj.schoolmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gduraj.schoolmanagement.entities.StudentLeave;

/**
 * @author grzeg
 */
@Repository
public interface StudentLeaveRepository extends JpaRepository<StudentLeave, Long> {



}

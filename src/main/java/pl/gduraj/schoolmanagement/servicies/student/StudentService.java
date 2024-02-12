package pl.gduraj.schoolmanagement.servicies.student;

import pl.gduraj.schoolmanagement.dto.SingleStudentDto;
import pl.gduraj.schoolmanagement.dto.StudentLeaveDto;

/**
 * @author grzeg
 */
public interface StudentService {

    SingleStudentDto getStudentById(Long studentId);

    StudentLeaveDto applyLeave(StudentLeaveDto studentLeaveDto);
}

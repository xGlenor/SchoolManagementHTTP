package pl.gduraj.schoolmanagement.servicies.admin;

import pl.gduraj.schoolmanagement.dto.FeeDto;
import pl.gduraj.schoolmanagement.dto.SingleStudentDto;
import pl.gduraj.schoolmanagement.dto.StudentDto;

import java.util.List;

/**
 * @author grzeg
 */
public interface AdminService {
    StudentDto postStudent(StudentDto studentDto);

    List<StudentDto> getAllStudents();

    void deleteStudent(Long id);

    SingleStudentDto getStudentById(Long studentId);

    StudentDto updateStudent(Long studentId, StudentDto studentDto);

    FeeDto payFee(Long studentId, FeeDto feeDto);
}

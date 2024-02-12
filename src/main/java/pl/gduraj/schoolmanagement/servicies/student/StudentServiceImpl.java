package pl.gduraj.schoolmanagement.servicies.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gduraj.schoolmanagement.dto.SingleStudentDto;
import pl.gduraj.schoolmanagement.dto.StudentLeaveDto;
import pl.gduraj.schoolmanagement.entities.StudentLeave;
import pl.gduraj.schoolmanagement.entities.User;
import pl.gduraj.schoolmanagement.enums.StudentLeaveStatus;
import pl.gduraj.schoolmanagement.repositories.StudentLeaveRepository;
import pl.gduraj.schoolmanagement.repositories.UserRepository;

import java.util.Date;
import java.util.Optional;

/**
 * @author grzeg
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final UserRepository userRepository;

    private final StudentLeaveRepository studentLeaveRepository;

    @Override
    public SingleStudentDto getStudentById(Long studentId) {
        Optional<User> optionalUser = userRepository.findById(studentId);
        SingleStudentDto singleStudentDto = new SingleStudentDto();
        optionalUser.ifPresent(user -> singleStudentDto.setStudentDto(user.getStudentDto()));

        return singleStudentDto;
    }

    @Override
    public StudentLeaveDto applyLeave(StudentLeaveDto studentLeaveDto) {
        Optional<User> optionalUser = userRepository.findById(studentLeaveDto.getUserid());
        if(optionalUser.isPresent()){
            StudentLeave studentLeave = new StudentLeave();
            studentLeave.setSubject(studentLeaveDto.getSubject());
            studentLeave.setBody(studentLeaveDto.getBody());
            studentLeave.setDate(new Date());
            studentLeave.setStudentLeaveStatus(StudentLeaveStatus.Pending);
            studentLeave.setUser(optionalUser.get());
            StudentLeave subbmitedStudentLeave = studentLeaveRepository.save(studentLeave);

            StudentLeaveDto studentLeaveDto1 = new StudentLeaveDto();
            studentLeaveDto1.setId(subbmitedStudentLeave.getId());
            return studentLeaveDto1;
        }

        return null;
    }
}

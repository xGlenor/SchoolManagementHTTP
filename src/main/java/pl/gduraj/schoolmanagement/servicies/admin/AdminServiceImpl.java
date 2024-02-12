package pl.gduraj.schoolmanagement.servicies.admin;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gduraj.schoolmanagement.dto.FeeDto;
import pl.gduraj.schoolmanagement.dto.SingleStudentDto;
import pl.gduraj.schoolmanagement.dto.StudentDto;
import pl.gduraj.schoolmanagement.entities.Fee;
import pl.gduraj.schoolmanagement.entities.User;
import pl.gduraj.schoolmanagement.enums.UserRole;
import pl.gduraj.schoolmanagement.repositories.FeeRepository;
import pl.gduraj.schoolmanagement.repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author grzeg
 */

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final UserRepository userRepository;

    private final FeeRepository feeRepository;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if(adminAccount == null){
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
        }
    }

    @Override
    public StudentDto postStudent(StudentDto studentDto) {
        Optional<User> optionalUser = userRepository.findFirstByEmail(studentDto.getEmail());
        if(optionalUser.isEmpty()){
            User user =  new User();
            BeanUtils.copyProperties(studentDto, user);
            user.setPassword(new BCryptPasswordEncoder().encode(studentDto.getPassword()));
            user.setRole(UserRole.STUDENT);
            User createdUser = userRepository.save(user);
            StudentDto createdStudentDto = new StudentDto();
            createdStudentDto.setId(createdUser.getId());
            createdStudentDto.setEmail(createdUser.getEmail());
            return createdStudentDto;
        }
        return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return userRepository.findAllByRole(UserRole.STUDENT).stream().map(User::getStudentDto).collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Long studentId) {
        userRepository.deleteById(studentId);
    }

    @Override
    public SingleStudentDto getStudentById(Long studentId) {
        Optional<User> optionalUser = userRepository.findById(studentId);
        SingleStudentDto singleStudentDto = new SingleStudentDto();
        optionalUser.ifPresent( user -> singleStudentDto.setStudentDto(user.getStudentDto()));
        return singleStudentDto;
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Optional<User> optionalUser = userRepository.findById(studentId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            BeanUtils.copyProperties(studentDto, user);
            user.setId(studentId);
            User updatedStudent = userRepository.save(user);

            StudentDto updatedStudentDto = new StudentDto();
            updatedStudentDto.setId(updatedStudent.getId());

            return updatedStudentDto;
        }
        return null;
    }

    @Override
    public FeeDto payFee(Long studentId, FeeDto feeDto) {
        Optional<User> optionalStudent = userRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            Fee fee = new Fee();
            fee.setAmount(feeDto.getAmount());
            fee.setMonth(feeDto.getMonth());
            fee.setDescription(feeDto.getDescription());
            fee.setCreatedDate(new Date());
            fee.setGivenBy(feeDto.getGivenBy());
            fee.setUser(optionalStudent.get());

            Fee paidFee = feeRepository.save(fee);
            FeeDto paidfeeDto = new FeeDto();
            paidfeeDto.setId(paidFee.getId());
            return paidfeeDto;
        }
        return null;
    }
}

package pl.gduraj.schoolmanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gduraj.schoolmanagement.dto.SingleStudentDto;
import pl.gduraj.schoolmanagement.dto.StudentLeaveDto;
import pl.gduraj.schoolmanagement.servicies.student.StudentService;

/**
 * @author grzeg
 */

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<SingleStudentDto> getStudentById(@PathVariable Long studentId){
        SingleStudentDto singleStudentDto = studentService.getStudentById(studentId);
        if(singleStudentDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(singleStudentDto);
    }

    @PostMapping("/leave")
    public ResponseEntity<?> applyLeave(@RequestBody StudentLeaveDto studentLeaveDto){
        StudentLeaveDto subbmitedStudentLeaveDto = studentService.applyLeave(studentLeaveDto);
        if(subbmitedStudentLeaveDto == null){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(subbmitedStudentLeaveDto);
    }


}

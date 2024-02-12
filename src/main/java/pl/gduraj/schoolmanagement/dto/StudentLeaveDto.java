package pl.gduraj.schoolmanagement.dto;

import lombok.Getter;
import lombok.Setter;
import pl.gduraj.schoolmanagement.enums.StudentLeaveStatus;

import java.util.Date;

/**
 * @author grzeg
 */
@Getter
@Setter
public class StudentLeaveDto {

    private Long id;

    private String subject;

    private String body;

    private Date date;

    private StudentLeaveStatus studentLeaveStatus;

    private Long userid;
}

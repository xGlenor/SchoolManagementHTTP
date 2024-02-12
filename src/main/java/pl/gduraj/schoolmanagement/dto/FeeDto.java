package pl.gduraj.schoolmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author grzeg
 */
@Setter
@Getter
public class FeeDto {

    private Long id;

    private String month;

    private String givenBy;

    private Long amount;

    private String description;

    private Date createdDate;

    private Long studentId;

}

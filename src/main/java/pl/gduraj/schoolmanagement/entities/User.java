package pl.gduraj.schoolmanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.gduraj.schoolmanagement.dto.StudentDto;
import pl.gduraj.schoolmanagement.enums.UserRole;

import java.util.Date;

/**
 * @author grzeg
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String email;
    private String password;

    private String fatherName;
    private String motherName;
    private String studentClass;
    private Date dob;
    private String address;
    private String gender;

    private UserRole role;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StudentDto getStudentDto() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(Id);
        studentDto.setName(name);
        studentDto.setEmail(email);
        studentDto.setAddress(address);
        studentDto.setDob(dob);
        studentDto.setStudentClass(studentClass);
        studentDto.setGender(gender);
        studentDto.setFatherName(fatherName);
        studentDto.setMotherName(motherName);
        return studentDto;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", role=" + role +
                '}';
    }
}

package com.systalinkProjectManagement.systalinkProjectManagement.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class EmployeeDTO {


    private int employeeid;
    private String employeename;
    private String surname;
    private Integer cin;
    private LocalDate birthdate;
    private String diplomayear;
    private String joinyear;
    private Integer leavebalance;
    private String email;
    private String password;


    public EmployeeDTO() {
    }

    public EmployeeDTO(int employeeid, String employeename, String surname, Integer cin, LocalDate birthdate, String diplomayear, String joinyear, Integer leavebalance, String email, String password) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.surname = surname;
        this.cin = cin;
        this.birthdate = birthdate;
        this.diplomayear = diplomayear;
        this.joinyear = joinyear;
        this.leavebalance = leavebalance;
        this.email = email;
        this.password = password;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getDiplomayear() {
        return diplomayear;
    }

    public void setDiplomayear(String diplomayear) {
        this.diplomayear = diplomayear;
    }

    public String getJoinyear() {
        return joinyear;
    }

    public void setJoinyear(String joinyear) {
        this.joinyear = joinyear;
    }

    public Integer getLeavebalance() {
        return leavebalance;
    }

    public void setLeavebalance(Integer leavebalance) {
        this.leavebalance = leavebalance;
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

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", surname='" + surname + '\'' +
                ", cin=" + cin +
                ", birthdate=" + birthdate +
                ", diplomayear=" + diplomayear +
                ", joinyear=" + joinyear +
                ", leavebalance=" + leavebalance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

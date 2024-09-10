package com.systalinkProjectManagement.systalinkProjectManagement.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
    @Table(name="employee")
    public class Employee {


        @Id
        @Column(name="employee_id", length = 45)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int employeeid;

        @Column(name="employee_name", length = 255)
        private String employeename;

        @Column(name="surname", length = 255)
        private String surname;

        @Column(name="cin", length = 255)
        private Integer cin;

        @Column(name="birthdate", length = 255)
        private LocalDate birthdate;

        @Column(name="diplomayear", length = 255)
        private String diplomayear;

        @Column(name="joinyear", length = 255)
        private String joinyear;

        @Column(name="leavebalance", length = 255)
        private Integer leavebalance;

        @Column(name="email", length = 255)
        private String email;

        @Column(name="password", length = 255)
        private String password;


        public Employee() {
        }


        public Employee(int employeeid, String employeename, String surname, Integer cin, LocalDate birthdate, String diplomayear, String joinyear, Integer leavebalance, String email, String password) {
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

        //create getters and setters
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
            return "Employee{" +
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

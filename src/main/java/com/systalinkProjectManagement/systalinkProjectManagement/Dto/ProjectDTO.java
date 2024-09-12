package com.systalinkProjectManagement.systalinkProjectManagement.Dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

public class ProjectDTO {

    private int projectid;
    private String name;
    private String client;
    private String description;
    private float workload;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectid, String name, String client, String description, float workload) {
        this.projectid = projectid;
        this.name = name;
        this.client = client;
        this.description = description;
        this.workload = workload;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectid=" + projectid +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' +
                ", description='" + description + '\'' +
                ", workload=" + workload +
                '}';
    }
}














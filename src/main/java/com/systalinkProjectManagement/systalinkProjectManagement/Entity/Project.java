package com.systalinkProjectManagement.systalinkProjectManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="project")
public class Project {
    @Id
    @Column(name="project_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectid;

    @Column(name="project_name", length = 255)
    private String name;

    @Column(name="client", length = 255)
    private String client;

    @Column(name="description", length = 255)
    private String description;

    @Column(name="workload", length = 255)
    private float workload;

    public Project() {
    }

    public Project(int projectid, String name, String client, String description, float workload) {
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
        return "Project{" +
                "projectid=" + projectid +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' +
                ", description='" + description + '\'' +
                ", workload=" + workload +
                '}';
    }
}


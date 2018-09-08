package com.sp.entity;

public class User {
    private int id;
    private String name;
    private String job;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", job=" + job + "]";
    }
    public User(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }
    public User() {
        super();
    }
    
}
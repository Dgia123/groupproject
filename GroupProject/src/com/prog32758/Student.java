package com.prog32758;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{

	private String userId;
	private String studentName;
	private String gender;
	private String pic;
	private String passWord;
	private double tutorRank;
	
	
	public Student() {}
	public Student(String userId, String sn, String ge,String pic,String pw) {
		this.userId=userId;
		this.studentName=sn;
		this.gender=ge;
		this.pic=pic;
		this.passWord=pw;
		this.tutorRank=0;
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public double getTutorRank() {
		return tutorRank;
	}
	public void setTutorRank(double tutorRank) {
		this.tutorRank = tutorRank;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}


}

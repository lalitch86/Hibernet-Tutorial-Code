package com.tut;

import javax.persistence.Embeddable;

@Embeddable		//is used to embed one class fields to another class fields
public class Certificate {
private String course;
private String Duration;
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getDuration() {
	return Duration;
}
public void setDuration(String duration) {
	Duration = duration;
}
public Certificate() {
	super();
}
public Certificate(String course, String duration) {
	super();
	this.course = course;
	Duration = duration;
}



}

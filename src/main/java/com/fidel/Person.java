package com.fidel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.StringJoiner;

public class Person {
	@JsonIgnore
	private String name;
	private Integer age;
	private String eyecolor;
	private String hobby;

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getEyecolor() {
		return eyecolor;
	}

	public String getHobby() {
		return hobby;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]").add("name='" + name + "'").add("age=" + age)
				.add("eyecolor='" + eyecolor + "'").add("hobby='" + hobby + "'").toString();
	}
}

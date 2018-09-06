package com.fidel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		String jsonLn = new String (Files.readAllBytes(Paths.get("jsondata.json")), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<Person> personList = mapper.readValue(jsonLn, new TypeReference<List<Person>>(){});

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("People.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		String ColumnNamesList = buildColumnNames(personList.get(0));
		builder.append(ColumnNamesList);
		for (Person person : personList) {
			builder.append(buildRow(person));
		}
		pw.write(builder.toString());
		pw.close();
		System.out.println("done!");

	}

	private static String buildColumnNames(Person person) {
		StringBuilder columnNamesList = new StringBuilder();
		if (person.getName() != null) {
			columnNamesList.append("name,");
		}
		if (person.getAge() != null) {
			columnNamesList.append("age,");
		}
		if (person.getEyecolor() != null) {
			columnNamesList.append("eyecolor,");
		}
		if (person.getHobby() != null) {
			columnNamesList.append("hobby,");
		}
		return columnNamesList.append("\n").toString();
	}

	private static String buildRow(Person person) {
		StringBuilder row = new StringBuilder();
		if (person.getName() != null) {
			row.append(person.getName()).append(",");
		}
		if (person.getAge() != null) {
			row.append(person.getAge()).append(",");
		}
		if (person.getEyecolor() != null) {
			row.append(person.getEyecolor()).append(",");
		}
		if (person.getHobby() != null) {
			row.append(person.getHobby()).append(",");
		}
		return row.append("\n").toString();
	}

}




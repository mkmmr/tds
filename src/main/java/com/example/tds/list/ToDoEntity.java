package com.example.tds.list;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDoEntity {
	private long id;
	private String state;
	private String task;
	private String limitDate;
}

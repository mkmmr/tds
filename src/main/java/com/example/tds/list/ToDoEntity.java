package com.example.tds.list;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDoEntity {
	private long id;
	private boolean done;
	private String task;
	private String limitDate;
}

package com.example.tds.list;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ToDoForm {

	@NotBlank
	@Size(max = 256)
	private String task;

	@NotBlank
	private String limitDate;
}

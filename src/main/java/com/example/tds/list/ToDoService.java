package com.example.tds.list;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoService {

	private final ToDoRepository toDoRepository;

	public List<ToDoEntity> selectAll() {
		return toDoRepository.selectAll();
	}

	@Transactional
	public void create(String task, String limitDate) {
		toDoRepository.insert(task, limitDate);
	}

	@Transactional
	public void deleteById(long toDoId) {
		toDoRepository.deleteById(toDoId);
	}

	@Transactional
	public void update(String task, String limitDate, long toDoId) {
		toDoRepository.update(task, limitDate, toDoId);
	}

	public ToDoEntity findById(long toDoId) {
		return toDoRepository.findById(toDoId);
	}

	@Transactional
	public void switchDone(boolean done, long toDoId) {
		ToDoEntity toDoEntity = findById(toDoId);
		toDoEntity.setDone(!toDoEntity.isDone());
		toDoRepository.switchDone(toDoEntity.isDone(), toDoId);
	}

}

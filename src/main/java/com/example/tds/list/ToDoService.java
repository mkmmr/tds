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
	public void switchState(boolean state, long toDoId) {
		ToDoEntity toDoEntity = findById(toDoId);
		toDoEntity.setState(!toDoEntity.isState());
		toDoRepository.switchState(toDoEntity.isState(), toDoId);
	}

}

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
	public void create(String state, String task, String limitDate) {
		toDoRepository.insert(state, task, limitDate);
	}

	public void deleteById(Integer id) {
		toDoRepository.deleteById(id);
	}

	public void update(String state) {
		toDoRepository.update(state);
	}

}

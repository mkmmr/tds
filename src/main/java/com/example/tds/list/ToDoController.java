package com.example.tds.list;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToDoController {

	private final ToDoService toDoService;

	// GET /
	@GetMapping
	public String showList(Model model) {
//		List<ToDoEntity> toDoList = new ArrayList<ToDoEntity>();
//		ToDoEntity task1 = new ToDoEntity(1, "完了", "Springの勉強", "2018/08/22");
//		ToDoEntity task2 = new ToDoEntity(2, "未完了", "JavaScriptの勉強", "2018/08/22");
//
//		toDoList.add(task1);
//		toDoList.add(task2);

		model.addAttribute("toDoList", toDoService.selectAll());// toDoService.selectAll());
		return "list";
	}

	@GetMapping("/form/add")
	public String showAddForm(Model model) {
		model.addAttribute("addForm", new AddForm());
		return "form/add";
	}

	@PostMapping("/form/add")
	public String create(AddForm form, Model model) {
		toDoService.create("未完了", form.getTask(), form.getLimitDate());
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam Integer id) {
		toDoService.deleteById(id);
		return "redirect:/";
	}
}

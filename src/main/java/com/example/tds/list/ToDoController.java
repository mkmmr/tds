package com.example.tds.list;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("toDoList", toDoService.selectAll());// toDoService.selectAll());
		return "list";
	}

	@GetMapping("/form/addForm")
	public String showAddForm(Model model) {
		model.addAttribute("addForm", new AddForm());
		return "form/addForm";
	}

	// 要バリデーション処理
	@PostMapping("/form/add")
	public String create(AddForm form, Model model) {
		toDoService.create("未完了", form.getTask(), form.getLimitDate());
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam long toDoId) {
		toDoService.deleteById(toDoId);
		return "redirect:/";
	}

	@GetMapping("/form/editForm/{toDoId}")
	public String showEditForm(@PathVariable("toDoId") long toDoId, Model model) {
		model.addAttribute("editForm", toDoService.findById(toDoId));
		return "form/editForm";
	}

	// 要バリデーション処理
	@PostMapping("/form/editForm/{toDoId}")
	public String edit(@PathVariable("toDoId") long toDoId, EditForm form, Model model) {
		toDoService.update(form.getTask(), form.getLimitDate(), toDoId);
		model.addAttribute("editForm", toDoService.findById(toDoId));
		return "redirect:/";
	}
}

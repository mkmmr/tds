package com.example.tds.list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToDoController {

	private final ToDoService toDoService;

	@GetMapping
	public String showList(Model model) {
		model.addAttribute("toDoList", toDoService.selectAll());
		return "list";
	}

	@GetMapping("/form/add-form")
	public String showAddForm(@ModelAttribute ToDoForm form) {
		return "form/addForm";
	}

	@PostMapping("/form/add-form")
	public String create(@Validated ToDoForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return showAddForm(form);
		}
		toDoService.create(form.getTask(), form.getLimitDate());
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(long toDoId) {
		toDoService.deleteById(toDoId);
		return "redirect:/";
	}

	@GetMapping("/form/edit-form/{toDoId}")
	public String showEditForm(@PathVariable("toDoId") long toDoId, Model model) {
		model.addAttribute("editForm", toDoService.findById(toDoId));
		return "form/editForm";
	}

	@PostMapping("/form/edit-form/{toDoId}")
	public String edit(@Validated ToDoForm form, BindingResult bindingResult, @PathVariable("toDoId") long toDoId,
			Model model) {
		if (bindingResult.hasErrors()) {
			return showEditForm(toDoId, model);
		}
		toDoService.update(form.getTask(), form.getLimitDate(), toDoId);
		model.addAttribute("editForm", toDoService.findById(toDoId));
		return "redirect:/";
	}

	@PostMapping("/switch")
	public String switchDone(boolean done, long toDoId) {
		toDoService.switchDone(done, toDoId);
		return "redirect:/";
	}

}

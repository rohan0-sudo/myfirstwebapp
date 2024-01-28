package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoService todoService;
	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository=todoRepository;
	}

	@RequestMapping("list-Todo")
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedInUserName(model);
		List<Todo> todos = todoRepository.findByUserName(userName);
		model.put("todos", todos);
		return "listTodos";
	}

	

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAllTodos(ModelMap model) {
		String userName = getLoggedInUserName(model);
		Todo todo = new Todo(0, userName, "Default value", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addAllTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String userName = getLoggedInUserName(model);
		todo.setUserName(userName);
		todoRepository.save(todo);
//		todoService.addTodos(userName, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-Todo";
	}

	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-Todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String userName = getLoggedInUserName(model);
		todo.setUserName(userName);
		todoRepository.save(todo);
//		todoService.updateTodo(todo);
		return "redirect:list-Todo";
	}
	private String getLoggedInUserName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}

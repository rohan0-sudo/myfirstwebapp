package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static int todoCount = 2;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(1, "Rohan", "learnAWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "sneha", "azure", LocalDate.now().plusYears(2), false));
	}

	public List<Todo> findByUserName(String username) {
		return todos;
	}

	public void addTodos(String userName, String description, LocalDate localDate, boolean done) {
		Todo todo = new Todo(++todoCount, userName, description, localDate, done);
		todos.add(todo);

	}

	public void deleteById(int id) {

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);

	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);

	}
}

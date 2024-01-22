package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(1, "Rohan", "learnAWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "sneha", "azure", LocalDate.now().plusYears(2), false));
	}
	
	public List<Todo> findByUserName(String username){
		return todos;
	}
}

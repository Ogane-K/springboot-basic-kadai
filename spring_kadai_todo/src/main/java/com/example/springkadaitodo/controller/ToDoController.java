package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;




@Controller
public class ToDoController {
	
	private final ToDoService toDoService;
	
	ToDoController(ToDoService toDoService ){
		this.toDoService = toDoService;
		
	}
		
	@GetMapping("/todo")
	public String toDoList(Model model ) {
		
		List<ToDo> toDo = toDoService.getAllToDo();
		
		model.addAttribute("toDo", toDo);
		
		return "todoView";
	}
	
	
	
	
	
}

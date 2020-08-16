package net.grugrut.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.grugrut.todo.domain.model.Item;
import net.grugrut.todo.domain.service.RestService;

@RestController
public class ItemRestController {
	@Autowired
	@Qualifier("RestServiceImpl")
	RestService service;
	
	@GetMapping("/v1/items")
	public List<Item> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/v1/items/{id}")
	public Item get(@PathVariable("id") Integer id) {
		return service.get(id);
	}
	
	@PostMapping("/v1/items")
	public String add(@RequestBody Item item) {
		boolean result = service.add(item);
		
		String resultStr;
		
		if (result) {
			resultStr = "{\"result\":\"ok\"}";
		} else {
			resultStr = "{\"result\":\"error\"}";
		}
		
		return resultStr;
	}
	
	@PutMapping("/v1/items")
	public String update(@RequestBody Item item) {
		boolean result = service.update(item);
		
		String resultStr;
		
		if (result) {
			resultStr = "{\"result\":\"ok\"}";
		} else {
			resultStr = "{\"result\":\"error\"}";
		}
		
		return resultStr;
	}
	
	@DeleteMapping("/v1/items/{id}")
	public String delete(@PathVariable("id") Integer id) {
		boolean result = service.delete(id);
		
		String resultStr;
		
		if (result) {
			resultStr = "{\"result\":\"ok\"}";
		} else {
			resultStr = "{\"result\":\"error\"}";
		}
		
		return resultStr;
	}
}

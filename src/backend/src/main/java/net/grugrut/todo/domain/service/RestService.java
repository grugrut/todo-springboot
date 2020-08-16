package net.grugrut.todo.domain.service;

import java.util.List;

import net.grugrut.todo.domain.model.Item;

public interface RestService {
	public boolean add(Item item);
	
	public List<Item> getAll();
	
	public Item get(Integer id);
	
	public boolean update(Item item);
	
	public boolean delete(Integer id);
}

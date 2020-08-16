package net.grugrut.todo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import net.grugrut.todo.domain.model.Item;

public interface ItemDao {
	public boolean add(Item item) throws DataAccessException;
	
	public List<Item> getAll() throws DataAccessException;
}

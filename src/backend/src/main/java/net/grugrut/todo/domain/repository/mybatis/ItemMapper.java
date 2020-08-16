package net.grugrut.todo.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.grugrut.todo.domain.model.Item;

@Mapper
public interface ItemMapper {
	public boolean add(Item item);
	
	public List<Item> getAll();
	
	public Item get(Integer id);
	
	public boolean update(Item item);
	
	public boolean delete(Integer id);
}

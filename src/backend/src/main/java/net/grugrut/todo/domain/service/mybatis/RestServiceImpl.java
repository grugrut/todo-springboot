package net.grugrut.todo.domain.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.grugrut.todo.domain.model.Item;
import net.grugrut.todo.domain.repository.mybatis.ItemMapper;
import net.grugrut.todo.domain.service.RestService;

@Transactional
@Service("RestServiceImpl")
public class RestServiceImpl implements RestService {
	@Autowired
	ItemMapper itemMapper;

	@Override
	public boolean add(Item item) {
		return itemMapper.add(item);
	}

	@Override
	public List<Item> getAll() {
		return itemMapper.getAll();
	}

	@Override
	public Item get(Integer id) {
		return itemMapper.get(id);
	}

	@Override
	public boolean update(Item item) {
		return itemMapper.update(item);
	}

	@Override
	public boolean delete(Integer id) {
		return itemMapper.delete(id);
	}
}

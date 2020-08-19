package net.grugrut.todo.domain.model;

import lombok.Data;

@Data
public class Item {
	Integer id;
	String name;
	Integer status;
}

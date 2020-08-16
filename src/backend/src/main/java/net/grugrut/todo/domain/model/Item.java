package net.grugrut.todo.domain.model;

import lombok.Data;

@Data
public class Item {
	int id;
	String name;
	int status;
}

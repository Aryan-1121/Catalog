package com.order.bean;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
	@Id
	private long id;
	private String customerEmail;
	private String customerAddress;
	@OneToMany
	private List<OrderItem> items;
}

package com.ty.stockadminister.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name should not be null")
	private String name;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "Enter proper email id")
	private String email;
	@NotNull(message="Password should not be null")
	private String password;
	@NotNull(message = "Phone should not be null")
	private Long phone;
	@NotNull(message = "Company name should not be null")
	private String comapnyName;
	private String department;
	@NotNull(message = "Address should not be null")
	private String address;
	@OneToMany(mappedBy = "owner")
	private List<Staff> staffs;
	@OneToMany(mappedBy = "owner1")
	private List<Stock> stocks;
	@OneToMany(mappedBy = "owner2")
	private List<Orders> orders;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Staff> getList() {
		return staffs;
	}

	public void setList(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getComapnyName() {
		return comapnyName;
	}

	public void setComapnyName(String comapnyName) {
		this.comapnyName = comapnyName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", comapnyName=" + comapnyName + ", department=" + department + ", address=" + address + "]";
	}

	public Owner(int id, String name, String email, String password, Long phone, String comapnyName, String department,
			String address) {
		super();
		this.id = id;
		this.name = name;

		this.phone = phone;
		this.comapnyName = comapnyName;
		this.department = department;
		this.address = address;
	}

	public Owner() {
		super();
	}

}

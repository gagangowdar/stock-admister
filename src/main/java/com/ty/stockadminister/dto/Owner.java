package com.ty.stockadminister.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.stockadminister.validation.PhoneNumber;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter proper email id")
	private String email;
	@NotNull(message = "Password should not be null")
	private String password;
	@PhoneNumber
	private Long phone;
	@NotNull(message = "Company name should not be null")
	private String comapnyName;
	private String department;
	@NotNull(message = "Address should not be null")
	private String address;
	@JsonIgnore
	@OneToMany(mappedBy = "owner")
	private List<Staff> staffs;
	@JsonIgnore
	@OneToMany(mappedBy = "owner1")
	private List<Stock> stocks;
	@JsonIgnore
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

	

	

	public Owner() {
		super();
	}

	public Owner(int id, String name,
			@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter proper email id") String email,
			@NotNull(message = "Password should not be null") String password, Long phone,
			@NotNull(message = "Company name should not be null") String comapnyName, String department,
			@NotNull(message = "Address should not be null") String address, List<Staff> staffs, List<Stock> stocks,
			List<Orders> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.comapnyName = comapnyName;
		this.department = department;
		this.address = address;
		this.staffs = staffs;
		this.stocks = stocks;
		this.orders = orders;
	}

}

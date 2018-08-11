package com.capgemini.util;

public class EmployeePojo 
{
	String name,dept,city,state;
	int salary,commission;
	String phone; int pincode;
	String id;
	public EmployeePojo(String id, String name, String dept, int salary, int commission)
	{
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.salary=salary;
		this.commission=commission;
	}
	
	//removeEmpByID
	public EmployeePojo(String id) 
	{
		this.id=id;
	}
	
	//updateCommision()
	public EmployeePojo(String id, int commission) 
	{
		this.id=id;
		this.commission=commission;
	}
//	public EmployeePojo(String name, int commission) 
//	{
//		this.name=name;
//		this.commission=commission;
//	}
	
	//add new employee
	public EmployeePojo(String id, String name, String dept, int salary, int commission, String city, String state, String phone, int pincode) 
	{
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.salary=salary;
		this.commission=commission;
		this.city=city;
		this.state=state;
		this.phone=phone;
		this.pincode=pincode;
	}
	
	//updateEmployee()
	public EmployeePojo(String id, String name) 
	{
		this.name=name;
		this.id=id;
	}
	
	//update citystatephonepincode
	public EmployeePojo(String id, String city, String state, String phone, int pincode) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.city=city;
		this.state=state;
		this.phone=phone;
		this.pincode=pincode;
	}

	public String getId() 
	{
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
	public double getCommission() 
	{
		return commission;
	}
	public void setCommission(int commission) 
	{
		this.commission = commission;
	}
	public String getPhone() 
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public long getPincode() 
	{
		return pincode;
	}
	public void setPincode(int pincode)
	{
		this.pincode = pincode;
	}
	@Override
	public String toString()
	{
		return "EmpDao [id=" + id + ", name=" + name + ", dept=" + dept + ", city=" + city + ", state=" + state
				+ ", salary=" + salary + ", commission=" + commission + ", phone=" + phone + ", pincode=" + pincode
				+ "]";
	}
}
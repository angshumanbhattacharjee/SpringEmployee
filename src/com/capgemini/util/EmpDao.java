package com.capgemini.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;

import com.capgemini.util.EmployeePojo;

public class EmpDao 
{
	private Connection con;
	private Statement st;
	private ResultSet rs,rs1;
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
		try {
			con=jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//View all employees
	public void getAllEmp() throws SQLException 
	{
		st=con.createStatement();
		rs= st.executeQuery("select * from employeetable");
		
		System.out.println("ID\tName\t\tSalary\t\tCommission\tDept");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t");
			//System.out.print(rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
		}
		
		rs1= st.executeQuery("select * from addresstable");
		
		System.out.println("\n\nID\tCity\t\tState\t\tPincode");
		
		while(rs1.next())
		{
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
		}
		
		
	}
	
	//Add new employee
	public int addNewEmp(EmployeePojo e) 
	{
		String query="insert into employeetable values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"','"+e.getCommission()+"','"+e.getDept()+"','"+e.getPhone()+"')";
		String query1="insert into addresstable values('"+e.getId()+"','"+e.getCity()+"','"+e.getState()+"', '"+e.getPincode()+"' )";
		int status= jdbcTemplate.update(query);
		jdbcTemplate.update(query1);
		return status;

	}
	
	//view employees by employee id
	public void getEmpByID(EmployeePojo e) throws SQLException 
	{
		st=con.createStatement();
		rs= st.executeQuery("select eid,name,dept from employeetable where eid='"+e.getId()+"' ");
		
		System.out.println("ID\tName\t\tDept");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		

	}
	
	//get highest salary by department
	public void getHighestSalaryByDept() throws SQLException 
	{
		
			
			st=con.createStatement();
			rs= st.executeQuery("select dept, max(salary) from employeetable group by dept");
			
			System.out.println("Name\tSalary");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t "+ rs.getInt(2));
			}
	

	}
	
	//update commission
	public int updateCommission(EmployeePojo e) throws SQLException
	{
		String query="update employeetable set commission='"+e.getCommission()+"'where eid='"+e.getId()+"' ";
		return  jdbcTemplate.update(query); 
	}
	
	//remove employee by employee id
	public int removeEmpByID(EmployeePojo e) 
	{
		String query1="delete from  employeetable where eid='"+e.getId()+"' ";
		
		String query2="delete from  addresstable where eid='"+e.getId()+"' ";
		
		jdbcTemplate.update(query2);
		
		return jdbcTemplate.update(query1);
			

	}
	
	//update employee name
	public int updateEmpName(EmployeePojo e) 
	{
		String query="update employeetable set name='"+e.getName()+"'where eid='"+e.getId()+"' ";
		
		return jdbcTemplate.update(query);
	}
	
	//update city, city, state, phone, pincode
	public int updateEmpCityStatePhonePincode(EmployeePojo e) 
	{
		String query="update employeetable set phone='"+e.getPhone()+"'where eid='"+e.getId()+"' ";
		String query1="update addresstable set city='"+e.getCity()+"', state='"+e.getState()+"', pin='"+e.getPincode()+"'where eid='"+e.getId()+"' ";
		jdbcTemplate.update(query);
		return jdbcTemplate.update(query1);

	}
	
}

package DAO;

import java.sql.*;
import java.util.*;

import beans.Product_bean;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import common.DataBaseConnect;

public class ProductDAO {

	Connection con;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public ProductDAO(Connection con) {
		this.con=con;
	}
	Product_bean pb = new Product_bean();
	
	String addMsg="";
	
	public boolean insert(Product_bean pb)throws SQLException{
		System.out.println("This is ProductDAO insert() Method page");
System.out.println("id==="+pb.getId());
		
		//int id=pb.getId();
	try{
			
		String sql="insert into RashanItem(id,name,quantity,cost,brand,available,fileName)"
				+ " values(?,?,?,?,?,?,?)" ; 
		
		pstmt  = con.prepareStatement(sql);
//		//set 
		System.out.println("now1");
		pstmt.setInt(1, pb.getId());
		pstmt.setString(2,pb.getName());
		pstmt.setString(3,pb.getQuantity());
		pstmt.setFloat(4,pb.getCost());
		pstmt.setString(5,pb.getBrand());
		pstmt.setString(6,pb.getAvailable()); 
		pstmt.setString(7,pb.getFileName());
		System.out.println("now0");

		int result  = pstmt.executeUpdate();
		pstmt.close();
	   if(result ==1){
		   
		   System.out.println("now2");
		   addMsg = " Record  Added Successfuly ";
		}else{
		   addMsg = " Record  Not Added ";
		}
	   System.out.println(addMsg);
	   return true;
	}catch(Exception e){
		System.out.println("Error ");
		System.err.println(e.getMessage());
		//pstmt.close();
	}
		
		System.out.println("addMsg   "+addMsg);
		
		
		return false;
	}
	
	
	//This is use for Fetch all the value from database for ADMIN
	
		public List<Product_bean> getAll(){
			
			System.out.println(" ProductDAO.java getAll() method");
			
			List<Product_bean> li=new ArrayList<>();
				try{
					String sql="select *from RashanItem";
					
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					
					Product_bean pb=null;
					while(rs.next()){
						pb=new Product_bean();
						
						pb.setId(rs.getInt("id"));
						pb.setName(rs.getString("name"));
						pb.setQuantity(rs.getString("quantity"));
						pb.setCost(rs.getFloat("cost"));
						pb.setBrand(rs.getString("brand"));
						pb.setAvailable(rs.getString("available"));
						pb.setFileName(rs.getString("fileName"));
						System.out.println("***********");
						li.add(pb);
						System.out.println("ProductDAO.java : id**="+pb.getId());
//						System.out.println("fileName="+pb.getFileName());
					}
					
					return li;
				}catch(Exception e){
					System.out.println("Error in getAll()");
					System.err.println(e.getMessage());
				}
				
			return null;
		}

		
		
		public Product_bean getOne(int id){
			
			System.out.println(" ProductDAO.java getOne() method");
			
			List<Product_bean> li=new ArrayList<>();
				try{
					String sql="select *from RashanItem where id="+id;
					
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					
					Product_bean pb=null;
					while(rs.next()){
						pb=new Product_bean();
						  
						pb.setId(rs.getInt("id"));
						pb.setName(rs.getString("name"));
						pb.setQuantity(rs.getString("quantity"));
						pb.setCost(rs.getFloat("cost"));
						pb.setBrand(rs.getString("brand"));
						pb.setAvailable(rs.getString("available"));
						pb.setFileName(rs.getString("fileName"));
						System.out.println("***********");
						
						System.out.println("fileName="+pb.getFileName());
					}
					
					return pb;
				}catch(Exception e){
					System.out.println("Error in getOne()");
					System.err.println(e.getMessage());
				}
				
			return null;
		}
		
		
		
		public boolean delete(int id){
			System.out.println("This is ProductDAO.java / delete()method");
			System.out.println(id);
			
			
			try{
				String sql="delete from RashanItem where id="+ id;
				Statement stmt=con.createStatement();
				int status=stmt.executeUpdate(sql);
				if(status>0){
					return true;
				}
				
			}catch(Exception e){}
			
			return false;
		}
		
		
		public Product_bean updateProductForm(int id){
			
			System.out.println(" ProductDAO.java updateProductForm() method");
			
			List<Product_bean> li=new ArrayList<>();
				try{
					String sql="select *from RashanItem where id="+id;
					
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					
					Product_bean pb=null;
					while(rs.next()){
						pb=new Product_bean();
						
						pb.setId(rs.getInt("id"));
						pb.setName(rs.getString("name"));
						pb.setQuantity(rs.getString("quantity"));
						pb.setCost(rs.getFloat("cost"));
						pb.setBrand(rs.getString("brand"));
						pb.setAvailable(rs.getString("available"));
						pb.setFileName(rs.getString("fileName"));
						System.out.println("***********");
						
						System.out.println("fileName="+pb.getFileName());
					}
					
					return pb;
				}catch(Exception e){
					System.out.println("Error in updateProductForm()");
					System.err.println(e.getMessage());
				}
				
			return null;
		}
		

		public boolean updateProductInDB(Product_bean pb)throws SQLException{
			
			System.out.println("This is ProductDAO updateProductInDB() Method page");
			System.out.println("id==="+pb.getId());
			
			//int id=pb.getId();
		try{
				
			String sql="update RashanItem set name=?,quantity=?,cost=?,brand=?,available=?,fileName=? where id=?"; 
			
			
			pstmt  = con.prepareStatement(sql);
		//	//set 
			System.out.println("now1");
			pstmt.setString(1,pb.getName());
			pstmt.setString(2,pb.getQuantity());
			pstmt.setFloat(3,pb.getCost());
			pstmt.setString(4,pb.getBrand());
			pstmt.setString(5,pb.getAvailable()); 
			pstmt.setString(6,pb.getFileName());
			pstmt.setInt(7, pb.getId());
			System.out.println("now0");
		
			int result  = pstmt.executeUpdate();
			
		   if(result ==1){
			   
			   System.out.println("now2");
			   addMsg = " Record  Added Successfuly ";
			}else{
			   addMsg = " Record  Not Added ";
			}
		   System.out.println(addMsg +"before true");
		   return true;
		}catch(Exception e){
			System.out.println("Error ");
			System.err.println(e.getMessage());
			//pstmt.close();
		}
			
			System.out.println("addMsg  before false "+addMsg);
			
			
			return false;
		}
	
}

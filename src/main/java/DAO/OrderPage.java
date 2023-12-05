package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




import beans.OrderList;
import beans.Product_bean;
import common.DataBaseConnect;

public class OrderPage {

	
	Connection con;
	Statement stmt = null;
	PreparedStatement pstmt  =null;
	ResultSet rs = null;
	public OrderPage(Connection con){
		this.con=con;
		
	}
	
	String addMsg="";
	
	
	
public boolean insert(OrderList orderList)throws SQLException{
		
		int pId=orderList.getpId();
		String pName =orderList.getpName();
		String pQuantity=orderList.getpQuantity();
		String pBrand =orderList.getpBrand();
		float cost=orderList.getCost();
		String cusName=orderList.getCusName();
		String cusPhone=orderList.getCusPhone();
		String cusLocation=orderList.getCusLocation();
		
		
			System.out.println("********");
			System.out.println(pId);
			System.out.println(pName);
			System.out.println(pQuantity);
			System.out.println(pBrand);
			System.out.println(cost);
			System.out.println(cusName);
			System.out.println(cusPhone);
			System.out.println(cusLocation);
			System.out.println("********");

	try{
			
		String sql="insert into CustomerOrder(pId,pName,pQuantity,pBrand,cost,cusName,cusPhone,cusLocation)"
				+ " values(?,?,?,?,?,?,?,?)" ; 
		
		pstmt  = con.prepareStatement(sql);
//		//set 
		System.out.println("now1");
		pstmt.setInt(1,pId);
		pstmt.setString(2,pName);
		pstmt.setString(3,pQuantity);
		pstmt.setString(4,pBrand);
		pstmt.setFloat(5,cost);
		pstmt.setString(6,cusName);
		pstmt.setString(7,cusPhone);
		pstmt.setString(8,cusLocation);
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
		
		System.out.println(addMsg);
		
		
		return false;
	}
	
	
	
	public List<OrderList> getAll(){
		
		System.out.println(" OrderPage.java getAll() method");
		
		List<OrderList> li=new ArrayList<>();
			try{
				String sql="select *from CustomerOrder";
				
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				
				OrderList orderList=null;
				while(rs.next()){
					orderList=new OrderList();
					
					orderList.setpId(rs.getInt("pId"));
					orderList.setpName(rs.getString("pName"));
					orderList.setpQuantity(rs.getString("pQuantity"));
					orderList.setpBrand(rs.getString("pBrand"));
					orderList.setCost(rs.getFloat("cost"));
					orderList.setCusName(rs.getString("cusName"));
					orderList.setCusPhone(rs.getString("cusPhone"));
					orderList.setCusLocation(rs.getString("cusLocation"));
					System.out.println("***********");
					li.add(orderList);
					System.out.println("OrderPage.java : id**="+orderList.getpId());
	//				System.out.println("fileName="+pb.getFileName());
				}
				
				return li;
			}catch(Exception e){
				System.out.println("Error in getAll()");
				System.err.println(e.getMessage());
			}
			
		return null;
	}
	public List<OrderList> getAllByName(String searchName){
		
		System.out.println(" OrderPage.java getAllByName() method="+searchName);
		
		List<OrderList> li=new ArrayList<>();
		try{
			//String sql = "select * from CustomerOrder where lower(pName) like lower('%"
				//	+ searchName + "%')";
			String sql="select *from CustomerOrder where cusPhone like('%"+searchName+"%')";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			OrderList orderList=null;
			while(rs.next()){
				orderList=new OrderList();
				
				orderList.setpId(rs.getInt("pId"));
				orderList.setpName(rs.getString("pName"));
				orderList.setpQuantity(rs.getString("pQuantity"));
				orderList.setpBrand(rs.getString("pBrand"));
				orderList.setCost(rs.getFloat("cost"));
				orderList.setCusName(rs.getString("cusName"));
				orderList.setCusPhone(rs.getString("cusPhone"));
				orderList.setCusLocation(rs.getString("cusLocation"));
				System.out.println("***********");
				li.add(orderList);
				System.out.println("OrderPage getAllByName().java : id**="+orderList.getpId());
			}
			
			return li;
		}catch(Exception e){
			System.out.println("Error in getAll()");
			System.err.println(e.getMessage());
		}
		
		return null;
	}

public boolean delete(String cusPhone) {
	System.out.println(" OrderPage  delete() cusPhone="+cusPhone);
		
		boolean isDeleted = false;
		try {
			
			String sql = "delete from  CustomerOrder where cusPhone="+cusPhone;
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, cusPhone);
			System.out.println(isDeleted);

			if (pstmt.executeUpdate()>0) {
				
				System.out.println(isDeleted);
				
				isDeleted = true;
				System.out.println(isDeleted);
			}

		} catch (SQLException e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
		} 

		return isDeleted;
	}


	
}

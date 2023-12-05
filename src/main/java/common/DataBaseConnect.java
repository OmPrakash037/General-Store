package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnect {
	
	public static Connection connect() {
		System.out.println("1");
		
		 String jdbc_driver="com.mysql.jdbc.Driver";
		 String db_url="jdbc:mysql://127.0.0.1:3306/generalstore";
		 String user="root";
		 String pass="om9901";
		
		StringBuilder errorCode= new StringBuilder("");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("111111");
		try {
			System.out.println("111111");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("111111");
			
			con = DriverManager.getConnection( db_url, user , pass);
			
			System.out.println("2");
			if(con!=null) {
				System.out.println("connected....");
				return con;
			}else {
				System.out.println("Not Connected....");
			}
		}catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException Error");
			errorCode.append("<h1 style='color:red'>Driver Not Loaded...." +e.getMessage());
		}catch(SQLException e) {
			System.out.println("SQLException error.....");
		}
		return null;
	}
}

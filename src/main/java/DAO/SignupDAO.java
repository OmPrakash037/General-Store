package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Signup;

public class SignupDAO {

	Connection con;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public SignupDAO(Connection con) {
		this.con = con;
	}

	//Signup s = new Signup();

	String addMsg = "";

	public boolean insert(Signup s) throws SQLException {
		String name = s.getName();
		String contact = s.getContact();
		String email = s.getEmail();
		String password = s.getPassword();
		String userrole = s.getUserrole();
		System.out.println("Name :: "+ name+" contact :: "+contact+" email :: "+email+" password :: "+password+" userrole :: "+userrole);

		try {
			String sql = "insert into signup(name,contact,email,password,userrole)" + "values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			System.out.println("Now 0");
			pstmt.setString(1, name);
			pstmt.setString(2, contact);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, userrole);

			System.out.println("Now 1");
			int result = pstmt.executeUpdate();
			System.out.println("result is assigned:::");
			pstmt.close();
			System.out.println("patmt closed::");
			if (result == 1) {
				System.out.println("Now 2");
				addMsg = "Record Added Successfully";
			} else {
				addMsg = "Record Not Added";
			}
			System.out.println("Result " + addMsg);
			return true;
		} catch (Exception e) {
			System.out.println("SignupDAO >> error");
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection close");
				} catch (SQLException e) {
					System.out.println("DB con closing error");
				}
			}
		} // finally

		System.out.println(addMsg);
		return false;
	}

	public Signup signin(Signup s) {

		try {
			
			String sql = "select *from signup where email='" + s.getEmail() + "' AND  password='" + s.getPassword()
					+ "'";
			stmt = con.createStatement();

			rs =   stmt.executeQuery(sql);

			Signup sb = new Signup();
			while (rs.next()) {
				System.out.println(rs.getString("email") + " " + rs.getString("password"));

				System.err.println(rs.getString("email") + " " + rs.getString("password"));

				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setContact(rs.getString("contact"));
				sb.setEmail(rs.getString("email"));
				sb.setPassword(rs.getString("password"));
				sb.setUserrole(rs.getString("userrole"));

			}
			if ((s.getEmail().equals(sb.getEmail())) && (s.getPassword().equals(sb.getPassword()))) {
				return sb;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Error in signin");
			System.err.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("connection close");
				} catch (SQLException e) {
					System.out.println("DB con Closing Error");
				}
			} // if
		} // finally

		return null;
	}
	
	//This is used for Fetching all the data from database for Admin use only:-
	
	public List<Signup> getAll(){
		List<Signup> li=new ArrayList<>();
		try {
			String sql="select * from signup";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			Signup sb = null;
			while(rs.next()) {
				sb=new Signup();
				
				sb.setName(rs.getString("name"));
				sb.setId(rs.getInt("id"));
				sb.setContact(rs.getString("contact"));
				sb.setEmail(rs.getString("email"));
				sb.setUserrole(rs.getString("userrole"));
				li.add(sb);
			}
			
			return li;
		}catch(Exception e) {
			System.out.println("Error in getAll()");
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	
	//This is used for Deleting row on the basis of given id:-
	
	public boolean delete(int id ){
		try {
			String sql="delete from signup where id="+id;
			Statement stmt=con.createStatement();
			int status = stmt.executeUpdate(sql);
			if(status>0) {
				return true;
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}

}

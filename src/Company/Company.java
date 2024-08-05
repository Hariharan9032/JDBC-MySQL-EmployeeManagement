package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Company {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pQuery = "insert into employee values(?,?,?,?,?,?)";
		String fQuery = "select * from employee where eid = ?";
		String uQuery = "Update employee set salary = ? where eid = ?";
		String dQuery = "Delete from 4employee where eid = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?user=root&password=2486");
			
			while(true) {
				System.out.println("Employee Details Enter Portal");
				System.out.println("\n1.Insert Record\n2.Find\n3.Update\n4.Delete\n5.Fetch all records\n6.Exit\n");
				int option = sc.nextInt();
				switch(option) {
					case 1:{
						pstmt = con.prepareStatement(pQuery);
						System.out.println("Enter the Employee Details to Insert");
						System.out.println("Enter the Employee ID");
						pstmt.setInt(1, sc.nextInt());
						sc.nextLine();
						System.out.println("Enter the Employee Name");
						pstmt.setString(2, sc.nextLine());
						System.out.println("Enter the Employee Salary");
						pstmt.setDouble(3, sc.nextDouble());
						sc.nextLine();
						System.out.println("Enter the Employee Designation");
						pstmt.setString(4, sc.nextLine());
						System.out.println("Enter the Employee address");
						pstmt.setString(5, sc.nextLine());
						System.out.println("Enter the Mobile Number");
						pstmt.setLong(6, sc.nextLong());
						pstmt.executeUpdate();
						break;
					}
					case 2:{
						pstmt = con.prepareStatement(fQuery);
						System.out.println("Find the employee By employee ID\n Please enter Employee ID");
						pstmt.setInt(1, sc.nextInt());
						ResultSet rst = pstmt.executeQuery();
						while(rst.next()) {
							System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getDouble(3)+" "+rst.getLong(6));
						}
						break;
					}
					case 3:{
						pstmt = con.prepareStatement(uQuery);
						System.out.println("Enter the Employee Id to Update the salary");
						pstmt.setInt(2, sc.nextInt());
						System.out.println("Enter the salary Increment");
						pstmt.setDouble(1, sc.nextDouble());
						pstmt.execute();
						System.out.println("Successfully Update");
						break;
					}
					case 4:{
						pstmt = con.prepareStatement(dQuery);
						System.out.println("Enter the Employee Id to Remove");
						pstmt.setInt(1, sc.nextInt());
						pstmt.executeUpdate();
						System.out.println("Succesfully Deleted");
						break;
					}
					case 5:{
						stmt = con.createStatement();
						ResultSet rsf = stmt.executeQuery("Select * from employee");
						while(rsf.next()) {
							System.out.println(rsf.getInt(1)+" "+rsf.getString(2)+" "+rsf.getDouble(3)+" "+rsf.getLong(6));
						}
						break;
					}
					case 6:{
						System.exit(0);
					}
					default:{
						System.out.println("\nPlease Enter the Proper Option");
					}
				}
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

package project_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerAPI {
	 public Customer[] getCustomers() {
	        List<Customer> customers = new ArrayList<Customer>();
	        Customer[] customerArray = new Customer[customers.size()];
	        Connection conn = null;
	        try {
	        	conn = JdbcSqlServerConnection.connect();
	        	Statement stmt = conn.createStatement();
	            String query = "SELECT TOP 10 * FROM SalesLT.Customer";
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                Customer customer = new Customer();
	                customer.setFirstName(rs.getString("FirstName"));
	                customer.setLastName(rs.getString("LastName"));
	                customer.setCompanyName(rs.getString("CompanyName"));
	                customers.add(customer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        Customer[] cusArr = customers.toArray(customerArray);
	        return cusArr;
	    }
	 
//	 public static void main(String[] args) {
//		CustomerAPI cus = new CustomerAPI();
//		cus.getCustomers();
//	}
}

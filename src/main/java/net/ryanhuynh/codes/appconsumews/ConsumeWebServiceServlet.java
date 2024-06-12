package net.ryanhuynh.codes.appconsumews;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/consume-webservice")
public class ConsumeWebServiceServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerAPIService service = new CustomerAPIService();
		CustomerAPI port = service.getCustomerAPI();
		List<Customer> customers = port.getCustomers();
		
		// Add attributes to the request
		request.setAttribute("customers", customers);
        // Get the RequestDispatcher to forward the request
        RequestDispatcher dispatcher = request.getRequestDispatcher("/display-names.jsp");
        // Forward the request to the target servlet
        dispatcher.forward(request, response);
	}
}

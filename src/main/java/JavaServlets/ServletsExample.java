package JavaServlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletsExample
 */
public class ServletsExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletsExample() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();                                                
		pw.println("<h1>INSERTED Successfully!!</h1>");
		
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Email = request.getParameter("Email");
		String Phone =request.getParameter("Phone");
		
		TestServlets TS = new TestServlets();
		
		TS.setFirstName(FirstName);
		TS.setLastName(LastName);
		TS.setEmail(Email);
		TS.setPhone(Phone);
		
		try {
			ServletsJDBCConnection.insert(TS);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 
//		PrintWriter pw =response.getWriter();
//		String a= request.getParameter("FirstName");	
//		String b= request.getParameter("LastName");
//		String c= request.getParameter("Email");
//   	Long d= request.getParameter("Phone");                                                 
//		pw.println("<h1>FirstName:"+a);
//		pw.println("<h1>LastName:"+a);
//		pw.println("<h1>Email:"+b);
//		pw.println("<h1>Phone:"+c);
//		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

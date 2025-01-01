

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String[]> al = new ArrayList<String[]>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "bhanuteja");
			PreparedStatement ps = ct.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery("select * from emp");
			while(rs.next()) {
				String[] st = new String[2];
				String a = rs.getString("name");
				String b = rs.getString("salary");
				st[0]=a;
				st[1]=b;
				al.add(st);
				
			}
			request.setAttribute("emp", al);
			RequestDispatcher dp = request.getRequestDispatcher("view.jsp");
			dp.forward(request, response);
		}catch(Exception e) {
			
		}
	}

}

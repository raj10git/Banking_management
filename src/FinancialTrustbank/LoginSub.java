package FinancialTrustbank;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSub
 */
@WebServlet("/LoginSub")
public class LoginSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@INTVMORADB04:1521/xe","FY2021_537645_BATCH2","tcstvmbatch2");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:FY2021_537645_BATCH2/tcstvmbatch2@INTVMORADB04:1521:ORAJAVADB");

			PrintWriter out=response.getWriter();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from EMPLOYEE");
			while (rs.next())
			{
				if(uname.equals(rs.getString(1)) && pass.equals(rs.getString(2)))
					{
						out.println("Login Successful");
						response.sendRedirect("member.jsp");
						break;
					}
				else
					{
						response.sendRedirect("error.jsp");
						break;
					}
			}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
		}
	}
}

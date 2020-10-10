package FinancialTrustbank;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountDetails
 */
@WebServlet("/AccountDetails")
public class AccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String cid = request.getParameter("custid");
				String aid = request.getParameter("accid");
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:FY2021_537645_BATCH2/tcstvmbatch2@INTVMORADB04:1521:ORAJAVADB");

					Statement st=con.createStatement();
					
					String query = "SELECT CUSTOMER_ID, ACCOUNT_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE FROM ACCDETAILS WHERE CUSTOMER_ID = '"+cid+"' AND ACCOUNT_ID = '"+aid+"'";
					ResultSet rs=st.executeQuery(query);
					
					if(rs.next())
					{
						String cust = rs.getString("CUSTOMER_ID");
						String acc = rs.getString("ACCOUNT_ID");
						String type = rs.getString("ACCOUNT_TYPE");
						String bal = rs.getString("ACCOUNT_BALANCE");
						
						request.setAttribute("CUSTOMER_ID", cust);
						request.setAttribute("ACCOUNT_ID", acc);
						request.setAttribute("ACCOUNT_TYPE", type);
						request.setAttribute("ACCOUNT_BALANCE", bal);
						
						RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
						rd.forward(request, response);
					}
				}
				catch (Exception e)
				{
					 e.printStackTrace();
				}
	}

}

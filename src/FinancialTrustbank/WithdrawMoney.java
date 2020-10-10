package FinancialTrustbank;


import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class WithdrawMoney
 */
@WebServlet("/WithdrawMoney")
public class WithdrawMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawMoney() {
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
		int amt = Integer.parseInt(request.getParameter("amt"));
		
		PrintWriter out = response.getWriter();
		Connection con = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:FY2021_537645_BATCH2/tcstvmbatch2@INTVMORADB04:1521:ORAJAVADB");
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			
			String qu = "SELECT ACCOUNT_BALANCE FROM ACCDETAILS WHERE CUSTOMER_ID = '"+cid+"' AND ACCOUNT_ID = '"+aid+"'";
			ResultSet rs1=st.executeQuery(qu);
			
			int cb=0;
			if(rs1.next())
			{
				cb = rs1.getInt("ACCOUNT_BALANCE");
			}
			if(cb<amt)
			{
				out.println("NOT ENOUGH BALANCE");
			}
			else
			{	
				String query = "UPDATE ACCDETAILS SET ACCOUNT_BALANCE=ACCOUNT_BALANCE-'"+amt+"' WHERE CUSTOMER_ID='"+cid+"' AND ACCOUNT_ID='"+aid+"'";
				st.executeUpdate(query);
			
			String query1 = "SELECT CUSTOMER_ID, ACCOUNT_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE FROM ACCDETAILS WHERE CUSTOMER_ID = '"+cid+"' AND ACCOUNT_ID = '"+aid+"'";
			ResultSet rs=st.executeQuery(query1);
			con.commit();
			
			if(rs.next())
			{
				String cust = rs.getString("CUSTOMER_ID");
				String acc = rs.getString("ACCOUNT_ID");
				String type = rs.getString("ACCOUNT_TYPE");
				int bal = rs.getInt("ACCOUNT_BALANCE");
				int fin = bal+amt;
				
				request.setAttribute("CUSTOMER_ID", cust);
				request.setAttribute("ACCOUNT_ID", acc);
				request.setAttribute("ACCOUNT_TYPE", type);
				request.setAttribute("ACCOUNT_BALANCE", bal);
				request.setAttribute("dep", fin);
				
				RequestDispatcher rd = request.getRequestDispatcher("/withdrawn.jsp");
				rd.forward(request, response);
			}
			out.println("Transaction success!!");
			}
		}
		catch (Exception e)
		{
			 try{
				 con.rollback();
				 e.printStackTrace();
				 out.println("Transaction Failure!!");
			 }
			 catch(Exception e1)
			 {
				 e1.printStackTrace();
			 }
		}
	}
}


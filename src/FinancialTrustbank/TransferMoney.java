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
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("custid");
		String stype = request.getParameter("sacctype");
		String rtype = request.getParameter("racctype");
		int amt = Integer.parseInt(request.getParameter("amt"));
		
		PrintWriter out = response.getWriter();
		Connection con = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:FY2021_537645_BATCH2/tcstvmbatch2@INTVMORADB04:1521:ORAJAVADB");
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			
			String qu = "SELECT ACCOUNT_BALANCE FROM ACCDETAILS WHERE CUSTOMER_ID = '"+cid+"' AND ACCOUNT_TYPE = '"+stype+"'";
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
			String query = "UPDATE ACCDETAILS SET ACCOUNT_BALANCE=ACCOUNT_BALANCE-'"+amt+"' WHERE CUSTOMER_ID='"+cid+"' AND ACCOUNT_TYPE='"+stype+"'";
			String query1 = "UPDATE ACCDETAILS SET ACCOUNT_BALANCE=ACCOUNT_BALANCE+'"+amt+"' WHERE CUSTOMER_ID='"+cid+"' AND ACCOUNT_TYPE='"+rtype+"'";

			st.executeUpdate(query);
			st.executeUpdate(query1);
			
			String query2 = "SELECT CUSTOMER_ID, ACCOUNT_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE FROM ACCDETAILS WHERE CUSTOMER_ID = '"+cid+"' AND ACCOUNT_TYPE = '"+stype+"'";
			String query3= "SELECT ACCOUNT_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE FROM ACCDETAILS WHERE CUSTOMER_ID = '"+cid+"' AND ACCOUNT_TYPE = '"+rtype+"'";
			ResultSet rs=st.executeQuery(query2);
			ResultSet rrs=st.executeQuery(query3);
			
			con.commit();
			
			if(rs.next())
			{
				String cust = rs.getString("CUSTOMER_ID");
				String acc = rs.getString("ACCOUNT_ID");
				String type = rs.getString("ACCOUNT_TYPE");
				int bal = rs.getInt("ACCOUNT_BALANCE");
				int sfin = bal+amt;
				
				String accr = rrs.getString("ACCOUNT_ID");
				String typer = rrs.getString("ACCOUNT_TYPE");
				int balr = rrs.getInt("ACCOUNT_BALANCE");
				int rfin = balr-amt;
				
				request.setAttribute("CUSTOMER_ID", cust);
				request.setAttribute("SACCOUNT_ID", acc);
				request.setAttribute("SACCOUNT_TYPE", type);
				request.setAttribute("SACCOUNT_BALANCE", bal);
				request.setAttribute("with", sfin);
				
				request.setAttribute("RACCOUNT_ID", accr);
				request.setAttribute("RACCOUNT_TYPE", typer);
				request.setAttribute("RACCOUNT_BALANCE", balr);
				request.setAttribute("dep", rfin);
				
				RequestDispatcher rd = request.getRequestDispatcher("/transfered.jsp");
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

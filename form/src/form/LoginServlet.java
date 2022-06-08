package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_pass");
        request.setAttribute("name", email);
        PrintWriter out = response.getWriter();
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "select password from user_details where email=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, email);
            ResultSet set = pstmt.executeQuery();
            String db_pass = "";
            while (set.next()) {
//				int id=set.getInt(1);
                db_pass = set.getString(1);
            }
            con.close();
            if (db_pass.equals(password)) {
                RequestDispatcher rd = request.getRequestDispatcher("success");
                rd.forward(request, response);
            } else if (db_pass.equals("")) {
                out.print("You Don't Have an account created..");
                out.print("Create an account..");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);

            } else {
                response.getWriter().print("The password is wrong");
                response.getWriter().print("Re Enter the Details");
                RequestDispatcher rd = request.getRequestDispatcher("Login.html");
                rd.forward(request, response);
//				out.print("You Don't Have an account created..");
//				out.print("Create an account..");
//				RequestDispatcher rd=request.getRequestDispatcher("index.html");
//				rd.forward(request, response);

            }

        } catch (Exception e) {
            out.print("You Don't Have an account created..");
            out.print("Create an account..");
            RequestDispatcher rd = request.getRequestDispatcher("register");
            rd.include(request, response);


        }
    }


}

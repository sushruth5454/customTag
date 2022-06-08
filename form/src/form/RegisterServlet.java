package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        out.print("<h2>Welcome to Register Servlet</h2>");
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_pass");
        String email = request.getParameter("user_email");
        String gender = request.getParameter("user_gender");
        String language = request.getParameter("user_language");
        String condition = request.getParameter("condition");
//        request.setAttribute("name", name);


        Cookie c = new Cookie("name", name);
        response.addCookie(c);
        if (condition != null && condition.equals("checked")) {
//        out.print(name + " " + password + " " + email + " " + gender + " " + language);
            try {
                System.out.println("In Loop>...");
                Connection con = ConnectionProvider.getConnection();
                String q = "insert into user_details(user_name,password,email,gender,language) values(?,?,?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1, name);
                pstmt.setNString(2, password);
                pstmt.setString(3, email);
                pstmt.setString(4, gender);
                pstmt.setString(5, language);
                pstmt.executeUpdate();
                System.out.println("Inserted...");
                out.print("you have succesfully created your account...");
                RequestDispatcher rd = request.getRequestDispatcher("success");
                rd.forward(request, response);
//        con.close();
            } catch (Exception e) {
                out.print("you are already registered..");

            }
//        con.close();

        } else {
            out.print("Accept the terms and conditions");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
    }

}

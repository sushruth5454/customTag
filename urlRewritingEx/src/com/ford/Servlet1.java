package com.ford;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Servlet1() {
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
        // TODO Auto-generated method stub
        String name = request.getParameter("user_name");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h1 style='background:black; color:white;'>Welcome  " + name + " to servlet 1</h1");

//		Using url rewriting

        /*
         * out.println("<a href='servlet2?user="+name+"'>Go to Second Servlet</a>");
         * out.println("<a href='servlet2?user="+name+"'>Go</a>");
         */

//		using state management  hidden field
        out.println("<form action=\"servlet2\" method=\"post\">");
        out.println("<input type='text' name='user' value='" + name + "'/>"
                + "<button type='submit'>GO</button>"
                + ""
                + "");

        out.println("</form>");


        out.println("</body>");

        out.println("</html>");

    }

}


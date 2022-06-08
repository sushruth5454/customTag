package com.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javax.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")


//to understand JVM that this servlet handles parts like image ,audio.video ..
@MultipartConfig
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_pass");
        String email = request.getParameter("user_email");
        Part part = request.getPart("image");
        String fileName = part.getSubmittedFileName();
        out.println(fileName);


        try {
            Thread.sleep(3000);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sushdb", "root", "Tada@5454");
            String q = "insert into users(name,password,email,imageName) values(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, fileName);
            pstmt.executeUpdate();

//			Upload images in to server's img folder
            InputStream is = part.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            String path = request.getRealPath("/") + "img" + File.separator + fileName;
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data);
            fos.close();


            out.print("Registered..");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

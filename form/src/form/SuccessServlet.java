package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		String name=(String) req.getAttribute("name");
        Cookie[] cookies = req.getCookies();
        String name = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("name")) {
                    name = new String(c.getValue());
                }
            }
            PrintWriter out = res.getWriter();
            out.print("Welcome " + name + " to the Home Page ");
        } else {
            PrintWriter out = res.getWriter();
            out.print("Your new to this page");
        }
    }

}

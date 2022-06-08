package test1;

import javax.servlet.*;

public class FirstServlet implements Servlet {
    //	Life Cycle Methods
    ServletConfig conf;

    public void init(ServletConfig conf) {
        this.conf = conf;
        System.out.println("Servlet Created...");
    }

    public void service(ServletRequest req, ServletResponse res) {
        System.out.println("Servicing.......");
    }

    public void destroy() {
        System.out.println("going to destroy the servlet object...");
    }

    //	Non life cycle methods
    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return this.conf;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return "This servlet is created by sushruth..";
    }


}

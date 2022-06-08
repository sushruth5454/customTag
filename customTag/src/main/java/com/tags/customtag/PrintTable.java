package com.tags.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.swing.text.html.HTML;

public class PrintTable extends TagSupport {
    public int number;
    public String colour;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            //print table;
            out.println("<div style='color:"+colour+"'");
            out.print("<br>");
            for (int i = 0; i <= 10; i++) {
                out.println((i * number)+"<br>");
            }
            out.println("</div>");
        }catch (Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}

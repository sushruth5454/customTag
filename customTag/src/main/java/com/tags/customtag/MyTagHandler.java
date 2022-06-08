package com.tags.customtag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{
    @Override
    public int doStartTag() throws JspException {
        try{
            JspWriter out= pageContext.getOut();
            out.println("Hello This is my custom Tag");

        }catch (Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}

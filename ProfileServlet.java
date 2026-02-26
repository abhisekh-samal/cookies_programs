package servlettutorials.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/html");
        String name= req.getParameter("username");
        PrintWriter out = res.getWriter();

        int count = 1;   // default for first visit

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        Cookie counter = new Cookie("count", String.valueOf(count));
        counter.setPath("/");
        res.addCookie(counter);

        out.println(name+"You have visited this page " + count + " times");
    }
}
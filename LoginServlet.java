package servlettutorials.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");

        Cookie c = new Cookie("username", name);
//        c.setMaxAge(60 * 60); // 1 hour
        res.addCookie(c);

        out.println("<h2>Login Successful</h2>");
        out.println("<a href='profile'>Go to Profile</a>");
    }
}
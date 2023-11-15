package lab05.java_technology.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer statusCode = (Integer) req.getAttribute("jakarta.servlet.error.status_code");
        String errorMsg = (String) req.getAttribute("jakarta.servlet.error.message");
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Error " + statusCode + "</h1>");
        resp.getWriter().println("<p>" + errorMsg + "</p>");
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}

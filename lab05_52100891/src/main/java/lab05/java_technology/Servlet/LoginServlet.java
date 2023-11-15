package lab05.java_technology.Servlet;


import lab05.java_technology.Repository.UserDAO;
import lab05.java_technology.domain.User;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Deleting Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String isRemember = req.getParameter("rememberPassword");
        try {
            User user = this.userDAO.findByName(username);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println(username + " logged in successfully");
                HttpSession session = req.getSession();
                session.setAttribute("userId", user.getId());
                session.setAttribute("username", user.getName());
            }
            if (isRemember != null) {
                Cookie userId = new Cookie("userId", String.valueOf(user.getId()));
                userId.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(userId);
            }
            resp.sendRedirect(req.getContextPath() + '/');
        } catch (Exception e) {
            System.out.println(username + " failed to log in");
            System.out.println(e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/register");
        }
    }
}

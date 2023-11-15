package lab05.java_technology.Servlet;


import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lab05.java_technology.Repository.UserDAO;
import lab05.java_technology.domain.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        try {
            User user = this.userDAO.findByName(username);
            JsonObject jsonObject = new JsonObject();
            PrintWriter out = resp.getWriter();

            if (user != null) {

            } else {
                User newUser = new User(username, email, password);
                userDAO.add(newUser);
                HttpSession session = req.getSession();
                session.setAttribute("userId", newUser.getId());
                session.setAttribute("username", newUser.getName());
                jsonObject.addProperty("success", true);
                resp.setContentType("application/json");
                out.print(jsonObject);
                out.flush();
            }

        } catch (Exception e) {
            System.out.println("Failed to register");
        }
    }
}

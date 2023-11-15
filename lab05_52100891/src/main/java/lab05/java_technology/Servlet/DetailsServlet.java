package lab05.java_technology.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab05.java_technology.Repository.ProductDAO;
import lab05.java_technology.domain.Product;

import java.io.IOException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    private ProductDAO productDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Product product = productDAO.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/jsp/details.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }
}

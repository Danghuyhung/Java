package lab05.java_technology.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lab05.java_technology.Repository.ProductDAO;
import lab05.java_technology.domain.Product;
import lab05.java_technology.utils.FlashMessage;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
    }

    public void refreshPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getRequestURI());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        productDAO.add(new Product(name, price));
        FlashMessage flashMessage = new FlashMessage("Added product", "success");
        req.getSession().setAttribute("flashMessage", flashMessage);
        this.refreshPage(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.remove(id);
        FlashMessage flashMessage = new FlashMessage("Deleted product", "success");
        req.getSession().setAttribute("flashMessage", flashMessage);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/plain");
        resp.getWriter().write("Delete operation successful");
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

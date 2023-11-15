package lab05.java_technology.Repository;

import lab05.java_technology.domain.Product;
import lab05.java_technology.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO implements Repository<Product, Integer> {
    private static final Session session;

    static {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public ProductDAO() {
        this.add(new Product(1, "Iphone", 999));
    }

    @Override
    public boolean add(Product item) {
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();

        return true;
    }

    @Override
    public Product findByName(String productName) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product where name = :name");
            query.setParameter("name", productName);
            Product product = (Product) query.getSingleResult();
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(Integer id) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product where id = :id");
            query.setParameter("id", id);
            Product product = (Product) query.getSingleResult();
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product");
            List<Product> products = query.getResultList();
            session.getTransaction().commit();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Product where id like :id");
            query.setParameter("id", id);
            Product user = (Product) query.getSingleResult();
            System.out.println(user);
            session.remove(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product item) {
        try {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

package lab05.java_technology.Repository;

import lab05.java_technology.domain.User;
import lab05.java_technology.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements Repository<User, Integer> {
    private static final Session session;

    static {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public UserDAO() {
        this.add(new User(1, "admin", "admin@email.com", "admin123"));
    }

    @Override
    public boolean add(User item) {
        session.beginTransaction();
        User isExistUser = session.get(User.class, item.getId());
        if (isExistUser == null) {
            session.save(item);
        }
        session.getTransaction().commit();
        return true;
    }

    @Override
    public User findByName(String username) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from User where name = :name");
            query.setParameter("name", username);
            User user = (User) query.uniqueResult();
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from User where id = :id");
            query.setParameter("id", id);
            User user = (User) query.getSingleResult();
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from User");
            List<User> users = query.getResultList();
            session.getTransaction().commit();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("from User where id like :id");
            query.setParameter("id", id);
            User user = (User) query.getSingleResult();
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
    public boolean update(User item) {
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

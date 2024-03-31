package hiber.dao;

import hiber.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user.getCar());
        session.save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCarModelSeries(String model, int series) {
        String hql = "FROM User u WHERE u.car.model=:model and u.car.series=:series";

        return sessionFactory.getCurrentSession()
                .createQuery(hql, User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .uniqueResult();
    }
}

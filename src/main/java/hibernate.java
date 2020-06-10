import function.TimeTest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hibernate {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(TimeTest.class);;
        cr.add(Restrictions.eq("",""));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(2020, 2, 22);
        java.sql.Date date1 = new java.sql.Date(new Date().getTime());
        System.out.println(date1.getHours());

    }
}

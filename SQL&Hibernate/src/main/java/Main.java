import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.sql.SQLException;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

  public static void main(String[] args) throws SQLException {

    StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
    Session session=sessionFactory.openSession();
    session.beginTransaction();
    session.createNativeQuery("INSERT INTO ******.linkedpurchaselist (student_id, course_id)"
        + " SELECT s.id student, co.id FROM *******.purchaselist p\n"
        + "left join *******.students s on  s.name=p.student_name\n"
        + "join ********.courses co on co.name =p.course_name", LinkedPurchaseList.class).executeUpdate();

    session.getTransaction().commit();
    sessionFactory.close();

  }


}

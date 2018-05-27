package banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.internal.EntityManagerImpl;

public class Fabrica {

    private static Fabrica fabrica;
    private EntityManager entityManager;

    public Fabrica() {
        entityManager = Persistence.createEntityManagerFactory("ProjetoDPWebPU").createEntityManager();
    }

    public synchronized static Fabrica getFabrica() {
        if (fabrica == null) {
            fabrica = new Fabrica();
        }
        return fabrica;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Connection getConnection() {
        EntityManagerImpl entityManagerImpl = (EntityManagerImpl) entityManager;
        SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) entityManagerImpl.getSession().getSessionFactory();
        try {
            return sessionFactoryImpl.getConnectionProvider().getConnection();
        } catch (SQLException exception) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }
}

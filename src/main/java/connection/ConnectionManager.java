package connection;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {

    private static Logger log = Logger.getLogger(ConnectionManager.class);
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("hibernateUnit");
        log.debug("EntityManagerFactory was opened");
    }

    private ConnectionManager() { }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        log.debug("EntityManagerFactory was closed");
        emf.close();
    }
}

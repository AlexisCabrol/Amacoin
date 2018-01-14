
package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import models.DAO;

/**
 *
 * @author Alexis
 */
public class InitialisationDAO implements ServletContextListener {
    private static final String ATTRIBUT_DAO = "dao";
    private DAO dao;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // on récup le ServletContext lors du chargement de l'application
        ServletContext servletContext = event.getServletContext();
        // puis on instancie le DAO
        this.dao = DAO.getInstance();
        // enfin on enregistre dans un attribut ayant pour portée toute l'application
        servletContext.setAttribute(ATTRIBUT_DAO, this.dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // on n'implemente pas cette méthode car il n'y a rien a réaliser lors de la fermeture de l'application
    }
    
}

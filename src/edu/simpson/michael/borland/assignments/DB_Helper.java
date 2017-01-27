package edu.simpson.michael.borland.assignments;
import javax.naming.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 * Created by micha on 1/25/2017.
 */
public class DB_Helper {
    private final static Logger log = Logger.getLogger(DB_Helper.class.getName());

    public static Connection getConnection() {

        try {
            log.log(Level.SEVERE, "Getting a database connection");
            System.out.print("Test");
            // Create a context. Uses context.xml
            Context initContext = new InitialContext();

            // Select which context to lookup.
            Context envContext = (Context) initContext.lookup("java:/comp/env");

            // Grab a source of database connection. Note how this matches the name
            // field in context.xml.
            DataSource ds = (DataSource) envContext.lookup("jdbc/cis320");

            // Hey, now we've got a datasource for connections. Let's get a connection.
            Connection conn = ds.getConnection();

            return conn;
        }
        catch(Exception e) {
            // Whoops, something bad happened. Log it.
            log.log(Level.SEVERE, "Unable to get a database connection.", e);
            return null;
        }
    }
}




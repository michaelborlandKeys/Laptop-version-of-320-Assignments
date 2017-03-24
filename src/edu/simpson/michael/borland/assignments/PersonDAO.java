package edu.simpson.michael.borland.assignments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by micha on 1/26/2017.
 */
public class PersonDAO {
    public static List<Person> getPeople() {
         final Logger log = Logger.getLogger(DB_Helper.class.getName());
        log.log(Level.FINE, "Get people");

        // Create an empty linked list to put the people we get from the database into.
        List<Person> list = new LinkedList<Person>();

        // Declare our variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // Databases are unreliable. Use some exception handling
        try {
            // Get our database connection
            conn = DB_Helper.getConnection();

            // This is a string that is our SQL query.
            String sql = "select id, first, last,email,phone,birthday from person";

            // If you had parameters, it would look something like
            // String sql = "select id, first, last, phone from person where id = ?";

            // Create an object with all the info about our SQL statement to run.
            stmt = conn.prepareStatement(sql);



            // If you had parameters, they would be set wit something like:
            // stmt.setString(1, "1");

            // Execute the SQL and get the results
            rs = stmt.executeQuery();
            // Loop through each record
            while(rs.next()) {
                // Create a new instance of the Person object.
                // You'll need to define that somewhere. Just a simple class with getters and setters on the
                // fields.
                Person person = new Person();

                // Get the data from the result set, and copy it to the Person object
                person.setId(rs.getInt("id"));
                person.setFirst(rs.getString("first"));
                person.setLast(rs.getString("last"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));
                person.setBirthday(rs.getString("birthday"));

                list.add(person);

                // Add this person to the list so we can return it. list.add(person);
            }
        } catch (SQLException se) {
            log.log(Level.SEVERE, "SQL Error", se );
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error", e );
        } finally {
            // Ok, close our result set, statement, and connection
            try { rs.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
            try { stmt.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
            try { conn.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
        }
        // Done! Return the results
        return list;
    }
    public static void addPeople(Person person) {
        final Logger log = Logger.getLogger(DB_Helper.class.getName());
        log.log(Level.FINE, "Get people");

        Connection conn = null;
        PreparedStatement stmt = null;


        // Databases are unreliable. Use some exception handling
        try {
            // Get our database connection
            conn = DB_Helper.getConnection();

            // This is a string that is our SQL query.
           String sql= " INSERT INTO person (first,last,email,phone,birthday) VALUES (?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,person.getFirst());
            stmt.setString(2,person.getLast());
            stmt.setString(3,person.getEmail());
            stmt.setString(4,person.getPhone());
            stmt.setString(5,person.getBirthday());


            stmt.executeUpdate();
            // If you had parameters, it would look something like
            // String sql = "select id, first, last, phone from person where id = ?";

            // Create an object with all the info about our SQL statement to run.



                // Add this person to the list so we can return it. list.add(person);

        } catch (SQLException se) {
            log.log(Level.SEVERE, "SQL Error", se );
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error", e );
        } finally {
            // Ok, close our result set, statement, and connection

            try { stmt.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
            try { conn.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
        }
        // Done! Return the results
    }
    public static void deletePeople(String id) {
        final Logger log = Logger.getLogger(DB_Helper.class.getName());
        log.log(Level.FINE, "Get people");

        Connection conn = null;
        PreparedStatement stmt = null;


        // Databases are unreliable. Use some exception handling
        try {
            // Get our database connection
            conn = DB_Helper.getConnection();

            // This is a string that is our SQL query.
     String sql = "DELETE FROM person WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);

            stmt.executeUpdate();
            // If you had parameters, it would look something like
            // String sql = "select id, first, last, phone from person where id = ?";

            // Create an object with all the info about our SQL statement to run.



            // Add this person to the list so we can return it. list.add(person);

        } catch (SQLException se) {
            log.log(Level.SEVERE, "SQL Error", se );
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error", e );
        } finally {
            // Ok, close our result set, statement, and connection

            try { stmt.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
            try { conn.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
        }
        // Done! Return the results



    }

    public static void editPeople(Person person) {
        final Logger log = Logger.getLogger(DB_Helper.class.getName());
        log.log(Level.FINE, "Get people");

        Connection conn = null;
        PreparedStatement stmt = null;


        // Databases are unreliable. Use some exception handling
        try {
            // Get our database connection
            conn = DB_Helper.getConnection();

            // This is a string that is our SQL query.
            String sql= " UPDATE person SET first=?,last=?,email=?,phone=?,birthday=? WHERE id=?";
            stmt = conn.prepareStatement(sql);
            log.log(Level.SEVERE, "Is it getting here ");
            log.log(Level.SEVERE, person.getFirst());

            stmt.setString(1,person.getFirst());
            stmt.setString(2,person.getLast());
            stmt.setString(3,person.getEmail());
            stmt.setString(4,person.getPhone());
            stmt.setString(5,person.getBirthday());
            stmt.setString(6,Integer.toString(person.getId()));

            stmt.executeUpdate();
            // If you had parameters, it would look something like
            // String sql = "select id, first, last, phone from person where id = ?";

            // Create an object with all the info about our SQL statement to run.



            // Add this person to the list so we can return it. list.add(person);

        } catch (SQLException se) {
            log.log(Level.SEVERE, "SQL Error", se );
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error", e );
        } finally {
            // Ok, close our result set, statement, and connection

            try { stmt.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
            try { conn.close(); } catch (Exception e) { log.log(Level.SEVERE, "Error", e ); }
        }
        // Done! Return the results
    }

}
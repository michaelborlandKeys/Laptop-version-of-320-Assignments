package edu.simpson.michael.borland.assignments;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by micha on 2/14/2017.
 */
@WebServlet(name = "NameListEdit")
public class NameListEdit extends HttpServlet {
    final Logger log = Logger.getLogger(NameListEdit.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
      //  List <Person> peopleList = PersonDAO.getPeople();


        java.io.BufferedReader in = request.getReader();
        String requestString = new String();
        for (String line; (line = in.readLine()) != null; requestString += line);
        // Grab the data we got via a parameter
        // programmed the old way without realizing it.
       // Output the string we got as a request, just as a check

        Gson gson = new Gson();
        Person fromJson = gson.fromJson(requestString, Person.class);
          PersonDAO.addPeople(fromJson);

log.log(Level.SEVERE, "Didn't get to printing out any data.");

        // Make sure our field was set.
        // out.println(" First Name: "+fromJson.getId());

        out.println(" First Name: "+fromJson.getFirst());
        out.println(" Last Name: "+fromJson.getLast());
        out.println(" Email: "+fromJson.getEmail());
        out.println(" Phone: "+fromJson.getPhone());
        out.println(" Birthday: "+fromJson.getBirthday());


        // Print that this is a post
        out.println("Post");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}

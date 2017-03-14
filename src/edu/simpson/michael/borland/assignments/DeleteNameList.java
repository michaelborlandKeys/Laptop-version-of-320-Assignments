package edu.simpson.michael.borland.assignments;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by micha on 3/13/2017.
 */
@WebServlet(name = "DeleteNameList")
public class DeleteNameList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Post");

        // Grab the data we got via a parameter



        java.io.BufferedReader in = request.getReader();

        String requestid = new String ();
        for (String line; (line = in.readLine()) != null; requestid += line);
        // Grab the data we got via a parameter
        // programmed the old way without realizing it.
        // Output the string we got as a request, just as a check

        Gson gson = new Gson();
        Person fromJson = gson.fromJson(requestid, Person.class);
        PersonDAO.deletePeople(fromJson);



        // Make sure our field was set.
        // out.println(" First Name: "+fromJson.getId());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

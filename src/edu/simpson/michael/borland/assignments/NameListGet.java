package edu.simpson.michael.borland.assignments;


import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.google.gson.Gson;

/**
 * Created by micha on 1/26/2017.
 */
@WebServlet(name = "NameListGet")
public class NameListGet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Replace the line below with your database code that will
        // write out your JSON file.
        List <Person> peopleList = PersonDAO.getPeople();
        boolean printPerson_Start= true;
        out.println("[");
        

        Gson gson = new Gson();

        // Go ahead and turn peopleList into a JSON string
        String json = gson.toJson(peopleList);

        // Write out that string
        out.println(json);
        out.print("{ \"Field\":\"Value\"}");



    }
}

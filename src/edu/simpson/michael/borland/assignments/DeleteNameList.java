package edu.simpson.michael.borland.assignments;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by micha on 3/16/2017.
 */
@WebServlet(name = "DeleteNameList")
public class DeleteNameList extends HttpServlet {
    private Pattern validate_ID_to_delete;
    final Logger log = Logger.getLogger(DeleteNameList.class.getName());
    boolean valid_ID = false;

   public DeleteNameList()
   {
       validate_ID_to_delete= Pattern.compile("^\\d{1,15}$");
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Post");


        log.log(Level.SEVERE, "Didn't get to here!.");
        Matcher matching_data_ID;



        // Grab the data we got via a parameter



        BufferedReader in = request.getReader();

        int requestid = 0;
        for (int number; (number = in.read()) != 0; requestid += number);
        // Grab the data we got via a parameter
        // programmed the old way without realizing it.
        // Output the string we got as a request, just as a check
        Gson gson = new Gson();
        Person fromJson = gson.fromJson(Integer.toString(requestid), Person.class);



        matching_data_ID = validate_ID_to_delete.matcher(Integer.toString(fromJson.getId()));
        out.println("is it reaching here ");
        if (matching_data_ID.find()) {
            valid_ID = true;
            out.println("is it reaching here ");
            out.println(" ID: "+fromJson.getId());
            out.println("Valid delete Name");
        } else {
            valid_ID = false;
            out.println("Invalid delete person");
        }

        if (valid_ID == true)
        {
            PersonDAO.deletePeople(fromJson);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

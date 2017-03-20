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

import static com.sun.jmx.mbeanserver.Util.cast;
import static java.lang.Integer.parseInt;

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
        Matcher matching_data_ID;

      String requestid=(request.getParameter("id"));

        // Grab the data we got via a parameter

        matching_data_ID = validate_ID_to_delete.matcher((requestid));
        out.println("is it reaching here ");
        if (matching_data_ID.find()) {
            valid_ID = true;
            out.println("is it reaching here ");

            out.println("Valid delete Name");
        } else {
            valid_ID = false;
            out.println("Invalid delete person");
        }

        if (valid_ID == true) {

            PersonDAO.deletePeople(requestid);

        }










        log.log(Level.SEVERE, "Didn't get to here!.");




        // Grab the data we got via a parameter


out.println("It reaches here ");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

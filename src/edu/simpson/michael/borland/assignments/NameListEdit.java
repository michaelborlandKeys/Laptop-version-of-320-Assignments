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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by micha on 2/14/2017.
 */
@WebServlet(name = "NameListEdit")
public class NameListEdit extends HttpServlet {
    private Pattern validate_First_Name;
    private Pattern validate_Last_Name;
    private Pattern validate_Email;
    private Pattern validate_Phone;
    private Pattern validate_Birthday;
    final Logger log = Logger.getLogger(NameListEdit.class.getName());
    private boolean valid_form = false;



    public NameListEdit ()
    {
        validate_First_Name = Pattern.compile("^[A-Za-z àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$/");
        validate_Last_Name = Pattern.compile("^[A-Za-z àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$/");
        validate_Email = Pattern.compile("^([0-9a-zA-Z]+[-._+&amp;])+[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$/");
        validate_Phone = Pattern.compile("^\\d{3}[-]*\\d{3}[-]*\\d{4}$/");
        validate_Birthday = Pattern.compile("^\\d{4}\\-\\d{2}\\-\\d{2}$/");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Post");

        Gson gson = new Gson();
        String requestString = new String();


        Person fromJson = gson.fromJson(requestString, Person.class);        // Grab the data we got via a parameter



log.log(Level.SEVERE, "Didn't get to printing out any data.");

        // Make sure our field was set.
        // out.println(" First Name: "+fromJson.getId());





        // Now create matcher object.
        Matcher matching_data_first = validate_First_Name.matcher(fromJson.getFirst());
        if (matching_data_first.find( )) {
            valid_form= true;
            out.println("Valid First Name");
        } else {
            valid_form= false;
            out.println("Invalid First Name");
        }
        Matcher matching_data_last = validate_Last_Name.matcher(fromJson.getLast());
        if (matching_data_last.find( )) {
            valid_form= true;
            out.println("Valid Last Name");
        } else {
            valid_form=false;
            out.println("Invalid Last Name");
        }

        Matcher matching_data_email = validate_Email.matcher(fromJson.getEmail());
        if (matching_data_email.find( )) {
            valid_form = true;
            out.println("Valid Email");
        } else {
            valid_form= false;
            out.println("Invalid Email");

        }
        Matcher matching_data_phone = validate_Phone.matcher(fromJson.getPhone());
        if (matching_data_phone.find( )) {
            valid_form= true;
            out.println("Valid Phone");

        } else {
            valid_form= false;
            out.println("Invalid Phone");

        }
        Matcher matching_data_birthday = validate_Birthday.matcher(fromJson.getBirthday());
        if (matching_data_birthday.find()) {
            out.println("Valid Birthday");
            valid_form= true;
        } else {
            valid_form= false;
            out.println("Invalid Bithday");
        }
        if(valid_form == true)
        {
            java.io.BufferedReader in = request.getReader();


            for (String line; (line = in.readLine()) != null; requestString += line);
            // Grab the data we got via a parameter
            // programmed the old way without realizing it.
            // Output the string we got as a request, just as a check

            out.println(" First Name: "+fromJson.getFirst());
            out.println(" Last Name: "+fromJson.getLast());
            out.println(" Email: "+fromJson.getEmail());
            out.println(" Phone: "+fromJson.getPhone());
            out.println(" Birthday: "+fromJson.getBirthday());


            PersonDAO.addPeople(fromJson) ;
        }





        // Print that this is a post
        out.println("Post");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}

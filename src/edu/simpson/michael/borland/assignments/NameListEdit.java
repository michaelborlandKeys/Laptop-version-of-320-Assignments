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
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;
import java.util.List;
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
    boolean valid_form = true;



    public NameListEdit() {
        validate_First_Name = Pattern.compile("^[A-Za-z àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$");
        validate_Last_Name = Pattern.compile("^[A-Za-z àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$");
        validate_Email = Pattern.compile("^([0-9a-zA-Z]+[-._+&amp;])+[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        validate_Phone = Pattern.compile("^\\d{3}[-]*\\d{3}[-]*\\d{4}$");
        validate_Birthday = Pattern.compile("^\\d{4}\\-\\d{2}\\-\\d{2}$");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("XPost");
        String id=request.getParameter("id");
        String firstName= request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String phone= request.getParameter("phone");
        String birthday= request.getParameter("birthday");
        Matcher matching_data_first;
        Matcher matching_data_last;
        Matcher matching_data_email;
        Matcher matching_data_phone;
        Matcher matching_data_birthday;






            // java.io.BufferedReader in = request.getReader();
            //   String requestString = new String();


             //  for (String line; (line = in.readLine()) != null; requestString += line);
               // Grab the data we got via a parameter
                     // programmed the old way without realizing it.
                          // Output the string we got as a request, just as a check
             // Gson gson = new Gson();
            // Person fromJson = gson.fromJson(requestString, Person.class);



        log.log(Level.SEVERE, "Didn't get to printing out any data.");

        // Make sure our field was set.
        // out.println(" First Name: "+fromJson.getId());


        // Grab the data we got via a parameter
        // programmed the old way without realizing it.




        out.println("is it reaching here ");


        matching_data_first = validate_First_Name.matcher(firstName);
        out.println("is it reaching here ");
        if (matching_data_first.find()) {
            out.println("is it reaching here ");
            valid_form = true;
            out.println("Valid First Name");
        } else {
            valid_form = false;
            out.println("Invalid First Name");
        }
        matching_data_last = validate_Last_Name.matcher(lastName);
        if (matching_data_last.find()) {
            valid_form = true;
            out.println("Valid Last Name");
        } else {
            valid_form = false;
            out.println("Invalid Last Name");
        }

        matching_data_email = validate_Email.matcher(email);
        if (matching_data_email.find()) {
            valid_form = true;
            out.println("Valid Email");
        } else {
            valid_form = false;
            out.println("Invalid Email");

        }
        matching_data_phone = validate_Phone.matcher(phone);
        if (matching_data_phone.find()) {
            valid_form = true;
            out.println("Valid Phone");

        } else {
            valid_form = false;
            out.println("Invalid Phone");

        }
        matching_data_birthday = validate_Birthday.matcher(birthday);
        if (matching_data_birthday.find()) {
            out.println("Valid Birthday");
            valid_form = true;
        } else {
            valid_form = false;
            out.println("Invalid Bithday");
        }





        if (valid_form) {
            Person person = new Person();

            person.setFirst(firstName);
            person.setLast(lastName);
            person.setEmail(email);
            person.setPhone(phone);
            person.setBirthday(birthday);
            // Output the string we got as a request, just as a chec// Gson gson = new Gson();
            if ( id== null|| id.equals("")) {

                PersonDAO.addPeople(person);


                out.println("Post");
            } else {
                // these are to check to see if the back end has received the information from front end to edit.
                out.println("ID="+" "+person.getId());
                out.println("FirstName="+" "+person.getFirst()+" "+"LastName="+person.getLast());
                out.println("Email="+" " + person.getEmail()+" " +"Phone="+" "+person.getPhone());
                out.println("Birthday="+" "+person.getBirthday() );


                person.setId(Integer.parseInt(id));
                PersonDAO.editPeople(person);

            }
        }

    }


    // Print that this is a post




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}

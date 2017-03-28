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
   private boolean valid_form = true;
   private Person person = new Person();

    public NameListEdit()
    {
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

        log.log(Level.SEVERE, "Didn't get to printing out any data.");

        valid_form=true;
        matching_data_first = validate_First_Name.matcher(firstName);

        if (matching_data_first.find())
        {
            out.println("Valid First Name");
        } else
        {
            valid_form = false;
            out.println("Invalid First Name");
        }

        matching_data_last = validate_Last_Name.matcher(lastName);

        if (matching_data_last.find())
        {
            out.println("Valid Last Name");
        } else
        {
            valid_form = false;
            out.println("Invalid Last Name");
        }

        matching_data_email = validate_Email.matcher(email);

        if (matching_data_email.find())
        {
            out.println("Valid Email");
        } else
        {
            valid_form = false;
            out.println("Invalid Email");
        }

        matching_data_phone = validate_Phone.matcher(phone);

        if (matching_data_phone.find())
        {
            out.println("Valid Phone");
        } else
        {
            valid_form = false;
            out.println("Invalid Phone");
        }

        matching_data_birthday = validate_Birthday.matcher(birthday);

        if (matching_data_birthday.find())
        {
            out.println("Valid Birthday");
        } else
        {
            valid_form = false;
            out.println("Invalid Bithday");
        }

        if (valid_form)
        {
            person.setFirst(firstName);
            person.setLast(lastName);
            person.setEmail(email);
            person.setPhone(phone);
            person.setBirthday(birthday);

            if ( id.equals(""))
            {
                PersonDAO.addPeople(person);
                out.println("Post");
            } else
            {
                // these are to check to see if the back end has received the information from front end to edit.
                person.setId(Integer.parseInt(id));
                PersonDAO.editPeople(person);
                out.println("ID="+" "+person.getId());
                out.println("FirstName="+" "+person.getFirst()+" "+"LastName="+person.getLast());
                out.println("Email="+" " + person.getEmail()+" " +"Phone="+" "+person.getPhone());
                out.println("Birthday="+" "+person.getBirthday() );
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
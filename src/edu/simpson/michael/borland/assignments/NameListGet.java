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
       Person person = new Person();

        out.println("[");

        int i = 1;

        for (Person print_Name_List_Info : peopleList)
         {

             out.print("{ \"id\""+":"+ (print_Name_List_Info.getId())+",");
             out.print("\"first\""+":"+"\""+(print_Name_List_Info.getFirst())+"\""+",");
             out.print("\"last\""+":"+"\""+(print_Name_List_Info.getLast())+"\""+",");
             out.print("\"phone\""+":"+"\""+(print_Name_List_Info.getPhone())+"\""+",");
             out.print("\"email\""+":"+"\""+(print_Name_List_Info.getEmail())+"\""+",");
             out.print("\"birthday\""+":"+"\""+(print_Name_List_Info.getBirthday())+"\"");
             out.println("}");

         if (i++ < peopleList.size()) {
             out.println(",");
         }
        }
        out.println("]\n");


        }






    }


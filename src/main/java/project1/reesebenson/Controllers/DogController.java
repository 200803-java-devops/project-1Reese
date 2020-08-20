package project1.reesebenson.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DogController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Doggo</h1> \n <img src=\"https://i.barkpost.com/wp-content/uploads/2015/02/featmeme.jpg?q=70&fit=crop&crop=entropy&w=808&h=500\"/>");
    }
}
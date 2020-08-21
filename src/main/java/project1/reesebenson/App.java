package project1.reesebenson;

import java.io.File;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import project1.reesebenson.Controllers.DogController;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Tomcat server = new Tomcat();
        server.setPort(8080);
        server.setBaseDir(new File("target/tomcat").getAbsolutePath());
        server.getConnector();
        server.addWebapp("/project1", new File("src/main/static").getAbsolutePath());
        System.out.println();
        server.addServlet("/project1", "DogController", DogController.class.getName()).addMapping("/dog");
        try {
            server.start();
        } catch (LifecycleException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println();
        }
    }

    
}

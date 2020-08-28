package project1.reesebenson;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import project1.reesebenson.Controllers.GitRepoController;

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
        server.addWebapp("/jankins", new File("src/main/static").getAbsolutePath());
        System.out.println();
        server.addServlet("/jankins", "GitRepoController", GitRepoController.class.getName()).addMapping("/Repo");
        try {
            server.start();
            server.getServer().await();
        } catch (LifecycleException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println();
        }
    }
}

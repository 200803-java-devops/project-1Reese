package project1.reesebenson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import project1.reesebenson.Controllers.GitRepoController;
import project1.reesebenson.DB.ConnectionUtils.ConnectionUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        load();
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
    private static void load(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("app.properties"));
            ConnectionUtils.setUsername(properties.getProperty("Username", "jankins"));
            ConnectionUtils.setPassword(properties.getProperty("Password", "pwd"));
            ConnectionUtils.setUrl(properties.getProperty("Url", "localhost:5265"));
            System.out.println("properties loaded");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

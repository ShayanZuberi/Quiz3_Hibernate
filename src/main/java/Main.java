import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class Main extends Application {
    public static void main(String[] args){
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Person.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session  = sf.openSession();
        Transaction trans = session.beginTransaction();

        List cars = session.createQuery("FROM Car where CarID = 1" ).list();
        for(Iterator iter = cars.iterator(); iter.hasNext(); ){
            Car car =  (Car) iter.next();
            System.out.println("Registration: " + car.getLicensePlate());
            System.out.println("Name: " +car.getOwner().getName());
        }

        trans.commit();



        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

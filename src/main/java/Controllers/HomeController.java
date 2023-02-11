package Controllers;
import com.example.finalgym.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
public class HomeController implements Initializable  {
    @FXML
    private Button newMember;
    @FXML
    private Button updateDeleteMember;
    @FXML
    private Button payments;
    @FXML
    private Button listOfMembers;
    @FXML
    private Button Logout;
    @FXML
    private Button bmi;


    @FXML
    private void newMemberOnAction(ActionEvent event) {
        try {
            Stage stage1 = (Stage) newMember.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewMember.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            stage.setTitle("Add New Member");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void updateDeleteMemberOnAction(ActionEvent event){
        try {
            Stage stage1 = (Stage) updateDeleteMember.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateDeleteMember.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1100, 664);
            stage.setTitle("Update & Delete");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void listOfMembersOnAction(ActionEvent event)
    {
        try {
            Stage stage1 = (Stage) listOfMembers.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ListOfMembers.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1100, 600);
            stage.setTitle("List of Members");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void paymentsOnAction(ActionEvent e)
    {
        try {
            Stage stage1 = (Stage) payments.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Payments.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 934, 651);
            stage.setTitle("Payments");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        }catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
    public void bmiOnAction()
    {
        try {
            Stage stage1 = (Stage) bmi.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Bmi.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 307);
            stage.setTitle("BMI Calculator");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        }catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
    public void logoutOnAction(ActionEvent event) throws IOException
    {
        Stage stage1 = (Stage) Logout.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(),1360,768);
        stage.setTitle("Black Angel Gym");
        stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

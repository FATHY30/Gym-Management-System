package Controllers;
import Connection.ConnectionProvider;
import com.example.finalgym.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class NewMemberController implements Initializable {

    @FXML
    private Label id;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private DatePicker joinDate;
    @FXML
    private TextField amount;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextField age;
    @FXML
    private ComboBox genderBox;
    @FXML
    private ComboBox membershipTypeBox;
    @FXML
    private String[] gender={"Male","Female"};
    @FXML
    private String[] memberShipType={"1 month","3 month","6 month","12 month"};
    @FXML
    private Button save;
    @FXML
    private Button closeNewMember;
    @FXML
    public static int id1=5;

    public void closeNewMemberOnAction(ActionEvent e) throws IOException{
        Stage stage1 = (Stage) closeNewMember.getScene().getWindow();
        stage1.close();
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String id2 = id.getText();
        String name1 = name.getText();
        String phone1 = phone.getText();
        String joinDate1 =String.valueOf(joinDate.getValue());
        String genderBox1 =(String) genderBox.getValue();
        String membershipType1 =String.valueOf(membershipTypeBox.getValue());
        String amount1 = amount.getText();
        String height1 = height.getText();
        String weight1 = weight.getText();
        String age1 = age.getText();
        Alert alert = new Alert(Alert.AlertType.NONE);
        try{
            Connection con1 = ConnectionProvider.getCon();
            PreparedStatement ps = con1.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,id2);
            ps.setString(2,name1);
            ps.setString(3,phone1);
            ps.setString(4,joinDate1);
            ps.setString(5,genderBox1);
            ps.setString(6,membershipType1);
            ps.setString(7,amount1);
            ps.setString(8,height1);
            ps.setString(9,weight1);
            ps.setString(10,age1);
            ps.executeUpdate();
            ImageView imageView = new ImageView("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\check-mark.png");
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("");
            alert.setContentText("Successfully Saved");
            alert.setTitle("Information");
            alert.setGraphic(imageView);
            alert.showAndWait();
            Stage stage1 = (Stage) save.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewMember.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(),1000,600);
            stage.setTitle("Black Angel Gym");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        }catch(Exception exception)
        {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.show();
            System.out.println(exception);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.getItems().addAll(gender);
        membershipTypeBox.getItems().addAll(memberShipType);
        try{
            id1=1;
            String str =String.valueOf(id1);
            id.setText(str);
            Connection con = ConnectionProvider.getCon();
            Statement statement =con.createStatement();
            ResultSet result = statement.executeQuery("select max(id) from member");
            while(result.next())
            {
                id1=result.getInt(1);
                id1++;
                String str2 = String.valueOf(id1);
                id.setText(str2);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

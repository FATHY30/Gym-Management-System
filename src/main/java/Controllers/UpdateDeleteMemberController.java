package Controllers;

import com.example.finalgym.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.sql.*;
import java.util.Optional;

import Connection.ConnectionProvider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UpdateDeleteMemberController {
    @FXML
    private Button search;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button close;
    @FXML
    private TextField id;
    @FXML
    private TextField idField;
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
    private String[] gender = {"Male", "Female"};
    @FXML
    private String[] memberShipType = {"1 month", "3 month", "6 month", "12 month"};
    Alert alert;

    public void searchOnAction(ActionEvent e) {
        boolean isFound = false;
        try {
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("Select * from member where id='" + id.getText() + "'");
            while (result.next()) {
                isFound = true;
                idField.setText(result.getString(1));
                name.setText(result.getString(2));
                phone.setText(result.getString(3));
                joinDate.setValue(result.getDate(4).toLocalDate());
                genderBox.setValue(result.getString(5));
                membershipTypeBox.setValue(result.getString(6));
                amount.setText(result.getString(7));
                height.setText(result.getString(8));
                weight.setText(result.getString(9));
                age.setText(result.getString(10));
                membershipTypeBox.getItems().addAll(memberShipType);
            }
            if (!isFound) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("ID does not found");
                alert.show();
            }
        } catch (Exception event) {
            System.out.println(event);
        }
    }

    public void updateOnAction(ActionEvent e) {
        String id1 = idField.getText();
        String name1 = name.getText();
        String phone1 = phone.getText();
        String joinDate1 = String.valueOf(joinDate.getValue());
        String gender1 = (String) genderBox.getValue();
        String membershipType1 = String.valueOf(membershipTypeBox.getValue());
        String amount1 = amount.getText();
        String height1 = height.getText();
        String weight1 = weight.getText();
        String age1 = age.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update member set id=?,name=?,phonenumber=?,joindate=?,gender=?,membershiptype=?,amount=?,height=?,weight=?,age=? where id=?");
            ps.setString(1, id1);
            ps.setString(2, name1);
            ps.setString(3, phone1);
            ps.setString(4, joinDate1);
            ps.setString(5, gender1);
            ps.setString(6, membershipType1);
            ps.setString(7, amount1);
            ps.setString(8, height1);
            ps.setString(9, weight1);
            ps.setString(10, age1);
            ps.setString(11, id1);
            ps.executeUpdate();
            ImageView imageView = new ImageView("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\check-mark.png");
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("");
            alert.setGraphic(imageView);
            alert.setContentText("Successfully Updated");
            alert.showAndWait();
            Stage stage1 = (Stage) update.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateDeleteMember.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1000, 664);
            stage.setTitle("Black Angel Gym");
            stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
            stage.setScene(scene);
            stage.show();
        } catch (Exception exception) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            System.out.println(exception);
        }
    }

    public void deleteOnAction(ActionEvent e) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Do you really want to delete this member?");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.get() == ButtonType.OK) {
            try {
                Connection con = ConnectionProvider.getCon();
                Statement statement = con.createStatement();
                statement.executeUpdate("delete from member where id='" + id.getText() + "'");
                Stage stage1 = (Stage) update.getScene().getWindow();
                ImageView imageView = new ImageView("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\check-mark.png");
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                alert.setHeaderText("");
                alert.setGraphic(imageView);
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();
                Stage stage2 = (Stage) delete.getScene().getWindow();
                stage2.close();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateDeleteMember.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 1000, 664);
                stage.setTitle("Black Angel Gym");
                stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
                stage.setScene(scene);
                stage.show();
            } catch (Exception exception) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.show();
                System.out.println(exception);
            }
        }

    }

    public void closeOnAction(ActionEvent e) {
        try {
            Stage stage1 = (Stage) close.getScene().getWindow();
            stage1.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}

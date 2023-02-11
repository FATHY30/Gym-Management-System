package Controllers;

import com.example.finalgym.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.sql.*;
import Connection.ConnectionProvider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;

public class PaymentsControllers implements Initializable {

    @FXML
    private TableView<PaymentModel>table;
    @FXML
    private TableColumn<PaymentModel,String>Date;
    @FXML
    private TableColumn<PaymentModel,Integer>Amount;
    @FXML
    private Button search;
    @FXML
    private TextField idField;
    @FXML
    private TextField memberName;
    @FXML
    private DatePicker memberDate;
    @FXML
    private TextField amount1;
    @FXML
    private TextField membershipType;

    @FXML
    private Button close;
    @FXML
    private Button savePayment;

    ObservableList<PaymentModel>payment= FXCollections.observableArrayList();
    public void searchOnAction() {
        boolean check = false;
        payment.clear();
        table.setItems(null);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement statement1 = con.createStatement();
            ResultSet resultSet = statement1.executeQuery("select * from payment where id='" + idField.getText() + "'");
            while (resultSet.next()) {
                check=true;
                payment.add(new PaymentModel(resultSet.getString("date"), resultSet.getInt("amount")));
            }
            if(check)
            table.setItems(payment);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select * from member where id= '"+idField.getText()+"'");
            while (res.next())
            {
                check=true;
                memberName.setText(res.getString("name"));
                amount1.setText(res.getString("amount"));
                membershipType.setText(res.getString("membershiptype"));
            }
            if(!check)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("");
                alert.setContentText("ID not found");
                alert.showAndWait();
                memberName.setText(res.getString(""));
                amount1.setText(res.getString(""));
                membershipType.setText(res.getString(""));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void savePaymentOnAction(ActionEvent e)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        boolean check=false;
        try {
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from payment where id = '"+idField.getText()+"' and date = '"+memberDate.getValue()+"'");
            while (resultSet.next())
            {
                check=true;
            }
        }catch(Exception exception)
        {
            System.out.println(exception);
        }
        if(!check) {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into payment values(?,?,?)");
                ps.setString(1, idField.getText());
                ps.setString(2, String.valueOf(memberDate.getValue()));
                ps.setString(3, amount1.getText());
                ps.executeUpdate();
                ImageView imageView = new ImageView("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\check-mark.png");
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                alert.setGraphic(imageView);
                alert.setHeaderText("");
                alert.setContentText("Successfully Added");
                alert.showAndWait();
            } catch (Exception exception) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.show();
                System.out.println(exception);
            }

            try {
                Connection con = ConnectionProvider.getCon();
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from payment where id='" + idField.getText() + "' AND Date = '" + memberDate.getValue() + "'");
                while (resultSet.next()) {
                    payment.add(new PaymentModel(resultSet.getString("date"), resultSet.getInt("amount")));
                }
                table.setItems(payment);

            } catch (Exception exception) {
                System.out.println(exception);
            }
        }else{
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setContentText("The payment associated with this number and this date is already paid");
            alert.show();
        }
    }
    public void closeOnAction(ActionEvent e)
    {
        Stage stage1 = (Stage) close.getScene().getWindow();
        stage1.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date.setCellValueFactory(new PropertyValueFactory<PaymentModel,String>("Date"));
        Amount.setCellValueFactory(new PropertyValueFactory<PaymentModel,Integer>("Amount"));
        table.setItems(payment);
    }
}

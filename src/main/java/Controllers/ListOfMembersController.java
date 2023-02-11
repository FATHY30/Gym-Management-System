package Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import Connection.ConnectionProvider;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
public class ListOfMembersController  implements Initializable {
    @FXML
    private Button close;
    @FXML
    private TextField filter;
    @FXML
    private TableView<memberModel> table;
    @FXML
    private TableColumn<memberModel, Integer> id;
    @FXML
    private TableColumn<memberModel, String> name;
    @FXML
    private TableColumn<memberModel, Long> phone;
    @FXML
    private TableColumn<memberModel, String> joinDate;
    @FXML
    private TableColumn<memberModel, String> gender;
    @FXML
    private TableColumn<memberModel, String> membershipType;
    @FXML
    private TableColumn<memberModel, Integer> amount;
    @FXML
    private TableColumn<memberModel, Float> height;
    @FXML
    private TableColumn<memberModel, Float> weight;
    @FXML
    private TableColumn<memberModel, Integer> age;
    public void closeOnAction(ActionEvent e) {
        Stage stage1 = (Stage) close.getScene().getWindow();
        stage1.close();
    }

    ObservableList<memberModel> member = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<memberModel, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<memberModel, String>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<memberModel, Long>("phone"));
        joinDate.setCellValueFactory(new PropertyValueFactory<memberModel, String>("joinDate"));
        gender.setCellValueFactory(new PropertyValueFactory<memberModel, String>("gender"));
        membershipType.setCellValueFactory(new PropertyValueFactory<memberModel, String>("membershipType"));
        amount.setCellValueFactory(new PropertyValueFactory<memberModel, Integer>("amount"));
        height.setCellValueFactory(new PropertyValueFactory<memberModel, Float>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<memberModel, Float>("weight"));
        age.setCellValueFactory(new PropertyValueFactory<memberModel, Integer>("age"));
        try {
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from member");

            while (resultSet.next()) {
                member.add(new memberModel(resultSet.getInt(1), resultSet.getNString(2), resultSet.getLong(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getFloat(8), resultSet.getFloat(9), resultSet.getInt(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        table.setItems(member);
        FilteredList<memberModel> filteredList = new FilteredList<>(member);
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(memberModel -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(memberModel.getName()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(memberModel.getId()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
            SortedList<memberModel> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedList);
        });

    }
}

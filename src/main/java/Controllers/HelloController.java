package Controllers;

import com.example.finalgym.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class HelloController {
    @FXML
    private Label invalidInput;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private CheckBox showPassword;
    @FXML
    private Button exitButton;
    @FXML
    private TextField password;
    public void exitButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void login(ActionEvent event)
    {
        try {
            if (usernameTextField.getText().equals("Karim3030") && (passwordTextField.getText().equals("kimo1234") || (password.getText().equals("kimo1234")))) {
                Stage stage1 = (Stage) loginButton.getScene().getWindow();
                stage1.close();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 1360, 768);
                stage.setTitle("Black Angel Gym");
                stage.getIcons().add(new Image("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\BAG.jpg"));
                stage.setScene(scene);
                stage.show();
            } else {
                invalidInput.setText("Invalid Username or Password");
                invalidInput.setVisible(true);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void messageController(ActionEvent event)
    {
        if(usernameTextField.isFocused() || passwordTextField.isFocused()) {
                invalidInput.setVisible(false);
            }
    }
    public void showPasswordOnAction(ActionEvent action) {
        if(showPassword.isSelected())
        {
            password.setText(passwordTextField.getText());
            password.setVisible(true);
            passwordTextField.setVisible(false);
            return;
        }
        passwordTextField.setText(password.getText());
        passwordTextField.setVisible(true);
        password.setVisible(false);
    }
}
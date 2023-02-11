package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BmiControllers {
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private Button close;
    public void calculateBmiOnAction(ActionEvent e)
    {
        try {
            ImageView imageView= new ImageView("C:\\Users\\dell\\IdeaProjects\\FinalGYM\\src\\main\\resources\\com\\example\\finalgym\\Images\\bmi(2).png");
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            float weight1 = Float.parseFloat(weight.getText());
            float height1 = Float.parseFloat(height.getText());
            float Bmi = weight1 / (height1 / 100 * height1 / 100);
            alert.setHeaderText("BMI = " + Bmi);
            if(Bmi<18.5)
                alert.setContentText("Underweight");

            else if(Bmi >=18.5 && Bmi <=24.9)
                alert.setContentText("Normal weight");

            else if(Bmi >=25 && Bmi<=29.9)
                alert.setContentText("Overweight");
            else
                alert.setContentText("Obesity");

            alert.setGraphic(imageView);
            alert.setTitle("BMI");
            alert.show();
        }catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    public void closeOnAction(ActionEvent e)
    {
        Stage stage1 = (Stage) close.getScene().getWindow();
        stage1.close();
    }

}

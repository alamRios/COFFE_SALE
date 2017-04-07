package gui.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author AlamRios
 */
public class LoginController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    
    @FXML
    private Label label;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    public void dragWindow(MouseEvent event){
        Stage stage = (Stage) label.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }
    
    @FXML
    public void setXY(MouseEvent event){
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }
    
    @FXML
    public void closeWindow(InputEvent e){
        Stage stage = (Stage) label.getScene().getWindow();
        stage.close();
    }
}

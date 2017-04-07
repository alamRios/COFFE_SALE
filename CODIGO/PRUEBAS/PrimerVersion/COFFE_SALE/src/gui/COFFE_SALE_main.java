package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AlamRios
 */
public class COFFE_SALE_main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Para quitar los bordes de la ventana
        stage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("login/Login.fxml"));
        
        Scene scene = new Scene(root);
        //Para que no aparezca el borde de color
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

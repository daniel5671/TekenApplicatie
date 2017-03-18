import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Canvas canvas ;

    private GraphicsContext gc;


    @FXML private void drawCanvas(ActionEvent event){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
       gc = canvas

    }

}

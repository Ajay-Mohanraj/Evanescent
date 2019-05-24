import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tron extends Application {
    public void start(Stage ps) {
        Pane pane = new Pane();

        Scene scene = new Scene(pane);
        ps.setScene(scene);
        ps.show();
    }
}

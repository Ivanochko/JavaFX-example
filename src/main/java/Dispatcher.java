import Files.FileHandler;
import Plane.PlaneHandler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Dispatcher extends Application {

    static PlaneHandler planeHandler = new PlaneHandler();
    static List<String> filenames = Arrays.asList("file1", "file2", "file3");
    static FileHandler fileHandler = new FileHandler(planeHandler, filenames, "src/main/java/Files/");
    Label response;
    long start;

    public static void main(String[] args) {

        fileHandler.readFromFiles();

        planeHandler.out();
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Sort planes in files");

        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #000000");

        Scene myScene = new Scene(root, 600, 240);
        myStage.setScene(myScene);

        response = new Label("Sorting type:");
        response.setTextFill(Color.web("#ffffff"));

        ObservableList<String> typeSorting = FXCollections.observableArrayList(
                "Plane - Speed - Distance",
                "Speed - Plane - Distance",
                "Speed - Distance - Plane");
        ComboBox<String> cb = new ComboBox<>(typeSorting);
        cb.setValue("Plane - Speed - Distance");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(1.0);
        ds.setOffsetX(1.0);
        ds.setColor(Color.color(0.7, 0.7, 0.7));

        Button button = new Button("Sort the files!");
        button.setMinSize(370, 30);
        button.setStyle("-fx-background-color: #ff660d;"
                + " -fx-text-fill: #FFFFFF;"
                + "-fx-font-weight: bold;");
        button.setEffect(ds);

        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                planeHandler.sortByCombobox(cb.getValue());
                fileHandler.writeToFile();
                System.out.println("Sorted!");
            }
        });

        root.getChildren().addAll(response, cb, button);

        myStage.show();
    }
}

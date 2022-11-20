package agh.ics.oop.gui;
import agh.ics.oop.*;
import agh.ics.oop.GrassField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class App extends Application {
    private AbstractWorldMap map;
    @Override
    public void init() throws Exception {
        super.init();

        Parameters parameters = getParameters();
        System.out.println(parameters.getRaw());
        List<String> argsTemp = parameters.getRaw();
        String[] args = argsTemp.toArray(new String[0]);

        try {
            OptionParser optionParser=new OptionParser();
            MoveDirection[] directions=optionParser.parse(args);
            IWorldMap map=new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Zwierzak");
        Scene scene = new Scene(label, 400, 400);
        GridPane gridPane = new GridPane();
//        grid.setGridLinesVisible(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

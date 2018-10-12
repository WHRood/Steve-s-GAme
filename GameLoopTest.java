import javafx.animation.RotateTransition;

import javafx.application.Application;

import javafx.event.EventHandler;


import javafx.scene.Group;

import javafx.scene.PerspectiveCamera;

import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import javafx.scene.paint.*;


import javafx.scene.shape.Box;

import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;

import javafx.scene.text.Text;

import javafx.scene.transform.Rotate;

import javafx.stage.Stage;

import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.*;

import java.util.*;

import javax.swing.*;

import java.awt.*;

import javafx.application.Application;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.input.KeyEvent;

import javafx.scene.layout.Pane;

import javafx.scene.layout.Priority;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.animation.AnimationTimer;

import javafx.animation.KeyFrame;

import javafx.animation.KeyValue;

import javafx.animation.Timeline;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.effect.Lighting;

import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;

import javafx.scene.text.Text;

import javafx.util.Duration;

import javafx.animation.*;



public class GameLoopTest extends Application {

    static boolean WisPressed = false;

    static boolean DisPressed = false;

    static boolean SisPressed = false;

    static boolean AisPressed = false;

    static boolean MouseClicked = false;

    static boolean UPPressed = false;
    static boolean DOWNPressed = false;
    static boolean LEFTPressed = false;
    static boolean RIGHTPressed = false;
    private Timeline timeline;

    MouseEvent mouseclick;

    public void start(Stage theStage) throws FileNotFoundException

    {

        theStage.setTitle( "Dungeon Diver" );

        // ImageIcon icon = new ImageIcon("fireball.png");
        javafx.scene.image.Image fireBall = new Image(new FileInputStream("./parameters/fire_final_right.png"));

        ImageView view = new ImageView(fireBall );






        view.setFitWidth(50);
        view.setX(-100);
        view.setY(-100);
        // view.setRotate(20);
        view.setPreserveRatio(true);

        view.setSmooth(true);

        view.setCache(true);

        Group group = new Group();

        Scene scene = new Scene(group, 719, 2*449);

        Rectangle rect1 = new Rectangle(500, 400, 40, 60);
        Image img = new Image(new FileInputStream("./parameters/wizard_forward.png"));

        rect1.setFill(new ImagePattern(img));

        //rect1.setFill(Color.BLACK);
        //---------------------------------------------------------this is the picture for the frame on the bottom of the screen to display health // might change this depending on features/potential looks in future

        javafx.scene.image.Image bottomHUD = new Image(new FileInputStream("./parameters/lower_bar.png"));
        javafx.scene.image.Image backgroundImage = new Image(new FileInputStream("./parameters/map_level_one.png"));
        ImageView viewBackground = new ImageView(backgroundImage);
        ImageView viewBottomHUD = new ImageView(bottomHUD);
        viewBackground.setFitHeight(850);
        viewBackground.setFitWidth(850);
        viewBottomHUD.setPreserveRatio(false);
        viewBottomHUD.setFitWidth(720.00);
        viewBottomHUD.setFitHeight(150.00);
        viewBottomHUD.setX(0);
        viewBottomHUD.setY(750);


        group.getChildren().addAll(viewBackground,rect1, view);

        theStage.setScene(scene);




        EventHandler<KeyEvent> onkeypress = new EventHandler<KeyEvent>() {

            @Override

            public void handle(KeyEvent event) {

                switch(event.getText()){

                    case "w" :

                        WisPressed = true;


                        break;

                    case "d":

                        DisPressed = true;

                        break;

                    case "s":

                        SisPressed = true;

                        break;

                    case "a":

                        AisPressed = true;

                        break;
                    case "UP":
                        UPPressed = true;
                       break;

                    case "DOWN":
                        DOWNPressed = true;
                        break;

                    case "RIGHT":
                        RIGHTPressed = true;
                        break;

                    case "LEFT":
                        LEFTPressed = true;
                        break;

                }

            }

        };

        EventHandler<KeyEvent> onkeyrelese = new EventHandler<KeyEvent>() {

            @Override

            public void handle(KeyEvent event) {
                System.out.println("event: "+ event.getText());

                switch(event.getText()){

                    case "w":

                        WisPressed = false;

                        break;

                    case "d":

                        DisPressed = false;

                        break;

                    case "s":

                        SisPressed = false;

                        break;
                    case "UP":
                        UPPressed = false;
                        break;


                    case "DOWN":
                        DOWNPressed = false;
                        break;

                    case "RIGHT":
                        RIGHTPressed = false;
                        break;
                    case "LEFT":
                        LEFTPressed = false;
                        break;


                    case "a":

                        AisPressed = false;

                        break;
                }

            }

        };

        EventHandler<MouseEvent> mouseclicked = new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent event) {

                // System.out.println("FF");

                MouseClicked = true;

                mouseclick = event;

            }

        };

        scene.addEventHandler(KeyEvent.KEY_PRESSED, onkeypress);

        scene.addEventHandler(KeyEvent.KEY_RELEASED, onkeyrelese);

        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseclicked);

        timeline = new Timeline(3);

        //GAME LOOP STARTS

        new AnimationTimer()

        {

            public void handle(long currentNanoTime)

            {

                // Rectangle rext = new Rectangle(300,300,50,50);

                // KeyValue xValue = new KeyValue(rext.xProperty(),100);

                // KeyValue yValue = new KeyValue(rext.yProperty(),100);

                // KeyFrame keyFrame = new KeyFrame(Duration.millis(5000),xValue,yValue);

                // keyFrame.draw();

                // System.out.println("FF");

                if(WisPressed){

                    rect1.setX(rect1.getX());

                    rect1.setY(rect1.getY()-2);

                }

                if(DisPressed){

                    rect1.setX(rect1.getX()+2);

                    rect1.setY(rect1.getY());

                }

                if(AisPressed){

                    rect1.setX(rect1.getX()-2);

                    rect1.setY(rect1.getY());

                }

                if(SisPressed){

                    rect1.setX(rect1.getX());

                    rect1.setY(rect1.getY()+2);

                }

                if(MouseClicked){ //do action

                    timeline = new Timeline();

                    timeline.setCycleCount(1);

                    timeline.setAutoReverse(true);

                    System.out.println("AA");

                    view.setX(rect1.getX());

                    view.setY(rect1.getY());
                    //---------------------------------Setting the angle for the fireball to be rotated on ---------------------------------------------------

                    float xDistance = (float)mouseclick.getX() - (float)view.getX();
                    float yDistance = (float)mouseclick.getY() - (float)view.getY();
                    double rotationAngle = Math.toDegrees(Math.atan2(yDistance, xDistance));
                    view.setRotate(rotationAngle);


                    KeyValue xValue = new KeyValue(view.xProperty(),((int)mouseclick.getX()));

                    KeyValue yValue = new KeyValue(view.yProperty(),((int)mouseclick.getY()));

                    // System.out.println((int)mouseclick.getX());

                    KeyFrame keyFrame = new KeyFrame(Duration.millis(2000), xValue,yValue);

                    timeline.getKeyFrames().add(keyFrame);

                    // timeline.getKeyFrames().add(0);

                    timeline.play();

                    //timeline

                    MouseClicked = false;

                }

            }

        }.start();



        theStage.show();

    }

    public static void main(String args[]){

        launch(args);

    }

}


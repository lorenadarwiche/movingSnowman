import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;


public class movingSnowman extends Application
{
    public final static int JUMP = 10;
    
    private String snowman;
    //--------------------------------------------------------------------
    //  Presents a snowman scene.
    //--------------------------------------------------------------------
    public void start(Stage primaryStage)
    {        
        //Bottom/base of snowman
        Ellipse base = new Ellipse(80, 210, 80, 60);
        base.setFill(Color.WHITE);
        
        //Body/Middle of snowman
        Ellipse middle = new Ellipse(80, 130, 50, 40);
        middle.setFill(Color.WHITE);
         
        //Head of snowman 
        Circle head = new Circle(80, 70, 30);
        head.setFill(Color.WHITE);
        
        //the right eye of snowman
        Circle rightEye = new Circle(70, 60, 5);
        //the left eye of snowman
        Circle leftEye = new Circle(90, 60, 5);
        //the mouth of the snowman
        Line mouth = new Line(70, 80, 90, 80);
        
        //The Top Button of the Snowman thats in the middle of the body
        Circle topButton = new Circle(80, 115, 6);
        //The coloring of Top Button of the Snowman thats in the middle of the body
        topButton.setFill(Color.BLACK);
        //The middle button of the Snowman thats in the middle part of the body
        Circle middleButton = new Circle(80, 135, 6);
        //The coloring of Middle Button of the snowman thats in the middle of the body
        middleButton.setFill(Color.ORANGE);
        //The bottom button of the snowman thats in the middle of the body
        Circle bottomButton = new Circle(80, 155, 6);
        //the coloring of Bottom button of the snowman thats in the middle of the body 
        bottomButton.setFill(Color.PURPLE);
        
        //The left arm of the Snowman
        Line leftArm = new Line(110, 130, 160, 130);
        //How thick the left arm is.
        leftArm.setStrokeWidth(3);
        //The Right arm of the Snowman
        Line rightArm = new Line(50, 130, 0, 100);
        //How thick the right arm is
        rightArm.setStrokeWidth(3);
         
        //Creation of the hat for the Snowman
        Rectangle stovepipe = new Rectangle(60, 0, 40, 50);
        Rectangle brim = new Rectangle(50, 45, 60, 5);
        //Grouping together the top and bottom part of the Hat for the Snowman
        Group hat = new Group(stovepipe, brim);
        //Seting the hat on top of the Snowman
        hat.setTranslateX(10);
        hat.setRotate(15);

        //Grouping together each part of the Snowman to create a group name called snowman
        Group snowman = new Group(base, middle, head, leftEye, rightEye,
            mouth, topButton, middleButton, bottomButton, leftArm, rightArm, hat);
        //Adjusting the placement for the snowman
        snowman.setTranslateX(170);
        snowman.setTranslateY(50);
        //snowman.setRotate(80);
        

         //Creates the button action for the snowman to move
         Pane pane = new Pane();
         pane.getChildren().add(snowman);
         pane.setOnKeyPressed(e -> {
			   switch (e.getCode()) {
               case UP:
                  snowman.setTranslateY(snowman.getTranslateY() - JUMP);
                  break;
               case DOWN:
                  snowman.setTranslateY(snowman.getTranslateY() + JUMP);
                  break;
               case RIGHT:
                  snowman.setTranslateX(snowman.getTranslateX() + JUMP);
                  break;
               case LEFT:
                  snowman.setTranslateX(snowman.getTranslateX() - JUMP);
                  break;
               default:
                  break; 
         }
	   	});

        //Sun for the Snowman background
        Circle sun = new Circle(50, 50, 30);
        //Color for the Sun
        sun.setFill(Color.GOLD);
        
        //The color for the background
        Rectangle ground = new Rectangle(0, 250, 500, 100);
        //Coloring for the background
        ground.setFill(Color.STEELBLUE);
        
        //Grouping together the sun, the ground, the snowman, and the pane to create a scene
        Group root = new Group(ground, sun, snowman, pane);
        //creating the physical content of the Snowman
        Scene scene = new Scene(root, 500, 350, Color.LIGHTBLUE);
        
        //implements the name of the graphics
        primaryStage.setTitle("Snowman");
        //implements the scene in the Snowman
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
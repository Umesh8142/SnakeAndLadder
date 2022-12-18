package com.example.snakeandladder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;



public class MainGameController {
   @FXML
   Text dicePrint1;
    @FXML
    Text dicePrint2;
   @FXML
           Text changeTurn;
   int turn =1;
    @FXML
    Text changeTurn2;
    @FXML
    ImageView player1,player2;

    HashMap<Pair<Double,Double>,Pair<Double,Double>> SL_CC= new HashMap<>();

   @FXML
    public void dice(MouseEvent event) throws IOException {

       slc();
       Random random = new Random();
       int rolling= random.nextInt(6)+1;

       if(turn==1) {

           Pair<Double,Double> moveC=  movement(player1.getTranslateX(),player1.getTranslateY(),rolling);
           player1.setTranslateX(moveC.getKey());
           player1.setTranslateY(moveC.getValue());

           if(SL_CC.containsKey(new Pair<>(moveC.getKey(),moveC.getValue())))
           {
               player1.setTranslateX(SL_CC.get(new Pair<>(moveC.getKey(),moveC.getValue())).getKey());
               player1.setTranslateY(SL_CC.get(new Pair<>(moveC.getKey(),moveC.getValue())).getValue());

           }

           checkWin(player1.getTranslateX(),player1.getTranslateY());


       }
       else {

           Pair<Double,Double> moveC=  movement(player2.getTranslateX(),player2.getTranslateY(),rolling);
           player2.setTranslateX(moveC.getKey());
           player2.setTranslateY(moveC.getValue());
           if(SL_CC.containsKey(new Pair<>(moveC.getKey(),moveC.getValue())))
           {
               player2.setTranslateX(SL_CC.get(new Pair<>(moveC.getKey(),moveC.getValue())).getKey());
               player2.setTranslateY(SL_CC.get(new Pair<>(moveC.getKey(),moveC.getValue())).getValue());

           }
           checkWin(player2.getTranslateX(),player2.getTranslateY());

       }


       if(rolling!=6) {
           if (turn == 1) {
               turn = 2;
               changeTurn2.setText("P 2's turn");
               changeTurn.setText("  ");
               dicePrint1.setText(" "+rolling);
               dicePrint2.setText(" ");

           }
           else {
               turn = 1;
               changeTurn.setText("P 1's turn");
               changeTurn2.setText(" ");
               dicePrint1.setText(" ");
               dicePrint2.setText(" "+rolling);

           }
       }
       else{
           if (turn == 1) {
               dicePrint1.setText(" "+rolling);
               dicePrint2.setText(" ");

           }
           else {
               dicePrint1.setText(" ");
               dicePrint2.setText(" "+rolling);

           }
       }





   }
   Pair<Double,Double> movement(double x,double y, int rolling) {


       double moveX = x;
       double moveY = y;


       if (moveY% 100 == 0) {
           moveX = moveX + rolling * 50;

           if (moveX > 500) {
               moveX = 500 * 2 - moveX + 50;
               moveY = moveY - 50;

           }
       } else{

           moveX = moveX - rolling * 50;
           if(moveX<50){
               if(moveY==-450){
                   return(new Pair<>(x,y));
               }
               moveX=-1*(moveX-50);
               moveY-=50;
           }

   }
       return new Pair<>(moveX,moveY);
    }

    void checkWin(Double x, Double y) throws IOException {
       if(x==50 && y==-450){
           Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
           winAlert.setHeaderText("Result");
           if(turn==1)
           {
               winAlert.setContentText("Player 1 has won the Game");
           }
           else
           {
               winAlert.setContentText("Player 2 has won the Game");
           }
           GamePageLoader page= new GamePageLoader();
          HelloApplication.root.getChildren().setAll(page.root);
           winAlert.showAndWait();
       }
    }
    void slc(){
       SL_CC= new HashMap<>();
       SL_CC.put(new Pair<>(50.0,0.0),new Pair<>(150.0,-150.0));
       SL_CC.put(new Pair<>(200.0,0.0),new Pair<>(350.0,-50.0));
        SL_CC.put(new Pair<>(450.0,0.0),new Pair<>(500.0,-150.0));
        SL_CC.put(new Pair<>(200.0,-50.0),new Pair<>(350.0,0.0));
        SL_CC.put(new Pair<>(50.0,-100.0),new Pair<>(100.0,-200.0));
        SL_CC.put(new Pair<>(50.0,-100.0),new Pair<>(100.0,-200.0));
        SL_CC.put(new Pair<>(400.0,-100.0),new Pair<>(200.0,-400.0));
        SL_CC.put(new Pair<>(500.0,-250.0),new Pair<>(350.0,-300.0));
        SL_CC.put(new Pair<>(350.0,-250.0),new Pair<>(350.0,-150.0));
        SL_CC.put(new Pair<>(350.0,-250.0),new Pair<>(350.0,-150.0));
        SL_CC.put(new Pair<>(200.0,-300.0),new Pair<>(50.0,-250.0));
        SL_CC.put(new Pair<>(100.0,-300.0),new Pair<>(100.0,-50.0));
        SL_CC.put(new Pair<>(500.0,-350.0),new Pair<>(500.0,-450.0));
        SL_CC.put(new Pair<>(50.0,-350.0),new Pair<>(50.0,-450.0));
        SL_CC.put(new Pair<>(350.0,-400.0),new Pair<>(200.0,-100.0));
        SL_CC.put(new Pair<>(400.0,-450.0),new Pair<>(400.0,-350.0));
        SL_CC.put(new Pair<>(300.0,-450.0),new Pair<>(400.0,-350.0));
        SL_CC.put(new Pair<>(150.0,-450.0),new Pair<>(100.0,-350.0));



    }


}

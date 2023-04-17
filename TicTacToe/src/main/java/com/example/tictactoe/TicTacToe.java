package com.example.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToe extends Application {
    private Label playerXScoreLabel,playerYScoreLabel;
    private boolean playerXturn=true;
    private int playerXScore=0,playerYScore=0;
    private Button buttons[][]=new Button[3][3];
    private BorderPane createContent(){
        BorderPane root=new BorderPane();
        root.setStyle("-fx-background-color:black");
        //tilte
        root.setPadding(new Insets(10));
        Label titleLabel=new Label("Tic Tac Toe");
        titleLabel.setStyle("-fx-font-size:35pt; -fx-font-weight:bold;" );
        titleLabel.setTextFill(Color.WHITE);
        root.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        //game board
        GridPane gridPane=new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                Button button=new Button();
                button.setPrefSize(120,120);
                button.setStyle("-fx-font-size:24pt; -fx-font-weight:bold" );
                button.setOnAction(event -> buttonClicked(button));
                buttons[i][j]=button;
                gridPane.add(button,j,i);
            }
        }
        root.setCenter(gridPane);
        BorderPane.setAlignment(gridPane,Pos.CENTER);
        //score
        HBox scoreBoard=new HBox(20);
        scoreBoard.setAlignment(Pos.CENTER);
        playerXScoreLabel=new Label("Player X:0");
        playerXScoreLabel.setStyle("-fx-font-size:16pt;-fx-font-width:bold;");
        playerXScoreLabel.setTextFill(Color.WHITE);
        playerYScoreLabel=new Label("Player Y:0");
        playerYScoreLabel.setTextFill(Color.WHITE);
        playerYScoreLabel.setStyle("-fx-font-size:16pt;-fx-font-width:bold;");
        scoreBoard.getChildren().addAll(playerXScoreLabel,playerYScoreLabel);
        root.setBottom(scoreBoard);

        return root;
    }
    private void buttonClicked(Button button){
        if(button.getText().equals("")){
            if(playerXturn){
                button.setText("X");
                button.setTextFill(Color.RED);
                button.setStyle("-fx-background-color: MediumSeaGreen;-fx-font-size:20pt;-fx-font-weight:bold");
            }
            else{
                button.setText("O");
                button.setTextFill(Color.BLACK);
                button.setStyle("-fx-background-color: Coral;-fx-font-size:20pt;-fx-font-weight:bold");
            }
            playerXturn=!playerXturn;
            checkedWinner();}
        return;}
    private void checkedWinner(){
        for (int i = 0; i <3 ; i++) {
            if(buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][1].getText().equals(buttons[i][2].getText())
                    && !buttons[i][0].getText().isEmpty())
            {  String winner=buttons[i][0].getText();
                showWinnerDialog(winner);
                updateScore(winner);
                resetBoard();
            }
        }
        for (int j = 0; j <3 ; j++) {
            if(buttons[0][j].getText().equals(buttons[1][j].getText())
                    && buttons[1][j].getText().equals(buttons[2][j].getText())
                    && !buttons[0][j].getText().isEmpty())
            {  String winner=buttons[0][j].getText();
                showWinnerDialog(winner);
                updateScore(winner);
                resetBoard();
                return;
            }
        }
        if(buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[2][2].getText())
                && !buttons[0][0].getText().isEmpty())
        {  String winner=buttons[0][0].getText();
            showWinnerDialog(winner);
            updateScore(winner);
            resetBoard();
            return;
        }
        if(buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[2][2].getText())
                && !buttons[0][0].getText().isEmpty())
        {  String winner=buttons[0][0].getText();
            showWinnerDialog(winner);
            updateScore(winner);
            resetBoard();
            return;
        }
        if(buttons[2][0].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[0][2].getText())
                && !buttons[2][0].getText().isEmpty())
        {  String winner=buttons[2][0].getText();
            showWinnerDialog(winner);
            updateScore(winner);
            resetBoard();
            return;
        }
        boolean tie=true;
        for (Button i[]:buttons) {
            for(Button button:i){
                if( button.getText().isEmpty()){
                    tie=false;
                    break;
                }
            }}
        if(tie){
            showTileDialog();
            resetBoard();
        }

    }
    private void showWinnerDialog(String winner){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("winner");
        alert.setContentText("Congratulations "+winner+" You won the game");
        alert.setHeaderText("");
        alert.showAndWait();}
    private void showTileDialog(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tie");
        alert.setContentText("Game Over tie");
        alert.setHeaderText("");
        alert.showAndWait();}
    private void updateScore(String winner){
        if(winner.equals("X")) {
            playerXScore++;
            playerXScoreLabel.setText("Player X" + playerXScore);
        }
        else{ playerYScore++;
            playerYScoreLabel.setText("Player Y"+playerYScore);
        }}
    private  void resetBoard(){
        for (Button i[]:buttons) {
            for(Button button:i){
                button.setText("");
                button.setStyle("-fx-font-size:24pt; -fx-font-weight:bold;background-color:AliceBlue" );

            }

        }
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());

        Image Imag=new Image("C:\\Users\\vishw\\IdeaProjects\\TicTacToe\\src\\main\\img.png");
        stage.getIcons().add(Imag);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
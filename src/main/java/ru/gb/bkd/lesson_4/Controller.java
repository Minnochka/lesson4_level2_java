package ru.gb.bkd.lesson_4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.awt.*;

public class Controller {
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField userText;

    private Chat chat;

    private int step;

    public Controller(){
        chat = new Chat("Test");
    }

    public void clickSendButton() {
        String text = userText.getText();
        if (text.isBlank()){
            return;
        }
        historyArea.appendText(chat.getName() + ": ");
        historyArea.appendText(text + "\n\n");
        userText.clear();
    }

    public void clickExit(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION, "Точно хотите выйти из чата?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO)
        );
        alert.setTitle("Выход");
        ButtonType answer = alert.showAndWait().get();
        if (answer.getButtonData() == ButtonBar.ButtonData.YES) {
            System.exit(0);
        }
    }

    public void clickClearHistory() {
        historyArea.clear();
    }


    public void keyListener(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER) {
            clickSendButton();
        }
    }
}
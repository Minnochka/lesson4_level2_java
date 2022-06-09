module ru.gb.bkd.lesson_4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ru.gb.bkd.lesson_4 to javafx.fxml;
    exports ru.gb.bkd.lesson_4;
}
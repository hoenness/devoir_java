module projetjava_s5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens projetjava_s5.controllers to javafx.fxml;
    exports projetjava_s5;
    exports projetjava_s5.entities;
}

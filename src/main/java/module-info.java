module bts.ciel.project_mp3_thestrongest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens bts.ciel.project_mp3_thestrongest to javafx.fxml;
    exports bts.ciel.project_mp3_thestrongest;
}
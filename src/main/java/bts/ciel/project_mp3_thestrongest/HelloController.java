package bts.ciel.project_mp3_thestrongest;

import bts.ciel.project_mp3_thestrongest.pk_mp3.GestionMp3;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Label pathLab;
    public Label fichierLab;
    public Button boutonLab;
    public Button stopLab;
    public Button playLab;
    public Media media;
    public MediaPlayer mediaPlayer;
    public String sFichier;
    public GestionMp3 gestionMp3;
    public Path path;
    public Button tagLab;
    public TextField titreLab;
    public TextField trackLab;
    public TextField commentaireLab;
    public TextField artisteLab;
    public TextField genreLab;
    public TextField anneeLab;
    public TextField albumLab;
    public Button modifierLab;
    public Button saveLab;
    private SimpleBooleanProperty isEditable;
    private SimpleStringProperty background;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isEditable = new SimpleBooleanProperty(false);
        background = new SimpleStringProperty("-fx-background-color: white;");
        //TF editable la
        titreLab.editableProperty().bind(isEditable);
        titreLab.styleProperty().bind(background);
        artisteLab.editableProperty().bind(isEditable);
        artisteLab.styleProperty().bind(background);
        anneeLab.editableProperty().bind(isEditable);
        anneeLab.styleProperty().bind(background);
        albumLab.editableProperty().bind(isEditable);
        albumLab.styleProperty().bind(background);
        genreLab.editableProperty().bind(isEditable);
        genreLab.styleProperty().bind(background);
        commentaireLab.editableProperty().bind(isEditable);
        commentaireLab.styleProperty().bind(background);
        trackLab.editableProperty().bind(isEditable);
        trackLab.styleProperty().bind(background);
        genreLab.editableProperty().bind(isEditable);
        genreLab.styleProperty().bind(background);


        boutonLab.setOnAction(event -> ouvrirfichier());
        saveLab.setOnAction(event -> gestionMp3.ecrireTag());
        playLab.setOnAction(event -> play());
        stopLab.setOnAction(event -> stop());
        tagLab.setOnAction(event -> liretag());
        modifierLab.setOnAction(event -> activerEdition());



    }

    private void liretag() {
        gestionMp3 = new GestionMp3(path);
        try {
            gestionMp3.lireTags();
        } catch (IOException e) {
            System.out.println("erreur truc");
        }
        titreLab.setText(gestionMp3.getTitre());
        artisteLab.setText(gestionMp3.getArtiste());
        albumLab.setText(gestionMp3.getAlbum());
        anneeLab.setText(gestionMp3.getAnnee());
        commentaireLab.setText(gestionMp3.getCommentaire());
        trackLab.setText(String.valueOf(gestionMp3.getPiste()));
        genreLab.setText(gestionMp3.getGenre());
        isEditable.set(false);
        background.set("-fx-background-color: lightgray;");

    }

    private void activerEdition() {
        isEditable.set(true);
        background.set("-fx-background-color: blue;");
    }

    private void play() {
        media = new Media(sFichier);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        stopLab.setDisable(false);
        playLab.setDisable(true);
    }

    private void stop() {
        mediaPlayer.stop();
        stopLab.setDisable(false);
        playLab.setDisable(true);
    }

    private void ouvrirfichier() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("src/mp3"));
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            path = file.toPath();
            sFichier = path.toUri().toString();
            fichierLab.setText(path.getFileName().toString());
            pathLab.setText(path.toAbsolutePath().toString());
            stopLab.setDisable(true);
            playLab.setDisable(false);
        }
    }


}
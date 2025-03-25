package bts.ciel.project_mp3_thestrongest;

import bts.ciel.project_mp3_thestrongest.pk_mp3.GestionMp3;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boutonLab.setOnAction(event -> ouvrirfichier());
        playLab.setOnAction(event -> play());
        stopLab.setOnAction(event -> stop());
        tagLab.setOnAction(event -> liretag());


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
        trackLab.setText(gestionMp3.getPiste);
        genreLab.setText((gestionMp3.getGenre()));

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
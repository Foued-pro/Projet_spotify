package bts.ciel.project_mp3_thestrongest.pk_mp3;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestionMp3 {
    public String getPiste;
    private Path fileSource;
    private byte[] tab;
    private TagMp3 tag;

    public GestionMp3(Path p) {
        this.fileSource = p;
        tab = new byte[128];
        this.tag = new TagMp3();
    }

    public void lireTags() throws IOException {
        RandomAccessFile ran = new RandomAccessFile(fileSource.toFile(), "rw");
        ran.seek(Files.size(fileSource) - 128);
        ran.read(tab);
        ran.close();
        if (new String(tab, 0, 3).equals("TAG")) {
            this.tag.setTitre(new String(tab, 3, 30));
            this.tag.setArtiste(new String(tab, 33, 30));
            this.tag.setAlbum(new String(tab, 63, 30));
            this.tag.setAnnee(new String(tab, 93, 4));
            this.tag.setCommentaire(new String(tab, 97, 28));
            this.tag.setPiste(tab[126]);
            this.tag.setGenre(tab[127]);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erreur de format");
            alert.showAndWait();

        }
    }


    public String getTitre() {
        return this.tag.getTitre();
    }

    public String getAlbum() {
        return this.tag.getAlbum();
    }

    public String getArtiste() {
        return this.tag.getArtiste();
    }

    public String getAnnee() {
        return this.tag.getAnnee();
    }

    public String getCommentaire() {
        return this.tag.getCommentaire();
    }

    public byte getPiste() {
        return this.tag.getPiste();
    }

    public String getGenre() {
        return this.tag.getGenre();
    }

    public void ecrireTag() throws IOException {
        RandomAccessFile ran = new RandomAccessFile(fileSource.toFile(), "rw");
        ran.seek(Files.size(fileSource) - 128);
        ran.read(tab);
        ran.close();
        for (int i = 0; i < tab.length - 3; i++) {
            tab[3 + i] = (byte) 0 * 00;
        }
        for (int i = 0; i < tag.getTitre().length(); i++) {
            if (i < 30) {
                tab[3 + i] = (byte) tag.getTitre().charAt(i);
            }
        }
        for (int i = 0; i < tag.getArtiste().length(); i++) {
            if (i < 30) {
                tab[33 + i] = (byte) tag.getArtiste().charAt(i);
            }
        }
        for (int i = 0; i < tag.getAlbum().length(); i++) {
            if (i < 30) {
                tab[63 + i] = (byte) tag.getAnnee().charAt(i);
            }
        }
        for (int i = 0; i < tag.getArtiste().length(); i++) {
            if (i < 30) {
                tab[33 + i] = (byte) tag.getArtiste().charAt(i);
            }
        }
        for (int i = 0; i < tag.getArtiste().length(); i++) {
            if (i < 30) {
                tab[33 + i] = (byte) tag.getArtiste().charAt(i);
            }
        }
        ran.write(tab);
        ran.close();
        lireTags();

    }


}



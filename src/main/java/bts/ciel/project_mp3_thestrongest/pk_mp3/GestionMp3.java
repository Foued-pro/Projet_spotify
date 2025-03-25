package bts.ciel.project_mp3_thestrongest.pk_mp3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream is = Files.newInputStream(fileSource);
        DataInputStream dis = new DataInputStream(is);
        dis.skipBytes((int) (Files.size(fileSource) - 128));
        dis.read(tab);
        dis.close();
        if (new String(tab, 0, 3).equals("TAG")) {
            this.tag.setTitre(new String(tab, 3, 30));
            this.tag.setArtiste(new String(tab, 33, 30));
            this.tag.setAlbum(new String(tab, 63, 30));
            this.tag.setAnnee(new String(tab, 93, 4));
            this.tag.setCommentaire(new String(tab, 97, 28));

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
}



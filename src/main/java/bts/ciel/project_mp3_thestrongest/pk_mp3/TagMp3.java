package bts.ciel.project_mp3_thestrongest.pk_mp3;

public class TagMp3 {
    private String tag;
    private String titre;
    private String nom;
    private String artiste;
    private String album;
    private String annee;
    private String commentaire;
    private byte piste;
    private String genre;

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public byte getPiste() {
        return piste;
    }

    public void setPiste(byte piste) {
        this.piste = piste;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(byte genre) {
        this.genre = String.valueOf(genre);
    }


}

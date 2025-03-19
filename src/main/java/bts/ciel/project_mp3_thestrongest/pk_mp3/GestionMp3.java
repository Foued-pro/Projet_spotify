package bts.ciel.project_mp3_thestrongest.pk_mp3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestionMp3 {
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
        System.out.println(new String(tab).replace("\0", "").substring(0, 126));
    }
}

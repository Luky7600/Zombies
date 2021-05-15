package Zombies;

import acm.graphics.GImage;

public class ZombieImatge {
    //Crearem una variable per comptar els emojis
    private static int lastID = 1;

    //Crearem un ID pels emojis
    private int id;

    //Assignarem la velocitat que tindran els emojis per defecte
    private static final int VELOCITATDEFECTE = 10;

    //Assignarem la velocitat màxima del emoji.
    private int maximaVelocitat;

    //Creem un array de les Imatges possibles dels emojis, aquestes s'assignaran automàticament
    private String[] imatgesEmoji = {"emoji1.png", "emoji2.png", "emoji3.png",
            "emoji4.png", "emoji5.png", "emoji6.png", "emoji8.png","emoji9.png","zoombie.png" };

    //Imatge del emoji
    private GImage imatge;

    //Mètode constructor del emoji
    public ZombieImatge() {
        int triaColor = (int) (Math.random() * imatgesEmoji.length-1);
        this.imatge = new GImage(imatgesEmoji[triaColor]);

        id = lastID;
        lastID++;
        if (id == 6){
            this.imatge = new GImage(imatgesEmoji[8]);
        }
        maximaVelocitat = VELOCITATDEFECTE;
    }

    //Retornarà la ID del emoji
    public final int getID() {
        return id;
    }

    //Retornarà la imatge del emoji
    public final GImage getImatge() {
        return imatge;
    }

    //Retornarà la posició "X" del emoji
    public final double getPosicio() {
        return imatge.getX() + imatge.getWidth();
    }

    //Definirà la posiciódel emoji, posició "X" i posició "Y"
    public final void setPosicio(final double x, final double y) {
        imatge.setLocation((int) (Math.random() * 50), (int) (Math.random() * 50));
        if (id == 6){
            imatge.setLocation(500,500);
        }
    }

    //Mourà el emoji en la posició corresponent
    public final void mou(final double x, final double y) {
        imatge.move(x, y);
    }

    //Retornarà la velocitat màxima a la que pot anar un emoji
    public final int getMaximaVelocitat() {
        return maximaVelocitat;
    }

    //Aqui definirem la velocitat màxima que pota anar un emoji
    public final void setMaximaVelocitat(final int maxima) {
        maximaVelocitat = maxima;
    }

}

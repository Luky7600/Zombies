package Zombies;

import acm.graphics.GImage;

import java.util.concurrent.ThreadLocalRandom;

public class ZombieImatge {
    //Crearem una variable per comptar els emojis
    private static int lastID = 1;

    //Crearem un ID pels emojis
    private int id;

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

    }
    //Retornarà la imatge del emoji
    public final GImage getImatge() {
        return imatge;
    }

    //Definirà la posició del emoji, posició "X" i posició "Y" de forma recursiva
    public final void setPosicio(final double x, final double y) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 500 + 1);
        int randomNum2 = ThreadLocalRandom.current().nextInt(1, 500 + 1);
        imatge.setLocation(randomNum, randomNum2);
        if (id == 6){
            imatge.setLocation(250,250);
        }
    }

}

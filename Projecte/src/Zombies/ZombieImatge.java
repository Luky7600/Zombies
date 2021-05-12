package Zombies;

import acm.graphics.GImage;

public class ZombieImatge {
    //Crearem una variable per comptar els camells
    private static int lastID = 1;

    //Crearem un ID pels camells
    private int id;

    //Assignarem la velocitat que tindran els camells per defecte
    private static final int VELOCITATDEFECTE = 10;

    //Assignarem la velocitat màxima del camell.
    private int maximaVelocitat;

    //Creem un array de les Imatges possibles dels camells, aquestes s'assignaran automàticament
    private String[] imatgesCamells = {"emoji1.png", "emoji2.png", "emoji3.png",
            "emoji4.png", "emoji5.png", "emoji6.png", "emoji8.png","emoji9.png","zoombie.png" };

    //Imatge del camell
    private GImage imatge;

    //Mètode constructor del camell
    public ZombieImatge() {
        int triaColor = (int) (Math.random() * imatgesCamells.length);
        this.imatge = new GImage(imatgesCamells[triaColor]);

        id = lastID;
        lastID++;

        maximaVelocitat = VELOCITATDEFECTE;
    }

    //Retornarà la ID del camell
    public final int getID() {
        return id;
    }

    //Retornarà la imatge del camell
    public final GImage getImatge() {
        return imatge;
    }

    //Retornarà la posició "X" del camell
    public final double getPosicio() {
        return imatge.getX() + imatge.getWidth();
    }

    //Definirà la posiciódel camell, posició "X" i posició "Y"
    public final void setPosicio(final double x, final double y) {
        imatge.setLocation(x, y);
    }

    //Mourà el camell en la posició corresponent
    public final void mou(final double x, final double y) {
        imatge.move(x, y);
    }

    //Retornarà la velocitat màxima a la que pot anar un camell
    public final int getMaximaVelocitat() {
        return maximaVelocitat;
    }

    //Aqui definirem la velocitat màxima que pota anar un camell
    public final void setMaximaVelocitat(final int maxima) {
        maximaVelocitat = maxima;
    }

}

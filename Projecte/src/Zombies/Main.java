package Zombies;

import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram {

    //definim numero emojis
    static final int num = 10;

    //Definim la meta
    static final double meta = 900;

    //Finalment fem el run que sera per mostra per pantalla el joc
    public final void run() {

        //fem un objecte per la pantalla
        ZombieMoviment pistaDeCarreres = new ZombieMoviment(this);

        //fem un bucle per imprimir tots els emojis amb una crida de la funcio el numero de vegades assignat al parametre num
        for (int i = 0; i < num; i++) {
            pistaDeCarreres.afegirEmoji(new ZombieImatge());
        }

        //Cridem el metode per poder iniciar la carrera
        pistaDeCarreres.iniciaCarrera();

    }

    //Aixo es per tal de que funcioni el acm amb 64 bits
    public static void main(String[] args) {
        new Main().start(args);
    }
}

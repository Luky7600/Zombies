package Zombies;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram {

    /**
     * @param num Fem una variable num que sera el numero total de camells imrpimits per pantalla
     */
    static final int num = 10;

    //Definim la meta
    static final double meta = 900;

    //Finalment fem el run que sera per mostra per pantalla la carrera
    public final void run() {

        //Fem una objecte per imprimir la pista amb els parametres de començament i la meta final
        ZombieMoviment pistaDeCarreres = new ZombieMoviment(this,900);

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

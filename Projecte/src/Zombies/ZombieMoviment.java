package Zombies;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class ZombieMoviment {
    //Assignem a la posicio de la pantalla con comença la carrera
    static final int POSICIOINICIAL = 10;

    //Assignem a la següent variable la separació entre cada emoji
    static final int SEPARACIO = 70;

    //Assignem el temps per començar la carrera
    static final int TIMESTART = 2000;

    //Assignem a la següent variable el temps entre cada torn
    static final int TIMEPAUSE = 80;

    //Assignem a pantalla nula que sera on s'ha de pintar
    private Main pantalla = null;

    //Creem un array buit on s'afegiran els emojis que participen
    private ArrayList <ZombieImatge> emojis = null;

    //On es troba la linia d'arribada en la pantalla
    private double liniaFinal = 0;

    //Variable Estrella que mostra qui va guanyant la carrera i qui guanya
    private GImage estrella = null;


    public ZombieMoviment(final Main c, final double mida) {
        //Pantalla serà el requadre del joc
        pantalla = c;
        emojis = new ArrayList<ZombieImatge>();
        liniaFinal = mida;
    }

    //En el següent métode, afegirem un emoji
    public final void afegirEmoji(final ZombieImatge manel) {
        if (manel != null) {
            manel.setPosicio(POSICIOINICIAL, (emojis.size() * SEPARACIO)
                    + POSICIOINICIAL);
            emojis.add(manel);
            pantalla.add(manel.getImatge());
        }
    }

    //Amb el següent metode, iniciem la carrera
    public final void iniciaCarrera() {
        //Creem la següent variable
        double emojiMesRapid = 0;

        //Assignem les dimensions del requadre
        pantalla.setSize(20000,15000);
        //Cridem els següents mètodes
        //pintaPista();
        //preparatsLlestos();
        //Fem que la següent variable sigui igual al mètode
        aCorrer();
        //Crida el següent mètode
        //mostraResultat(emojiMesRapid);
    }
    private double aCorrer() {
        //Creem un boleà que sigui fals
        boolean finalCarrera = false;
        double posicioPrimer = 0;

        while (!finalCarrera) {
            // Ronda
            pantalla.pause(TIMEPAUSE);
            for (ZombieImatge candidat : emojis) {
                double dx = 2;
                double dy = 1;
                /*Storage in the variables "positionX" and "positionY", the position X and Y to the emoji to param*/
                double positionX = candidat.getImatge().getX();
                double positionY = candidat.getImatge().getY();

                /*Check what "locX" be less that 0 or "locX" be greater that width to the window less 50
                 * if is complies, will do the following*/
                if (positionX < 0 || positionX > candidat.getImatge().getWidth() - 50) {
                    dx = -dx;
                }
                /*Check what "locY" be less that 0 or "locY" be greater that height to the window less 50
                 * if is complies, will do the following*/
                if (positionY < 0 || positionY > candidat.getImatge().getHeight() - 50) {
                    dy = -dy;
                }

                /*Move the emoji*/
                candidat.getImatge().move(dx,dy);

                /*establishes the pause time, in the value of the variable "3"*/
                pantalla.pause(1);
            }
        }
        //Retorna el emoji que ha arribat primer
        return posicioPrimer;
    }

    //Aquest metode es per tal de que la estrella segueixi sempre el emoji que va guanyan en aquel moment
    /*private void pintaPista() {
        int posicio = POSICIOINICIAL;
        // Pinta les línies horitzontals de les pistes
        for (int i = 0; i <= emojis.size(); i++) {
            GLine linia = new GLine(0, posicio - POSICIOINICIAL, liniaFinal,
                    posicio - POSICIOINICIAL);
            linia.setColor(Color.GRAY);
            pantalla.add(linia);
            posicio += SEPARACIO;
        }

        // Pinta la línia d'arribada
        GLine liniaArribada = new GLine(liniaFinal, 0, liniaFinal, SEPARACIO
                * emojis.size());
        liniaArribada.setColor(Color.RED);
        pantalla.add(liniaArribada);

    }*/

    //metode per posar perparats a la llista de espera
    /*private void preparatsLlestos() {
        final File f = new File(ZombieMoviment.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        playSong(f + "\\nokia.wav");
        GLabel text = new GLabel("Preparats ");
        text.setLocation((pantalla.getWidth() - text.getWidth()) / 2,
                (pantalla.getHeight() - text.getHeight()) / 2);
        text.setFont("Serif-bold-40");
        pantalla.add(text);
        pantalla.pause(TIMESTART);
        pantalla.remove(text);
        GLabel text2 = new GLabel("Llestos");
        text2.setLocation((pantalla.getWidth() - text2.getWidth()) / 2,
                (pantalla.getHeight() - text2.getHeight()) / 2);
        text2.setFont("Serif-bold-40");
        pantalla.add(text2);
        pantalla.pause(TIMESTART);
        pantalla.remove(text2);
        GLabel text3 = new GLabel("YA!");
        text3.setLocation((pantalla.getWidth() - text3.getWidth()) / 2,
                (pantalla.getHeight() - text3.getHeight()) / 2);
        text3.setFont("Serif-bold-40");
        pantalla.add(text3);
        pantalla.pause(TIMESTART-1000);
        pantalla.remove(text3);
    }*/

    //Aquest metode es per tal cuan el emoji arribi a la posicio desitjada surit el missatge de guanyador
    /*private void mostraResultat(final double emojiMesRapid) {
        GLabel text = null;
        GLabel text2 = null;
        for (ZombieImatge candidat : emojis) {
            if (candidat.getPosicio() == emojiMesRapid) {
                // És un guanyador
                text = new GLabel("Emoji GUANYADOR!");
                text2 = new GLabel("\uD83C\uDFC1");
                text.setFont("Serif-bold-25");
                text.setColor(Color.BLUE);
                text2.setFont("Serif-bold-25");
                text2.setColor(Color.BLACK);
                text.setLocation(pantalla.getWidth() / 2,
                        ((candidat.getID() * 2) - 1) * SEPARACIO / 2);
                text2.setLocation(pantalla.getWidth() / 1.20,
                        ((candidat.getID() * 2) - 1) * SEPARACIO / 2);
                int contador = 10;
                for(int i = 0; i <= contador; i++){
                    pantalla.add(text);
                    pantalla.add(text2);
                    pantalla.pause(TIMESTART-1500);
                    pantalla.remove(text);
                    pantalla.remove(text2);
                    pantalla.pause(TIMESTART-1500);
                    pantalla.add(text);
                    pantalla.add(text2);
                }
                pantalla.add(text);
                pantalla.add(text2);

            }
        }
    }*/
    public static void playSong (String filepath){
        try {
            File file = new File(filepath);
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();

            // sleep to allow enough time for the clip to play
            Thread.sleep(500);

            stream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Main().start(args);
    }
}
/*contador++;
                int velocitatMaxima = candidat.getMaximaVelocitat();
                double moviment = (int) (Math.random() * velocitatMaxima);
                double moviment2 = (int) (Math.random() * velocitatMaxima);
                candidat.mou(moviment, moviment2);
                if (candidat.getPosicio() >= liniaFinal) {
                    finalCarrera = true;
                }

                if (candidat.getPosicio() > posicioPrimer) {
                    posicioPrimer = candidat.getPosicio();
                }*/
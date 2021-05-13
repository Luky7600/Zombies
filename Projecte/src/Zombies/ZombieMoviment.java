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

    //Assignem a la següent variable la separació entre cada camell
    static final int SEPARACIO = 70;

    //Assignem el temps per començar la carrera
    static final int TIMESTART = 2000;

    //Assignem a la següent variable el temps entre cada torn
    static final int TIMEPAUSE = 80;

    //Assignem a pantalla nula que sera on s'ha de pintar
    private Main pantalla = null;

    //Creem un array buit on s'afegiran els camells que participen
    private ArrayList <ZombieImatge> camells = null;

    //On es troba la linia d'arribada en la pantalla
    private double liniaFinal = 0;

    //Variable Estrella que mostra qui va guanyant la carrera i qui guanya
    private GImage estrella = null;


    public ZombieMoviment(final Main c, final double mida) {
        //Pantalla serà el requadre del joc
        pantalla = c;
        camells = new ArrayList<ZombieImatge>();
        //Assignem el valor de liniaFinal a la següent variable
        liniaFinal = mida;
    }

    //En el següent métode, afegirem un camell
    public final void afegirCamell(final ZombieImatge manel) {
        if (manel != null) {
            manel.setPosicio(POSICIOINICIAL, (camells.size() * SEPARACIO)
                    + POSICIOINICIAL);
            camells.add(manel);
            pantalla.add(manel.getImatge());
        }
    }

    //Amb el següent metode, iniciem la carrera
    public final void iniciaCarrera() {
        //Creem la següent variable
        double camellMesRapid = 0;

        //Assignem les dimensions del requadre
        pantalla.setSize((int) liniaFinal + POSICIOINICIAL * 2, camells.size()
                * SEPARACIO);

        //Cridem els següents mètodes
        //pintaPista();
        //preparatsLlestos();
        //Fem que la següent variable sigui igual al mètode
        camellMesRapid = aCorrer();
        //Crida el següent mètode
        mostraResultat(camellMesRapid);
    }

    private double aCorrer() {
        //Creem un boleà que sigui fals
        boolean finalCarrera = false;
        double posicioPrimer = 0;

        while (!finalCarrera) {
            // Ronda
            pantalla.pause(TIMEPAUSE);
            int contador =1;
            for (ZombieImatge candidat : camells) {
                contador++;
                int velocitatMaxima = candidat.getMaximaVelocitat();
                double moviment = (int) (Math.random() * velocitatMaxima);
                double moviment2 = (int) (Math.random() * velocitatMaxima);
                candidat.mou(moviment, moviment2);
                if (candidat.getPosicio() >= liniaFinal) {
                    finalCarrera = true;
                }

                if (candidat.getPosicio() > posicioPrimer) {
                    posicioPrimer = candidat.getPosicio();
                }
            }
        }
        //Retorna el camell que ha arribat primer
        return posicioPrimer;
    }

    //Aquest metode es per tal de que la estrella segueixi sempre el camell que va guanyan en aquel moment
    /*private void pintaPista() {
        int posicio = POSICIOINICIAL;
        // Pinta les línies horitzontals de les pistes
        for (int i = 0; i <= camells.size(); i++) {
            GLine linia = new GLine(0, posicio - POSICIOINICIAL, liniaFinal,
                    posicio - POSICIOINICIAL);
            linia.setColor(Color.GRAY);
            pantalla.add(linia);
            posicio += SEPARACIO;
        }

        // Pinta la línia d'arribada
        GLine liniaArribada = new GLine(liniaFinal, 0, liniaFinal, SEPARACIO
                * camells.size());
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

    //Aquest metode es per tal cuan el camell arribi a la posicio desitjada surit el missatge de guanyador
    private void mostraResultat(final double camellMesRapid) {
        GLabel text = null;
        GLabel text2 = null;
        for (ZombieImatge candidat : camells) {
            if (candidat.getPosicio() == camellMesRapid) {
                // És un guanyador
                text = new GLabel("CAMELL GUANYADOR!");
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
    }
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

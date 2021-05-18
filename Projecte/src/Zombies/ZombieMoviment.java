package Zombies;

import java.util.ArrayList;

public class ZombieMoviment {
    //Assignem a la posicio de la pantalla con comença la carrera
    static final int POSICIOINICIAL = 10;

    //Assignem a la següent variable la separació entre cada emoji
    static final int SEPARACIO = 70;

    //Assignem a la següent variable el temps entre cada torn
    static final int TIMEPAUSE = 80;

    //Assignem a pantalla nula que sera on s'ha de pintar
    private Main pantalla = null;

    //Creem un array buit on s'afegiran els emojis que participen
    private ArrayList <ZombieImatge> emojis = null;

    public ZombieMoviment(final Main c) {
        //Pantalla serà el requadre del joc
        pantalla = c;
        emojis = new ArrayList<ZombieImatge>();
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

    public final void iniciaCarrera() {
        pantalla.setSize(20000,15000);
        aCorrer();
    }
    private double aCorrer() {
        //Creem un boleà que sigui fals
        boolean finalCarrera = false;
        double zombiultim = 0;

        while (!finalCarrera) {
            // Ronda
            pantalla.pause(TIMEPAUSE);
            for (ZombieImatge candidat : emojis) {
                double dx = 2;
                double dy = 1;
                //agafem les poscisions del emojis
                double positionX = candidat.getImatge().getX();
                double positionY = candidat.getImatge().getY();

                //fem que si toca el extrem de la pantalla reboti
                if (positionX < 0 || positionX > candidat.getImatge().getWidth() - 50) {
                    dx = -dx;
                }
                if (positionY < 0 || positionY > candidat.getImatge().getHeight() - 50) {
                    dy = -dy;
                }

                //moguem el emoji
                candidat.getImatge().move(dx,dy);

                //pausar la pantalla quant reboten
                pantalla.pause(1);
            }
        }
        //Retorna el emoji que ha arribat primer
        return zombiultim;
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
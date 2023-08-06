//Ángel de Jesús Mérida Jiménez Carné:23661
// Esta es la clase jugador donde se establece la parte del jugador junto con la del BOT

import java.util.Random;

public class Jugador {
    private String nombre;
    private int puntos;
    private boolean bot;

    public Jugador(boolean bot, String nombre){
        this.bot = bot;
        this.nombre = nombre; 
    }

    // metodos

    public String getNombre(){
        return this.nombre;
    }

    public boolean esBot(){
        return this.bot;
    }
    public int getPuntos(){
        return puntos;
    }
    // Agregar puntos y sumarlos 
    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }
}

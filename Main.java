//Ángel de Jesús Mérida Jiménez Carné:23661
//El programa consiste en realizar un juego llamado "Pig", el cual consiste en lanzar un dado e ir sumando la cantidad de numeros acumulados
//Este es el Main, donde se debe correr el programa, contiene la clase main y realizar turno. 

// Fuente de donde se saco para realizar el deley en Java: https://www.delftstack.com/es/howto/java/how-to-delay-few-seconds-in-java/

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        // llamar al objeto dado
        Dado dado = new Dado();
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = myObj.nextLine();
        //crear jugador
        Jugador jp = new Jugador(false, nombre);
        //crear BOT
        Jugador bot = new Jugador(true, "BOT");
        // crear meta 
        int puntajeGanador = 100;

        // Creamos los numeros de rondas:
        int ronda = 1;
        // Ciclo para obtener puntos tanto para el jugador como el BOT
        while (jp.getPuntos() <= puntajeGanador && bot.getPuntos() <= puntajeGanador){
            System.out.println("-----------------------------------");
            System.out.println("Ronda #"+ ronda + ": ");
            System.out.println("Turno de: "+ jp.getNombre());
            // deley para turno del jugador:
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
            int puntos = realizarTurno(dado, jp.esBot());
            jp.agregarPuntos(puntos);
            System.out.println("Puntos de "+ jp.getNombre()+": "+jp.getPuntos());
            System.out.println("");
            System.out.println("Turno del bot:");
            //Deley para turno del BOT
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
            if(jp.getPuntos() >= puntajeGanador){
                break;
            }
            
            //Agregar los puntos del BOT
            puntos = realizarTurno(dado,bot.esBot());
            bot.agregarPuntos(puntos);
            System.out.println("Puntos del bot : "+bot.getPuntos());
            ronda++;
            // deley para punteo del BOT:
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        if (jp.getPuntos() >= puntajeGanador){
            System.out.println("El ganador es "+jp.getNombre()+" con "+ jp.getPuntos());
        }
        else {
            System.out.println("El ganador es bot con "+ bot.getPuntos());

        }
    }


    public static int realizarTurno(Dado dado, boolean esBot){
        Scanner myObj = new Scanner(System.in);
        boolean seguirJugando = true;
        int total = 0;
        while(seguirJugando){
            int resultado = dado.lanzarDado();
            int resultado2 = dado.lanzarDado();
            System.out.println("Dado1: " + resultado + " Dado2: "+resultado2);
            if (resultado == 1 || resultado2 == 1){
                return 0;
            }
            total += resultado+resultado2;
            if (total >= 20){
                break;
            }
            if(esBot){
                Random random = new Random();
                seguirJugando = random.nextBoolean();
            }
            else {
                System.out.println("Desea lanzar otra vez? (Yes, no)");
                String seguir = myObj.nextLine();
                System.out.println(seguir);
                // Si se ingresa "Yes, volver a tirar dados"
                if(seguir.equals("Yes")){
                    seguirJugando = true;
                }
                else{
                    seguirJugando = false;
                }
            }
        }
        return total;
    }
}
//Ángel de Jesús Mérida Jiménez Carné:23661
// Clase donde de dado, donde se establece la cantidad de numeros aleatorios paraa el juego
import java.util.Random;
public class Dado {

    //hacer la función de lanzar dado 
    public int lanzarDado() {
        Random rand = new Random();
        //hacer el número random entre 1 y 6
        int resultado = rand.nextInt(6)+1;
        return resultado;
    }
}

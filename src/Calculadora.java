import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        getTargetNumber();
//Variables, condicionales, bucles y, preferiblemente, funciones.






//Pedir primer numero entre 1 y 9

//Si es el 1º número se aceptará automáticamente, con while (numInPut == 0)
//Si no es el 1º numero, el número deberá estar en la misma fila o columna que el ultimo introducido, pero no ser el mismo. if (numInPut !=0, numInPut == 1)

//número sea valido + total y se comprobará si el igual = o mayor > que el objetivo del juego,
// si iguala o supera = perdedor.

//Al finalizar la partida sout (Quieres volver a jugar?): si = se reiniciará, no = chao
    }
    public static int getTargetNumber() {

//Numero objetivo: Pedir un numero entre 10 y 99. Si esta  fuera de ese rango = error y se vuelve a pedir.
//Si introduce -1 el número se generará aleatoriamente dentro del rango.

        System.out.println("Establece el número objetivo entre 10 y 99");
        Scanner sc = new Scanner(System.in);
        int targetNum = sc.nextInt();

        //el rango que queremos tener es entre 10 y 99
        //de 10 a 100 hay 90 números y mínimo queremos empezar en 10.
        //fórmula Math.random nos da nums entre 0 y 1 (excluye al 1), lo multiplicamos por 90 para tener rango de 0 a 90
        //y le sumamos 10 para que mínimo nos de 10.
        int maxNumber = 90;
        int minNumber = 10;

        if (targetNum == -1) {
            targetNum = (int) (Math.random() * maxNumber + minNumber);
        }

        //mientras el numero es invalido
        //el nº es invalido cuando es menor que 10 o mayor que 99
        while (targetNum < 10 || targetNum > 99) {
            System.err.println("Ese número no es valido, introduce un número entre 10 y 99");
            targetNum = sc.nextInt();
        }
        System.out.println("Genial! Tu objetivo es " + targetNum + ", empieza el juego");
        return targetNum;
    }
}

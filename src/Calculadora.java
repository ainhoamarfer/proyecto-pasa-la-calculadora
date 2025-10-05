import java.util.Scanner;
//Variables, condicionales, bucles y, preferiblemente, funciones.
public class Calculadora {
    public static void main(String[] args) {
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

    public static int getFirstUserNumber() {
        //Pedir primer numero entre 1 y 9
        //El 1º número se aceptará automáticamente, ¿¿main con while (numInPut == 0)??

        int count = 0;
        System.out.println("Jugador 1, introduce un número entero del 1 al 9");
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();

        while (count < 1 || count > 9) {
            System.err.println("Ese número no es válido, introduce otro");
            count = sc.nextInt();
        }

        System.out.println("Suma total: " + count + ", turno del jugador 2");
        return count;
    }


    public static int getRestOfTheNumbers(int count) {
        //segunda función para el resto de jugadas
        //Si no es el 1º numero, el número deberá estar en la misma fila o columna que el ultimo introducido, pero no ser el mismo.

        int nextNumber;
        Scanner sc = new Scanner(System.in);
        nextNumber = sc.nextInt();


        //si count == 1, nextNumber tiene que ser o 2 o 3 o 4 o 7

        if (count == 1 && (nextNumber != 1 || nextNumber != 2 || nextNumber != 3 || nextNumber != 4 || nextNumber != 7)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 2, 3, 4 o 7.");
            nextNumber = sc.nextInt();
        }

        //si count == 2, nextNumber tiene que ser o 1 o 3 o 5 o 8

        if (count == 2 && (nextNumber != 2 || nextNumber != 1 || nextNumber != 3 || nextNumber != 5 || nextNumber != 8)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 1, 3, 5 o 8.");
            nextNumber = sc.nextInt();

        }

        //si count == 3, nextNumber tiene que ser o 1 o 2 o 6 o 9

        if (count == 3 && (nextNumber != 3 || nextNumber != 1 || nextNumber != 2 || nextNumber != 6 || nextNumber != 9)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 1, 2, 6 o 9.");
            nextNumber = sc.nextInt();
        }
        //si count == 4, nextNumber tiene que ser o 1 o 7 o 5 o 6

        if (count == 4 && (nextNumber != 4 || nextNumber != 1 || nextNumber != 5 || nextNumber != 6 || nextNumber != 7)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 1, 5, 6 o 7.");
            nextNumber = sc.nextInt();
        }

        //si count == 5, nextNumber tiene que ser o 2 o 6 o 8 o 4
        if (count == 5 && (nextNumber != 5 || nextNumber != 2 || nextNumber != 4 || nextNumber != 6 || nextNumber != 8)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 2, 4, 6 o 8.");
            nextNumber = sc.nextInt();

        }

        //si count == 6, nextNumber tiene que ser o 3 o 9 o 5 o 4

        if (count == 6 && (nextNumber != 6 || nextNumber != 3 || nextNumber != 4 || nextNumber != 5 || nextNumber != 9)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 3, 4, 5 o 9.");
            nextNumber = sc.nextInt();

        }

        //si count == 7, nextNumber tiene que ser o 1 o 4 o 8 o 9
        if (count == 7 && (nextNumber != 7 || nextNumber != 1 || nextNumber != 4 || nextNumber != 8 || nextNumber != 9)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 1, 4, 8 o 9.");
            nextNumber = sc.nextInt();

        }

        //si count == 8, nextNumber tiene que ser o 2 o 5 o 7 o 9
        if (count == 8 && (nextNumber != 8 || nextNumber != 2 || nextNumber != 5 || nextNumber != 7 || nextNumber != 9)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 2, 5, 7 o 9.");
            nextNumber = sc.nextInt();

        }

        //si count == 9, nextNumber tiene que ser o 3 o 6 o 8 o 7
        if (count == 9 && (nextNumber != 9 || nextNumber != 3 || nextNumber != 6 || nextNumber != 7 || nextNumber != 8)) {
            System.err.println("Movimiento no válido: desde 1 solo puedes sumar un 3, 6, 7 o 8.");
            nextNumber = sc.nextInt();

        }

        //número sea valido + total y se comprobará si el igual = o mayor > que el objetivo del juego,
        // si iguala o supera = perdedor.

        count = count + nextNumber;
        if (count >= getTargetNumber()){
            System.out.println("Has pedido");
        }else {
            System.out.println("Ahora la suma es de" + count);
        }
        return count;
    }
}

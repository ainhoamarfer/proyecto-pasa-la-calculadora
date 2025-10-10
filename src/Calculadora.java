import java.util.Scanner;
//Variables, condicionales, bucles y, preferiblemente, funciones.
public class Calculadora {

    public static void main(String[] args) {
        int previousNumber = 0;
        int firstNumber;
        int count = 0;
        boolean continuar = true;
        String respuesta;
        boolean theEnd = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a Pasa la Calculadora, para empezar introduce un número objetivo, tendra que ser mayor que 10 y menos que 99");
        int targetNum = getTargetNumber();

        System.out.println("¡Genial! Empieza la partida, tu objetivo es " + targetNum + "\nJugador 1. Introduce un primer número del 1 al 9");
        firstNumber = getFirstUserNumber(count, previousNumber);
        count = firstNumber;

        while (continuar == true) {
            System.out.println("Suma total " + count + ", siguiente turno\nElige un número que esté en la misma columna o en la misma fila que " + count);
            count = getRestOfTheNumbers(count, firstNumber, previousNumber);

            theEnd = comprobarFinalPartida(count, targetNum);

            if (theEnd == true) {
                System.out.println("Fin de partida. \t¿Quiéres jugar otra? (si/no)");
                respuesta = sc.next();

                if (!respuesta.equalsIgnoreCase("si")) {
                    continuar = false;
                }
            }

        }
        //Al finalizar la partida sout (Quieres volver a jugar?): si = se reiniciará, no = chao
    }

    private static boolean comprobarFinalPartida(int count, int targetNum) {
        //número sea valido + total y se comprobará si el igual = o mayor > que el objetivo del juego,
        if (count >= targetNum) {
            //Al finalizar la partida sout (Quieres volver a jugar?): si = se reiniciará, no = chao
            return true;
        }
        return false;
    }


    public static int getTargetNumber() {

        //Numero objetivo: Pedir un numero entre 10 y 99. Si esta  fuera de ese rango = error y se vuelve a pedir.
        //Si introduce -1 el número se generará aleatoriamente dentro del rango.

        Scanner sc = new Scanner(System.in);
        int targetNumPriv = sc.nextInt();

        //el rango que queremos tener es entre 10 y 99
        //de 10 a 100 hay 90 números y mínimo queremos empezar en 10.
        //fórmula Math.random nos da nums entre 0 y 1 (excluye al 1), lo multiplicamos por 90 para tener rango de 0 a 90
        //y le sumamos 10 para que mínimo nos de 10.
        int maxNumber = 90;
        int minNumber = 10;

        if (targetNumPriv == -1) {
            targetNumPriv = (int) (Math.random() * maxNumber + minNumber);
        }

        //mientras el numero es invalido
        //el nº es invalido cuando es menor que 10 o mayor que 99
        while (targetNumPriv < 10 || targetNumPriv > 99) {
            System.err.println("Ese número no es valido, introduce un número entre 10 y 99");
            targetNumPriv = sc.nextInt();
        }
        return targetNumPriv;

    }

    public static int getFirstUserNumber(int count, int previousNumber) {
        //Pedir primer numero entre 1 y 9
        //El 1º número se aceptará automáticamente, ¿¿main con while (numInPut == 0)??


        //System.out.println("Jugador 1, introduce un número entero del 1 al 9");
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();

        while (count < 1 || count > 9) {
            System.err.println("Ese número no es válido, introduce otro");
            count = sc.nextInt();
        }
        return count;
    }


    public static int getRestOfTheNumbers(int count, int previousNumber, int nextNumber) {
        //Segunda función para el resto de jugadas
        //Si no es el 1º numero, el número deberá estar en la misma fila o columna que el ultimo introducido, pero no ser el mismo.

        Scanner sc = new Scanner(System.in);
        nextNumber = sc.nextInt();

        if (verifyPreviousNumber(previousNumber, nextNumber) == false){
            System.err.println("Este número no es valido, introduce otro que este en la misma columna o fila que " + previousNumber);
            nextNumber = sc.nextInt();
        }else{
            count = count + nextNumber;
            System.out.println("Ahora la suma es de " + count);
        }
        return count;


        // si iguala o supera = perdedor.

    }

    public static boolean verifyPreviousNumber(int previousNumber, int nextNumber) {

        //hacer función a parte + while

        //si count == 1, nextNumber tiene que ser o 2 o 3 o 4 o 7

        if (previousNumber == 1 && (nextNumber == 2 || nextNumber == 3 || nextNumber == 4 || nextNumber == 7)) {
           return true;
        }

        //si count == 2, nextNumber tiene que ser o 1 o 3 o 5 o 8

        if (previousNumber == 2 && (nextNumber == 1 || nextNumber == 3 || nextNumber == 5 || nextNumber == 8)) {
            return true;
        }

        //si count == 3, nextNumber tiene que ser o 1 o 2 o 6 o 9

        if (previousNumber == 3 && (nextNumber == 1 || nextNumber == 2 || nextNumber == 6 || nextNumber == 9)) {
            return true;
        }
        //si count == 4, nextNumber tiene que ser o 1 o 7 o 5 o 6

        if (previousNumber == 4 && (nextNumber == 1 || nextNumber == 5 || nextNumber == 6 || nextNumber == 7)) {
            return true;
        }

        //si count == 5, nextNumber tiene que ser o 2 o 6 o 8 o 4
        if (previousNumber == 5 && ( nextNumber == 2 || nextNumber == 4 || nextNumber == 6 || nextNumber == 8)) {
            return true;
        }

        //si count == 6, nextNumber tiene que ser o 3 o 9 o 5 o 4

        if (previousNumber == 6 && (nextNumber == 3 || nextNumber == 4 || nextNumber == 5 || nextNumber == 9)) {
            return true;
        }

        //si count == 7, nextNumber tiene que ser o 1 o 4 o 8 o 9
        if (previousNumber == 7 && (nextNumber == 1 || nextNumber == 4 || nextNumber == 8 || nextNumber == 9)) {
            return true;
        }

        //si count == 8, nextNumber tiene que ser o 2 o 5 o 7 o 9
        if (previousNumber == 8 && (nextNumber == 2 || nextNumber == 5 || nextNumber == 7 || nextNumber == 9)) {
            return true;
        }

        //si count == 9, nextNumber tiene que ser o 3 o 6 o 8 o 7
        if (previousNumber == 9 && (nextNumber == 8 || nextNumber == 3 || nextNumber == 6 || nextNumber == 7)) {
            return true;
        }
        return false;
    }
}

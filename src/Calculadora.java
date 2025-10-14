import java.util.Scanner;
public class Calculadora {
    // Hemos puesto los valores de estas funciones fuera del main para no tener líos a la hora de llamarlas en las funciones.
    // De esta manera las funciones ya las conocen
    private static int previousNumber = 0;
    private static int count = 0;
    private static boolean continuar = true;
    private static String respuesta;
    private static boolean theEnd = false;
    private static int targetNum;
    private static int nextNumber = 0;
    private static int turn = 1;
    private static String player1;
    private static String player2;
    private static String player;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Preguntamos los nombres de los jugadores
        System.out.println("Bienvenidos/as a Pasa la Calculadora \nJugador 1, ¿Cómo te llamas?");
        player1 = sc.next();

        System.out.println("Jugador 2, ¿Cómo te llamas?");
        player2 = sc.next();
        player = nameAPlayer();

        System.out.println("Para empezar introducid un número objetivo, tendrá que ser mayor que 10 y menor que 99");
        targetNum = getTargetNumber();

        System.out.println("Turno de " + player + "\nEmpieza la partida, tu objetivo es " + targetNum + "\nIntroduce un primer número del 1 al 9");
        nextNumber = getPlayableNumber();

        //Creamos un bucle para que la partida continúe hasta que decidan no jugar más, a su vez una partida concreta termina cuando un jugador pierde.
        while (continuar == true) {
            turn = setPlayerTurn();
            player = nameAPlayer();

            System.out.println("Suma total " + count + "\nTurno de " + player + "\nElige un número que esté en la misma columna o en la misma fila que " + previousNumber);
            nextNumber = getPlayableNumber();
            theEnd = testEndGame();

            if (theEnd == true) {
                System.out.println("Fin de partida.\n" + player + " has perdido.\n¿Quiéres jugar otra? (si/no)");
                respuesta = sc.next();

                //Esta parte es igual a la que está fuera del bucle para que no se repitiese la bienvenida, se reproduce cuando deciden continuar con otra partida
                //Cuando deciden echarse otra no se les vuelve a pedir el nombre
                if (!respuesta.equalsIgnoreCase("no")) {
                    resetGame();
                    System.out.println("Bienvenido/as otra vez a Pasa la Calculadora, para empezar introducid un número objetivo, tendrá que ser mayor que 10 y menor que 99");

                    targetNum = getTargetNumber();
                    turn = setPlayerTurn();
                    player = nameAPlayer();
                    System.out.println("Empieza la partida, " + player +" tu objetivo es " + targetNum + "\nIntroduce un primer número del 1 al 9");
                    nextNumber = getPlayableNumber();
                    continuar = true;
                } else  {
                    continuar = false;
                    System.out.println("Gracias por jugar, hasta la próxima.");
                }
            }
        }
    }
    //Cambiar de jugador dependiendo del turno
    public static String nameAPlayer(){
        if (turn == 1) {
            return player1;
        } else {
            return player2;
        }
    }
    //Cambiar turno
    public static int setPlayerTurn (){
        if (turn == 1) {
            return turn = 2;
        }
        if (turn == 2) {
            return turn = 1;
        }
        return turn;
    }

    //Resetea los valores que nos interesan que se reseteen para volver a jugar, excluye los nombres de los jugadores.
    public static void resetGame() {
        targetNum = 0;
        previousNumber = 0;
        nextNumber = 0;
        count = 0;
        theEnd = false;
    }
    //Comprueba si alguien ha perdido
    public static boolean testEndGame() {
        //número sea valido + total y se comprobará si el igual = o mayor > que el objetivo del juego,
        if (count >= targetNum) {
            return true;
        }
        return false;
    }

    public static int getTargetNumber() {
        //Numero objetivo: Pedir un numero entre 10 y 99. Si esta  fuera de ese rango = error y se vuelve a pedir.
        //Si introduce -1 el número se generará aleatoriamente dentro del rango.

        Scanner sc = new Scanner(System.in);
        targetNum = sc.nextInt();

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
        return targetNum;
    }

    public static int getValidNumber() {
        //esta función va validar que el número seleccionado por los jugadores esté entre 1 y 9.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num < 1 || num > 9) {
            System.err.println("Ese número no es válido, introduce otro");
            num = sc.nextInt();
        }
        nextNumber = num;

        return nextNumber;
    }

    //Usa la función de verificar y suma al count si está bien
    public static int getPlayableNumber() {
        Scanner sc = new Scanner(System.in);
        getValidNumber();

        if (verifyPreviousNumber() == false){
            System.err.println("Este número no es valido, introduce otro que este en la misma columna o fila que " + previousNumber);
            nextNumber = getPlayableNumber();
        }else{
            count = count + nextNumber;
            previousNumber = nextNumber;
        }
        return nextNumber;

    }
    //Verifica que el número este en la misma fila o columna que el numero anterior
    public static boolean verifyPreviousNumber() {
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
        if (previousNumber == 0){
            return true;
        }
        return false;
    }
}

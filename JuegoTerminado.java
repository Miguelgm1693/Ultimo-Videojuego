package juegoterminado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JuegoTerminado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opciones = 0;

        while (opciones != 3) {
            System.out.println("--- RECORDATORIO ÚLTIMO JUEGO ACABADO ---");
            System.out.println("----------------- MENÚ ---------------");
            System.out.println("1. Añadir videojuego terminado \n2.Ver último juego terminado \n3. Salir ");

            opciones = Integer.parseInt(sc.nextLine());

            switch (opciones) {
                case 1:
                    System.out.println("Introduzca el nombre del videojuego");
                    String juego = sc.nextLine();

                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("juegoTerminado.txt"));

                        bw.write(juego);
                        bw.close();

                    } catch (IOException ioe) {
                        System.out.println("Se ha producido un error");
                    }

                    break;

                case 2:
                    System.out.println("---- ÚLTIMO JUEGO ACABADO ----");

                    try {
                        BufferedReader br = new BufferedReader(new FileReader("juegosTerminados.txt"));
                        String linea = "\n";
                        while (linea != null) {
                            System.out.println(linea);
                            linea = br.readLine();
                        }

                        br.close();

                    } catch (IOException ioe) {
                        System.out.println("No se ha podido leer el fichero");
                    }

                case 3:
                    break;

                default:
                    System.out.println("Introduzca la opción correcta");
                    break;

            }

        }
    }

}

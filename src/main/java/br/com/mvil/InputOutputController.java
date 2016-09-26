package br.com.mvil;

import br.com.mvil.dto.Position;

import java.util.Scanner;

/**
 * Created by iago.laguna on 26/09/2016.
 */
public class InputOutputController {



    public Position readPositionOfPlayer(String player) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        message(String.format("Jogador %s faça sua jogada",player));
        message("Insira a posição da linha");

        x = scanner.nextInt();

        message("Insira a posição da coluna");

        y = scanner.nextInt();

        message("A Linha escolhida foi: "+x+" A Coluna escolhida foi: "+y);

        return new Position(x-1,y-1);
    }


    public static void message(String message) {
        System.out.println(message);
    }
    public static void messageWithEspaces(String message) {
        System.out.println("");
        System.out.println(message);
        System.out.println("");
    }
}

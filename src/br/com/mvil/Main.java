package br.com.mvil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.init('X','O');
        int x;
        int y;
        while (!game.hasWinner()){
            game.getPositionsOfPlayer();
            System.out.println(String.format("Jogador %s faça sua jogada",game.isTurnOfPlayer1() ? "1" : "2"));
            System.out.println("Insira a posição da linha");
            x = scanner.nextInt();
            System.out.println("Insira a posição da coluna");
            y = scanner.nextInt();
            System.out.println("A Linha escolhida foi: "+x+" A Coluna escolhida foi: "+y);
            game.putPiece(x,y);
        }
        game.finalizeGame();

    }
}

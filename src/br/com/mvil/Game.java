package br.com.mvil;

/**
 * Created by Aluno on 22/09/2016.
 */
public class Game {
    public Game(){

    }

    public void init(char brandPlayer1, char brandPlayer2){
        Player p1 = new Player(brandPlayer1);
        Player p2 = new Player(brandPlayer2);
    }

    
    public void move(){}
}

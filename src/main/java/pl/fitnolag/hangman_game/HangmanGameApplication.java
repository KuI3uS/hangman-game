package pl.fitnolag.hangman_game;


import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class HangmanGameApplication {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman Game!");
        Game game = new Game("ALA MA KOTA");

        while(!game.isGameOver()){
            System.out.println(game.getDisplayedWord());
            System.out.println("enter the letter : ");
            String input = scanner.nextLine();
            if (input.length() != 1){
                System.out.println("1 letter");
                continue;
            }
            char letter = input.charAt(0);
            game.guessLetter(letter);

        }
        if (game.isWin()) {
            System.out.println("Wygrałeś!");
        } else {
            System.out.println("Przegrałeś!");
        }

    }
}

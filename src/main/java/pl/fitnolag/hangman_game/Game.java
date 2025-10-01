package pl.fitnolag.hangman_game;

import org.apache.logging.log4j.util.StringBuilders;

import java.util.Set;

public class Game {
    private String wordToGuess;
    private Set<Character> guessedLetters;   // zestaw poprawnie zgadniętych liter
    private Set<Character> wrongLetters;   // zestaw źle zgadniętych liter
    private int mistakeCount = 0;  // liczba błędnych prób
    private int maxMistakes = 7; // maksymalna liczba błędów (np. 7)
    private String displayedState;
    private boolean isGameOver;
    private boolean isWin;  // czy gra się zakończyła
    private int difficultyLevel = 1;
    private String originalText;

    public String getDisplayedWord() {
        StringBuilder result = new StringBuilder();

        for (char c : wordToGuess.toCharArray()) {
            if (c == ' '){
                result.append(" ");
            } else if (guessedLetters.contains(c)) {
                result.append(c).append(" ");
            }else {
                result.append("_ ");
            }
        }
        return result.toString();

    }
    public void guessLetter(char letter) {
       char upper = Character.toUpperCase(letter);
       if (guessedLetters.contains(upper) || wrongLetters.contains(upper)) {
           System.out.println("Już próbowałeś tej litery");
           return;

       }
       if (wordToGuess.contains(String.valueOf(upper))) {
           guessedLetters.add(upper);
           System.out.println("trafileś");
       } else {
           wrongLetters.add(upper);
           System.out.println("błąd");
           mistakeCount++;
       }
       if (mistakeCount >= maxMistakes){
           isGameOver = true;
        }
    }
}

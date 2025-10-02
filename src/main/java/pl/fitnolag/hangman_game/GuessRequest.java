package pl.fitnolag.hangman_game;

public class GuessRequest {
    private String gameId;
    private char letter;

    public String getGameId() {
        return gameId;
    }

    public char getLetter() {
        return letter;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}

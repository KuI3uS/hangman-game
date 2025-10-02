package pl.fitnolag.hangman_game;


public class GameDto {
    private String gameId;
    private String displayedWord;
    private int mistakeCount;
    private boolean isWin;
    private boolean isGameOver;

    public GameDto(String gameId, String displayedWord, int mistakeCount, boolean isWin, boolean isGameOver) {
        this.gameId = gameId;
        this.displayedWord = displayedWord;
        this.mistakeCount = mistakeCount;
        this.isWin = isWin;
        this.isGameOver = isGameOver;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getDisplayedWord() {
        return displayedWord;
    }

    public void setDisplayedWord(String displayedWord) {
        this.displayedWord = displayedWord;
    }

    public int getMistakeCount() {
        return mistakeCount;
    }

    public void setMistakeCount(int mistakeCount) {
        this.mistakeCount = mistakeCount;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}

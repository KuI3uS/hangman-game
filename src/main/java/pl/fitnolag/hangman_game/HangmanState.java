package pl.fitnolag.hangman_game;

public class HangmanState {
    private static final String[] STAGES = {
            // 0 błędów
            """
         +---+
         |   |
             |
             |
             |
             |
        =========
        """,
            // 1 błąd
            """
         +---+
         |   |
         O   |
             |
             |
             |
        =========
        """,
            // 2 błędy
            """
         +---+
         |   |
         O   |
         |   |
             |
             |
        =========
        """,
            // 3 błędy
            """
         +---+
         |   |
         O   |
        /|   |
             |
             |
        =========
        """,
            // 4 błędy
            """
         +---+
         |   |
         O   |
        /|\\  |
             |
             |
        =========
        """,
            // 5 błędów
            """
         +---+
         |   |
         O   |
        /|\\  |
        /    |
             |
        =========
        """,
            // 6 błędów
            """
         +---+
         |   |
         O   |
        /|\\  |
        / \\  |
             |
        =========
        """,
    };

    public static void printStage(int mistakeCount) {
        if (mistakeCount < STAGES.length) {
            System.out.println(STAGES[mistakeCount]);
        } else {
            System.out.println(STAGES[STAGES.length - 1]);
        }
    }
}

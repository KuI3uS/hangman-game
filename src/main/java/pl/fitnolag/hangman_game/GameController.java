package pl.fitnolag.hangman_game;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/game")
public class GameController {

    Map<String, Game> games = new HashMap<>();
    private static final List<String> WORDS = List.of(
            "ALA MA KOTA",
            "JAVA JEST SUPER",
            "WISIELEC",
            "PROGRAMOWANIE"
    );

    @GetMapping("/start")
    public GameDto startGame() {
        String word = "ALA MA KOTA";
        Game game = new Game(word);

        String gameId = UUID.randomUUID().toString();
        games.put(gameId, game);

        return new GameDto(
                gameId,
                game.getDisplayedWord(),
                game.getMistakeCount(),
                game.isWin(),
                game.isGameOver()
        );
    }
    @PostMapping("/guess")
    public GameDto guessLetter(@RequestBody GuessRequest req) {
        // znajdź grę po ID
        Game game = games.get(req.getGameId());
        if (game == null) {
            throw new RuntimeException("Game not found");
        }
        game.guessLetter(req.getLetter());
        // wykonaj guessLetter()
        return new GameDto(
                req.getGameId(),
                game.getDisplayedWord(),
                game.getMistakeCount(),
                game.isWin(),
                game.isGameOver()
        );
    }
    @PostMapping("/reset")
    public GameDto resetGame(@RequestBody ResetRequest req) {
        // znajdź grę po ID
        Game game = games.get(req.getGameId());
        if ( game == null){
            throw new RuntimeException("Game not found");}

        // zresetuj stan gry
        int index = ThreadLocalRandom.current().nextInt(WORDS.size());
        String word = WORDS.get(index);
        game.reset(word);
        // zwróć aktualny stan jako GameDto
        return new GameDto(
                req.getGameId(),
                game.getDisplayedWord(),
                game.getMistakeCount(),
                game.isWin(),
                game.isGameOver()
        );
    }
    @GetMapping("/{id}")
    public GameDto getGame(@PathVariable String id) {
        // 1. znajdź grę po ID
        Game game = games.get(id);
        if (game == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
        // 2. jeśli brak → rzuć wyjątek
        return new GameDto(
                id,
                game.getDisplayedWord(),
                game.getMistakeCount(),
                game.isWin(),
                game.isGameOver()
        );

        // 3. jeśli jest → zwróć GameDto z aktualnym stanem

    }
}

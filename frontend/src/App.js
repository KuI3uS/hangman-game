import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [game, setGame] = useState(null);
    const [letter, setLetter] = useState("");

  useEffect(() => {
    axios.get("/game/start")
        .then(res => {
          setGame(res.data);
        })
        .catch(err => {
          console.error("Błąd połączenia z backendem:", err);
        });
  }, []);

  if (!game) return <p>Ładowanie gry...</p>;

    const handleGuess = () => {
        if (!letter || letter.length !== 1) {
            alert("Wpisz dokładnie jedną literę.");
            return;
        }

        axios.post("/game/guess", {
            gameId: game.gameId,
            letter: letter
        })
            .then(res => {
                setGame(res.data);   // aktualizuje stan gry
                setLetter("");       // czyści pole input
            })
            .catch(err => {
                console.error("Błąd przy zgadywaniu:", err);
            });
    };
  return (
      <div>
          <h1>Hangman Game</h1>
          <p>Word: {game.displayedWord}</p>
          <p>Mistakes: {game.mistakeCount}</p>
          <input
              type="text"
              value={letter}
              maxLength={1}
              onChange={(e) => setLetter(e.target.value.toUpperCase())}
          />
          <button onClick={handleGuess}>Zgadnij</button>
      </div>

  );
}

export default App;
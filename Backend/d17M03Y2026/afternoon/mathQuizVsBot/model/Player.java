package d17M03Y2026.afternoon.mathQuizVsBot.model;

// Classe per memorizzare le informazioni e il punteggio del giocatore
public class Player {
    private double playerAnswer; // Risposta inserita dal giocatore per un quesito
    private int scorePlayer = 0; // Punteggio accumulato dal giocatore, inizializzato a 0

    // Costruttore vuoto
    public Player() {}

    // Costruttore parametrizzato per inizializzare risposta e punteggio
    public Player(double playerAnswer, int scorePlayer) {
        this.playerAnswer = playerAnswer;
        this.scorePlayer = scorePlayer;
    }

    // Incrementa lo score del giocatore di 1 punto
    public void increasePlayerScore(){
        this.scorePlayer++;
    }

    // Resetta lo score del giocatore a 0
    public void resetPlayerScore(){
        this.scorePlayer = 0;
    }

    // Getter e Setter
    public double getPlayerAnswer() { return this.playerAnswer; } // Restituisce ultima risposta
    public void setPlayerAnswer(double playerAnswer) { this.playerAnswer = playerAnswer; } // Imposta risposta

    public int getScorePlayer() { return this.scorePlayer; } // Restituisce punteggio
    public void setScorePlayer(int scorePlayer) { this.scorePlayer = scorePlayer; } // Imposta punteggio
}
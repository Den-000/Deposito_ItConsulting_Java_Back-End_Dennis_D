package mathQuizVsBot.model;

public class Bot {
    private int difficultySelected; // Difficoltà selezionata
    private double botAnswer;        // Risposta del bot
    private boolean willItGuess;     // Se il bot risponde correttamente
    private int scoreBot = 0;        // Punteggio bot

    // Bot risponde a una domanda
    public void giveTheAnswer(int botDifficultySelected, double correctAnswer){
        calculateIfItWillGuess(botDifficultySelected); // decide se rispondere correttamente
        if (this.willItGuess == true) {
            this.botAnswer = correctAnswer;
        } else {
            this.botAnswer = generateWrongAnswer();
        }
    }

    // Genera risposta errata casuale fra -100.0 e 100.0
    public double generateWrongAnswer(){
        return ((Math.floor(Math.random() * 2001 - 1000))/10);
    }

    // Decide se il bot risponderà correttamente in base alla difficoltà
    public void calculateIfItWillGuess(int botDifficultySelected){
        int probabilityOfGuessing = (int)(Math.random() * 4) + 1;
        switch (botDifficultySelected) {
            case 1: 
                if (probabilityOfGuessing == 1) {
                    this.willItGuess = true;
                }
                break;
            case 2: 
                if (probabilityOfGuessing <= 2) {
                    this.willItGuess = true;
                }
                break;
            case 3: 
                if (probabilityOfGuessing != 4) {
                    this.willItGuess = true;
                }
                break;
            default: 
                break;
        }
    }

    // Incrementa lo score del bot
    public void increaseBotScore(){ this.scoreBot++; }

    // Resetta lo score
    public void resetBotScore(){ this.scoreBot = 0; }

    // Costruttori
    public Bot() { }
    public Bot(int difficultySelected) { this.difficultySelected = difficultySelected; }
    public Bot(int difficultySelected, double botAnswer, boolean willItGuess, int scoreBot) {
        this.difficultySelected = difficultySelected;
        this.botAnswer = botAnswer;
        this.willItGuess = willItGuess;
        this.scoreBot = scoreBot;
    }

    // Getter e Setter
    public int getDifficultySelected() { return this.difficultySelected; }
    public void setDifficultySelected(int difficultySelected) { this.difficultySelected = difficultySelected; }
    public double getBotAnswer() { return this.botAnswer; }
    public void setBotAnswer(double botAnswer) { this.botAnswer = botAnswer; }
    public boolean getWillItGuess() { return this.willItGuess; }
    public void setWillItGuess(boolean willItGuess) { this.willItGuess = willItGuess; }
    public int getScoreBot() { return this.scoreBot; }
    public void setScoreBot(int scoreBot) { this.scoreBot = scoreBot; }
}
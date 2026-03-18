package mathQuizVsBot.controller;

import mathQuizVsBot.model.*;
import mathQuizVsBot.utility.*;
import mathQuizVsBot.view.*;

public class Main {
    public static void main(String[] args) {
        boolean loop = true; // Ciclo principale del programma
        int choice;          // Scelta del menu
        @SuppressWarnings("unused")
        int gameDifficultySelected = 1; // Difficoltà iniziale (non ancora implementata)

        while (loop == true){
            View.showMenu(); // Mostra menu principale
            View.print("Opzione scelta: \n");
            choice = Utility.askInt(); // Legge scelta utente

            switch(choice){
                // *DA IMPLEMENTARE "2) Opzioni" → possibilità di impostare difficoltà delle domande e del bot*
                case 1:
                    // Inizializza nuovo game
                    Game gameObj = new Game();
                    Player playerObj = new Player();
                    Bot botObj = new Bot(1); // Bot con difficoltà 1 (Facile)

                    View.print("\n\n");
                    View.print("loading");
                    View.loading(); // Animazione
                    View.print("\n\n");

                    View.separationBarAndLineBreak();
                    View.gameMasterIntro(); // Introduzione
                    for(int i = 1; i <= 10; i++){ // Ciclo 10 round
                        View.printRoundNumber(i);
                        View.print(gameObj.generatesQuestion()); // Genera e stampa domanda
                        gameObj.calculateCorrectAnswer(); // Calcola risultato corretto

                        // Chiede risposta all'utente
                        playerObj.setPlayerAnswer(Utility.askDouble());
                        View.print("\n");

                        // Genera risposta del bot
                        botObj.giveTheAnswer(botObj.getDifficultySelected(), gameObj.getCorrectAnswer());
                        View.print("Bot: \"Per me il risultato è ".concat(Double.toString(botObj.getBotAnswer())).concat(" !\"\n\n"));

                        // Stampa risposta corretta
                        View.print("La risposta corretta era");
                        View.loading();
                        View.print(" " + Double.toString(gameObj.getCorrectAnswer()));
                        View.print("\n");

                        // Determina vincitore round e aggiorna punteggio
                        if (playerObj.getPlayerAnswer() == gameObj.getCorrectAnswer() && botObj.getBotAnswer() == gameObj.getCorrectAnswer()) {
                            View.print("Il round si conclude con un pareggio. \n(Nessuno guadagna punto)\n");
                        } else if(playerObj.getPlayerAnswer() == gameObj.getCorrectAnswer()){
                            View.print("Il round si conclude la tua vittoria!\n");
                            playerObj.increasePlayerScore();
                        } else if(botObj.getBotAnswer() == gameObj.getCorrectAnswer()){
                            View.print("Il round si conclude la vittoria del bot!\n");
                            botObj.increaseBotScore();
                        } else{
                            View.print("Il round si conclude con la vittoria di nessuno.\n");
                        }
                        View.separationBarAndLineBreak();
                    }

                    // Determina vincitore della partita
                    if(playerObj.getScorePlayer() == botObj.getScoreBot()) {
                        View.print("La parita si conclude in pareggio! \nGrazie per aver giocato <3\n\n");
                    } else if(playerObj.getScorePlayer() > botObj.getScoreBot()) {
                        View.print("La parita si conclude con la tua vittoria! \nGrazie per aver giocato <3\n\n");
                    } else{
                        View.print("La parita si conclude con la vittoria del bot! \nGrazie per aver giocato <3\n\n");
                    }
                    break;

                case 2:
                    View.print("Arrivederci!"); // Esci dal gioco
                    loop = false;
                    break;

                default:
                    break;
            }
        }
    }
}
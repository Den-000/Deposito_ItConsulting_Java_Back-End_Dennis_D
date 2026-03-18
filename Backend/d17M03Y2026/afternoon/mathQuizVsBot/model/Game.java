package d17M03Y2026.afternoon.mathQuizVsBot.model;

public class Game {
    private double firstNumber; // Primo numero dell'operazione
    private double secondNumber; // Secondo numero
    private int arithmeticOperationIndex; // 1=add, 2=sub, 3=mul, 4=div
    private String arithmeticOperation; // Simbolo dell'operazione
    private double correctAnswer; // Risultato corretto

    // Calcola il risultato corretto in base all'operazione
    public void calculateCorrectAnswer(){
        switch(arithmeticOperationIndex){
            case 1: 
                this.correctAnswer = Math.round((this.firstNumber + this.secondNumber) * 100.0) / 100.0;
                break;
            case 2: 
                this.correctAnswer = Math.round((this.firstNumber - this.secondNumber) * 100.0) / 100.0;
                break;
            case 3: 
                this.correctAnswer = Math.round((this.firstNumber * this.secondNumber) * 100.0) / 100.0;
                break;
            case 4: 
                this.correctAnswer = Math.round((this.firstNumber / this.secondNumber) * 100.0) / 100.0;
                break;
        }
    }

    // Genera la stringa con la domanda da proporre
    public String generatesQuestion(){

        // Sceglie casualmente operazione
        this.arithmeticOperationIndex = (int)(Math.random() * 4) + 1;

        switch(arithmeticOperationIndex){
            case 1: // Addizione
                this.arithmeticOperation = "+";
                this.firstNumber = (Math.floor(Math.random() * 2001 - 1000))/10;
                this.secondNumber = (Math.floor(Math.random() * 2001 - 1000))/10;
                break;
            case 2: // Sottrazione
                this.arithmeticOperation = "-";
                this.firstNumber = (Math.floor(Math.random() * 2001 - 1000))/10;
                this.secondNumber = (Math.floor(Math.random() * 2001 - 1000))/10;
                break;
            case 3: // Moltiplicazione
                this.arithmeticOperation = "*";
                this.firstNumber = Math.floor(Math.random() * 201 - 100);
                this.secondNumber = Math.floor(Math.random() * 201 - 100);
                break;
            case 4: // Divisione
                this.arithmeticOperation = "/";
                this.firstNumber = Math.floor(Math.random() * 21 - 10);
                this.secondNumber = Math.floor(Math.random() * 21 - 10);
                if (this.secondNumber == 0) { // evita divisione per zero
                    while(this.secondNumber == 0){
                        this.secondNumber = Math.floor(Math.random() * 21 - 10);
                    }
                }
                break;
        }

        // Restituisce la domanda come stringa
        String question = "Quanto fa " + Double.toString(firstNumber) + " " + arithmeticOperation + " " + Double.toString(secondNumber) + "?\n";
        return question;
    }

    // Costruttori
    public Game() { }
    public Game(double firstNumber, double secondNumber, int arithmeticOperationIndex) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.arithmeticOperationIndex = arithmeticOperationIndex;
        calculateCorrectAnswer();
    }
    public Game(double firstNumber, double secondNumber, int arithmeticOperationIndex, String arithmeticOperation, double correctAnswer) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.arithmeticOperationIndex = arithmeticOperationIndex;
        this.arithmeticOperation = arithmeticOperation;
        this.correctAnswer = correctAnswer;
    }

    // Getter e Setter per tutte le proprietà
    public double getFirstNumber() { return this.firstNumber; }
    public void setFirstNumber(double firstNumber) { this.firstNumber = firstNumber; }
    public double getSecondNumber() { return this.secondNumber; }
    public void setSecondNumber(double secondNumber) { this.secondNumber = secondNumber; }
    public int getArithmeticOperationIndex() { return this.arithmeticOperationIndex; }
    public void setArithmeticOperationIndex(int arithmeticOperationIndex) { this.arithmeticOperationIndex = arithmeticOperationIndex; }
    public String getArithmeticOperation() { return this.arithmeticOperation; }
    public void setArithmeticOperation(String arithmeticOperation) { this.arithmeticOperation = arithmeticOperation; }
    public double getCorrectAnswer() { return this.correctAnswer; }
    public void setCorrectAnswer(double correctAnswer) { this.correctAnswer = correctAnswer; }
}
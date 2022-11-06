package domain;

public class Game {
    private BaseballNumbers computerNumbers;
    private BaseballNumbers userNumbers;

    public void createComputerNumbers(){
        this.computerNumbers = BaseballNumbers.getComputerNumbers();
    }

    public void setUserNumbers(String inputNumbers){
        userNumbers = BaseballNumbers.getUserNumbers(inputNumbers);
    }

    public RoundResult getRoundResult(){
        return computerNumbers.compareTo(userNumbers);
    }
}

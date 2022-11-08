package baseball.computer.entity;

public class Computer {
    private final int NUMBER_LENGTH = 3;

    protected Integer randomNumber;

    public final Integer[] computerNumbers;

    public Computer(){
        this.computerNumbers = new Integer[NUMBER_LENGTH];
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber){
        this.randomNumber = randomNumber;
    }

    public String getComputerNumbers(){
        StringBuilder sb = new StringBuilder();
        for(Integer e : computerNumbers){
            sb.append(e);
        }

        return sb.toString();
    }

}

package baseball;

public class Game {

    private InputNumber inputNumber;
    private AnswerNumber answerNumber;

    private int strike;
    private int ball;


    public Game(){
        inputNumber = new InputNumber();
        answerNumber = new AnswerNumber();

        strike = 0;
        ball = 0;
    }


}

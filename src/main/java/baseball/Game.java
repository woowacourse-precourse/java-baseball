package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private InputNumber inputNumber;
    private AnswerNumber answerNumber;

    private List<String> inputNumberList;
    private List<String> answerNumberList;

    private int strike;
    private int ball;


    public Game(){
        inputNumber = new InputNumber();
        answerNumber = new AnswerNumber();

        inputNumberList = new ArrayList<>();
        answerNumberList = new ArrayList<>();

        strike = 0;
        ball = 0;
    }

    public void playGame(){
        System.out.println("게임을 시작합니다.");
        answerNumber.RandomNumber();
        answerNumberList = answerNumber.getAnswerNumberList();
        do{
            inputNumber.userInputNumber();
            inputNumberList.add(inputNumber.getUserNumber());
            strike = 0;
            ball = 0;
            getScore();
            getHintMessage();
            inputNumberList.clear();
        }while(!getWin());
        System.out.println("3개의 숫자를 모두 맞히셨습니다!. 게임종료");
    }


    public void getScore(){
        String input = inputNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String answer = answerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        for (int i = 0; i<4; i++){
            int index = input.indexOf(answer.charAt(i));
            if(index == i){
                strike++;
            }
            if(index != -1){
                ball++;
            }
        }
    }

    public void getHintMessage(){
        if(ball > 0){
            System.out.println(ball + "볼");
        }
        if(strike > 0){
            System.out.println(strike + "스트라이크");
        }
        if(ball + strike == 0){
            System.out.println("낫싱");
        }
        System.out.println();
    }

    public boolean getWin(){
        return strike == 3;
    }






}

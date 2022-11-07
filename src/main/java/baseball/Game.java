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

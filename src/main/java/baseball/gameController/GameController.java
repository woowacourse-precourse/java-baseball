package baseball.gameController;

import baseball.Random.NumberGenerator;
import baseball.utils.UserInput;
import baseball.utils.UserOutput;

public class GameController {
    private String userInput;
    private Boolean userAnswer;
    public GameController(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public Boolean play(){
        String answer = NumberGenerator.generateAnswerNumber();


        try{
            do{
                userInput = UserInput.input();
            }
            while (!isThreeStrike(answer, userInput));

            userAnswer = afterPlaying();
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
        return userAnswer;
    }

    private static Boolean afterPlaying(){
        String userInput = UserInput.endInput();

        if (userInput.equals("1")){
            return true;
        }
        return false;
    }

    private static Boolean isThreeStrike(String answer, String user){
        int[] count = countStrikeBall(answer, user);
        int ball = count[0], strike = count[1];

        UserOutput.printResult(ball, strike);

        return strike == 3;
    }

    private static int[] countStrikeBall(String answer, String user){
        int ball = 0, strike = 0;

        for (int i=0; i<3; i++){
            if (answer.charAt(i) == user.charAt(i))
                strike++;
            else if (answer.contains(user.subSequence(i,i+1))){
                ball++;
            }
        }
        return new int[]{ball, strike};
    }


}

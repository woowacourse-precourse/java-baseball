/*
 * NumberBaseball.java
 * written by Dohoon Gwak
 * latest modification time: 2022.11.08
 */
package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseball {
    private List<Integer> CorrectAnswer;

    public List<Integer> getAnswer(){
        return CorrectAnswer;
    }

    public void setAnswer(int first, int second, int third){
        CorrectAnswer.set(0, first);
        CorrectAnswer.set(1, second);
        CorrectAnswer.set(2, third);
    }

    public NumberBaseball(){ // generate answer by Randoms library
        int temp;
        CorrectAnswer = new ArrayList<Integer>();
        // initialize first
        CorrectAnswer.add(Randoms.pickNumberInRange(0, 9));
        for (int i = 0; i < 2; i++){ // initialize the rest
            do {
                temp = Randoms.pickNumberInRange(0, 9);
            } while(CorrectAnswer.contains(temp));
            CorrectAnswer.add(temp);
        }
    }

    public void playBall(){
        int[] MyAnswer = new int[3];
        String input;

        do { // repeat until victory(3 strike)
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            // check the input value
            if (checkInput(input)){
                // convert numbers from Ascii to integer value
                MyAnswer[0] = input.charAt(0) - 48;
                MyAnswer[1] = input.charAt(1) - 48;
                MyAnswer[2] = input.charAt(2) - 48;
            } else { // wrong input, throw exception
                throw new IllegalArgumentException();
            }
        } while (!judgeBall(MyAnswer));//repeat until victory

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean checkInput(String input){
        // get String as an input
        // length check
        if (input.length() >= 4){
            return false;
        }
        // ascii value check
        for (int i = 0; i < 3; i++){
            if ((input.charAt(i) < 48)
                    || (input.charAt(i) > 57)){
                return false;
            }
        }
        return true;
    }

    public boolean judgeBall(int[] MyAnswer){
        int StrikeCount = countStrike(MyAnswer);
        int BallCount = countBall(MyAnswer);
        // exclude intersection.
        BallCount -= StrikeCount;
        // evaluate the result and print message
        if (StrikeCount == 3){
            System.out.println("3스트라이크");
            return true;
        } else if (StrikeCount == 0 && BallCount == 0){
            System.out.println("낫싱");
            return false;
        } else {
            System.out.println(BallCount+"볼 "+StrikeCount+"스트라이크");
            return false;
        }
    }

    public int countStrike(int[] MyAnswer){
        int result = 0;
        for (int i = 0; i < 3; i++){
            if(MyAnswer[i] == CorrectAnswer.get(i)){
                result++;
            }
        }
        return result;
    }

    public int countBall(int[] MyAnswer) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (CorrectAnswer.contains(MyAnswer[i])) {
                result++;
            }
        }
        return result;
    }
}

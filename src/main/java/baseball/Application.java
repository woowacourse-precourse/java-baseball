package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {


    private static boolean checkRepeate(){
        boolean isRepeate = true;

        System.out.println("Repeat game:1, End game:2 ");

        String input = readLine();

        if(input.equals("1")){
            isRepeate = true;
        } else if(input.equals("2")){
            isRepeate = false;
        } else{
            throw new IllegalArgumentException("Wrong input");
        }

        return isRepeate;
    }

    private static String makeAnswer(){

        List<Integer> answerList = new ArrayList<>();
        while(answerList.size()<3){
            int tempNum = pickNumberInRange(1, 9);
            if(!answerList.contains(tempNum)) answerList.add(tempNum);
        }

        String answer = answerList.toString().replaceAll("[^0-9]","");
        System.out.println(answer);
        return answer;
    }

    private static boolean checkDuplicateNum(String input){
        boolean isDuplicate = false;

        if(input.substring(1,3).contains(input.substring(0,1))){
            isDuplicate = true;
        }
        if(input.substring(0,2).contains(input.substring(2,3))){
            isDuplicate=true;
        }

        return isDuplicate;
    }

    private static void checkException(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("Wrong length");
        }
        if(!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException("Input must be number");
        }
        if(checkDuplicateNum(input)){
            throw new IllegalArgumentException("Input can't duplicate");
        }
    }

    private static int calStrike(String answer, String input){
        int strike = 0;

        for(int i=0; i<3; i++){
            if(answer.charAt(i) == input.charAt(i)) strike++;
        }

        return strike;
    }

    private static int calBall(String answer, String input){
        int ball = 0;

        for(int i=0; i<3; i++){
            if(answer.contains(input.substring(i,i+1))) ball++;
        }

        return ball;
    }

    private static void printResult(int strike, int ball){
        ball = ball - strike;
        String result = "";

        if (strike+ball == 0){
            result = "nothing";
        }
        else {
            if(ball>0){
                result += ball + "ball ";
            }
            if(strike>0){
                result += strike + "strike ";
            }
        }

        System.out.println(result);
    }


    private static void playBaseball(String answer){
        String input;
        int strike = 0;
        int ball = 0;

        while(strike < 3){
            System.out.print("Input number: ");
            input = readLine();

            checkException(input);

            strike = calStrike(answer, input);
            ball = calBall(answer, input);

            printResult(strike, ball);
        }

        System.out.println("You correct 3 numbers! ");
    }


    public static void main(String[] args) {
        String answer;

        System.out.println("Start Baseball Game!");
        try{
            do {
                answer = makeAnswer();
                playBaseball(answer);

            } while(checkRepeate());

        } catch(IllegalArgumentException e){
            System.out.println(e);
        }
        System.out.println("게임 종료");
    }
}

package baseball.Controller;

import baseball.model.Baseball;
import baseball.view.Printer;
import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Executor {
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    private static Computer computer;
    private static BaseballResult result;
    private static Checker checker = new Checker();
    private static boolean flag = true;
    public static void startGame(){
        Baseball computerRandomBaseball = new Computer().createRandomBaseball();
        Printer.gameStart();
        while(flag){
            Printer.inputNumber();
            result = guessNumber(computerRandomBaseball);
            if(result.isAllCorrect()){
                String resultString = result.getResult();
                System.out.println(resultString);
                Printer.allCorrect();
                askRestart();
            }else{
                String resultString = result.getResult();
                System.out.println(resultString);
            }
        }
    }
    public static BaseballResult guessNumber(Baseball computerRandomBaseBall){
        Baseball userBaseball = inputUserBaseball();
        HashMap<String, Integer> check_result = checker.start(computerRandomBaseBall, userBaseball);
        BaseballResult baseballResult = new BaseballResult(check_result);
        return baseballResult;
    }
    public static Baseball inputUserBaseball(){
        User user = new User();
        Baseball userBaseball = user.getInput();
        return userBaseball;
    }

    public static void askRestart(){
        Printer.askRestart();
        String s = Console.readLine();
        int reStart = Integer.valueOf(s);
        if(reStart == RESTART){
            startGame();
        }else if(reStart != EXIT){
            askRestart();
        }else{
            flag = false;
        }
    }
}

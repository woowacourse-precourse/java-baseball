package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.util.Message;
import baseball.util.NumberNaming;
import baseball.view.SystemOutput;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseBallGame {

    ComputerNumber computerNumber = new ComputerNumber();
    public void start() {
        List<Integer> Computer = computerNumber.getComputerRandomNumber();
        while(true){
            String inputNumber = SystemOutput.printUserInput();
            UserNumber userNumber = new UserNumber(inputNumber);
            List<Integer> userNumberList = UserNumber.getUserNumber(inputNumber);

            if(getResult(userNumberList, Computer) == 3)
                break;
        }
        String input = Console.readLine();

        if(Integer.parseInt(input) == NumberNaming.RE_START_GAME){
            start();
        }
    }
    public int getResult(List<Integer> user,List<Integer> computer){

        int total = ballCount(user, computer);
        int strike = strikeCount(user, computer);
        int ball = total - strike;

        if(strike == 3){
            SystemOutput.printThreeStrikeMessage();
            return strike;
        }

        SystemOutput.printResultMessage(ball, strike);
        return strike;
    }

    public int ballCount(List<Integer> user, List<Integer> computer){
        int ball = 0;
        for(int i = 0; i < computer.size(); i++){
            if(computer.contains(user.get(i))){
                ball++;
            }
        }
        return ball;
    }

    public int strikeCount(List<Integer> user, List<Integer> computer){
        int strike = 0;
        for(int i = 0; i < user.size(); i++){
            if(computer.get(i) == user.get(i)){
                strike++;
            }
        }
        return strike;
    }

}

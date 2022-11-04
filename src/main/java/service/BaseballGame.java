package service;

import camp.nextstep.edu.missionutils.Console;
import data.ComputerData;
import data.UserData;
import repository.ComputerRepository;
import repository.UserRepository;
import util.Utils;

import java.util.List;

public class BaseballGame {

    private ComputerRepository computerRepository;
    private UserRepository userRepository;
    private int strike;
    private int ball;

    public void init() throws IllegalArgumentException {
        try {
            ComputerData computerData = new ComputerData();
            computerRepository = new ComputerRepository(computerData);
            computerRepository.setRandomNum();
            getUserInput();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    //유저 입력 받기
    private void getUserInput() throws IllegalArgumentException{
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        strike=0;
        ball=0;
        System.out.println(Utils.INPUTNUMBER);
        try{
            String userinput= Console.readLine();
            userRepository.inputanswer(userinput);
            countBallAndStrike();
            printResult();
            return;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    //볼이랑 스트라이크 개수 구하기
    private void countBallAndStrike() {
        List<Integer> user = userRepository.getUserData();
        int index = 1;
        for (int i = 0; i < Utils.Numlen; i++) {
            if (computerRepository.getDataIndex(user.get(i)) == index) {
                strike++;
            } else if (computerRepository.getDataIndex(user.get(i)) != 0) {
                ball++;
            }
            index++;
        }
    }

    //결과 출력 메서드
    private void printResult(){;
        String msg="";
        if(ball==0&&strike==0){
            msg+=Utils.NOBALLANDNOSTRIKE;
        }
        if(ball!=0){
            msg+=ball+Utils.BALL;
        }
        if(strike!=0){
            msg+=strike+Utils.STRIKE;
        }
        if(checkResult()){
            System.out.println(msg);
            System.out.println(Utils.ALLSTRIKE);
            checkRestart();
        }
        else {
            System.out.println(msg);
            getUserInput();
        }
    }

    //정답인지 확인
    private boolean checkResult(){
        if(strike==3) {
            return true;
        }
        return false;
    }

    //재시작 할지 확인
    private void checkRestart(){
        System.out.println(Utils.RESTARTQUESTION);
        String restart= Console.readLine();
        if(restart.equals("1"))
            init();
        else if(restart.equals("2"))
            return;
    }
}

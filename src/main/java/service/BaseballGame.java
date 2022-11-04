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
            getuserinput();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    //유저 입력 받기
    private void getuserinput() throws IllegalArgumentException{
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        strike=0;
        ball=0;
        System.out.println(Utils.INPUTNUMBER);
        try{
            String userinput= Console.readLine();
            userRepository.inputanswer(userinput);
            countBallAndStrike();
            return;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

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
}

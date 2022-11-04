package service;

import camp.nextstep.edu.missionutils.Console;
import data.ComputerData;
import data.UserData;
import repository.ComputerRepository;
import repository.UserRepository;
import util.Utils;

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
            return;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}

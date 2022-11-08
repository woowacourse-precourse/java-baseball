package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.HitStatus.*;
import static baseball.Validation.validate;

public class BaseBallGame {
    private List<Integer> computer;
    private List<Integer> player;
    private List<HitStatus> stepResult;

    private void initComputer(){
        computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNum)){
                computer.add(randomNum);
            }
        }
    }

    private void initPlayer(){
        player = new ArrayList<>(Arrays.asList(0,0,0));
    }

    private void initFirstMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void initGame(){
        initComputer();
        initPlayer();
        initFirstMessage();
    }

    private void initPlayerInput(){
        System.out.println("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        validate(number);

        for(int i = 0; i < number.length(); i++){
            player.set(i,Integer.parseInt(String.valueOf(number.charAt(i))));
        }
    }

    private void initStepResult(){
        stepResult = new ArrayList<>(Arrays.asList(NOTHING, NOTHING, NOTHING));
    }

    private boolean checkIsStrike(int index, int value){
        return computer.get(index) == value;
    }

    private boolean checkIsBall(int index, int value){
        return stepResult.get(index) != STRIKE && computer.contains(value);
    }

    private void doHit(){
        for(int i = 0; i < 3; i++){
            int currentPlayerNumber = player.get(i);

            if(checkIsStrike(i,currentPlayerNumber)){
                stepResult.set(i,STRIKE);
            }
            if(checkIsBall(i,currentPlayerNumber)){
                stepResult.set(i,BALL);
            }
        }
    }

    private Map<HitStatus, Integer> countHitStatus(){
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for(int i = 0; i < 3; i++){
            if(stepResult.get(i) == STRIKE){
                strike++;
            }
            else if(stepResult.get(i) == BALL){
                ball++;
            }
            else{
                nothing++;
            }
        }
        Map<HitStatus, Integer> result = new HashMap<>();
        result.put(STRIKE, strike);
        result.put(BALL, ball);
        result.put(NOTHING,nothing);
        return result;
    }

    private boolean playerContinueGame(){
        boolean continueGame;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();

        if(playerInput.contains("1")){
            continueGame = true;
        }
        else if(playerInput.contains("2")){
            continueGame = false;
        }
        else{
            throw new IllegalArgumentException();
        }

        return continueGame;
    }

    private boolean checkBallType(){
        boolean threeStrike;
        Map<HitStatus, Integer> result = countHitStatus();

        if(result.get(STRIKE) != 0){

        }
        if(result.get(BALL) != 0){

        }
        if(result.get(NOTHING) == 3){

        }

        return true;
    }

    private boolean judgeResult(){
        boolean continueGame;
        if(checkBallType()){
            boolean wantContinueGame = playerContinueGame();
            if(wantContinueGame == true){
                continueGame = true;
                initGame();
            }
            else{
                continueGame = false;
            }
        }
        else{
            continueGame = true;
        }
        return continueGame;
    }

    public void play(){
        initGame();

        while(true){
            initPlayerInput();
            initStepResult();
            doHit();

            if(judgeResult() == false){
                System.out.println("게임 종료");
                break;
            }
        }
    }
}

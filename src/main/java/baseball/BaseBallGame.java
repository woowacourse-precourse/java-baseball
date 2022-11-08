package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.GameStatus.*;
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
        System.out.print("숫자를 입력해주세요 : ");
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
        result.put(NOTHING, nothing);
        return result;
    }

    private boolean playerContinueGame(){
        boolean continueGame;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();

        if(playerInput.equals(START.getCode())){
            continueGame = true;
        }
        else if(playerInput.equals(END.getCode())){
            continueGame = false;
        }
        else{
            throw new IllegalArgumentException();
        }

        return continueGame;
    }

    private boolean checkBallType(){
        boolean threeStrike = false;
        List<String> playerResult = new ArrayList<>();
        Map<HitStatus, Integer> result = countHitStatus();

        if(result.get(BALL) != 0){ // 볼이 1개 이상 있음
            playerResult.add(result.get(BALL) + BALL.getName());
        }

        if(result.get(STRIKE) != 0){ // 스트라이크가 1개이상 있음
            playerResult.add(result.get(STRIKE) + STRIKE.getName());
            if(result.get(STRIKE) == 3){
                threeStrike = true;
                playerResult.add("\n3개의 숫자을 모두 맞히셨습니다! 게임 종료");
            }
        }

        if(result.get(NOTHING) == 3){ // 3자리 다 틀림
            playerResult.add(NOTHING.getName());
        }

        System.out.println(String.join(" ", playerResult));
        return threeStrike;
    }

    private boolean judgeResult(){
        boolean continueGame;
        boolean isThreeStrike = checkBallType();
        if(isThreeStrike){ // 3스트라이크일 경우
            boolean wantContinueGame = playerContinueGame();
            if(wantContinueGame == true){ // 게임 계속하길원함
                continueGame = true;
                initGame();
            }
            else{ // 게임 종료
                continueGame = false;
            }
        }
        else{ // 3스트라이크가 아님
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

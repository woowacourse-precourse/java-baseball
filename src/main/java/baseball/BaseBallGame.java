package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Validation.validate;
import static baseball.HitStatus.NOTHING;

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

    public void play(){
        initComputer();
        initPlayer();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            initPlayerInput();
            initStepResult();
            break;
        }
    }
}

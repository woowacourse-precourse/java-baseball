package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

import static baseball.Constants.*;

public class Game {
    private Computer computer;
    private Player player;
    private List<Integer> computerNumbers;
    public Game(){
        computer = new Computer();
        player = new Player();
    }
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        getComputerNumbers();
        guessNumbers();
    }

    public boolean replay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userReplayInput = Console.readLine();
        Validate.validateReplay(userReplayInput);
        return userReplayInput.equals("1");

    }
    public void getComputerNumbers(){
        computer.selectNumbers();
        computerNumbers = computer.getSelectedNum();
    }

    public void guessNumbers(){
        String playerNumber;
        do{
            player.selectNumber();
            playerNumber = player.getSelectedNumber();
            Validate.validateInputNumber(playerNumber);
        }
        while(judge(playerNumber));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean judge(String num){
        int cntBall=0;
        int cntStrike = 0;
        for(int i=0;i<INPUT_SIZE;i++){
            int cur = num.charAt(i)-'0';
            if(cur == computerNumbers.get(i)){
                cntStrike++;
            }
            else if(computerNumbers.contains(cur)){
                cntBall++;
            }
        }
        printJudgeResult(cntBall,cntStrike);
        return(cntStrike!=3);

    }
    public void printJudgeResult(int cntBall, int cntStrike){
        if(cntBall+cntStrike==0){
            System.out.println("낫싱");
        }
        else if(cntBall==0){
            System.out.println(cntStrike+"스트라이크");
        }
        else if(cntStrike==0){
            System.out.println(cntBall+"볼");
        }
        else{
            System.out.println(cntBall+"볼 "+cntStrike+"스트라이크");
        }
    }

}

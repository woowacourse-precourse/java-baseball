package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class GameSet {
    private List<Integer> computerAnswer;
    private List<Integer> userAnswer;
    private Integer strikeCount;
    private Integer ballCount;

    //
    public GameSet() {
        setComputerAnswer();
    }
    //랜덤으로 3자리수 숫자 만들어주는 함수
    public void setComputerAnswer(){
        computerAnswer = new ArrayList<>();
        while(computerAnswer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerAnswer.contains(randomNumber))
                computerAnswer.add(randomNumber);
        }
    }
    //게임을 시작하는 함수
    public void playBaseballGame(){
        PrintMessage.inputUserNum();
        String inputNumber = Console.readLine();
        this.userAnswer = makeUserAnswer(inputNumber);
        compareAnswer();

    }
    // 입력값을 List<Integer> 형태로 변환해주는 함수
    public List<Integer> makeUserAnswer(String inputNumber){
        List<String> inputArray = List.of(inputNumber.split(""));
        List<Integer> userSolution = new ArrayList<>();

        for(String number : inputArray){
            userSolution.add(Integer.parseInt(number));
        }
        return userSolution;
    }
    // 볼과 스트라이크 갯수를 세어주는 함수
    public void compareAnswer(){
        this.strikeCount = 0;
        this.ballCount = 0;
        for(int i = 0; i < userAnswer.size(); i++){
            if(computerAnswer.indexOf(userAnswer.get(i)) == i){
                strikeCount++;
                continue;
            }
            if(computerAnswer.contains(userAnswer.get(i))){
                ballCount++;
            }
        }
    }
}

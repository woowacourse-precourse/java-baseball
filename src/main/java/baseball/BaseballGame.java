package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    static private List<Character> number;
    static public Boolean gameRestart = false;

    public boolean run(){
        // TODO 1. 랜덤 숫자 생성
        generateNumber();

        boolean threeStrike = false;
        while(!threeStrike){
            // TODO 2-1. 사용자 입력 받기
            System.out.print("숫자를 입력해주세요 : ");
            String newInput = Console.readLine();
            // TODO 2-2. 예외 처리하기
            checkInputFormat(newInput);
            // TODO 2-3. 스트라이크, 볼 갯수 계산
            // TODO 2-4. 결과 출력
            if(strikeAndBall(newInput)){
                threeStrike = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // TODO 3. 게임을 종료한 후 게임을 다시 시작할건지 종료할건지 선택하는 부분
                gameRestart= checkRestartGame();
            }
        }

        return gameRestart;
    }

    public void generateNumber(){
        List<Character> computer = new ArrayList<>();
        while (computer.size() < 3) {
            char randomNumber = (char) (Randoms.pickNumberInRange(1, 9)+48);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.number = computer;
    }

    public void checkInputFormat(String newInput){
        if(newInput.length() != 3){
            throw new IllegalArgumentException("userInput is index out of range: 3");
        }
        for (int i = 0; i < 3; i++){
            if( newInput.charAt(i) < '1' || newInput.charAt(i) > '9') {
                throw new IllegalArgumentException("userInput is not configured from number : 1 o 9");
            }else if(newInput.charAt(i) == newInput.charAt((i+1)%3)) {
                throw new IllegalArgumentException("duplicate number found in use Input");
            }
       }
    }

    public boolean strikeAndBall(String newInput){
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (number.get(i) == newInput.charAt(i)) {
                strikeCount += 1;
            } else if (number.contains(newInput.charAt(i))) {
                ballCount += 1;
            }
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(strikeCount + "스트라이크");
        }

        return (strikeCount==3);
    }

    public boolean checkRestartGame() {
        String restartInput = Console.readLine();
        if (restartInput.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (restartInput.charAt(1) != '2' || restartInput.charAt(1) != '1') {
            throw new IllegalArgumentException();
        }
        return restartInput.charAt(1) == '1';
    }


}

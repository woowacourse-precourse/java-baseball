package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameStarter {
    private Integer strike;
    private Integer ball;
    private List<Integer> user;
    private List<Integer> computer;

    public GameStarter() {
        RandomNum();
    }

    //잘못된 입력을 받을 경우
    public void IllegalInput() {
        //입력이 3자리의 숫자가 아님
        if(user.size()!=3){
            throw new IllegalArgumentException("3자리의 수를 입력하세요.");
        }
        //서로 다른 3자리의 숫자가 아닌 경우
        if(Objects.equals(user.get(0), user.get(1)) || Objects.equals(user.get(0), user.get(2)) || Objects.equals(user.get(1), user.get(2))){
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }
    }

    //게임 시작을 알림
    public void playGame(){
        System.out.println("숫자를 입력해주세요 : ");
        this.user = InputNum();
        IllegalInput();
        compare();
        System.out.println(solution());
    }

    //랜덤값을 추출
    public void RandomNum(){
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }
    }

    //user에게 값을 받음
    public List<Integer> InputNum(){
        List<Integer> list = new ArrayList<>();
        String[] userInput = Console.readLine().split("");
        for(int i=0; i<userInput.length; i++){
            list.add(Integer.parseInt(userInput[i]));
        }
        return list;
    }

    //computer 와 user의 값을 비교한다.
    public void compare(){
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.indexOf(user.get(i)) == i) {
                strike++;
                continue;
            }
            if (computer.contains(user.get(i))) ball++;
        }
    }

    //입력된 값과 정답이 일치하는지 확인
    public String solution(){
        if(ball != 0 && strike == 0) return (ball + "볼");
        if(ball == 0 && strike != 0) return (strike + "스트라이크");
        if(ball != 0 && strike != 0) return (ball + "볼 " + strike + "스트라이크");
        return ("낫싱");
    }

    public boolean endCheck(){
        if (strike != null && strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
            String res = Console.readLine();
            if (res.equals("1")) {
                RandomNum();
                return true;
            }
            if (res.equals("2")) return false;
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
        }
        return true;
    }
}



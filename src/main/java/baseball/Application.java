package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        String answer;
        int[] answersplit = new int[3];
        boolean again = true, runstop = false;

        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        while (again){
            answer = camp.nextstep.edu.missionutils.Console.readLine();
            if(answer.length()!=3){
                throw new IllegalArgumentException();
            }
            for(int i=0;i<3;i++){
                answersplit[i] = answer.charAt(i) - '0';
                if(answersplit[i]==0)
                    runstop = true;
            }
            if(runstop == true){
                throw new IllegalArgumentException();
            }
        }

        // TODO: 프로그램 구현
    }
}

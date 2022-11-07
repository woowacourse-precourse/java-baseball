package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    void printresult(int cntstrike, int cntball){
        if(cntball!=0 && cntstrike!=0){
            System.out.println(cntball + "볼 "+ cntstrike + "스트라이크");
        } else if(cntball!=0 && cntstrike==0){
            System.out.println(cntball + "볼");
        } else if(cntstrike!=0 && cntball==0){
            System.out.println(cntstrike + "스트라이크");
        } else{
            System.out.println("낫싱");
        }
    }
    boolean check(int[] ans, List<Integer> com){
        boolean again = true;
        int i, cntstrike = 0, cntball = 0;

        for(i=0;i<3;i++){
            if(com.contains(ans[i])){
                if(com.get(i)==ans[i]){
                    cntstrike++;
                } else{
                    cntball++;
                }
            }
        }
        if(cntstrike == 3){
            again = false;
        }

        printresult(cntstrike, cntball);

        return again;
    }
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        Application main = new Application();
        String answer, gameagain;
        int[] answersplit = new int[3];
        boolean again = true, runstop = false;
        int integer_gameagain;

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
            again = main.check(answersplit, computer);
            if(again == false){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.");
                gameagain = camp.nextstep.edu.missionutils.Console.readLine();
                integer_gameagain = Integer.parseInt(gameagain);

            }
        }

        // TODO: 프로그램 구현
    }
}

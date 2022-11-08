package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> player = new ArrayList<>();
    static HashMap<String, Integer> judgment = new HashMap<>(){{
        put("strike", 0);
        put("ball", 0);
    }};

    private static void computerNumber(List<Integer> list){
        while(list.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }
    }

    private static void playerNumber(List<Integer> list){
        int i = 0;
        System.out.print("숫자를 입력해주세요 : ");
        String value = Console.readLine();
        if(value.length() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
        } else {
            while(list.size() < 3){
                list.add(Integer.parseInt(value.split("")[i]));
                i++;
            }
        }
    }

    private static void findNumber(){
        for(int j = 0;j<player.size();j++){
            for(int i=0;i<computer.size();i++) {
                numberCompare(i, j);
            }
        }
    }

    private static void numberCompare(int i, int j){
        if (Objects.equals(player.get(j), computer.get(i))) {
            if (j == i) {
                judgment.put("strike", judgment.get("strike")+1);
            } else {
                judgment.put("ball", judgment.get("ball")+1);
            }
        }
    }

    private static void checkJudgment(){
        if(judgment.get("strike") == 0 && judgment.get("ball") == 0){
            System.out.println("낫싱");
        } else if(judgment.get("strike") == 0){
            System.out.println(judgment.get("ball")+"볼");
        } else if(judgment.get("ball") == 0){
            System.out.println(judgment.get("strike")+"스트라이크");
        } else {
            System.out.println(judgment.get("ball")+"볼 "+judgment.get("strike")+"스트라이크");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        computer.clear();
        computerNumber(computer);

        judgment.put("strike", 0);
        judgment.put("ball", 0);

        player.clear();
        playerNumber(player);

        findNumber();
        checkJudgment();

        System.out.println("게임 종료");
    }
}

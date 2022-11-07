package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {
    //임의의 3개의수 저장
    final int startNum=1;
    final int endNum=9;
    final int size = 3;


//    final List<Integer> computerNumList;
    public static List<Integer> comNumList(){
        List<Integer> computerNumList = new ArrayList<>();
        while(computerNumList.size()<3){
        int num = Randoms.pickNumberInRange(1, 9);
            if(!computerNumList.contains(num)){
                computerNumList.add(num);
            }
        }
        return computerNumList;
    }




    //사용자의 입력 수와 자신의 수 비교
    //결과 출력 (스트라이크 볼 낫싱) 3스트라이크 게임 오버
    //list contain 으로 숫자가 같은지 , indexOf로 인덱스 같은지 확인후 스트라이크 볼 판별
    //list contain에 없으면 낫싱,
}

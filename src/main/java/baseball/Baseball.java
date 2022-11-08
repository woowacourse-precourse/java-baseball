package baseball;

//### 알고리즘 구성
//        1. 3가지 숫자가 랜덤 생성
//        2. 한 자리씩 자르기
//        3. 각 수별로 수가 일치하는지 확인
//        4. 다른 자리수에 해당 자리 수가 있는지 확인
//        5. 3을 만족하면 "스트라이크", 4를 만족하면 "볼", 둘다 만족하지 않으면 ""
//        6. 각 스트라이크와 볼의 갯수를 합산하고 각 문자 앞에 수로 표시
//        7. 스트라이크와 볼 모두 0개일 경우 "낫싱"출력
//        8. 3스트라이크가 나올 때까지 무한 반복

//        1. "숫자를 입력해주세요 :"
//        2. 사용자 입력
//        3. 알고리즘 적용

import java.util.List;

public class Baseball {
    public int compare(List<Integer> computer, List<Integer> player){
        int result = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                result += 1;
            }
        }
        return result;
    }

    public int countStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}


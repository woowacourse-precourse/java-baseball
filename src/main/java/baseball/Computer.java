package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private static Map<Character, Integer> numberIndexMap;

    public Computer() {
        setNumberIndexMap(getNumbers());
    }

    /*
    * Randoms API를 사용해 랜덤 숫자를 생성해 반환한다.
    * 서로 다른 숫자 3개로 이루어질 때까지 반복한다.
    *
    * @return List
    * */
    private static List<Integer> getNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }

    /*
    * 만들어진 컴퓨터 숫자의 각 자리별 인덱스를 저장하는 맵 반환
    *
    * @return Map
    * */
    private static void setNumberIndexMap(List<Integer> numbers) {
        Map<Character, Integer> map = new HashMap<>();

        for (int index = 0; index < 3; index++) {
            int number = numbers.get(index);
            map.put((char) (number + '0'), index);
        }

        numberIndexMap = map;
    }

    public Map<Character, Integer> getNumberIndexMap() {
        return numberIndexMap;
    }
}

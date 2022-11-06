package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {
    // 숫자 야구게임에서 사용할 숫자의 개수를 저장하는 변수
    private final int gameInputCount;
    // 숫자 야구게임에서 컴퓨터가 가지고 있는 랜덤 숫자 리스트
    private List<Integer> answerNumberList;

    /**
     * 게임에서 사용할 숫자의 개수를 초기화한다
     * @param gameInputCount : 게임에서 사용할 숫자의 개수
     */
    public BaseballService(int gameInputCount) {
        this.gameInputCount = gameInputCount;
    }

    /**
     * 숫자 리스트를 컴퓨터의 리스트와 비교하여 볼과 스트라이크의 개수를 담은 배열을 반환한다
     * @param inputNumberList : 컴퓨터의 숫자 리스트와 비교할 리스트
     * @return [ballCount, strikeCount] 형태의 배열
     */
    public List<Integer> getBallAndStrikeCounts(List<Integer> inputNumberList) {
        List<Integer> result = new ArrayList<>(List.of(0, 0));
        for (int index = 0; index < inputNumberList.size(); index++) {
            addBallAndStrikeCountsByNumberAndIndex(inputNumberList.get(index),index,result);
        }
        return result;
    }

    /**
     * 숫자 한개를 컴퓨터의 리스트와 비교하여 리스트에 볼과 스트라이크 개수를 갱신한다
     * @param inputNumber : 비교할 숫자
     * @param index : 해당 숫자의 인덱스
     * @param result : 볼과 스트라이크 개수가 담긴 배열
     */
    private void addBallAndStrikeCountsByNumberAndIndex(int inputNumber, int index ,List<Integer> result){
        int findIndex = answerNumberList.indexOf(inputNumber);
        if (findIndex == -1){
            return;
        }
        if (findIndex != index){
            result.set(0, result.get(0) + 1);
        } else if (findIndex == index){
            result.set(1, result.get(1) + 1);
        }
    }

    /**
     * 컴퓨터의 숫자리스트(this.answerNumberList)를 새로 할당한다
     */
    public void setAnswerNumberList() {
    }

    /**
     * 리스트에 중복이 없도록 gameInputCount 개의 원소를 가진 새로운 리스트를 할당한다
     * @param list : 값을 할당할 리스트
     */
    private void addRandomNumberToList(List<Integer> list) {
    }
}

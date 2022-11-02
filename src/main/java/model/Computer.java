package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Computer {

    final private static int NUM_START_RANGE_RAM = 1;
    final private static int NUM_END_RANGE_RAM = 9;
    final private List<Integer> numThreeRanOfComputerList;

    public int cntStrike;
    public int cntBall;

    public Computer() {
        this.numThreeRanOfComputerList = new ArrayList<>();
        this.cntStrike = 0;
        this.cntBall = 0;
    }

    public void creatRanNumOfComputerList() {
        while (numThreeRanOfComputerList.size() < 3) {
            int randomNumber = getOneRanNumAnInt();
            if (!numThreeRanOfComputerList.contains(randomNumber)) {
                numThreeRanOfComputerList.add(randomNumber);
            }
        }
    }

    public int getOneRanNumAnInt() {
        return Randoms.pickNumberInRange(NUM_START_RANGE_RAM, NUM_END_RANGE_RAM);
    }

    // 컴퓨터야 이 3개의 숫자가 너의 랜덤리스트와 맞니?
    // 컴퓨터의 숫자와 매개변수의 숫자를 비교합니다.
    public Boolean isRightThreeNumOfComputer(int numOfCompare) {
        // TODO: 1. numOfCompare를 3개의 숫자로 분리한다.
        ArrayList<Integer> splitNumOfCompare = new ArrayList<>();

        // TODO: 2. 각숫자가 컴퓨터 랜덤 리스트에 포함하는가 안하는가 확인
        if (isEqualsCollection(this.numThreeRanOfComputerList, splitNumOfCompare)) {
            // TODO: 2.1 if 포함한다면?
            // TODO: 2.1.1 스트라이크 볼 체크
        } else {
            // TODO: 2.2 else 포함안한다면? => 낫싱
        }
        return true;
    }

    // strike체크 함수
    private void checkStrike(List<Integer> splitNumOfCompare) {
        // TODO: 매개변수 숫자의 첫번째 숫자가 컴퓨터의 나머지 숫자들과 비교
        boolean isStrike = true;
        for (int first = 0; first < splitNumOfCompare.size(); first++) {
            isStrike = false;
            int numComputerAtNow = this.numThreeRanOfComputerList.get(first);
            for (int second = 0; second < this.numThreeRanOfComputerList.size(); second++) {
                int numAtNow = splitNumOfCompare.get(second);
                if (first == second && numComputerAtNow == numAtNow) {
                    isStrike = true;
                }
            }
            if (isStrike) {
                this.cntStrike = this.cntStrike + 1;
            }
        }
    }

    // strike체크 함수
    private void checkBall(List<Integer> splitNumOfCompare) {
        // TODO: 매개변수 숫자의 첫번째 숫자가 컴퓨터의 나머지 숫자들과 비교
        boolean isBall = true;
        for (int first = 0; first < splitNumOfCompare.size(); first++) {
            isBall = false;
            int numComputerAtNow = this.numThreeRanOfComputerList.get(first);
            for (int second = 0; second < this.numThreeRanOfComputerList.size(); second++) {
                int numAtNow = splitNumOfCompare.get(second);
                if (first != second && numComputerAtNow == numAtNow) {
                    isBall = true;
                }
            }
            if (isBall) {
                this.cntBall = this.cntBall + 1;
            }
        }
    }

    public boolean isEqualsCollection(Collection collection_1,
        Collection collection_2) {
        if (collection_1.containsAll(collection_2)) {
            return true;
        } else {
            return false;
        }
    }

    // 숫자의 각각의 자릿수를 List로 리턴
    public List<Integer> splitEachDigitOfNum(int numTosplit) {
        List list = new ArrayList<>();
        // TODO: 숫자가 3개인가? 확인
        String strParseIntArr = "" + numTosplit;
        String[] strSplitArr = strParseIntArr.split("");

        for (String str : strSplitArr) {
            Integer intParseStr = Integer.valueOf(str);
            list.add(intParseStr);
        }
        return list;
    }

    public List<Integer> getNumThreeRanOfComputerList() {
        return numThreeRanOfComputerList;
    }
}

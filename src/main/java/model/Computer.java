package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Computer {

    final private static int NUM_START_RANGE_RAM = 1;
    final private static int NUM_END_RANGE_RAM = 9;
    final private static String NOT_TING_ANSWER = "낫싱";

    public List<Integer> numThreeRanOfComputerList;

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

    @Override
    public String toString() {
        // 볼 0 , 스트라이크 0
        if (this.cntBall == 0 && this.cntStrike == 0) {
            return NOT_TING_ANSWER;
        }
        // 스트라이크 0
        else if (this.cntStrike == 0) {
            return (this.cntBall + "볼 ");
        }
        // 볼 0
        else if (this.cntBall == 0) {
            return (this.cntStrike + "스트라이크");
        } else {
            return (this.cntBall + "볼 " + this.cntStrike + "스트라이크");
        }
    }

    public int getOneRanNumAnInt() {
        return Randoms.pickNumberInRange(NUM_START_RANGE_RAM, NUM_END_RANGE_RAM);
    }

    // 유저에게 힌트를 주다
    public String giveHint2User(int numOfCompare) {
        return this.toString();
    }

    // 게임을 종료해도 되겠니?
    public boolean isEndTheGame() {
        if (this.cntStrike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void initCntStrikeBall() {
        this.cntStrike = 0;
        this.cntBall = 0;
    }

    public boolean isRealRightNumOfUser(int numInputOfUser) {
        if (isRightThreeNumOfComputer(numInputOfUser)) {
            // TODO: 스트라이크와 볼이 있다면
            return true;
        } else {
            // TODO: 낫싱이면
            return false;
        }
    }

    // 컴퓨터야 이 3개의 숫자가 너의 랜덤리스트와 맞니?
    // 컴퓨터의 숫자와 매개변수의 숫자를 비교합니다.
    public Boolean isRightThreeNumOfComputer(int numOfCompare) {
        // TODO: 1. numOfCompare를 3개의 숫자로 분리한다.
        ArrayList<Integer> splitNumOfCompare = new ArrayList<>();
        splitNumOfCompare = (ArrayList<Integer>) this.splitEachDigitOfNum(numOfCompare);
        // TODO: 2. 각숫자가 컴퓨터 랜덤 리스트에 포함하는가 안하는가 확인
        if (isEqualsCollection(this.numThreeRanOfComputerList, splitNumOfCompare)) {
            // TODO: 2.1 if 포함한다면?
            // TODO: 2.1.1 스트라이크 체크
            checkStrike(splitNumOfCompare);
            // TODO: 2.1.2 스트라이크 체크
            checkBall(splitNumOfCompare);
//            System.out.println(this.cntBall + " " + this.cntStrike);
            return true;
        } else {
            // TODO: 2.2 else 포함안한다면? => 낫싱
            return false;
        }
    }

    public void initComputer() {
        this.creatRanNumOfComputerList();
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

    public int getCntStrike() {
        return cntStrike;
    }

    public int getCntBall() {
        return cntBall;
    }

    public boolean isEqualsCollection(Collection collection_1,
        Collection collection_2) {
        boolean isTrue = true;
        for (Object num : collection_2) {
            if (collection_1.contains(num)) {
                isTrue = true;
            }
        }
        return isTrue;
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

    public void setCntStrike(int cntStrike) {
        this.cntStrike = cntStrike;
    }

    public void setCntBall(int cntBall) {
        this.cntBall = cntBall;
    }

    public List<Integer> getNumThreeRanOfComputerList() {
        return numThreeRanOfComputerList;
    }
}

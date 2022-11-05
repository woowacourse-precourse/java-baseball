package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Computer {


    final private static int NUM_START_RANGE_RAM = 1;
    final private static int NUM_END_RANGE_RAM = 9;
    final private static String NOT_TING_ANSWER = "낫싱";
    final private static int COUNT_ZERO = 0;

    public List<Integer> numThreeRanOfComputerList;

    private int cntStrike;
    private int cntBall;

    public Computer() {
        this.cntStrike = 0;
        this.cntBall = 0;
    }

    public void initComputer() {
        this.creatRanNumOfComputerList();

        while (!isNumOfComputerIndividually()) {
            this.creatRanNumOfComputerList();
        }
    }

    private void creatRanNumOfComputerList() {
        this.numThreeRanOfComputerList = new ArrayList<>();
        while (numThreeRanOfComputerList.size() < 3) {
            addRanNumList();
        }
    }

    private void addRanNumList() {
        int randomNumber = getOneRanNumAnInt();
        if (!isContainList(randomNumber)) {
            numThreeRanOfComputerList.add(randomNumber);
        }
    }

    private boolean isContainList(int randomNumber) {
        return numThreeRanOfComputerList.contains(randomNumber);
    }

    private boolean isNumOfComputerIndividually() {
        String strComputerList = getStrFromList();
        if (UseFunc.isNumOfIndividually(strComputerList)) {
            return true;
        }
        return false;
    }

    private String getStrFromList() {
        String strOfList = "";
        for (Integer numComputerList : numThreeRanOfComputerList) {
            strOfList = strOfList + numComputerList;
        }
        return strOfList;
    }

    public void initCntStrikeBall() {
        this.cntStrike = 0;
        this.cntBall = 0;
    }

    public boolean isEndTheGame() {
        if (this.cntStrike == 3) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        ResultType result = getResultType();
        switch (result) {
            case BALL_STRIKE_ZERO:
                return NOT_TING_ANSWER;
            case BALL_ONLY:
                return (this.cntBall + "볼 ");
            case STRIKE_ONLY:
                return (this.cntStrike + "스트라이크");
            case BALL_STRIKE:
                return (this.cntBall + "볼 " + this.cntStrike + "스트라이크");
        }
        return "";
    }


    private ResultType getResultType() {
        if (isHinNotting()) {
            return ResultType.BALL_STRIKE_ZERO;
        } else if (isHintBallOnly()) {
            return ResultType.BALL_ONLY;
        }
        if (isHintStrikeOnly()) {
            return ResultType.STRIKE_ONLY;
        }
        if (isHintBallStrik()) {
            return ResultType.BALL_STRIKE;
        }
        return null;
    }

    private boolean isHintBallStrik() {
        return !UseFunc.isEqualIntOfTwo(cntBall, COUNT_ZERO) && !UseFunc.isEqualIntOfTwo(cntStrike,
            COUNT_ZERO);
    }

    private boolean isHintStrikeOnly() {
        return UseFunc.isEqualIntOfTwo(cntBall, COUNT_ZERO);
    }

    private boolean isHintBallOnly() {
        return UseFunc.isEqualIntOfTwo(cntStrike, COUNT_ZERO);

    }

    private boolean isHinNotting() {
        return UseFunc.isEqualIntOfTwo(cntBall, COUNT_ZERO) && UseFunc.isEqualIntOfTwo(cntStrike,
            COUNT_ZERO);

    }

    public int getOneRanNumAnInt() {
        return Randoms.pickNumberInRange(NUM_START_RANGE_RAM, NUM_END_RANGE_RAM);
    }

    public boolean isRealRightNumOfUser(int numInputOfUser) {
        if (isRightThreeNumOfComputer(numInputOfUser)) {
            return true;
        }
        return false;

    }

    private Boolean isRightThreeNumOfComputer(int numOfCompare) {
        ArrayList<Integer> splitNumOfCompare = splitEachDigitOfNum(numOfCompare);
        if (isContainValueList(this.numThreeRanOfComputerList, splitNumOfCompare)) {
            checkStrikeBall(splitNumOfCompare);
            return true;
        }
        return false;
    }

    private void checkStrikeBall(List<Integer> listSplitNum) {
        boolean isStrike = true, isBall = true;
        for (int first = 0; first < listSplitNum.size(); first++) {
            isStrike = false;
            isBall = false;
            int numComputerAtNow = getValueOfIndexFromList(numThreeRanOfComputerList, first);

            for (int second = 0; second < this.numThreeRanOfComputerList.size(); second++) {
                int numAtNow = getValueOfIndexFromList(listSplitNum, second);
                isStrike = isCheckStrike(isStrike, first, numComputerAtNow, second, numAtNow);
                isBall = isBallCheck(isBall, first, numComputerAtNow, second, numAtNow);
            }
            addCntBallStrike(isStrike, isBall);
        }
    }

    private Integer getValueOfIndexFromList(List<Integer> list, int first) {
        return list.get(first);
    }

    private void addCntBallStrike(boolean isStrike, boolean isBall) {
        if (isStrike) {
            addCntStrike();
        }
        if (isBall) {
            addCntBall();
        }
    }

    private void addCntBall() {
        this.cntBall = this.cntBall + 1;
    }

    private void addCntStrike() {
        this.cntStrike = this.cntStrike + 1;
    }

    private boolean isCheckStrike(boolean isStrike, int first, int numComputerAtNow, int second,
        int numAtNow) {
        if (first == second && numComputerAtNow == numAtNow) {
            isStrike = true;
        }
        return isStrike;
    }


    private boolean isBallCheck(boolean isBall, int first, int numComputerAtNow, int second,
        int numAtNow) {
        if (first != second && numComputerAtNow == numAtNow) {
            isBall = true;
        }
        return isBall;
    }

    private boolean isContainValueList(Collection collection_1,
        Collection<Integer> collection_2) {
        return collection_1.stream().anyMatch((num) -> collection_2.contains(num));
    }

    private ArrayList<Integer> splitEachDigitOfNum(int numTosplit) {
        // TODO: 숫자가 3개인가? 확인
        String[] strSplitArr = getSpitArr(parseStringFromNum(numTosplit));
        return getListOfIntegerFromStrArr(strSplitArr);
    }

    private ArrayList<Integer> getListOfIntegerFromStrArr(String[] strSplitArr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String str : strSplitArr) {
            list.add(parseIntegerFromStr(str));
        }
        return list;
    }

    private String parseStringFromNum(int num) {
        return ("" + num);
    }

    private String[] getSpitArr(String str) {
        return str.split("");
    }

    private Integer parseIntegerFromStr(String str) {
        return Integer.valueOf(str);
    }

    public String giveHint2User(int numOfCompare) {
        return this.toString();
    }

    public int getCntStrike() {
        return cntStrike;
    }

    public int getCntBall() {
        return cntBall;
    }

    public List<Integer> getNumThreeRanOfComputerList() {
        return numThreeRanOfComputerList;
    }

    public static Computer getInstanceUser() {
        return (new Computer());
    }
}

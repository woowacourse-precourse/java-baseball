package utill;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class UseFunc {

    public static boolean isNumOfIndividually(String str) {
        ArrayList<Integer> splitStrList = getListStrArr2Split(str);
        int cntSameNum = ConstantVO.INIT_NUM;
        if (isRightContainSameNum(splitStrList, cntSameNum)) {
            return false;
        }
        return true;
    }

    private static boolean isRightContainSameNum(List<Integer> splitStrList, int cntSameNum) {
        for (int value : splitStrList) {
            cntSameNum = getCntSameNum(splitStrList, cntSameNum, value);
            return isValidCntSameNumLen(cntSameNum);
        }
        return false;
    }

    private static boolean isValidCntSameNumLen(int cntSameNum) {
        return cntSameNum > ConstantVO.ONLY_ONE_THING_SAME;
    }

    private static int getCntSameNum(List<Integer> splitStrList, int cntSameNum, int value) {
        cntSameNum = 0;
        for (int index = 0; index < splitStrList.size(); index++) {
            int numValueListAtNow = getValueIndexList(splitStrList, index);
            cntSameNum = addSameNum(cntSameNum, value, numValueListAtNow);
        }
        return cntSameNum;
    }

    private static int addSameNum(int cntSameNum, int value, int numValueListAtNow) {
        if (isEqualIntOfTwo(value, numValueListAtNow)) {
            cntSameNum = cntSameNum + 1;
        }
        return cntSameNum;
    }

    private static int getValueIndexList(List<Integer> list, int index) {
        return list.get(index);
    }

    private static ArrayList<Integer> getListStrArr2Split(String str) {
        String[] strArr = getArrSplit(str);
        ArrayList<Integer> list = new ArrayList<>();
        for (String value : strArr) {
            list.add(parseIntFromValue(value));
        }
        return list;
    }

    private static Integer parseIntFromValue(String value) {
        return Integer.valueOf(value);
    }

    private static String[] getArrSplit(String str) {
        return str.split("");
    }

    public static boolean isEqualIntOfTwo(int num_1, int num_2) {
        return num_1 == num_2;
    }

    public static String getString() {
        return readLine();
    }

    public static int parseIntFromStr(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConstantVO.MSG_INPUT_NUM);
        }
    }

}
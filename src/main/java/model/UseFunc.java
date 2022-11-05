package model;

import java.util.ArrayList;
import java.util.List;

public class UseFunc {

    // 서로 다른 3자리의 수인지 확인
    // 서로 다른 3자리의 수인지 확인하는 방법은?
    // 1번을 for문 2번?
    public static boolean isNumOfIndividually(String str) {
        List<Integer> splitStrList = getListStrArr2Split(str);
        int cntSameNum = 0;
        for (int value : splitStrList) {
            cntSameNum = 0;
            for (int index = 0; index < splitStrList.size(); index++) {

                int numValueListAtNow = getValueIndexList(splitStrList, index);
                if (isEqualIntOfTwo(value, numValueListAtNow)) {
                    cntSameNum = cntSameNum + 1;
                }
            }
            if (cntSameNum > 1) {
                return false;
            }
        }
        return true;
    }

    private static int getValueIndexList(List<Integer> list, int index) {
        return list.get(index);
    }

    private static List getListStrArr2Split(String str) {
        String[] strArr = getArrSplit(str);
        List<Integer> list = new ArrayList<>();
        for (String value : strArr) {
            list.add(Integer.valueOf(value));
        }
        return list;
    }

    private static String[] getArrSplit(String str) {
        return str.split("");
    }

    public static boolean isEqualIntOfTwo(int num_1, int num_2) {
        if (num_1 == num_2) {
            return true;
        }
        return false;
    }
}
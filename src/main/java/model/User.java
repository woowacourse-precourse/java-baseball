package model;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int numSelecUser;

    public User() {
        this.numSelecUser = 0;
    }

    public int getInputAllRightNumOfUser() {
        // TODO : 숫자 받기
        String strInput = getString();
        // TODO : 숫자로 변환하면서 숫자인지 검증
        int numInput = parseIntFromStr(strInput);
        // TODO : 길이가 3개인지
        isValidLength(strInput);
        // TODO : 서로 다른 수인지 확인
        isValidNumOfIndividually(strInput);
        // TODO : 입력이 음수인지 확인
        isValidPositiveInt(numInput);

        return numInput;
    }

    public boolean isValidPositiveInt(int num) {
        if (num > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }

    public String getString() {
        String strInput = "";
        strInput = readLine();
        return strInput;
    }


    public int parseIntFromStr(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public boolean isValidLength(String str) {
        if (str.length() == 3) {
            return true;
        } else {
            throw new IllegalArgumentException("입력의 길이는 \"3\" 만 가능합니다.");
        }
    }

    public boolean isValidNumOfIndividually(String str) {
        if (isNumOfIndividually(str)) {
            return true;
        } else {
            throw new IllegalArgumentException("각각의 다른 숫자를 입력해주세요.");
        }
    }

    // 서로 다른 3자리의 수인지 확인
    // 서로 다른 3자리의 수인지 확인하는 방법은?
    // 1번을 for문 2번?
    public boolean isNumOfIndividually(String str) {
        List<Integer> splitStrList = getListStrArr2Split(str);
        int cntSameNum = 0;
        for (int value : splitStrList) {
            cntSameNum = 0;
            for (int index = 0; index < splitStrList.size(); index++) {
                if (value == splitStrList.get(index)) {
                    cntSameNum = cntSameNum + 1;
                }
            }
            if (cntSameNum > 1) {
                return false;
            }
        }
        return true;
    }

    public List getListStrArr2Split(String str) {
        String[] strArr = str.split("");
        List<Integer> list = new ArrayList<>();
        for (String value : strArr) {
            list.add(Integer.valueOf(value));
        }
        return list;
    }
}

package custom.table;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private String number;

    public Table() {

    }

    private Table(String number) {
        validateDuplicateNumber(number);
        this.number = number;
    }

    public static Table init(String number) {
        return new Table(number);
    }

    public char get(int index) {
        validateInit();
        return number.charAt(index);
    }

    public boolean contains(char character) {
        validateInit();
        for (char elem : number.toCharArray()) {
            if (elem == character) {
                return true;
            }
        }
        return false;
    }

    public void setNumber(String number) {
        validateDuplicateNumber(number);
        this.number = number;
    }

    private void validateDuplicateNumber(String number) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            if (list.contains(number.charAt(i))) {
                throw new IllegalStateException("중복된 숫자로 데이터를 초기화 할 수 없습니다");
            }
            list.add(number.charAt(i));
        }
    }

    private void validateInit() {
        if (this.number == null) {
            throw new RuntimeException("숫자를 먼저 초기화해주세요");
        }
    }
}

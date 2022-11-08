package baseball.model.numbers;

import java.util.List;

public class Numbers {

    private List<Integer> nums;

    public Numbers(List<Integer> Numbers) {
        this.nums = Numbers;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public boolean equals(Object o, int i) {
        if (!(o instanceof Numbers)) return false;
        Numbers numbers= (Numbers) o;
        List<Integer> numberList = numbers.getNums();

        if (this.nums.get(i).equals(numberList.get(i))) return true;
        else return false;
    }

    public boolean contains(Object o, int i) {
        if (!(o instanceof Numbers)) return false;
        Numbers numbers= (Numbers) o;
        List<Integer> numberList = numbers.getNums();

        if (this.nums.contains(numberList.get(i))) return true;
        else return false;
    }

    public int size() {
        return nums.size();
    }
}
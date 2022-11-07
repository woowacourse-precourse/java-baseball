package baseball;

import java.util.Objects;

public class Baseball {
    private final Integer baseball;

    public Baseball(Integer number){
        this.baseball = number;
    }

    public void getBaseball(){
        System.out.println(this.baseball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball1 = (Baseball) o;
        return Objects.equals(baseball, baseball1.baseball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseball);
    }
}

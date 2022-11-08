# 숫자 야구
## 예상 필요 기능.
1. 같은 수가 있는가?
2. 같은 자리에 있는가?
3. ~~컴퓨터 차례~~
4. 랜덤 1~9 선택
5. 다시 시작하겠는가?
6. 사용자 값이 잘못되었는가?(IllegalArgumentException)
7. ~~3번 맞췄는가?~~

## 1. 같은수가 있는가? 
### 1.1 Ball판단
~~~java
public int ball(List<Integer> answer, int input, int i) {
    for (int j = 0; j < answer.size(); j++) {
        if (input == answer.get(j) && i != j) {
            System.out.println(answer.get(i) + "" + input);
            System.out.println(i + "" + j);
            return 1;
        }
    }
    return 0;
}
~~~

## 2. 같은자리에 있는가?
### 2.1 Strike판단
~~~java
public int strike(int answer, int input) {
    if (answer == input) {
        return 1;
    } else {
        return 0;
    }
~~~

## 4. 랜덤 1~9선택
### 4.1 게임의 정답을 선택한다
~~~java
public List<Integer> ComputerAnswer()
{
    List<Integer> computerAnswer = new ArrayList<>();
    while (computerAnswer.size() < 3) {
        int tmp = Randoms.pickNumberInRange(1, 9);
        if (!computerAnswer.contains(tmp)) {
            computerAnswer.add(tmp);
        }
    }
    return computerAnswer;
}
~~~
## 5. 다시 시작하겠는가?
### 5.1 Restart
~~~java
public boolean gameRestart() throws IllegalArgumentException {
    System.out.println(GAME_RESTART);
    String input = readLine();
    if (input.equals("1")) {
        gameStart();
        return true;
    } else if (input.equals("2")) {
        return false;
    } else {
        throw new IllegalArgumentException();
    }
}
~~~
##6. 코드생략


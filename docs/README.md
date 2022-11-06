### 기능 목록
#### 1. Game class
- 숫자 하나에 대해 볼인지, 스트라이크인지 체크하는 함수
```java
List<Integer> checkOneDigitNumberCount(Integer number, Integer index, List<Integer> secretNumber, List<Integer> hitCount)
```

- 사용자가 입력한 숫자에 대해 볼과 스트라이크 카운트를 체크하는 함수
```java
List<Integer> checkTotalNumberCount(Integer totalNumber, List<Integer> secretNumber)
```

- 볼인지 스트라이크인지 확인하는 리스트를 초기화하는 함수
```java
List<Integer> initHitCount()
```

- 볼과 스트라이크의 개수에 따라 사용자에게 스트라이크와 볼의 개수를 알리는 함수
```java
void showHitCount(List<Integer> hitCount)
```

- 사용자가 숫자를 다 맞췄는지 확인하는 함수
```java
boolean checkWin(List<Integer> hitCount)
```

- 사용자로부터 숫자를 입력받는 함수
```java
Integer inputTotalNumber()
```

- 사용자로부터 게임을 계속할지 말지 입력받는 함수
```java
boolean inputPlayGame()
```

- 컴퓨터가 정한 하나의 숫자에 대해 게임을 진행하는 함수
```java
void play()
```

- 게임을 반복적으로 진행하는 함수
```java
void run()
```
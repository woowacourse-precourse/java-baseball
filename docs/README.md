# 구현 기능 목록(java-baseball)

### 게임 시작

###랜덤으로 3자리 수 생성하기
- 각각의 자리에 있는 수가 모두 달라야 한다.
> Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

###사용자에게 3자리 수 입력 받기
- 3자리 수여야 한다.
- 각각의 자리에 있는 수가 모두 달라야 한다.
- 각각의 수는 1~9사이의 수로 이루어져 있다.
> 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

> 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 사용자가 입력한 값에 대한 정답여부 판단
- 사용자가 정답을 맞출 때까지 입력과 판단(볼, 스트라이크, 낫싱)을 반복한다.
- 사용자가 정답을 맞출 경우 게임 다시 시작 or 종료를 선택할 수 있어야한다.
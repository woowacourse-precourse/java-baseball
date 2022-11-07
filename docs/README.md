### 기능 목록
1. 컴퓨터: 3자리 수 입력
2. 유저: 3자리 수 입력
3. 컴퓨터와 유저의 숫자 비교
4. 힌트(볼/스트라이크/낫싱) 출력
5. 숫자를 맞출 때까지 2~4번 반복
6. 게임 재시작/종료 선택


### 0. 게임 시작 알림
- "숫자 야구 게임을 시작합니다."

### 1. 컴퓨터의 3자리 수 입력
- camp.nextstep.edu.missionutils에서 제공하는 Randoms API를 사용
- camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 1부터 9사이의 서로 다른 3개의 숫자 결정

### 2. 유저의 3자리 수 입력
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용
- camp.nextstep.edu.missionutils.Console의 readLine()을 사용해 3자리 수 입력
- "숫자를 입력해주세요 : "
- 잘못된 값을 입력한 경우, IllegalArgumentException을 발생시킨 후 어플리케이션 종료
- [예외1] 입력한 숫자가 3개가 아닌 경우
- [예외2] 0을 입력한 경우
- [예외3] 중복된 숫자를 입력한 경우
- [예외4] 숫자가 아닌 문자를 입력한 경우

### 3. 컴퓨터와 유저의 숫자 비교
- 다른 자리에 같은 숫자가 있는 경우: 볼
- 같은 자리에 같은 숫자가 있는 경우: 스트라이크
- 볼이나 스트라이크가 하나도 없는 경우: 낫싱

### 4. 힌트 출력
- 3번에서 구한 값을 토대로 힌트 출력
- 볼과 스트라이크가 모두 존재하는 경우, 볼의 개수 먼저 출력

### 5. 게임 종료
- 숫자를 모두 맞힌 경우 게임 종료
- " 3개의 숫자를 모두 맞히셨습니다! 게임 종료 "

### 6. 게임 재시작/종료
- camp.nextstep.edu.missionutils.Console의 readLine()을 사용
- " 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. "
- 재시작: 1 / 종료: 2
- 잘못된 값을 입력한 경우, IllegalArgumentException을 발생
- [예외] 1과 2가 아닌 다른 수를 입력한 경우
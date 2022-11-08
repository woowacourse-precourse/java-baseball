# 프로그램 설명
컴퓨터가 제시하는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

## 0. 종료 조건
### 1) 정상적인 종료
- 한 세트의 게임 종료 시, 즉, 3스트라이크 후 게임종료 여부 확인 시에 사용자가 종료(입력값 : 2)를 선택했을 경우

### 2) 비정상적인 종료
- 사용자가 터미널에 입력한 값이 비정상적인 값일 경우
  1. 게임 도중, 3자리의 숫자를 입력하지 않을 경우
  2. 한 세트의 게임 종료 시, 게임종료 여부 확인 시에 1과 2가 아닌 다른 값을 입력할 경우
- 이 경우, IllegalArgumentException을 발생시킨 후 종료해야 한다.
## 구현할 method 설명

### 0. main
- Integer형 List computer, user 생성하고 게임을 실행한다.
- game_over
  - 초기값이 false인 전역 변수로, 게임이 완전히 종료되는지 계속 확인한다.
  - 사용자가 3스트라이크 이후 게임 종료를 원하면 wouldYouExitGame()에서 true로 바꿔준다. 

```
while(true){
  List<Integer> computer = new ArrayList<>();
  List<Integer> user = new ArrayList<>();
  makeGame(computer); 
  playgame(computer,user);
  wouldYouExitGame();
  if(game_over) break;
}
```

### 1. makeGame(computer)
- computer가 random하게 세 자리의 수를 설정하고 한개의 게임 세트를 생성한다.
  - Random한 수 생성은 camp.nextstep.edu.missionutils.Randoms 라이브러리를 활용한다.
- 게임 시작을 console에 알린다.




### 2. playGame(computer,user)
- 사용자가 컴퓨터의 3자리 수를 맞출때까지 게임을 진행한다.
- oneGameFinished
  - 초기값이 false인 전역변수로, 한 세트의 게임이 끝났는지 계속 확인한다. 
  - judgement()에서 3스트라이크일때 true로 바꿔준다. 

```
while(true){
  getNumber(user);
  judgement(computer,user);
  if(oneGameFinished) break;
}
```
#### getNumber(user)
- Console로 사용자가 예측하는 숫자를 입력받아, isvalid()를 통해 유효한 입력인지 확인한다.
  - 유효하면 입력받은 숫자를 List형태의 user에 넣는다.
  - 유효하지 않으면 IllegalArgumentException을 발생시킨다.

#### judgement(computer,user)
- computer와 user에 저장된 숫자들을 활용gkdu, x볼 x스트라이크, 혹은 낫싱인지 Console에 출력해준다.
- 3스트라이크가 되면 전역변수 oneGameFinished 값을 true로 설정한다.



### 3. wouldYouExitGame
- 사용자가 3개의 숫자를 모두 맞추고 게임을 더 진행할 건지 Console을 통해 입력받고, iscommand()를 통해 유효한 입력인지 확인한다.
  - 유효한 값 1일 경우, oneGameFinished를 false로 설정한다.(더 게임 진행할 것을 의미)
  - 유효한 값 2일 경우, game_over를 true로 설정한다.(게임 종료할 것을 의미)
  - 그 외의 유효하지 않은 값일 경우, IllegalArgumentException을 발생시킨다.
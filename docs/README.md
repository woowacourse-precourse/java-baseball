Game : 게임을 진행한다
- initAnswer : 무작위 세자리 수를 세팅한다
  - 중복 숫자가 있을 경우 다시 세팅한다
  - `Referee`에게 게임 진행 상황을 초기화해달라고 요청한다
- doWantRegame : `Player`에게 게임을 재실행할지 묻는다
- getAnswer : 답을 반환한다
- play : `Player`에게 답을 묻고 `Referee`에게 판정을 요구한다
  - `Referee`에게 게임이 끝났는지 묻는다
    - 끝났다면 `Player`에게 게임을 다시 할건지 묻는다
  - `Player`에게 게임 결과를 유저에게 보여주길 요청한다
- end : 게임 종료

Player : 클라이언트(유저)와 소통한다
- askNumbers : 유저에게서 3자리 수를 얻는다
  - 입력받은 값이 ***서로 다른 3자리 숫자***가 아닐 경우 `IllegalArgumentException`을 발생시킨다
- askRegame : 유저가 게임을 다시 하길 원하는지 묻는다
- printResult : 게임 결과를 출력한다

Referee : 게임 결과를 알린다
- plusGameCount : 게임 진행 횟수를 추가한다
- isEnd : 게임이 3회 진행되어 끝났는지 알린다
- initStatus : 게임 진행 상황을 초기화한다
- scoring : 매개변수로 넘어온 숫자와 `Game`에게 얻은 숫자를 비교해 결과를 판정한다

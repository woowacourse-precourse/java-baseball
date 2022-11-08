## 기능 목록

- 주 기능

| 기능이름 | 기능 세부사항 | 
|:---:|---|
|BaseBallGame.run|게임의 상태 질의 및 사용자 인터렉티브가 진행되는 공간 |
|BaseBallGame.generateNumber|랜덤으로 서로다른 수로 이루어진 3자리 숫자를 생성|
|BasBallGame.getUserInput|사용자의 입력을 받음|
|BaseBallGame.validateUserInput|사용자의 입력의 validation을 검증|
|BaseBallGame.getResultOfInput|사용자 입력에 대한 결과값을 출력|
|BaseBall.State|게임의 상태 열거체 |
|BaseBall.doStateRoutine|게임 상태의 특정 수행 동작|
|BaseBall.Trigger|게임의 상태전이 열거체 |


- 보조 기능 : run()외의 주기능에 종속되어 보조해주는 함수들

| 기능이름 | 기능 세부사항 | 종 기능 |
|:---:|---| --- |
|BaseBallGame.inpuStringToList| 유저에서 받은 인풋값을 List\<Integer\>타입으로 변환 | BasBallGame.getUserInput |
|BaseBallGame.getResultandPrint| ON_GAME 상태일 때 유저 인풋스트링에 대한 스트라이크와 볼의 수를 도출| BaseBallGame.getResultOfInput | 
|BaseBallGame.printResult| getResultandPrint에서 도출한 스트라이크와 볼의 수를 가지고 주어진 시나리오 대로 출력문을 출력 | BaseBallGame.getResultOfInput | 
|BaseBallGame.selectRestartOrNot| FINISH_GAME 상태일 떄 유저의 인풋에 따른 선택을 결정 |BaseBallGame.getResultOfInput |


## 상태 목록

|상태이름 | 상태 수행 동작                                                              |
|---|-----------------------------------------------------------------------|
|START_GAME| <div>1. 게임시작 문구 출력</div> <div> 2. 랜덤으로 서로다른 수로 이루어진 <br> 3자리 숫자를 생성 </div>|
|ON_GAME| <div> 1. 유저의 인풋을 받음  </div><div> 2. 유저의 인풋을 검증  </div> <div> 3.유저의 인풋에 대한 결과를 출력</div> |
|FINISH_GAME|<div>1. 유저의 인풋을 받음 </div>|

## 트리거 목록
|트리거이름| 상세|
|---|---|
|INVALID_USER_INPUT| IllegalArgumentException 발생시키고 게임을 종료|
|INCOREECT_ANSWER|유저 인풋을 다시 받음|
|CRRECT_ANSWER|FINISH_GAME으로 STATE를 이동|
|RE_GAME|다시 게임을 시작|
|EXIT|게임을 종료|

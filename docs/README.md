# 숫자 야구

## 기능 목록

- [ ] 게임 시작하는 문구 출력 - view#OutputView#printStartMessage()


- [ ] 상대방(컴퓨터)의 수 설정 - model#Generator#computerNumGenerator()
    - [ ] 1부터 9까지의 서로 다른 3개의 수 저장


- [ ] 플레이어의 수 입력 받기 - view#InputView#readPlayerNum()
    - [ ] 입력값 검증 - model#Validator#validatePlayerNum()
        - [ ] 입력값이 서로 다른 수가 아닌 경우 - model#Validator#checkDuplicate()
        - [ ] 숫자가 3개가 아닌 경우 - model#Validator#checkSize()
        - [ ] 입력값이 1부터 9까지의 숫자가 아닌 경우 - model#Validator#checkNumScope()


- [ ] 플레이어와 상대방(컴퓨터)의 수 비교 - model#Judge#compareNumbers()
    - [ ] 같은 수가 같은 자리에 있는 경우 스트라이크 값 증가
    - [ ] 같은 수가 다른 자리에 있는 경우 볼 값 증가


- [ ] 결과 출력 - view#OutputView#printResult()


- [ ] 3스트라이크가 아닌 경우 반복
- [ ] 3스트라이크인 경우 게임 종료


- [ ] 재시작/종료 여부 입력 받기 - view#InputView#readGameCommand()
    - [ ] 입력값 검증 - model#Validator#validateGameCommand()
        - [ ] 입력값이 1 또는 2가 아닌 경우
    - [ ] 게임 종료 후 1을 입력 받으면 **재시작**
    - [ ] 게임 종료 후 2를 입력 받으면 **종료**
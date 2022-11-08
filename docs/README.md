# 구현할 기능 목록

#### [구체화 및 구현 과정](./PROCESS.md)

### BaseballQuestion
- [x] 질문에 해당하는 정답(BaseballAnswer) 생성
  - 숫자야구 하는 자릿수가 가변적으로 변할 수 있도록 함 (BaseballType 이용)
- [x] 숫자를 제시하면, 그것에 해당하는 답변을 제시
  - 형식이 일치하지 않는 경우, IllegalArgumentException을 발생
  - 자릿 수가 서로 다른 N자리 숫자

### BaseballAnswer
- [x] 서로 다른 랜덤 세자리 수를 생성하여 답변으로 가짐
- [x] 숫자를 제시하면, 그것에 해당하는 답변을 제시 (BaseballResponse를 통해 구현)
- [x] 숫자를 제시하면, 답이 일치하는지 확인함

### ConsoleInput
- [x] 숫자를 입력받음 (숫자가 아닌 경우 예외를 발생시킴)

### ConsoleOutput
- [x] 주어진 메세지에 따라 출력
- [x] 출력할 메세지들은 OutputMessage, InputRequestMessage에 enum 값으로 둠 

### BaseballApplication
- [x] 전부 맞힐 때까지 반복적으로 질문하고 대답함
- [x] 정답을 맞히면 게임을 끝냄
- [x] 재시작 요청에 따라 재시작을 하거나 종료함
  - 입력값이 1,2 가 아니면 IllegalArgumentException을 발생시킴
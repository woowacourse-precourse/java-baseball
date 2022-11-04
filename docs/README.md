## 🚀 기능 요구 사항 정리
기능 요구 사항 정리는 다음과 같이 구성돼있습니다.

### 대상

- [x] 기능1
- [ ] 기능2
- [ ] ...

<hr>

### 0. Application
#### public
- [ ] psvm: 사용자가 1과 2를 입력하여 게임을 반복하여 진행합니다.


### 1. BaseBall: 
#### public
- [ ] void play(): 게임을 시작합니다.


### 2. AnswerGenerator
#### public
- [ ] String generate(): 정답을 생성합니다.


### 3. Validator - Interface
#### public
- boolean validate(String string): 구현체의 용도에 맞는 입력에 대하여 검증합니다.

- ### 3-1. BaseBallValidator: 야구 게임의 정답을 검증 합니다.
- - [ ] boolean validate(String string)

- ### 3-2. GameModeValidator: 게임의 재시작 여부 입력을 검증 합니다.
- - [ ] boolean validate(String string)

    
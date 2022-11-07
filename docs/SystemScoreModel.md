---
docs: SystemScoreModel 기능 구현 목록
## 기능 구현

- 주어진 입력값에 따라 Strike, Ball, Nothing 의 값을 출력하므로 따로 enum클래스를 만들어 조금 더 가독성있게 값을 리턴해주도록 하였다.
- getScore()
    - Controller 혹은 다른 모델에서 값이 필요 하므로 String 형식으로도 받을 수 있게 해주었다.

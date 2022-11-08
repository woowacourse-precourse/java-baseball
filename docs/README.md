# JAVA BASEBALL 

---

## 기능 구현 설계 이전 고민들...

---

0. junit5 의 테스트 방법을 공부한다.

```
기존에 아무생각없이 그냥 @Autowired로 주입받아서 테스트 돌리던거를 그대로 구현하려고 보니까 에러가 났다. 
springTest
```

1. 게임 진행을 위해 loop 문이 무조건 필요하다. &rarr; loop 문을 안써도 괜찮지 않을까?
2. input과 output은 camp package의 Console 객체를 활용한다! (*이것도 싱글톤으로 구현되어있다*)
3. state pattern을 적용시켜보자! 
   1. 사용자 input 
   2. 결과 도출 
   3. 정답 or 다시(1번 생태로) 
   4. 게임 다시 시작 혹은 종료

## 게임 상태 종류
1. input 상태 &rarr; 입력을 받기 위해 기다리는 상태
2. input 처리 및 결과 출력 상태 &rarr; 입력받은 값을 판단하여 상태를 update해야 한다. (1번, 3번 상태로 전이)
3. game over 상태 &rarr; 1번 혹은 2번을 input 받아 끝낼지 다시 시작할지 분기. (1번 혹은 끝나는 상태로 전이)

## 기능 구현 리스트 

- [ ] 상대방 난수 생성 구현
- [ ] game state interface 구조 확인
- [ ] game Manager에서 상태별로 state 분기
- [ ] 지속해서 run 진행
- [ ] 끝나는 조건에서 분기처리 진행





```mermaid
graph TD
A(컴퓨터의 수 생성) --> B(사용자의 입력)
B --> C{일치하는 숫자 있음?} 
C --> |YES| D{같은 자리?}
C --> |NO| E(NONE)
D --> |YES| F(Strike +1)
D --> |NO| G(Ball +1)
E --> H(결과 출력)
F --> H
G --> H
```

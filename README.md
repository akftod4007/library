# KBU Library
: 클래스 구조의 이해와 디자인 패턴의 이해를 위한 프로젝트

### 핵심코드

#### 로그인 전략 패턴
<details>
<summary>여기를 눌러주세요</summary>
<div markdown="1">       
public class LoginMethod {
    private LoginStrategy strategy;

    public void setStrategy(LoginStrategy strategy){
        this.strategy = strategy;
    }

    public boolean dologin() throws FileNotFoundException {
        return strategy.login();
    }
}
</div>
</details>
로그인을 처리할 때 모듈화와 전략 패턴을 사용해 사용자 로그인과 관리자 로그인을 관리하고 있음



#### 옵저버 패턴
![image](https://github.com/akftod4007/library/assets/113909192/cfb6aacb-d338-459d-9fc0-6f22bf45152e)

Book class에 등록된 책의 상태에 변화(대여, 반납)가 있으면 등록된 옵저버(사용자, 관리자)에게 변화를 알려줘서 사용자와 관리자가 책의 대출반납을 확인할 수 있도록 설계함

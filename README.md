# KBU Library
: 클래스 구조의 이해와 디자인 패턴의 이해를 위한 프로젝트

### 핵심코드

#### 로그인 전략 패턴


User 테이블과 Product 테이블을 연결하는 관계를 다대다 관계가 아닌 일대다,다대 일로 변경하여 테이블을 작성함

    static associate(db) {
        db.Review.belongsTo(db.User, { foreignKey: 'userId', targetKey: 'id' });
        db.Review.belongsTo(db.Product, { foreignKey: 'productId', targetKey: 'id' });
    }



#### 사용자 인증 시스템
<details>
<summary>API 요청과 DB 액세스를 제한하기 위해서 세션과 passport를 사용하여 사용자 인증 시스템 구현</summary>
<div markdown="1">
    
passport를 모듈화하여 사용중

    module.exports = () => {
          passport.serializeUser((user, done) => {
            done(null, user.id);
          });

    passport.deserializeUser((id, done) => {
        User.findOne({
          where: { id }
        })
        .then(user => done(null, user))
        .catch(err => done(err));
      });

      local();
      kakao();
    };


</div>
</details>

# Hackathon-BE

Spring Boot로 구현된 롤링페이퍼(메시지 보드) 백엔드입니다.
사용자 관리, 팔로우, 메시지 작성, 알림 기능 등을 제공합니다.

---

## 🗂️ 주요 기능

### ✅ 회원 가입 및 로그인

* `POST /api/v1/auth/signup`
* `POST /api/v1/auth/login`

### ✅ 프로필 조회

* `GET /api/v1/user/profile`

### ✅ 팔로우 기능

* `POST /api/v1/user/follow`
* `GET /api/v1/user/following`
* `GET /api/v1/user/follower`

### ✅ 롤링페이퍼 작성 및 조회

* `POST /api/v1/paper`
* `GET /api/v1/paper/my`
* `GET /api/v1/paper/friends`
* `GET /api/v1/paper/public`
* `GET /api/v1/paper/{uuid}`
* `GET /api/v1/paper/{uuid}/message`

### ✅ 메시지 작성

* `POST /api/v1/message`

### ✅ 알림 조회

* `GET /api/v1/notification`

---

## 📦 프로젝트 구조

```
src/main/java/com/example/hackathonbe
```

* `user`, `follow`, `paper`, `message`, `notification`, `skeleton` 등 **기능별 패키지**로 구성되어 있습니다.
* **예외 및 응답 포맷**은 `global` 패키지에서 관리합니다.

---

## ⚙️ 빌드 및 실행

* **JDK 17 이상**과 **Gradle**이 필요합니다.
* 저장소에는 **gradlew(Gradle Wrapper)** 가 포함되어 있어 별도 설치 없이 실행 가능합니다.
* MySQL 접속 정보를 **환경 변수**로 설정합니다.

  * `DB_USERNAME`
  * `DB_PASSWORD`

```bash
./gradlew bootRun
```

* 기본 API 경로는 **/api/v1**입니다.

---

## 🛠️ 설정

* 데이터베이스 연결 및 로깅 레벨은

  ```
  src/main/resources/application.yml
  ```

  에서 지정합니다.

* JPA의 `ddl-auto` 값이 **update**로 설정되어 있어
  **최초 실행 시 필요한 테이블이 자동 생성**됩니다.

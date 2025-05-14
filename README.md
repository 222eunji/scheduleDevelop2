# 📅 Schedule Develop

## 0️⃣ 개요
### **프로젝트 개요**
- 일정관리 앱 서버v2를 만들었습니다.
- 일정, 댓글, 답글 테이블을 가지며, 기본적인 CRUD 기능이 있습니다.
- CustomException을 사용하여 예외처리를 진행했습니다.
- local DB에 데이터 저장이 가능합니다.

### **프로젝트기간**
- 2025-04-30 ~ 2025-05-09
  
### **개발 환경** 
- jdk: 17.0.1
- Framework: Spring Boot 3.4.5
- Build Tool: Gradle
- IDE: IntelliJ
 <br/>
 
## 1️⃣ ERD 및 API명세서 작성
### **📌 ERD**
![ERD](https://github.com/user-attachments/assets/f4793154-588f-4e80-a8a7-69ba26623b62)

### **📌 Schedule API 명세서**
![screencapture-notion-so-teamsparta-API-ERD-1f22dc3ef5148130bed3f4bc8274220a-2025-05-15-00_00_09](https://github.com/user-attachments/assets/86817be6-eb59-4257-8bca-423b32abc6c6)
 
## 2️⃣ 기능 소개
### **🧩 SCHEDULE CRUD**
- **일정 생성**: title, content, userId를 입력받아 일정을 생성합니다.
- **전체 일정 조회**: 등록된 전체 일정의 ID, 작성자ID, 제목, 댓글수를 조회합니다. 일정이 없을 시 빈 리스트가 반환됩니다.
- **단건 일정 조회**: 일정의 상세 정보(일정ID, 작성자ID, 제목, 내용, 댓글 수, 작성일, 수정일)를 조회합니다. 해당 일정에 작성된 모든 댓글 목록도 함께 조회합니다 (작성일 기준 오름차순 정렬)
- **일정 수정**: title과 content 모두 수정이 가능하며,수정일이 자동 업데이트 됩니다.
- **일정 삭제**: scheduleId를 활용하여 일정을 삭제합니다.

### **🧩 COMMENT CRUD**
- **댓글 생성**: 일정ID, 내용을 입력받아 댓글을 생성합니다. (익명 댓글)
- **댓글 조회**: 댓글ID, 내용, 일정ID, 생성일, 수정일을 조회합니다.
- **댓글 수정**: content 수정이 가능하며, 수정일이 자동 업데이트 됩니다.
- **댓글 삭제**: commentId를 활용하여 댓글을 삭제합니다.

### **🧩 REPLY CRUD**
- **답글 생성**: 댓글ID, 내용을 입력받아 일정을 생성합니다. 답글은 1Depth까지만 허용합니다. 즉, 대댓글에 다시 대댓글은 불가능합니다.
- **답글 조회**: 답글을 조회 시, 부모 댓글 하위에 정렬되어 함께 조회합니다.
- **답글 수정**: content 수정이 가능하며, 수정일이 자동 업데이트 됩니다.
- **답글 삭제**: replyId를 활용하여 일정을 삭제합니다.
  
### **🚫 예외 처리**
- 존재하지 않는 일정/댓글/답글을 ID로 조회할 경우 404 Not Found CustomException이 발생합니다.
 <br/>
 

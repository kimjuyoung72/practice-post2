# Spring을 이용한 게시판 구현(v 0.1)
### 1. 요구사항
- 게시글 
  - 목록 표시
  - 작성 기능
  - 수정 기능
  - 삭제 기능
  - 검색 기능
- 댓글
  - 목록 표시
  - 작성 기능
  - 수정 기능
  - 삭제 기능
  - 검색 기능

### 2. 엔티티
- Member : 회원 정보
- Article : 게시글 정보
- Comment : 댓글 정보
- Tag : 게시글 검색 태그

### 3. Rest API
- GET/articles : 게시글 목록
- POST/articles : 게시글 작성
- GET/articles/{id} : 게시글 상세
- PUT/articles/{id} : 게시글 수정
- GET/search/articles : 게시글 검색
- POST/articles/{id}/comments : 댓글 작성
- PUT/comments/{id} : 댓글 수정
- DELETE/comments/{id} : 댓글 삭제
- GET/search/comments : 댓글 검색

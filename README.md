# spring-boot-sandbox
이것 저것 넣어보고 싶은 기능들 테스트
- [공통 응답 객체 사용](#common_response)
---
### 공통 응답 <a id="common_response"></a>
```json
{
  "result": true,
  "body": {
    "exampleKey": "exampleValue"
  }
}
```
```json
{
    "result": false,
    "body": null,
    "errorCode": "API_ERROR",
    "errorMessage": "API 요청이 실패하였습니다."
}
```

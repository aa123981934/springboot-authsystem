# Spring Boot 會員認證系統 (Auth System)

這是一個基於 Spring Boot 3 與 Spring Security 實作的標準會員認證系統。專案採用嚴謹的系統架構開發，解決了實體曝露、資料驗證及安全性加密等常見問題。

## 🚀 技術棧
* **後端**: Java 17+, Spring Boot 3.x
* **安全**: Spring Security (BCrypt 加密)
* **資料庫**: Spring Data JPA, H2/MySQL
* **工具**: Lombok, Jakarta Validation

## ✨ 核心亮點
1. **DTO 模式應用**: 建立 `UserRegistrationDto` 隔離資料庫實體與傳輸對象，有效防止 Over-posting 攻擊。
2. **安全性加固**: 實作 `BCryptPasswordEncoder` 確保使用者密碼不以明文存儲，並配置 CSRF 保護。
3. **後端欄位驗證**: 使用 `@Valid` 與 `BindingResult` 進行嚴格的格式校驗（如 Email 格式、密碼長度）。
4. **事務管理**: 在註冊邏輯中使用 `@Transactional` 確保資料操作的一致性。

## 🛠 如何運行
1. Clone 此專案到本地。
2. 確保已安裝 Maven 與 JDK 17。
3. 執行 `mvn spring-boot:run`。
4. 訪問 `(http://127.0.0.1:8080/login)` 開始測試。

---
*本專案為學習 Spring Boot 標準架構實作之成果。*

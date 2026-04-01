# Pracfinal API - JSON Test Examples

## Base URL
```
http://localhost:8080
```

---

## 1. USER REGISTRATION

### Endpoint
```
POST /api/register
```

### Request JSON
```json
{
  "login": "johndoe",
  "email": "john@example.com",
  "firstName": "John",
  "lastName": "Doe",
  "password": "MyPassword123!",
  "langKey": "en"
}
```

### Alternative Examples

**Example 2 - Simple User:**
```json
{
  "login": "alice",
  "email": "alice@company.com",
  "firstName": "Alice",
  "lastName": "Smith",
  "password": "SecurePass@123",
  "langKey": "en"
}
```

**Example 3 - User with Different Language:**
```json
{
  "login": "bob_smith",
  "email": "bob@example.com",
  "firstName": "Bob",
  "lastName": "Smith",
  "password": "BobPassword@456",
  "langKey": "es"
}
```

---

## 2. CREATE USER (Admin Only)

### Endpoint
```
POST /api/admin/users
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json
```

### Request JSON - Regular User
```json
{
  "login": "newuser",
  "email": "newuser@example.com",
  "firstName": "New",
  "lastName": "User",
  "activated": true,
  "langKey": "en",
  "authorities": ["ROLE_USER"]
}
```

### Request JSON - Admin User
```json
{
  "login": "adminuser",
  "email": "admin@company.com",
  "firstName": "Admin",
  "lastName": "Account",
  "activated": true,
  "langKey": "en",
  "authorities": ["ROLE_ADMIN", "ROLE_USER"]
}
```

### Request JSON - Inactive User
```json
{
  "login": "pendinguser",
  "email": "pending@example.com",
  "firstName": "Pending",
  "lastName": "Activation",
  "activated": false,
  "langKey": "en",
  "authorities": ["ROLE_USER"]
}
```

---

## 3. GET ALL USERS (Admin Only)

### Endpoint
```
GET /api/admin/users?page=0&size=20&sort=id,desc
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json
```

### Response JSON Example
```json
[
  {
    "id": 1,
    "login": "admin",
    "firstName": "Administrator",
    "lastName": "User",
    "email": "admin@localhost",
    "imageUrl": null,
    "activated": true,
    "langKey": "en",
    "createdBy": "system",
    "createdDate": "2026-04-01T09:00:00Z",
    "lastModifiedBy": "admin",
    "lastModifiedDate": "2026-04-01T10:30:00Z",
    "authorities": ["ROLE_ADMIN", "ROLE_USER"]
  },
  {
    "id": 2,
    "login": "user",
    "firstName": "Normal",
    "lastName": "User",
    "email": "user@example.com",
    "imageUrl": null,
    "activated": true,
    "langKey": "en",
    "createdBy": "admin",
    "createdDate": "2026-04-01T09:30:00Z",
    "lastModifiedBy": "user",
    "lastModifiedDate": "2026-04-01T11:00:00Z",
    "authorities": ["ROLE_USER"]
  }
]
```

---

## 4. GET SPECIFIC USER (Admin Only)

### Endpoint
```
GET /api/admin/users/{login}
```

### Example
```
GET /api/admin/users/johndoe
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
```

### Response JSON
```json
{
  "id": 3,
  "login": "johndoe",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "imageUrl": null,
  "activated": true,
  "langKey": "en",
  "createdBy": "admin",
  "createdDate": "2026-04-01T12:00:00Z",
  "lastModifiedBy": "johndoe",
  "lastModifiedDate": "2026-04-01T13:15:00Z",
  "authorities": ["ROLE_USER"]
}
```

---

## 5. UPDATE USER (Admin Only)

### Endpoint
```
PUT /api/admin/users/{login}
```

### Example
```
PUT /api/admin/users/johndoe
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json
```

### Request JSON
```json
{
  "id": 3,
  "login": "johndoe",
  "firstName": "John Updated",
  "lastName": "Doe Updated",
  "email": "john.updated@example.com",
  "activated": true,
  "langKey": "es",
  "authorities": ["ROLE_ADMIN", "ROLE_USER"]
}
```

---

## 6. DELETE USER (Admin Only)

### Endpoint
```
DELETE /api/admin/users/{login}
```

### Example
```
DELETE /api/admin/users/johndoe
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
```

### Response
```
No Content (HTTP 204)
```

---

## 7. AUTHENTICATE / LOGIN

### Endpoint
```
POST /api/authenticate
```

### Request JSON
```json
{
  "username": "admin",
  "password": "admin",
  "rememberMe": true
}
```

### Response JSON
```json
{
  "id_token": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0NTA2NzUwMH0..."
}
```

---

## 8. GET CURRENT USER ACCOUNT

### Endpoint
```
GET /api/account
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
```

### Response JSON
```json
{
  "id": 1,
  "login": "admin",
  "firstName": "Administrator",
  "lastName": "User",
  "email": "admin@localhost",
  "imageUrl": null,
  "activated": true,
  "langKey": "en",
  "createdBy": "system",
  "createdDate": "2026-04-01T09:00:00Z",
  "lastModifiedBy": "admin",
  "lastModifiedDate": "2026-04-01T10:30:00Z",
  "authorities": ["ROLE_ADMIN", "ROLE_USER"]
}
```

---

## 9. UPDATE CURRENT USER ACCOUNT

### Endpoint
```
POST /api/account
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json
```

### Request JSON
```json
{
  "firstName": "Updated First Name",
  "lastName": "Updated Last Name",
  "email": "newemail@example.com",
  "langKey": "es",
  "imageUrl": "https://example.com/avatar.jpg"
}
```

---

## 10. CHANGE PASSWORD

### Endpoint
```
POST /api/account/change-password
```

### Headers Required
```
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json
```

### Request JSON
```json
{
  "currentPassword": "oldPassword@123",
  "newPassword": "newPassword@456"
}
```

---

## 11. REQUEST PASSWORD RESET

### Endpoint
```
POST /api/account/reset-password/init
```

### Request (Plain Text)
```
admin@localhost
```

### Or Request JSON
```json
{
  "email": "admin@localhost"
}
```

---

## 12. FINISH PASSWORD RESET

### Endpoint
```
POST /api/account/reset-password/finish
```

### Request JSON
```json
{
  "key": "reset_key_from_email",
  "newPassword": "NewPassword@789"
}
```

---

## 13. ACTIVATE ACCOUNT

### Endpoint
```
GET /api/activate?key=activation_key_from_email
```

### Example
```
GET /api/activate?key=1a2b3c4d5e6f7g8h9i0j
```

---

## 14. GET PUBLIC USERS

### Endpoint
```
GET /api/public/users?page=0&size=20&sort=id,desc
```

### No Authorization Required

### Response JSON
```json
[
  {
    "id": 1,
    "login": "user1",
    "firstName": "User",
    "lastName": "One"
  },
  {
    "id": 2,
    "login": "user2",
    "firstName": "User",
    "lastName": "Two"
  }
]
```

---

## Testing Steps

### 1. Register New User
```bash
curl -X POST http://localhost:8080/api/register \
  -H "Content-Type: application/json" \
  -d '{
    "login": "testuser",
    "email": "test@example.com",
    "firstName": "Test",
    "lastName": "User",
    "password": "TestPassword@123",
    "langKey": "en"
  }'
```

### 2. Authenticate (Login)
```bash
curl -X POST http://localhost:8080/api/authenticate \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "TestPassword@123"
  }'
```

### 3. Get Current Account (using token from step 2)
```bash
curl -X GET http://localhost:8080/api/account \
  -H "Authorization: Bearer YOUR_JWT_TOKEN_HERE"
```

### 4. Create New User (as Admin)
```bash
curl -X POST http://localhost:8080/api/admin/users \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ADMIN_JWT_TOKEN_HERE" \
  -d '{
    "login": "newadminuser",
    "email": "admin@example.com",
    "firstName": "Admin",
    "lastName": "User",
    "activated": true,
    "langKey": "en",
    "authorities": ["ROLE_ADMIN", "ROLE_USER"]
  }'
```

---

## Notes

- Replace `YOUR_JWT_TOKEN_HERE` with actual token from login response
- Password requirements: Minimum 8 characters
- Login and email must be unique
- Admin endpoints require `ROLE_ADMIN` authority
- All timestamps are in ISO 8601 format (UTC)
- Default admin login: `admin` | password: `admin`


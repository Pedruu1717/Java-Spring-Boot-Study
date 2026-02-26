## 🎯 System objective

Allow customers to:

* Create an account
* Check their balance
* Make deposits
* Make withdrawals
* Transfer funds between accounts
* View their statement


## 🧱 Basic system structure
### 👤 Customers have 💳 Accounts and can make 💸 Transactions

---

## 🔌 API endpoints (REST example)

### Create customer

```
POST /customers
```

### Create account

```
POST /accounts
```

### Deposit

```
POST /accounts/{id}/deposit
```

### Withdraw

```
POST /accounts/{id}/withdrawal
```

### Transfer

```
POST /accounts/transfer
```

### View statement

```
GET /accounts/{id}/statement
```

---

## 🧠 Bank rules

* ❌ You cannot withdraw if your balance is insufficient.
* ❌ You cannot transfer a negative amount.
* ❌ CPF numbers cannot be duplicated.
* ✔️ Every movement must generate a transaction.
* ✔️ Transfers must debit one account and credit another (atomic transaction).

## 🛠 Technologies used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* Database: MySQL
* Testing with JUnit
* Docker

---

## 🚀 @TODO in the future

* Authentication with JWT
* Access control (customers only see their own accounts)
* Pagination in statements
* Global exception handling
* Audit logs

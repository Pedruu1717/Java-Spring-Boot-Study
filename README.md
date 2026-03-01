## 🎯 System objective

Allow clients to:

* Create an account
* Check their balance
* Make deposits
* Make withdrawals
* Transfer funds between accounts
* View their statement


## 🧱 Basic system structure
👤 Client<br>
 &nbsp; |---------------> 💳 Accounts<br> 
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; |--------------> 💸 Transactions

---

## 🔌 API endpoints (REST example)

### Create client

```
POST /api/client/add
```

### Create account

```
POST /api/account/add
```

### Deposit, Withdrawal and Transfer


transfer_type = <b>DEPOSIT</b> or <b>WITHDRAWAL</b> or <b>TRANSFER</b>
```
POST /api/transaction/add?type={transfer_type}
```

### View statements

```
GET /transactions
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

## 🚀 @TODO in the future

* Authentication with JWT
* Access control (clients only see their own accounts)
* Pagination in statements
* Global exception handling
* Audit logs

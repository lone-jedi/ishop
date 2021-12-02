# Internet Shop
## 1. Installation guide
#### 1.1 At first run docker command to start postgres:
``docker run --name=main-pg --env=POSTGRES_USER=postgres --env=POSTGRES_PASSWORD=121212 --env=POSRGRES_DB=postgres -p 5432:5432 postgres``

#### 1.2 Create in Postgres database `ishop`
#### 1.3 Create table `product`
```sql
CREATE TABLE IF NOT EXISTS product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price NUMERIC NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```


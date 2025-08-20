# Category-Product CRUD (Spring Boot 3 + MySQL)

## How to run
1. Ensure MySQL is running and accessible on `localhost:3306` with user `root`/`root` (edit `application.yml` if needed).
2. Create DB (auto): the app uses `createDatabaseIfNotExist=true` so it will create `cp_crud` on first run.
3. Build & run:
   ```bash
   mvn spring-boot:run
   ```

## API
- Categories: `/api/categories`
- Products: `/api/products`

Supports: CRUD, pagination (`page`, `size`), validation, global error handling.

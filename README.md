# CGS Test Task

A simple Spring Boot application for managing bus routes, seats, and bookings.

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/Valighieri/cgs-test-task.git
   cd cgs-test-task
   ```

2. Start services with Docker Compose:

   ```bash
   docker-compose up
   ```

3. The application will be available at:

    * **App:** [http://localhost:8080](http://localhost:8080)
    * **Database (PostgreSQL):** localhost:5432

## Configuration

By default, the Docker Compose file maps:

* **App port:** `8080:8080`
* **DB port:**  `5432:5432`

If you already run PostgreSQL locally or need different ports, update the `ports` section in `docker-compose.yml`:

```yaml
services:
  db:
    ports:
      - "<your-db-port>:5432"

  app:
    ports:
      - "<your-app-port>:8080"
```

Then restart:

```bash
docker-compose down
docker-compose up --build
```

---

## IntelliJ HTTP Client Requests

I’ve included a `requests.http` file in the project root alongside this README. It contains example HTTP calls for all API endpoints. To use it:

1. Open `requests.http` in IntelliJ IDEA.
2. Click the ▶️ icon next to any request line to execute.
3. View the response inline without leaving the IDE.


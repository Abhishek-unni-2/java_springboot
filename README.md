Spring Boot + Nginx Deployment
This project demonstrates a simple Spring Boot application (CRUD API for User Records) deployed with Nginx as the reverse proxy, serving static content from /var/www/html.

📂 Project Structure
graphql
Copy
Edit
.
├── src/                 # Spring Boot source code
├── pom.xml              # Maven build configuration
├── index.html           # Static HTML file (placed in /var/www/html)
└── nginx-config         # Nginx configuration file (sites-available/default)
⚙️ Requirements
Java 17+

Maven 3+

Nginx installed on server

Linux/Unix environment (for paths mentioned below)

🚀 Build & Run Spring Boot App
bash
Copy
Edit
# Build the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run
The API will be available at:
http://localhost:8080/records

🌐 API Endpoints
Method	Endpoint	Description
GET	/records	Get all records
POST	/records	Create a new record
GET	/records/{id}	Get record by ID
PUT	/records/{id}	Update record by ID
DELETE	/records/{id}	Delete record by ID

Example curl Commands
bash
Copy
Edit
# Get all records
curl -X GET http://localhost:8080/records

#Access the application
Open your browser: http://localhost/


# Create a record
curl -X POST http://localhost:8080/records \
     -H "Content-Type: application/json" \
     -d '{"name":"John Doe","email":"john@example.com"}'

# Get record by ID
curl -X GET http://localhost:8080/records/1

# Update record
curl -X PUT http://localhost:8080/records/1 \
     -H "Content-Type: application/json" \
     -d '{"name":"Jane Doe","email":"jane@example.com"}'

# Delete record
curl -X DELETE http://localhost:8080/records/1
📄 Nginx Setup
1️⃣ Place index.html in:
bash
Copy
Edit
cd /var/www/html
2️⃣ Place Nginx configuration in:
bash
Copy
Edit
cd /etc/nginx/sites-available
Example configuration (default):

nginx
Copy
Edit
server {
    listen 80;

    location / {
        root /var/www/html;
        index index.html;
    }

    location /api/ {
        proxy_pass http://localhost:8080/;
    }
}
3️⃣ Enable the configuration:
bash
Copy
Edit
sudo ln -s /etc/nginx/sites-available/default /etc/nginx/sites-enabled/
sudo nginx -t
sudo systemctl restart nginx
📦 Deployment Steps
Build Spring Boot JAR:

bash
Copy
Edit
mvn clean package
Copy JAR to server.

Run:

bash
Copy
Edit
java -jar target/demo-0.0.1-SNAPSHOT.jar
Configure Nginx and serve HTML.

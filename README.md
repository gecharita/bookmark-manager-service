#Bookmark Manager Service

---
Client of the following project:
https://github.com/gecharita/bookmark-manager
---

- Requires JAVA 11.
- Runs on port **8900**.
- **H2 in memory DB** is being initialized when the applications starts.
- The initialization script of the DB can be found here:
  [src/main/resources/data.sql](src/main/resources/data.sql)
  
##REST API:
It exposes the following endpoints:
- GET: /api/bookmarks
- POST: /api/bookmarks
- DELETE: /api/bookmarks/{id}
- PUT: /api/bookmarks/{id}
- GET: /api/bookmarks/test -> for testing

####Request & Response Body example:
```json
{
    "id": 3,
    "name": "google",
    "url": "www.google.com",
    "group": "general"
}
```

##How to run:
```sh
# For MAC or LINUX users
./mvnw clean package
./mvnw spring-boot:run 
```

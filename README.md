# Spring RESTful Web Services

***Language:*** Java <br />
***Library:*** Spring, RESTful API <br />

***Summary:***<br />
This project is a Social Media Application developed using Spring framework and RESTful API. The application provides endpoints to perform CRUD operations on users and their posts. Users can be added, retrieved, and deleted, while posts can be added, retrieved, and deleted for a specific user.

## Endpoints

The following endpoints are available in the application:

**Users:**
- Retrieve all Users: GET /users
- Create a User: POST /users
- Retrieve a User: GET /users/{id}  (e.g., /users/1)
- Delete a User: DELETE /users/{id}  (e.g., /users/1)

**Posts:**
- Retrieve all posts for a User: GET /users/{id}/posts  (e.g., /users/1/posts)
- Create a post for a User: POST /users/{id}/posts  (e.g., /users/1/posts)
- Retrieve details of a post: GET /users/{id}/posts/{post_id}  (e.g., /users/1/posts/1)

## Storage

In this version of the project, Lists are used for storage, allowing data to be stored in memory. For a version using SQL, please refer to the Spring-RESTful-SQL repository.

## Usage

To use the Spring RESTful Web Services application, follow these steps:

1. Set up a Java development environment with Spring framework and necessary dependencies.

2. Clone the project repository to your local machine.

3. Build and run the application.

4. Use a tool like Postman to send requests to the available endpoints.

5. Perform the desired operations such as adding users, retrieving users, deleting users, adding posts, retrieving posts, etc.

6. Use the appropriate HTTP methods and endpoint URLs mentioned above to interact with the application.

7. Retrieve and verify the responses from the server.

Feel free to customize the application according to your requirements, such as adding additional endpoints or modifying the storage mechanism.

## Contributors

- [rayin19](https://github.com/rayin19): Project Developer

Feel free to contribute to the project by submitting pull requests, reporting issues, or suggesting improvements.



---

# Online Quiz Application

A Spring Boot application for creating and managing quiz questions, providing functionalities to handle question CRUD operations, fetch quiz questions by subject, and deliver a randomized set of questions for users.

## Features

- **Create Questions**: Add new questions with multiple choices and correct answers.
- **View Questions**: Retrieve all questions or specific questions by ID.
- **Update Questions**: Modify existing questions by their ID.
- **Delete Questions**: Remove questions from the database.
- **Filter by Subject**: Fetch questions based on specific subjects.
- **Randomized Questions**: Retrieve a random subset of questions for a user to take the quiz.

## Technologies Used

- **Spring Boot**: Backend framework.
- **Hibernate/JPA**: ORM for database operations.
- **Lombok**: Simplified Java code with annotations.
- **Jakarta Validation**: For request validation.
- **MySQL/PostgreSQL**: Database (adjustable based on your preference).
- **Maven**: Build and dependency management tool.

## Project Structure

```
src/main/java/topg/online_quiz
    ├── model
    │   └── Question.java      // Entity class for Quiz Questions
    ├── controller
    │   └── QuestionController.java // REST APIs for managing questions
    ├── service
    │   └── QuestionService.java   // Business logic for question management
    └── repository
        └── QuestionRepository.java // JPA Repository for Question entity
```

## Endpoints

### Base URL: `/api/quizzes`

| HTTP Method | Endpoint                           | Description                                                   |
|-------------|------------------------------------|---------------------------------------------------------------|
| POST        | `/create-question`                | Create a new quiz question.                                   |
| GET         | `/questions`                      | Retrieve all questions.                                       |
| GET         | `/questions/{id}`                 | Retrieve a question by its ID.                                |
| PUT         | `/questions/update/{id}`          | Update an existing question by ID.                           |
| DELETE      | `/questions/{id}`                 | Delete a question by its ID.                                  |
| GET         | `/subjects`                       | Retrieve all unique subjects.                                |
| GET         | `/fetch-question-for-user`        | Fetch a randomized subset of questions by subject.           |

## Example JSON Payloads

### Create Question
```json
{
  "question": "What is the capital of France?",
  "subject": "Geography",
  "questionType": "MCQ",
  "choices": ["Paris", "Berlin", "Madrid", "Rome"],
  "correctAnswers": ["Paris"]
}
```

### Fetch Questions for Users
**Endpoint**: `/fetch-question-for-user?numOfQuestions=5&subject=Geography`

## Setup Instructions

### Prerequisites
- Java 17 or later
- Maven 3.8+
- A relational database (MySQL, PostgreSQL, etc.)
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd online-quiz
   ```
3. Configure the database:
   - Update `application.properties` with your database credentials.
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```
4. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the API at `http://localhost:8080/api/quizzes`.

## Future Enhancements

- User authentication and authorization.
- Quiz scoring and result storage.
- Timer-based quizzes.
- Enhanced UI with frontend integration (e.g., React or Angular).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

This README gives a professional overview of your project, describing its features, setup, and usage.

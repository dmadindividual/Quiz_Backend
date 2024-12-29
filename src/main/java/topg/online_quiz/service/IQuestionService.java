package topg.online_quiz.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import topg.online_quiz.model.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {
    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(Long questionId);
    List<String> getAllSubjects();
    Question updateQuestionById(Long questionId, Question question) throws ChangeSetPersister.NotFoundException;
    void deleteQuestionById(Long questionId);
    List<Question> getQuestionsForUsers(Integer numOfQuestions, String subject );

}

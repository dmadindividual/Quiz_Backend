package topg.online_quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topg.online_quiz.model.Question;
import topg.online_quiz.repository.QuestionRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{
    private final QuestionRepository questionRepository;
    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Long questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public List<String> getAllSubjects() {
        return questionRepository.findDistinctSubject();
    }

    @Override
    public Question updateQuestionById(Long questionId, Question question) throws ChangeSetPersister.NotFoundException {
        Optional<Question> theQuestion = this.getQuestionById(questionId);
        if(theQuestion.isPresent()){
            Question updatedQuestion =  theQuestion.get();
            updatedQuestion.setQuestion(question.getQuestion());
            updatedQuestion.setSubject(question.getSubject());
            updatedQuestion.setChoices(question.getChoices());
            updatedQuestion.setCorrectAnswers(question.getCorrectAnswers());
            return questionRepository.save(updatedQuestion);

        }else{
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public void deleteQuestionById(Long questionId) {
        questionRepository.deleteById(questionId);

    }

    @Override
    public List<Question> getQuestionsForUsers(Integer numOfQuestions, String subject) {
        Pageable pageable = (Pageable) PageRequest.of(0, numOfQuestions);
        return questionRepository.findBySubject(subject, pageable).getContent();
    }
}


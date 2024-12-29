package topg.online_quiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import topg.online_quiz.model.Question;
import topg.online_quiz.service.QuestionService;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quizzes")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/create-question")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> createQuestion(@Valid  @RequestBody Question question){
        Question questionServiceQuestion = questionService.createQuestion(question);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/questions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questionList = questionService.getAllQuestions();
        return ResponseEntity.ok(questionList);
    }

    @GetMapping("/questions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable("id") Long questionId) throws ChangeSetPersister.NotFoundException {
        Optional<Question> question = questionService.getQuestionById(questionId);
      if(question.isPresent()){
          return ResponseEntity.ok(question);
      }else {
          throw new ChangeSetPersister.NotFoundException();
      }
    }

    @PutMapping("/questions/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Question> updateQuestionById(@PathVariable("id") Long questionId, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        Question question1 = questionService.updateQuestionById(questionId, question);
        return ResponseEntity.ok(question1);
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable("id") Long questionId){
        questionService.deleteQuestionById(questionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subjects")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getAllSubjects(){
       List<String> getSubjects =  questionService.getAllSubjects();
       return ResponseEntity.ok(getSubjects);
    }

    @GetMapping("/fetch-question-for-user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Question>>getQuestionsForUsers(@RequestParam Integer numOfQuestions, @RequestParam String subject){
        List<Question> allQuestions = questionService.getQuestionsForUsers(numOfQuestions, subject);
        List<Question> mutableQuestions= new ArrayList<>(allQuestions);
        Collections.shuffle(mutableQuestions);
        int availableQuestions = Math.min(numOfQuestions, mutableQuestions.size());
        List<Question> randomQuestion = mutableQuestions.subList(0, availableQuestions);
        return ResponseEntity.ok(randomQuestion);

    }








}

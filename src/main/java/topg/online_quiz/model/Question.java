package topg.online_quiz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String question;
    @NotBlank
    private String subject;
    @NotBlank
    private String questionType;
    @NotBlank
    @ElementCollection
    private List<String> choices;
    @NotBlank
    @ElementCollection
    private List<String> correctAnswers;
}

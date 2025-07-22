package com.vishalverma04.StudentSphere.Service;

import com.vishalverma04.StudentSphere.Models.Comment;
import com.vishalverma04.StudentSphere.Models.QuestionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QuestionService {
    QuestionModel createQuestion(QuestionModel question);
    Optional<QuestionModel> getQuestionById(String id);
    List<QuestionModel> getAllQuestions();
    Page<QuestionModel> getAllQuestions(Pageable pageable);
    QuestionModel updateQuestion(String id, QuestionModel updated);
    void deleteQuestion(String id);

    List<QuestionModel> getByCompany(String company);
    List<QuestionModel> getByDifficulty(String difficultyLevel);
    List<QuestionModel> getByQuestionType(String questionType);
    List<QuestionModel> getByTags(List<String> tags);
    List<QuestionModel> getByTopics(List<String> topics);
    List<QuestionModel> getByUploader(String uploadedBy);
    List<QuestionModel> getUploadedAfter(LocalDateTime date);
    List<QuestionModel> searchByTitle(String keyword);

    QuestionModel likeQuestion(String id);
    QuestionModel unlikeQuestion(String id);
    QuestionModel addComment(String id, Comment comment);
    QuestionModel markVerified(String id, boolean verified);
}

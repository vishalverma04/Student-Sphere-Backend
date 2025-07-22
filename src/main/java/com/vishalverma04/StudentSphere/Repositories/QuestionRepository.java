package com.vishalverma04.StudentSphere.Repositories;

import com.vishalverma04.StudentSphere.Models.QuestionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionModel,String> {

    // Find by company
    List<QuestionModel> findByCompanyIgnoreCase(String company);

    // Find by difficulty level
    List<QuestionModel> findByDifficultyLevelIgnoreCase(String difficultyLevel);

    // Find by question type (OA, Interview, etc.)
    List<QuestionModel> findByQuestionTypeIgnoreCase(String questionType);

    // Search by tags
    List<QuestionModel> findByTagsIn(List<String> tags);

    // Search by topics
    List<QuestionModel> findByTopicsIn(List<String> topics);

    // Find all by uploadedBy
    List<QuestionModel> findByUploadedBy(String uploadedBy);

    // Find all questions uploaded after a specific date
    List<QuestionModel> findByUploadedAtAfter(java.time.LocalDateTime date);

    // Custom method to search by title (partial match)
    List<QuestionModel> findByTitleContainingIgnoreCase(String keyword);
}

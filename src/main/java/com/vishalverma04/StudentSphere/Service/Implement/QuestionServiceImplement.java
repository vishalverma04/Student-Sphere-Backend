package com.vishalverma04.StudentSphere.Service.Implement;

import com.vishalverma04.StudentSphere.Models.Comment;
import com.vishalverma04.StudentSphere.Models.QuestionModel;
import com.vishalverma04.StudentSphere.Repositories.QuestionRepository;
import com.vishalverma04.StudentSphere.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImplement implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionModel createQuestion(QuestionModel question) {
        if (question.getUploadedAt() == null) {
            question.setUploadedAt(LocalDateTime.now());
        }
        if (question.getTags() == null) question.setTags(new ArrayList<>());
        if (question.getTopics() == null) question.setTopics(new ArrayList<>());
        if (question.getComments() == null) question.setComments(new ArrayList<>());
        return questionRepository.save(question);
    }

    @Override
    public Optional<QuestionModel> getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<QuestionModel> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Page<QuestionModel> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public QuestionModel updateQuestion(String id, QuestionModel updated) {
        return questionRepository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setContent(updated.getContent());
            existing.setCompany(updated.getCompany());
            existing.setQuestionType(updated.getQuestionType());
            existing.setDifficultyLevel(updated.getDifficultyLevel());
            existing.setTags(updated.getTags());
            existing.setTopics(updated.getTopics());
            existing.setAskedDate(updated.getAskedDate());
            return questionRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Question not found: " + id));
    }

    @Override
    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<QuestionModel> getByCompany(String company) {
        return questionRepository.findByCompanyIgnoreCase(company);
    }

    @Override
    public List<QuestionModel> getByDifficulty(String difficultyLevel) {
        return questionRepository.findByDifficultyLevelIgnoreCase(difficultyLevel);
    }

    @Override
    public List<QuestionModel> getByQuestionType(String questionType) {
        return questionRepository.findByQuestionTypeIgnoreCase(questionType);
    }

    @Override
    public List<QuestionModel> getByTags(List<String> tags) {
        return questionRepository.findByTagsIn(tags);
    }

    @Override
    public List<QuestionModel> getByTopics(List<String> topics) {
        return questionRepository.findByTopicsIn(topics);
    }

    @Override
    public List<QuestionModel> getByUploader(String uploadedBy) {
        return questionRepository.findByUploadedBy(uploadedBy);
    }

    @Override
    public List<QuestionModel> getUploadedAfter(LocalDateTime date) {
        return questionRepository.findByUploadedAtAfter(date);
    }

    @Override
    public List<QuestionModel> searchByTitle(String keyword) {
        return questionRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public QuestionModel likeQuestion(String id) {
        QuestionModel q = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found: " + id));
        q.setLikes(q.getLikes() + 1);
        return questionRepository.save(q);
    }

    @Override
    public QuestionModel unlikeQuestion(String id) {
        QuestionModel q = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found: " + id));
        q.setLikes(Math.max(0, q.getLikes() - 1));
        return questionRepository.save(q);
    }

    @Override
    public QuestionModel addComment(String id, Comment comment) {
        QuestionModel q = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found: " + id));

        if (q.getComments() == null) {
            q.setComments(new ArrayList<>());
        }
        if (comment.getCommentedAt() == null) {
            comment.setCommentedAt(LocalDateTime.now());
        }

        q.getComments().add(comment);
        return questionRepository.save(q);
    }

    @Override
    public QuestionModel markVerified(String id, boolean verified) {
        QuestionModel q = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found: " + id));
        q.setVerified(verified);
        return questionRepository.save(q);
    }
}

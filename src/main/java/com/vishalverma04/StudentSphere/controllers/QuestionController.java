package com.vishalverma04.StudentSphere.controllers;

import com.vishalverma04.StudentSphere.Models.Comment;
import com.vishalverma04.StudentSphere.Models.QuestionModel;
import com.vishalverma04.StudentSphere.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*") // Allow frontend to access
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // ---------------------- CREATE ----------------------

    @PostMapping
    public QuestionModel createQuestion(@RequestBody QuestionModel question) {
        return questionService.createQuestion(question);
    }

    // ---------------------- READ ----------------------

    @GetMapping
    public List<QuestionModel> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/paged")
    public Page<QuestionModel> getPagedQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return questionService.getAllQuestions(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<QuestionModel> getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id);
    }

    // ---------------------- UPDATE ----------------------

    @PutMapping("/{id}")
    public QuestionModel updateQuestion(@PathVariable String id, @RequestBody QuestionModel updated) {
        return questionService.updateQuestion(id, updated);
    }

    // ---------------------- DELETE ----------------------

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
    }

    // ---------------------- FILTERS ----------------------

    @GetMapping("/company/{company}")
    public List<QuestionModel> getByCompany(@PathVariable String company) {
        return questionService.getByCompany(company);
    }

    @GetMapping("/type/{type}")
    public List<QuestionModel> getByQuestionType(@PathVariable String type) {
        return questionService.getByQuestionType(type);
    }

    @GetMapping("/difficulty/{level}")
    public List<QuestionModel> getByDifficulty(@PathVariable String level) {
        return questionService.getByDifficulty(level);
    }

    @GetMapping("/tags")
    public List<QuestionModel> getByTags(@RequestParam List<String> tags) {
        return questionService.getByTags(tags);
    }

    @GetMapping("/topics")
    public List<QuestionModel> getByTopics(@RequestParam List<String> topics) {
        return questionService.getByTopics(topics);
    }

    @GetMapping("/uploaded-by/{user}")
    public List<QuestionModel> getByUploader(@PathVariable String user) {
        return questionService.getByUploader(user);
    }

    @GetMapping("/after-date")
    public List<QuestionModel> getUploadedAfter(@RequestParam String date) {
        LocalDateTime parsed = LocalDateTime.parse(date);
        return questionService.getUploadedAfter(parsed);
    }

    @GetMapping("/search")
    public List<QuestionModel> searchByTitle(@RequestParam String keyword) {
        return questionService.searchByTitle(keyword);
    }

    // ---------------------- LIKE / UNLIKE ----------------------

    @PostMapping("/{id}/like")
    public QuestionModel likeQuestion(@PathVariable String id) {
        return questionService.likeQuestion(id);
    }

    @PostMapping("/{id}/unlike")
    public QuestionModel unlikeQuestion(@PathVariable String id) {
        return questionService.unlikeQuestion(id);
    }

    // ---------------------- COMMENT ----------------------

    @PostMapping("/{id}/comment")
    public QuestionModel addComment(@PathVariable String id, @RequestBody Comment comment) {
        return questionService.addComment(id, comment);
    }

    // ---------------------- VERIFY ----------------------

    @PostMapping("/{id}/verify")
    public QuestionModel markVerified(@PathVariable String id, @RequestParam boolean verified) {
        return questionService.markVerified(id, verified);
    }
    // In your QuestionController

    @GetMapping("/filter")
    public ResponseEntity<List<QuestionModel>> filterQuestions(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) List<String> topics,
            @RequestParam(required = false) String questionType
    ) {
        List<QuestionModel> questions = questionService.filterQuestions(fromDate, toDate, company, difficulty, topics,questionType);
        return ResponseEntity.ok(questions);
    }

}

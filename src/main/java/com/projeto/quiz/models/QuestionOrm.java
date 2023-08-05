package com.projeto.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "question_orm")
public class QuestionOrm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "option_a")
    private String optionA;
    @Column(name = "option_b")
    private String optionB;
    @Column(name = "option_c")
    private String optionC;
    @Column(name = "option_d")
    private String optionD;
    @Column(name = "response")
    private String response;

    @OneToMany(mappedBy = "questionOrm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserResponsesOrm> userQuestionsOrm = new ArrayList<>();

    public QuestionOrm() {
    }

    public QuestionOrm(String question, String optionA, String optionB, String optionC, String optionD, String response, List<UserResponsesOrm> userQuestionsOrm) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.response = response;
        this.userQuestionsOrm = userQuestionsOrm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<UserResponsesOrm> getUserQuestionsOrm() {
        return userQuestionsOrm;
    }

    public void setUserQuestionsOrm(List<UserResponsesOrm> userQuestionsOrm) {
        this.userQuestionsOrm = userQuestionsOrm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionOrm that = (QuestionOrm) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(optionA, that.optionA) && Objects.equals(optionB, that.optionB) && Objects.equals(optionC, that.optionC) && Objects.equals(optionD, that.optionD) && Objects.equals(response, that.response) && Objects.equals(userQuestionsOrm, that.userQuestionsOrm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, optionA, optionB, optionC, optionD, response, userQuestionsOrm);
    }

    @Override
    public String toString() {
        return "QuestionOrm{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", response='" + response + '\'' +
                ", userQuestionsOrm=" + userQuestionsOrm +
                '}';
    }
}

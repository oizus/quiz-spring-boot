package com.projeto.quiz.controllers;

import com.projeto.quiz.services.GenerateQuizService;
import com.projeto.quiz.utils.MediaType;
import com.projeto.quiz.vo.QuestionOrmVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz/questions")
@Tag(name = "Questions", description = "Endpoint to manage the generation of questions for users.")
public class GenerateQuizController {
    @Autowired
    GenerateQuizService generateFiveQuiz;

    @GetMapping(value = "/orm", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Generation of five questions about Object Relational Mapper (ORM) content.", description = "Generation of five questions about Object Relational Mapper (ORM) content.", tags = {"Questions"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = QuestionOrmVO.class))
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<QuestionOrmVO> getFiveQuiz() {
        return generateFiveQuiz.generateFiveQuizQuestionsOrm();
    }
}

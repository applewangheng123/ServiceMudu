package com.wh.testapi.wework.qibo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


//https://blog.csdn.net/weixin_43291944/article/details/95061580
class QuestionnaireTest {
    Questionnaire questionnaire=new Questionnaire();

    @ParameterizedTest
    @CsvFileSource(resources = "/data/create.csv")
    void adminInfo(String actId, String question_id) {
        questionnaire.adminInfo(actId,question_id);
    }

    @Test
    void adminInfox() {
        questionnaire.createExame();

    }
    @Test
    void createExamethe() {
        questionnaire.createExamether();

    }

    @Test
    void createExame() {
        questionnaire.getExam();
    }

    @Test
    void getNOyaml() {
        questionnaire.getNoYamlExam();
    }



}
package com.wh.testapi.wework.qibo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireTest {
    Questionnaire questionnaire=new Questionnaire();

    @Test
    void adminInfo() {
        questionnaire.adminInfo("","");

    }

    @Test
    void createInfo() {
    }
}
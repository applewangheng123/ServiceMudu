package com.wh.testapi.wework.qibo;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireTest {
    Questionnaire questionnaire=new Questionnaire();

    @Test
    @Step("我的是step")
    @Disabled("我是Disb")
    void adminInfo() {
        questionnaire.adminInfo("","");

    }

    @Test
    void createInfo() {
    }
}
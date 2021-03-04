package com.wh.testapi.wework.qibo;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("特大范围测试junit5的Dispaly")
@Story("特大测试下story")
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
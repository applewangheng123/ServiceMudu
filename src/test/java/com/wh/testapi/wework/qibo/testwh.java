package com.wh.testapi.wework.qibo;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class testwh {

    @BeforeAll
    static void initAll() {
        System.out.println("哎呀beforeall  \n");
    }
    @BeforeEach
    void init() {
        System.out.println("我的天哪beforeach \n");
    }

    @Feature("测试下Feature")
    @Story("测试下story")
    @Step("测试下step")
    @Description("看下Description")
    @Issue("http://www.baidu.com")
    @Link("http://www.baidu.com")
    @DisplayName("测试junit5的Dispaly")
    @Test
    void test1() {
    }
    @Test
    void test2() {
    }

}

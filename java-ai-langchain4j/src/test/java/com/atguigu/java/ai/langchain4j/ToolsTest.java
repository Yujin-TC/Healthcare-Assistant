package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.SeperateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {
    @Autowired
    private SeperateChatAssistant separateChatAssistant;
    @Test
    public void testCalculatorTools() {
        String answer = separateChatAssistant.chat(2, "1+2等于几，475695037565的平方根是多少？");
        System.out.println(answer);
    }
}
package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.atguigu.java.ai.langchain4j.assistant.SeperateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeperateChatAssistant seperateChatAssistant;
    @Test
    public void testSystemMessages() {
        String answer = seperateChatAssistant.chat(5, "今天几号呢");
        System.out.println(answer);
    }
    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testUserMessage() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我18了");
        System.out.println(answer2);
        String answer3 = memoryChatAssistant.chat("你知道我是谁吗,多大了");
        System.out.println(answer3);
    }

    @Test
    public void testV() {
        String answer1 = seperateChatAssistant.chat2(10, "我是环环");
        System.out.println(answer1);
        String answer2 = seperateChatAssistant.chat2(10, "我是谁");
        System.out.println(answer2);
    }


    @Test
    public void testUserInfo() {
        String username = "翠花";
        int age = 18;
        String answer = seperateChatAssistant.chat3(20, "我是谁，我多大了", username, age);
        System.out.println(answer);
    }
}

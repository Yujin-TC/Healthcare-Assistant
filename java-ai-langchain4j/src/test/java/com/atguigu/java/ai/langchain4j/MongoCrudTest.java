package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@SpringBootTest
public class MongoCrudTest {

        @Autowired
        private MongoTemplate mongoTemplate;

        /**@Test
        public void testInsert() {
            mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
        }*/

        @Test
        public void testInsert2() {
                ChatMessages chatMessages = new ChatMessages();
                chatMessages.setContent("聊天记录");
                mongoTemplate.insert(chatMessages);
                //mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
        }

        @Test
        public void testFindById() {
                ChatMessages chatMessages = mongoTemplate.findById("68a38071d0d3ba5948c12b17", ChatMessages.class);
                System.out.println(chatMessages);
        }

        @Test
        public void testUpdate() {
                Criteria criteria = Criteria.where("_id").is("68a38071d0d3ba5948c12b17");
                Query query = new Query(criteria);
                Update update = new Update();
                update.set("content", "新的聊天记录列表");
                //upsert修改和新增的功能
                mongoTemplate.upsert(query, update, ChatMessages.class);

        }
        @Test
        public void testDelete() {
                Criteria criteria = Criteria.where("_id").is("68a40024dd16863800986ab5");
                Query query = new Query(criteria);

                mongoTemplate.remove(query, ChatMessages.class);

        }

}

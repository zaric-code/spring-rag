package com.xunyu.rag.server;

import com.xunyu.rag.server.embedding.service.EmbeddingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmbeddingServiceTest {

    @Autowired
    private EmbeddingService embeddingService;

    @Test
    public void test(){
        Float[] ret = embeddingService.encode("你叫什么名字");
        System.out.println(Arrays.asList(ret));
    }

}

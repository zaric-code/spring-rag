package com.xunyu.rag.server.embedding;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "xunyu.rag.embedding")
@Component
@Data
public class EmbeddingConfig {

    private String baseUrl;

    private String model;

    private String apiKey;

    private Integer batchSize;

}

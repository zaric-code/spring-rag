package com.xunyu.rag.server.embedding.service.impl;

import com.google.common.collect.Lists;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.embeddings.CreateEmbeddingResponse;
import com.openai.models.embeddings.Embedding;
import com.openai.models.embeddings.EmbeddingCreateParams;
import com.xunyu.rag.server.embedding.EmbeddingConfig;
import com.xunyu.rag.server.embedding.service.EmbeddingService;
import com.xunyu.rag.server.exception.BizException;
import com.xunyu.rag.server.utils.VectorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmbeddingServiceImpl implements EmbeddingService {

    @Autowired
    private EmbeddingConfig config;

    @Override
    public List<Float[]> encodeList(List<String> texts) {
        List<Float[]> ret = new ArrayList<>();
        int batchSize = config.getBatchSize();
        int totalBatch = (texts.size() + batchSize - 1) / batchSize;
        // 分批执行
        for (int i = 0;i<totalBatch;i++){
            List<Float[]> subResult = subEncode(texts.subList(i * batchSize, (i + 1) * batchSize));
            ret.addAll(subResult);
        }
        return ret;
    }

    @Override
    public Float[] encode(String text) {
        List<Float[]> ret = subEncode(Lists.newArrayList(text));
        return ret.get(0);
    }

    private List<Float[]> subEncode(List<String> texts){
        // 创建客户端
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(config.getApiKey())
                .baseUrl(config.getBaseUrl())
                .build();

        // 创建向量化请求参数
        EmbeddingCreateParams params = EmbeddingCreateParams.builder()
                .model(config.getModel())
                .inputOfArrayOfStrings(texts)
                .build();
        try {
            // 发送请求并获取响应
            CreateEmbeddingResponse response = client.embeddings().create(params);
            return parseResponse(response);
        } catch (Exception e) {
            log.error("", e);
            throw new BizException(e.getMessage());
        }
    }

    private List<Float[]> parseResponse(CreateEmbeddingResponse response){
        List<Float[]> ret = new ArrayList<>();
        for (Embedding datum : response.data()) {
            ret.add(VectorUtil.toFloatArray(datum.embedding()));
        }
        return ret;
    }



}

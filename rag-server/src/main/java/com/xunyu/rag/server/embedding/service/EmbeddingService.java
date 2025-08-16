package com.xunyu.rag.server.embedding.service;

import java.util.List;

public interface EmbeddingService {

    List<Float[]> encodeList(List<String> texts);

    Float[] encode(String text);

}

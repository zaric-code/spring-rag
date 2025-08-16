# XunyuRAG · Spring Boot Retrieval-Augmented Generation Starter

> **One-liner:** A pragmatic, production-friendly RAG starter built with Spring Boot.

> **中文简介**：XunyuRAG 计划打造一个开箱即用、可在生产环境落地的 **Spring Boot 版 RAG（检索增强生成）** 项目：聚焦简洁、可替换、易部署。  
> 项目刚起步，如果你也对 Java 生态下的 RAG 感兴趣，**麻烦点个 ⭐ Star 支持一下**，也欢迎提交 Issue/PR 一起完善！

---

## 🧱 功能规划（Roadmap 中逐步实现）

- **数据接入**：文件上传（PDF/Docx/TXT/Markdown/CSV）
- **切分与清洗**：规则/语义切分、表格/图片抽取、页面范围、语言检测
- **嵌入（Embeddings）**：OpenAI、Azure OpenAI、Ollama/Local（bge/e5/gte）、自定义模型
- **重排（Rerank）**：Cross-Encoder/ColBERT，或外部服务接口
- **生成（LLM）**：OpenAI / Azure / Qwen / GLM / DeepSeek / 兼容 OpenAI API 的本地推理
- **管线**：标准 RAG、HyDE、RAPTOR（层次摘要）、多检索器融合
- **服务接口**：REST API + SSE/WS 流式输出
- **管理界面（可选）**：简单的前端控制台（后续发布）

> 欢迎在 Issue 里补充你的需求，我们会按呼声和工作量排期。


## ⭐ 支持项目

这个项目刚起步，**如果对你有帮助或你也期待 Java 生态下的 RAG 工程化方案，请先点一个 Star！**  
> Star 是开源作者最大的动力 🙌

---

## 📄 License

本项目采用 **MIT License**，详见 [LICENSE](LICENSE)。

---

## 📝 致谢

- 感谢开源社区在向量数据库、嵌入模型、评测工具上的大量探索（pgvector、ragflow、Elasticsearch、Langfuse、Ollama 等）。
- 灵感来源于数据工程与检索系统的最佳实践。

# CORS Auto-Configuration Library

Spring Boot 3.x 自动配置 CORS 请求的库。

## 功能特性

- 自动配置 CORS 过滤器，无需手动编写配置代码
- 支持通过 `application.yml` 或 `application.properties` 灵活配置
- 使用 `HIGHEST_PRECEDENCE` 优先级，确保 CORS 头在认证过滤器之前添加
- 开箱即用，添加依赖即可生效

## 安装

```xml
<dependency>
    <groupId>com.edu</groupId>
    <artifactId>cors</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 配置

在 `application.yml` 中配置：

```yaml
cors:
  enabled: true
  allowed-origins: "*"
  allowed-methods: GET,POST,PUT,DELETE,OPTIONS
  allowed-headers: "*"
  allow-credentials: true
  max-age: 3600
```

或在 `application.properties` 中配置：

```properties
cors.enabled=true
cors.allowed-origins=*
cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
cors.allowed-headers=*
cors.allow-credentials=true
cors.max-age=3600
```

## 配置项说明

| 配置项 | 说明 | 默认值 |
|--------|------|--------|
| `cors.enabled` | 是否启用 CORS 自动配置 | `true` |
| `cors.allowed-origins` | 允许的来源列表，`*` 表示允许所有 | `[]` |
| `cors.allowed-methods` | 允许的 HTTP 方法 | `GET,POST,PUT,DELETE,OPTIONS` |
| `cors.allowed-headers` | 允许的请求头，`*` 表示允许所有 | `["*"]` |
| `cors.allow-credentials` | 是否允许携带凭据（Cookie、Authorization 头） | `true` |
| `cors.max-age` | 预检请求缓存时间（秒） | `3600` |

## 禁用 CORS

如需禁用 CORS 自动配置，设置 `cors.enabled=false`：

```yaml
cors:
  enabled: false
```

或完全移除此依赖。

## 构建和安装

```bash
# 编译
mvn compile

# 安装到本地仓库
mvn install
```

## 安全说明

如需完全禁用 CORS，请从项目中移除此依赖。

## 版本要求

- Java 17+
- Spring Boot 3.4.x

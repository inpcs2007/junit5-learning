# WireMock
WireMock是一个开源的测试工具，支持HTTP响应存根、请求验证、代理/拦截、记录和回放。

官网链接：http://wiremock.org/docs/

# 最直接的用法： 
* 为Web/移动应用构建Mock Service
* 快速创建Web API原型
* 模拟Web Service中错误返回
* 录制HTTP请求和回放

# 常用函数
## stubFor
以下代码将配置一个Response，当URL完全匹配到"/some/thing"（包括查询参数）时，将返回状态200。
Response的主体将是"Hello world!",并且"Content-Type"标头将与"text/plain"的值一起发送。
```shell script
stubFor(get(urlEqualTo("/some/thing"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "text/plain")
                .withBody("Hello world!")));
```
### get
对应http的get
### post
对应http的post
### put
对应http的put
### delete
对应http的delete

### urlEqualTo
完全匹配传入的URL字符串
### urlMatching
匹配传入正则表达式的URL

### willReturn
期望返回结果
### aResponse
对应响应的结果（Response）

### withHeader
期望结果的头信息
### withStatus
期望结果的http状态码
### withBody
期望返回的body部分的内容
### withBodyFile
从文件中读取期望返回的body部分的内容

## Header
```shell script
stubFor(get(urlEqualTo("/whatever"))
        .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withHeader("Set-Cookie", "session_id=91837492837")
                .withHeader("Set-Cookie", "split_test_group=B") // You can call withHeader more than once for the same header if multiple values are required
                .withHeader("Cache-Control", "no-cache")));
```
## editStub
如果已经存在stub（分配了uuid），则可以进行编辑修改。
```shell script
    // init uuid
    UUID uuid = java.util.UUID.randomUUID();
    
    // init stub for hello wiremock!
    wireMockServer.stubFor(get(urlEqualTo("/wiremock-sapmel"))
            .withId(uuid).willReturn(aResponse().withBody("hello wiremock!")));
    Response response = given().when().get("http://localhost:8090/wiremock-sapmel");
    assertEquals(response.asString(), "hello wiremock!");
    
    // editstub for world wiremock!
    wireMockServer.editStub(get(urlEqualTo("/wiremock-sapmel"))
            .withId(uuid).willReturn(aResponse().withBody("world wiremock!")));
    
    response = given().when().get("http://localhost:8090/wiremock-sapmel");
    assertEquals(response.asString(), "world wiremock!");
```
## remove stub
```shell script
    wireMockServer.stubFor(get(urlEqualTo("/wiremock-sapmel"))
                    .willReturn(aResponse().withStatus(200)));
    
    given().
            when().
            get("http://localhost:8090/wiremock-sapmel").
            then().
            assertThat().statusCode(200);
    wireMockServer.removeStub(get(urlEqualTo("/wiremock-sapmel")));
    
    given().
            when().
            get("http://localhost:8090/wiremock-sapmel").
            then().
            assertThat().statusCode(404);
```





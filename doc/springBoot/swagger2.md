# swagger2

# 引入依賴
引入2.8.0版本的swagger2,
```shell script
 <dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.8.0</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.8.0</version>
</dependency>

<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>1.9.6</version>
</dependency>
```
# 在application中引入
注意@ComponentScan已經在@SpringBootApplication包含不必重複引入。
另外，2.8.0這個版本穩定，2.9.2會有問題

```shell script
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
```

# 引入SwaggerConfig類
RequestHandlerSelectors.any()是掃描全部目錄
```shell script

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("inpcs-swagger2")	//标题
                .description("Restful-API-Doc")	//描述
                .termsOfServiceUrl("https://www.inpcs.cn") 
                .contact(new Contact("inpcs的技术博客", "https://www.inpcs.cn", "408946001@qq.com")) 
                .version("1.0") //版本
                .build();
    }


}

```

# 在controller中引入@Api
# 在domain中引入@ApiModel
# swagger2 的註解說明
## @Api
注解名称	| 注解属性 | 作用域 | 属性作用
     ---|      ---|     ---|---
@Api| tags| 类| 说明该类的作用
@Api| value| 类| 说明该类的作用

## @ApiOperation
注解名称| 注解属性| 作用域| 属性作用
---|---|---|---
@ApiOperation()| value| 方法| 描述方法作用
@ApiOperation()| notes| 方法| 提示内容
@ApiOperation()| tags|  方法| 分组

## @ApiParam
注解名称| 注解属性| 作用域| 属性作用
---|---|---|---
@ApiParam()|     name| 方法参数| 参数名
@ApiParam()|    value| 方法参数| 参数说明
@ApiParam()| required| 方法参数| 是否必填

## @ApiModel && @ApiModelProperty
注解名称| 注解属性| 作用域| 属性作用
---|---|---|---
@ApiModel()|        valu| 类| 对象名
@ApiModel()| description| 类| 描述
@ApiModelProperty()| value| 方法| 字段说明
@ApiModelProperty()| name| 方法| 属性名
@ApiModelProperty()| dataType| 方法| 属性类型
@ApiModelProperty()| required| 方法| 是否必填
@ApiModelProperty()| example| 方法| 举例
@ApiModelProperty()| hidden| 方法| 隐藏

## @ApiImplicitParam && @ApiImplicitParams
注解名称| 注解属性| 作用域| 属性作用
---|---|---|---
@ApiImplicitParam()| value    | 方法| 参数说明
@ApiImplicitParam()| name     | 方法| 参数名
@ApiImplicitParam()| dataType | 方法| 数据类型
@ApiImplicitParam()| paramType| 方法| 参数类型
@ApiImplicitParam()| example  | 方法| 举例

## @ApiResposne && @ApiResponses
注解名称| 注解属性| 作用域| 属性作用
---|---|---|---
@ApiResponse()| response| 方法| 返回类
@ApiResponse()| code    | 方法| 返回码
@ApiResponse()| message | 方法| 返回信息
@ApiResponse()| examples| 方法| 例子





# eureka 集群

> 在中国很多公司都使用spring boot + spring cloud 全家桶套餐，免不了会使用eureka替代zookeeper做注册发现中心，
下面直接演示spring boot 集成eureka 组件（基于spring boot#1.5.2 & spring cloud#Edgware.SR3）。

## 1. eureka server集群配置
不知道官网为什么先说eureka client在谈论server,其中缘由有点不解。
### 1.1 怎样包含eureka server
在maven pom.xml 包含
```xml
    <properties>
        <spring-cloud-dependencies.version>Edgware.SR3</spring-cloud-dependencies.version>
        <spring-boot-dependencies.version>1.5.12.RELEASE</spring-boot-dependencies.version>
    </properties>
    <!--依赖管理-->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <!-- Import dependency management from Spring Boot -->
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot-dependencies.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud-dependencies.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>
```

### 1.2 如何启动 eureka server
eureka server run example:
```java
@SpringBootApplication
@ComponentScan({"com.jiulong"}) // spring beans scan
@EnableEurekaServer
public class EurekaServerApplication {
    /**
     * spring eureka server 启动入口
     * @param args
     */
    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
```
eureka server 有主界面可以看到server各项指标，也提供以 <code>/eureka/*</code>前缀的restful api。
### 1.3 高可用 和 zones, regions
有个很多人都迷糊的点： regions > zones
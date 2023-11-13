package hj;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.hj.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hj.mapper")
@EnableFeignClients(basePackages = "com.hj.feign")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    @Value("${workerId}")
    private Integer workerId;
    @Value("${datacenterId}")
    private Integer datacenterId;

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(workerId, datacenterId);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}

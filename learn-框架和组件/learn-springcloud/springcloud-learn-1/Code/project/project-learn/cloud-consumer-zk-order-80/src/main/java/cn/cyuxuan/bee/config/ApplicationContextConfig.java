package cn.cyuxuan.bee.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author [cyuxuan]
 * @date [2021/7/6 0006 23:24]
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}

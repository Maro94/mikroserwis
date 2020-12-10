package mallek.com.appmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AppmasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppmasterApplication.class, args);
    }

}

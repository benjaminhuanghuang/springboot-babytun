package ben.study.babytunseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("ben.study.babytunseckill")    // form mybatis
@EnableScheduling
public class BabytunSeckillApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabytunSeckillApplication.class, args);
	}

}

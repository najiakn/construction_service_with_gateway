package ConsutuctionMicroServices.example.tache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacheApplication.class, args);
	}

}

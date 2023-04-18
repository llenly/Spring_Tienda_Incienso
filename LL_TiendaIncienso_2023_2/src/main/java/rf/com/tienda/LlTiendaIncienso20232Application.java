package rf.com.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = { DataSourceAutoConfiguration.class})
public class LlTiendaIncienso20232Application {

	public static void main(String[] args) {
		SpringApplication.run(LlTiendaIncienso20232Application.class, args);
	}

}

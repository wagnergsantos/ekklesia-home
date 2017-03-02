package br.com.geracaoelias.ekklesia_home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cosium.spring.data.jpa.entity.graph.repository.support.JpaEntityGraphRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = JpaEntityGraphRepositoryFactoryBean.class)
public class EkklesiaHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkklesiaHomeApplication.class, args);
	}
}

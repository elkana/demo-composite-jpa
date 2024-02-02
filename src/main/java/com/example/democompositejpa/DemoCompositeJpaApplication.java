package com.example.democompositejpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.democompositejpa.model.LdvDetail;
import com.example.democompositejpa.model.LdvDetailId;
import com.example.democompositejpa.repo.LdvDetailsRepo;

@SpringBootApplication
public class DemoCompositeJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCompositeJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(LdvDetailsRepo repo) {
		return args -> {
			// var id = LdvDetailId.builder().build();
			var data1 = LdvDetail.builder().ldvNo("ldv1").contractNo("contract1")
					.custName("Elkana 1").build();
			repo.save(data1);
			var data2 = LdvDetail.builder().ldvNo("ldv2").contractNo("contract2")
					.custName("Elkana 2").build();
			repo.save(data2);

			LdvDetail dtl = repo.findByContractNo("contract2");
			System.out.println("->>>>" + dtl.toString());

			int r = repo.deleteByContractNo("contract2");
			System.out.println("deleted " + r);
		};
	}
}

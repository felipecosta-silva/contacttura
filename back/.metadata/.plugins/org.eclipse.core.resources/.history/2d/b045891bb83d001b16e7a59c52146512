package com.Livrariahotel.Livrariahotel;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Livrariahotel.Livrariahotel.model.Livrariahotel;
import com.Livrariahotel.Livrariahotel.repository.LivrariahotelRepository;

@SpringBootApplication
public class LivrariahotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariahotelApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner init(LivrariahotelRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(0, 9)
			.mapToObj(i -> {
				Livrariahotel l = new Livrariahotel();
				String poeta[] = {"Ariano Suassuna","Jorge Amado","Ferreira Gullar","Aluísio de Azevedo","Gonçalves Dias","Patativa do Assaré","Patativa do Assaré","Graciliano Ramos","Rachel de Queiroz","Celina de Holanda"};
				String escritor[] = {"Manuel Bandeira", "João Cabral", "Rogério Generoso", "Cosme Rogério", "Maria José Arimatéia", "Chico science", "Fernando Pessoa", "Clarice Lispector", "Luzilá Gonçalves"};
				String musicos[] = {"Luiz Gonzaga", "Alceu Valença", "Ana Diniz", "Nando Cordel", "Lenine", "Selma do Coco", "Marlene Cavalcanti", "Cristina Amaral", "Reginaldo Rossi", "Julia Konrad"};
				l.setCnpj("Hotel Livraria" + i);
				l.setNome(escritor[i]);
				l.setRua("Rua " + poeta[i]);
				l.setBairro(musicos[i]);
				l.setCidade("Recife");
				long n = i;
				if (i > 4) {
					n = (i - 5);
				}
				l.setCep((i+1)+i+"."+(n+3)+(n+1)+i+"-"+(n+2)+(n+4)+i);
				l.setCapacidade((i*10));
				
				return l;
			})
			.map(m -> repository.save(m))
			.forEach(System.out::println);
		};
	}

}

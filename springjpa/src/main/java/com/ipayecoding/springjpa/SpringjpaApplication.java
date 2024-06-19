package com.ipayecoding.springjpa;
import com.github.javafaker.Faker;
import com.ipayecoding.springjpa.models.Author;
import com.ipayecoding.springjpa.models.Video;

import com.ipayecoding.springjpa.repositories.AuthorRepository;
import com.ipayecoding.springjpa.repositories.VideoRepository;
import com.ipayecoding.springjpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringjpaApplication.class, args);
	}
	  @Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	){
		return args -> {
			 for(int i = 0; i<40; i++){
				Faker faker = new Faker();
				var author =Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().firstName())
						.age(faker.number().numberBetween(19, 70))
						.email("contact" + i + "JamesMorgan@gmail.com")
						.build();
				 //authorRepository.save(author);
			}
			 //update author with iD 1
			var author =Author.builder()
					.id(1)
					.firstName("James")
					.lastName("Baker")
					.age(34)
					.email("JamesMorgan@gmail.com")
					.build();
		//	authorRepository.save(author);

			// update Author set.age = 22
		//	authorRepository.updateAuthor  (22, 1);

//			var video =Video.builder()
//					.name("abc")
//					.length(7)
//					.build();
//			videoRepository.save(video);
			//find by named query
			//authorRepository.findByNamedQuery(40)
			//.forEach(System.out::println);

			//update with named query
			// authorRepository.updateByNamedQuery(12);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(34))
					.and(AuthorSpecification.firstNameLike("Mi"));
			authorRepository.findAll((Sort) spec).forEach(System.out::println);
		};

	}

}

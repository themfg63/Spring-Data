package yte.intern.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import yte.intern.springdata.Books.Book;
import yte.intern.springdata.Books.BookRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringDataApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		saveBooks(bookRepository);

		// 1.Title'ı <<Domain Driven Design>> olan kitabı bulun
		System.out.println(bookRepository.findByTitle("Domain Driven Design"));

		//2.Yaşı 15 ve üstü kitapları bulun ve yaşlarına göre küçükten büyüğe doğru sıralayın.
		System.out.println(bookRepository.findByAgeGreaterThan(15L, Sort.by("age").ascending()));

		//3.2000 yılından sonra yayınlanan kitapları bulun. Bunları 5'lik sayfalara bölün ve 2. sayfayı getirin.
		System.out.println(bookRepository.findByPublishDateAfter(LocalDateTime.parse("2000-01-01T00:00"), PageRequest.of(1,5)));

		// 4.İçerisinde "Clean" sözcüğü geçen kitapları bulun.
		System.out.println(bookRepository.findByTitleContains("Clean"));

		// 5.Robert C. Martin tarafından yazılan 10 yaşından büyük kitapları bulun
		System.out.println(bookRepository.findByAuthorAndAgeGreaterThan("Robert C. Martin", 10L));

		//6.Kent Beck'e ait kitapların sayısını bulun
		System.out.println(bookRepository.countByAuthor("Kent Beck"));

		//7.Martin Fowler'a ait kitap olup olmadığına bakın
		System.out.println(bookRepository.existsByAuthor("Martin Fowler"));

	}

	//KİTAP LİSTESİ
	public static void saveBooks(BookRepository bookRepository){
		List<Book> exampleBooks = new ArrayList<>();
		exampleBooks.add(new Book(null,"Clean Code","Robert C. Martin",11L,LocalDateTime.parse("2008-07-11T00:00")));
		exampleBooks.add(new Book(null,"Clean Agile","Robert C. Martin",11L,LocalDateTime.parse("2019-09-12T00:00")));
		exampleBooks.add(new Book(null,"Agile Software Development","Robert C. Martin",11L,LocalDateTime.parse("2002-10-25T00:00")));
		exampleBooks.add(new Book(null,"Code Complete 2","Steve McConnel",11L,LocalDateTime.parse("1993-05-30T00:00")));
		exampleBooks.add(new Book(null,"Essential Scrum","Kenneth S. Rubin",11L,LocalDateTime.parse("2012-07-20T00:00")));
		exampleBooks.add(new Book(null,"Design Patterns","Gang of Four",11L,LocalDateTime.parse("1994-20-01T00:00")));
		exampleBooks.add(new Book(null,"Domain Driven Design","Eric Evans",11L,LocalDateTime.parse("2003-08-30T00:00")));
		exampleBooks.add(new Book(null,"Test Driven Development","Kent Beck",11L,LocalDateTime.parse("2002-11-18T00:00")));
		exampleBooks.add(new Book(null,"Refactoring","Kent Beck",11L,LocalDateTime.parse("2023-07-06T00:00")));
		exampleBooks.add(new Book(null,"Extreme Programming Explained","Kent Bec	k",11L,LocalDateTime.parse("2023-10-06T00:00")));

		bookRepository.saveAll(exampleBooks);
	}

}

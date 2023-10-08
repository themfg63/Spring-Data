package yte.intern.springdata.Books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/* UYGULAMA
   -> Bu entity'e ait BookRepository'i oluşturun.
   -> Entity'leri veri tabanına kaydedin
   -> Aşağıdaki sorguları çalıştırmak için BookRepository interface'inde fonskiyonlar tanımlayın ve cevaplarını konsola
   yaın:
        1.Title'ı <<Domain Driven Design>> olan kitabı bulun
        2.Yaşı 15 ve üstü kitapları bulun ve yaşlarına göre küçükten büyüğe doğru sıralayın.
        3.2000 yılından sonra yayınlanan kitapları bulun. Bunları 5'lik sayfalara bölün ve 2. sayfayı getirin.
        4.İçerisinde "Clean" sözcüğü geçen kitapları bulun.
        5.Robert C. Martin tarafından yazılan 10 yaşından büyük kitapları bulun
        6.Kent Beck'e ait kitapların sayısını bulun
        7.Martin Fowler'a ait kitap olup olmadığına bakın
 */

import java.time.LocalDateTime;

@Entity
@Getter  //classtaki değişkenlerin getter methodlarını oluşturur.
@Setter  //classtaki değişkenlerin setter methodlarını oluşturur.
@AllArgsConstructor //parametreli constructor oluşturur.
@NoArgsConstructor  //parametresiz constructor oluşturur.
@ToString       //toString methodları oluşturur.
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long age;
    private LocalDateTime publishDate;

}
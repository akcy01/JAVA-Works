package GenericYapilar.KitapSiralayici;

import java.util.Comparator;
import java.util.TreeSet;

import GenericYapilar.main;

public class Main {

    public static void main(String[] args) {

        //Önce 5 tane nesne oluşturdum
        Book book1 = new Book("Aklından Bir Sayı Tut", 400, "John Verdon", 2000);
        Book book2 = new Book("Gözlerini Sımsıkı Kapat", 200, "Franz Kafka", 2000);
        Book book3 = new Book("Kurt Gölü", 300, "Charles Dickens", 2000);
        Book book4 = new Book("Dijital Kale", 520, "Dan Brown", 2000);
        Book book5 = new Book("Siyah Kan", 851, "Stefan Zweig", 1986);

        TreeSet<Book> books = new TreeSet<Book>();
    
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for(Book book : books ){
            System.out.println(book.getBookName());
        }

        TreeSet<Book> sayfaSayisi = new TreeSet<>(new OrderBookComperator().reversed());
            
        sayfaSayisi.add(book1);
        sayfaSayisi.add(book2);
        sayfaSayisi.add(book3);
        sayfaSayisi.add(book4);
        sayfaSayisi.add(book5);

        for(Book sayfa : sayfaSayisi ){
            System.out.println(sayfa.getSayfaSayisi());
        }

        TreeSet<Book> yazarAdi = new TreeSet<>(new OrderBookYazar());
        yazarAdi.add(book1);
        yazarAdi.add(book2);
        yazarAdi.add(book3);
        yazarAdi.add(book4);
        yazarAdi.add(book5);

        for(Book yazar : yazarAdi){
            System.out.println(yazar.getYazarAdi());
        }

    }
    
}

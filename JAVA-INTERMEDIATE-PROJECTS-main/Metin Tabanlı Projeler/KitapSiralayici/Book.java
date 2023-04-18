package GenericYapilar.KitapSiralayici;
import java.lang.Comparable;

//implement ederek kalıtım aldık

public class Book implements Comparable <Book>{
    
    private String bookName;
    private int sayfaSayisi;
    private String yazarAdi;
    private int yayinTarihi;
    
    public Book(String bookName, int sayfaSayisi, String yazarAdi, int yayinTarihi) {
        this.bookName = bookName;
        this.sayfaSayisi = sayfaSayisi;
        this.yazarAdi = yazarAdi;
        this.yayinTarihi = yayinTarihi;
    }

    public int getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(int yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    //A'dan Z'ye yaptık sıralamayı!
    @Override
    public int compareTo(Book o) {
       // return (this.getBookName().compareTo(o.getBookName()));
        return this.getBookName().compareTo(o.getBookName());
    }
    
    
}

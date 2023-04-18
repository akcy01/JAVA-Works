package GenericYapilar.KitapSiralayici;

import java.util.Comparator;

public class OrderBookComperator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        
        return o1.getSayfaSayisi()-o2.getSayfaSayisi();
    }
    
}

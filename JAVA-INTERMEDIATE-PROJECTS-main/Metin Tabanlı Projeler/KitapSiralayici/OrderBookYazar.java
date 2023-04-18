package GenericYapilar.KitapSiralayici;

import java.util.Comparator;

public class OrderBookYazar implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        
        return o1.getYazarAdi().compareTo(o2.getYazarAdi());
    }

    
}

package OdevListeSiniflari;

public class MyList <T>  {

    T[] array;
    
    // Boş contructor kullanılırsa dizinin başlangıç boyutu 10 olmalıdır.
    public MyList(){
        
        this.array = (T[]) new Object[10];
    }

    //Dizinin başlangıç değeri capacity parametresinden alınmalıdır.
    public MyList(int capacity){
        this.array = (T[]) new Object[capacity];
        
    }

    //Dizideki eleman sayısını vericek.
    public int size(){
        int size = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i] != null){
                size++;
            }
        }
        return size;
    }

    //Dizinin kapasite değerini verecek.
    public int getCapacity(){
        return array.length;
    }

    //Sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.
    public void add(T data){
    
        for(int i = 0; i<array.length; i++){
           
            if(array[i] == null){
                array[i] = data; // Datayı içine attım ve sürekli atılmaması için break komutunu kullandım.
                break;
            }

        }

    }

    //Verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
    public T getIndex(int index){
        if(array[index] != null){ //Array dizisinden istenen indexi yazdık ve gerekli koşulu sağlarsa döndürdük
            return array[index];//array dizisinin girilen index numarasını döndürecek
        }else{
            return null;
        }
        
    }

    public T removeIndex(int index){
     return null;
    }

    //Verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır.Geçersiz indis girilerse null döndürür.
    public void setIndex(int index, T data){
        if(array[index] !=null){
            array[index] = data ;
        }else{
             System.out.println("hatalı işlem");
        }
        
    }

    //String toString() : Sınıfa ait dizideki elemanları listeleyen bir metot.
    public String toString(){

        String list = "[";

        for(int i = 0; i<array.length; i++){
            list = list + array[i];
            list = list + ",";
            if(array[i] == null){
                break;
            }
        }
        int son = list.length();
        list = list.substring(0, son - 6);
        list = list + "]";
        return list;
    }

    


}





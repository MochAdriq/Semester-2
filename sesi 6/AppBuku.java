import java.util.ArrayList;
import java.io.Console;

public class AppBuku {
    public static void main(String[] args) throws Exception {
        Console console = System.console();
        ArrayList<Buku> buku = new ArrayList<Buku>();
        while(true){
            System.out.print("Masukan judul buku : "); 
            String judul = console.readLine(); 

            System.out.print("Masukan pengarang: "); 
            String pengarang = console.readLine();
        
            System.out.print("masukan penerbit : "); 
            String penerbit = console.readLine();
        
            System.out.print("Masukan tahun terbit : "); 
            int tahun = Integer.parseInt(console.readLine());

            System.out.print("input lagi atau tidak : (y/n)");
            String lanjut = console.readLine();
            if(!lanjut.equals("y")){
                break;
            }
            buku.add(new Buku(judul, pengarang, penerbit, tahun));
        }
        for (Buku buku2 : buku){
            System.out.print(buku2.judul);
    }
}
}



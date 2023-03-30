import java.util.ArrayList;
import java.io.Console;


public class Perpustakaan {
    public static void main(String[] args) throws Exception{
        Console console = System.console();
        ArrayList <book> buku = new ArrayList<book>();
        String jawaban;
        int num = 1;
        int kategori;
        do{
            System.out.println("________________________________");
            System.out.println("Data buku ke " + num);

            String judul = console.readLine("Judul : ");
            String pengarang = console.readLine("Pengarang : ");
            String penerbit = console.readLine("Penerbit : ");
            int tahun = Integer.parseInt(console.readLine("Tahun terbit : "));

            System.out.println("1) Teknik");
            System.out.println("2) Manajemen");
            System.out.println("3) Fiksi");
            System.out.println("4) Lainnya");
            System.out.print("Masukan Kategori (1-4) : ");
            kategori = Integer.parseInt(console.readLine());

            String keterangan;
            if (kategori == 1) {
                keterangan = "Teknik";
            } else if (kategori == 2) {
                keterangan = "Manajemen";
            } else if (kategori == 3) {
                keterangan = "Fiksi";
            } else{
                keterangan = "Lainnya";
            }
            
            buku.add(new book(judul, pengarang, penerbit, tahun, kategori, keterangan));
            jawaban = console.readLine("Apakah anda ingin menambah data lagi ? (Y/N) : ");
            num++;
        } while (jawaban.equals("Y") || jawaban.equals("y"));

        System.out.println("==========================================================================================");
        System.out.println("Daftar Buku Yang Tersedia");
        System.out.println("==========================================================================================");
        System.out.println("No\tJudul\tPengarang\tPenerbit\tTahun\tKategori");

        int Teknik = 0;
        int Manajemen = 0;
        int Fiksi = 0;
        int Lainnya = 0;
        int BukuBaru = 0;
        int BukuLawas = 0;
        int no=1;
        for(book b:buku){
            System.out.println(no+"\t"+b.judul+"\t"+b.pengarang+"\t\t"+b.penerbit+"\t\t"+b.tahun+"\t"+b.keterangan);

            if (b.keterangan.equals("Teknik")) {
                Teknik++;
            } else if (b.keterangan.equals("Manajemen")) {
                Manajemen++;
            } else if (b.keterangan.equals("Fiksi")) {
                Fiksi++;
            } else{
                Lainnya++;
            }

            if (b.tahun <= 2000) {
                BukuLawas++;
            } else {
                BukuBaru++;
            }
    
        }

        System.out.println("==========================================================================================");
        System.out.println("Jumlah Buku Yang Tersedia : "+buku.size());
        System.out.println("Buku Teknik : "+Teknik);
        System.out.println("Buku Manajemen : "+Manajemen);
        System.out.println("Buku Fiksi : "+Fiksi);
        System.out.println("Buku Lainnya : "+Lainnya);
        System.out.println("Buku Lawas : "+BukuLawas);
        System.out.println("Buku Baru : "+BukuBaru);
    }
}
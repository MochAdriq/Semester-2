import java.util.Scanner;

public class Array {
    public static void main(String[] args) throws Exception{
        Scanner inputan = new Scanner(System.in);

        System.out.print("Masukan jumlah data : ");
        int n = inputan.nextInt();
        
        String[] Nama= new String[n];
        int[] Nilai= new int[n];

        for(int i = 0; i < n; i++){
            System.out.print("Masukan nama  : ");
            Nama[i]= inputan.next();
            System.out.print("Masukan nilai  : ");
            Nilai[i]= inputan.nextInt();
        }
        System.out.println("==================================");
        System.out.println("No\tNama\tNilai\tKet");
        System.out.println("==================================");

        String Ket = Nilai >= 70 ? ("lulus") : ("Tidak lulus");
        System.out.println(Nama + Nilai + Ket);
    }
        
}


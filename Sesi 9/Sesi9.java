import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class todoList{
	
	public static void main(String[] args) {
	    
	    Queue<String> Listtodo = new LinkedList<>();
	
	    int choice;
	    
	    Scanner sc = new Scanner(System.in);
	    
		while(true) {
	    	System.out.println("Menu: ");
			System.out.println("1. Tambah Kegiatan");
			System.out.println("2. Hapus 1 kegiatan");
			System.out.println("3. Tampilkan data kegiatan dalam Queue");
			System.out.println("4. Bersihkan Queue");
			System.out.println("5. Keluar dari Program");
			System.out.print("Pilihan Menu (1 - 5) >>> ");
			choice = sc.nextInt();
			
			if (choice == 5){
			    break;
		    	}else if (choice == 1){
		    	    System.out.print("\nBerapa kegiatan yang ingin anda tambahkan?(mohon ketik secara angka) >>> ");
		    	    int much = sc.nextInt();
		    	    
		    	    for(int i = 0;i <= much - 1; i++){
		    	        System.out.print("Masukan Kegiatan >>> ");
		    	        String kegiatan = sc.next();
		    	        
		    	        Listtodo.add(kegiatan);
		    	        }
			        
			    }
		    	else if (choice == 2){
		    	    System.out.println("---------------------------------------------------");
		    	    System.out.println(Listtodo);
			        System.out.println("---------------------------------------------------");
			        System.out.print("Kegiatan mana yang ingin anda hapus dari list ? (Mohon ketik nama kegiatan nya secara persis sama dengan di list di atas)>>> ");
			        String delKeg = sc.next();
			        
			        Listtodo.remove(delKeg);
			        
			        System.out.println("---------------------------------------------------");
		    	    System.out.println(Listtodo);
			        System.out.println("---------------------------------------------------");
			    
			    }
		    	else if (choice == 3){
		    	    System.out.println("---------------------------------------------------");
		    	    System.out.println(Listtodo);
			        System.out.println("---------------------------------------------------");
			    }
		    	else if (choice == 4){
		    	    Listtodo.clear();
			    
			    }
		    	    else{
			            System.out.println("Mohon maaf, anda memasukan pilihan yang salah");
		    	    }
		}
	}
}
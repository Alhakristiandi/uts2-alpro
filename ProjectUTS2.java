package projectuts2;
                //LIA
import java.util.Scanner; // Memanggil scanner

public class ProjectUTS2 { //Deklarasi kelas dengan nama ProjectUTS2

    static Scanner sc = new Scanner(System.in); // Inisialisasi objek scanner untuk input
    static String[] name;  //Deklarasi array untuk menyimpan data nama
    static double[] usia; //Deklarasi array untuk menyimpan data usia
    static double[] suhu; //Deklarasi array untuk menyimpan data suhu
    static String[] kategori; //Deklarasi array untuk menyimpan data kategori
    static String[] keterangan; //Deklarasi array untuk menyimpan data keterangan
    static int n; //Deklarasi variable n untuk menyimpan jumlah orang yang disurvey

    public static void main(String[] args) { //Metode utama untuk memulai program
        System.out.println("==========================================================================================================");
        System.out.println("\t\t\t\tPROGRAM STATISTIK PENGECEKAN SUHU");
        System.out.println("==========================================================================================================");
        System.out.print("Jumlah orang yang akan dicek = "); //Cetak perintah untuk meminta pengguna menginput jumlah orang yang disurvey
        n = sc.nextInt(); //Input jumlah orang yang disurvey
        name = new String[n]; //Inisialisasi array untuk menyimpan data nama dengan jumlah elemen sebanyak n
        usia = new double[n]; //Inisialisasi array untuk menyimpan data usia dengan jumlah elemen array sebanyak n 
        suhu = new double[n]; //Inisialisasi array untuk menyimpan data suhu dengan jumlah elemen array sebanyak n
        kategori = new String[n]; //Inisialisasi array untuk menyimpan data kategori dengan jumlah elemen array sebanyak n
        keterangan = new String[n]; //Inisialisasi array untuk menyimpan data keterangan dengan jumlah elemen array sebanyak n
        input(); // Memanggil metode input untuk mengisi data survey
    }

    static double totalSuhu = 0; //Inisialisasi variabel totalSuhu
    static double rata; //Deklarasi variabel rata

    static void input() { //Metode untuk menginput data survei dari pengguna
        for (int i = 0; i < n; i++) { //Loop untuk mengiterasi sebanyak jumlah orang yang disurvei
            System.out.println();
            System.out.println("=====================");
            System.out.println("MENGINPUT DATA KE-" + (i + 1));
            System.out.println("=====================");
            System.out.print("Nama\t= "); //Menampilkan prompt untuk input nama
            name[i] = sc.next(); //Input nama
            //Validasi usia agar tidak kurang dari 0 atau lebih dari 200
            do {
                System.out.print("Usia\t= ");
                usia[i] = sc.nextDouble();
            } while (usia[i] <= 0 || usia[i] > 200);
            //
            System.out.print("Suhu\t= "); //Menampilkan prompt untuk input suhu
            suhu[i] = sc.nextDouble(); //Menyimpan input suhu dari pengguna ke dalam array
            totalSuhu += suhu[i]; //Menambahkan suhu ke total suhu untuk menghitung rata-rata
            rata = totalSuhu / n; //Menghitung rata-rata
            System.out.println(); //Mencetak baris baru
        }
        kategori(); //Melanjutkan ke metode kategori 
    }
                     //SELTIA
    //Inisialisasi  variabel untuk jumlah individu dalam setiap kategori yang akan digunakan sebagai index untuk mencetak diagram 
    static int balita = 0;
    static int anak = 0;
    static int remaja = 0;
    static int dewasa = 0;
    static int lansia = 0;
    static int manula = 0;

    static void kategori() { //Metode untuk mengkategorikan individu berdasarkan usia
        for (int i = 0; i < n; i++) {
            if (usia[i] > 0 && usia[i] < 5) {
                kategori[i] = "Balita";
                balita++;
            } else if (usia[i] >= 5 && usia[i] < 12) {
                kategori[i] = "Anak";
                anak++;
            } else if (usia[i] >= 12 && usia[i] < 20) {
                kategori[i] = "Remaja";
                remaja++;
            } else if (usia[i] >= 20 && usia[i] < 46) {
                kategori[i] = "Dewasa";
                dewasa++;
            } else if (usia[i] >= 46 && usia[i] < 60) {
                kategori[i] = "Lansia";
                lansia++;
            } else {
                kategori[i] = "Manula";
                manula++;
            }
        }
        cekSuhu(); //Melanjutkan ke metode cekSuhu
    }
    
    static double max = 0; //Inisialisasi variabel suhu maximum
    static double min = 200; //Inisialisasi variabel suhu minimum

    static void cekSuhu() { //Metode untuk mengecek suhu maximun dan minimum
        for (int i = 0; i < n; i++) { //Loop untuk mengiterasi seluruh data suhu
            if (suhu[i] > max) { //Memeriksa apakah suhu saat saat ini lebih tinggi dari suhu max
                max = suhu[i]; // Jika ya, mengupdate nilai maximum
            }
            if (suhu[i] < min) { //Memeriksa apakah suhu saat saat ini lebih tinggi dari suhu min
                min = suhu[i]; // Jika ya, mengupdate nilai minimum
            }
        }
        keterangan(); // Melanjutkan ke metode keterangan untuk menetapkan keterangan suhu
    }
                //RAMBU
    static void keterangan() { //Metode untuk memberikan keterangan pada rentang suhu
        for (int i = 0; i < n; i++) { //Loop untuk mengiterasi seluruh data suhu
            //Menentukan keterangan suhu  berdasarkan rentang tertentu
            if (suhu[i] >= 20 && suhu[i] < 30) {
                keterangan[i] = "Sangat Dingin";
            } else if (suhu[i] >= 30 && suhu[i] < 36) {
                keterangan[i] = "Dingin";
            } else if (suhu[i] >= 36 && suhu[i] < 37) {
                keterangan[i] = "Normal";
            } else if (suhu[i] >= 37 && suhu[i] < 43) {
                keterangan[i] = "Panas";
            } else {
                keterangan[i] = "Error";
            }
        }
        cetakDiagram(); //Melanjutkan ke metode diagram  
    }

    static void cetakDiagram() { //Metode untuk mencetak diagram berdasarkan kategori usia
        System.out.println();
        System.out.println("Dari " + n + " orang yang dicek, diperoleh data sebagai berikut !");
        System.out.println("========");
        System.out.println("DIAGRAM");
        System.out.println("========");
        //Menampilkan  jumlah individu dalam setiap kategori dengan tanda "*"
        System.out.print("Balita\t\t= ");
        for (int i = 0; i < balita; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("Anak\t\t= ");
        for (int i = 0; i < anak; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("Remaja\t\t= ");
        for (int i = 0; i < remaja; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("Dewasa\t\t= ");
        for (int i = 0; i < dewasa; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("Lansia\t\t= ");
        for (int i = 0; i < lansia; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("Manula\t\t= ");
        for (int i = 0; i < manula; i++) {
            System.out.print("*");
        }
        System.out.println();
        cetakTabel(); //Memanggil metode cetaktabel untuk menampilkan data survei dalam  bentuk tabel

    }
                //SION
    static void cetakTabel() { //Metode untuk mencetak tabel berisi data survei dan informasi suhu
        System.out.println();
        System.out.println("TABEL");
        //Membuat header tabel
        System.out.println("============================================================================================================");
        System.out.println("NO\t\tNAMA\t\tUSIA\t\tKATEGORI\t\tSUHU\t\tKETERANGAN");
        System.out.println("============================================================================================================");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t\t" + name[i] + "\t\t" + usia[i] + "\t\t" + kategori[i] + "\t\t\t" + suhu[i] + "\t\t  " + keterangan[i]);
            System.out.println();
            System.out.println();
        }
        System.out.println("============================================================================================================");
        //Menampilkan suhu tertinggi, terendah, dan rata-rata suhu ke layar
        System.out.println("Suhu Tertinggi\t= " + max);
        System.out.println("Suhu Terendah\t= " + min);
        System.out.printf("Rata-rata Suhu\t= " + "%.2f", rata);
        System.out.println();
        System.out.println("============================================================================================================");
        choose(); //Memanggil metode pilihan
    }
    
    static void choose() { //metode untuk pilihan apakah akan mengurutkan data atau tidak
        int pilihan;
        System.out.println("");
        do { 
            System.out.println("Apakah data ingin diurutkan?");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            System.out.print("Jawaban : ");
            pilihan = sc.nextInt();
        } while (pilihan < 1 || pilihan > 2);
        switch (pilihan) {
            case 1:
                pilihan();
                break;
            case 2:
                System.out.println("Terimakasih");
                break;
        }
    }
    ///NICHO
    static void pilihan() { //Metode untuk menampilkan menu pengurutan dan mengambil pilihan pengguna
        System.out.println();
        int opsi; //Deklarasi variabel opsi
        //Menampilkan opsi pengurutan
        do {
            System.out.println("1. Suhu Terendah");
            System.out.println("2. Usia Termuda");
            System.out.println("3. Suhu Tertinggi");
            System.out.println("4. Usia Tertua");
            System.out.print("Ingin diurutkan berdasarkan : "); //Meminta pengguna memilih opsi pengurutan
            opsi = sc.nextInt();
        } while (opsi < 1 || opsi > 4);
        switch (opsi) {
            case 1:
                urutanSuhuRendah();
                break;
            case 2:
                urutanUmurMuda();
                break;
            case 3:
                urutanSuhuTinggi();
                break;
            case 4:
                urutanUmurTua();
                break;
        }
    }
//Variabel-variabel penyimpanan sementara untuk pengurutan bubblesort
    static double simpanSuhu; 
    static String simpanNama;
    static String simpanKategori;
    static double simpanUsia;
    static String simpanKeterangan;

    static void urutanSuhuRendah() { //Metode untuk mengurutkan suhu dari yang terendah dengan bubblesort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (suhu[i] < suhu[j]) {
                    simpanSuhu = suhu[i];
                    suhu[i] = suhu[j];
                    suhu[j] = simpanSuhu;

                    simpanNama = name[i];
                    name[i] = name[j];
                    name[j] = simpanNama;

                    simpanUsia = usia[i];
                    usia[i] = usia[j];
                    usia[j] = simpanUsia;

                    simpanKategori = kategori[i];
                    kategori[i] = kategori[j];
                    kategori[j] = simpanKategori;

                    simpanKeterangan = keterangan[i];
                    keterangan[i] = keterangan[j];
                    keterangan[j] = simpanKeterangan;

                }
            }
        }
        cetakTabel();
    }

    static void urutanUmurMuda() { //Metode untuk mengurutkan umur dari yang termuda dengan bubblesort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (usia[i] < usia[j]) {
                    simpanSuhu = suhu[i];
                    suhu[i] = suhu[j];
                    suhu[j] = simpanSuhu;

                    simpanNama = name[i];
                    name[i] = name[j];
                    name[j] = simpanNama;

                    simpanUsia = usia[i];
                    usia[i] = usia[j];
                    usia[j] = simpanUsia;

                    simpanKategori = kategori[i];
                    kategori[i] = kategori[j];
                    kategori[j] = simpanKategori;

                    simpanKeterangan = keterangan[i];
                    keterangan[i] = keterangan[j];
                    keterangan[j] = simpanKeterangan;
                }
            }
        }
        cetakTabel();
    }

    static void urutanSuhuTinggi() { //Metode untuk mengurutkan suhu dari yang tertinggi dengan bubblesort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (suhu[i] > suhu[j]) {
                    simpanSuhu = suhu[i];
                    suhu[i] = suhu[j];
                    suhu[j] = simpanSuhu;

                    simpanNama = name[i];
                    name[i] = name[j];
                    name[j] = simpanNama;

                    simpanUsia = usia[i];
                    usia[i] = usia[j];
                    usia[j] = simpanUsia;

                    simpanKategori = kategori[i];
                    kategori[i] = kategori[j];
                    kategori[j] = simpanKategori;

                    simpanKeterangan = keterangan[i];
                    keterangan[i] = keterangan[j];
                    keterangan[j] = simpanKeterangan;
                }
            }
        }
        cetakTabel();
    }

    static void urutanUmurTua() { //Metode untuk mengurutkan umur dari yang tertua dengan bubblesort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (usia[i] > usia[j]) {
                    simpanSuhu = suhu[i];
                    suhu[i] = suhu[j];
                    suhu[j] = simpanSuhu;

                    simpanNama = name[i];
                    name[i] = name[j];
                    name[j] = simpanNama;

                    simpanUsia = usia[i];
                    usia[i] = usia[j];
                    usia[j] = simpanUsia;

                    simpanKategori = kategori[i];
                    kategori[i] = kategori[j];
                    kategori[j] = simpanKategori;

                    simpanKeterangan = keterangan[i];
                    keterangan[i] = keterangan[j];
                    keterangan[j] = simpanKeterangan;
                }
            }
        }
        cetakTabel();
    }
}
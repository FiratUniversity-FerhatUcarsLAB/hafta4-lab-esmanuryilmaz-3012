     /*
     * Ad Soyad: [Esmanur YILMAZ]
     * Ogrenci No: [250541033]
     * Tarih: [05.11.2025]
     * Aciklama: Gorev 3 - Geometrik Hesap Sistemi
     * Bu program kullanicidan yaricap bilgisini alir ve gerekli islemleri yaptiktan
     * sonra sonuclari duzenli bir formatta ekrana yazdirir.
     */
     import java.util.Scanner;
public class GeometrikHesap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n=== GEOMETRIK HESAPLAYICI ===");
        System.out.println("Dairenin yaricapini girin (cm):");
        double r = input.nextDouble();
        double pi = 3.14159;

        //Cap hesapla
        double cap = 2 * r;

        //Dairenin alanını hesapla
        double alan = pi * r * r;

        //Dairenin cevresini hesapla
        double cevre = 2 * pi * r;

        //Bu yaricapli bir kurenin hacmini hesapla
        double hacim = (4.0 / 3.0) * pi * Math.pow(r, 3);

        //Bu yaricapli bir kurenin Yuzey Alanı
        double yuzeyAlani = 4 * pi * Math.pow(r, 2);

        // --- SONUÇLARIN EKRANA YAZDIRILMASI (Düzenli Format) ---
        System.out.println("\nSONUCLAR:");
        System.out.println("----------");

        // printf() ile sütunları hizalama (%-20s: stringi soldan hizala ve 20 karakter boşluk bırak)
        // Tüm sonuçları %.2f ile 2 ondalık basamakla gösteriyoruz.
        System.out.printf("%-20s : %.2f cm%n", "Daire Capi", cap);
        System.out.printf("%-20s : %.2f cm²%n", "Daire Alani", alan);
        System.out.printf("%-20s : %.2f cm%n", "Daire Cevresi", cevre);
        System.out.printf("%-20s : %.2f cm³%n", "Kure Hacmi", hacim);
        System.out.printf("%-20s : %.2f cm²%n", "Kure Yuzey Alani", yuzeyAlani);

        input.close();
    }
}

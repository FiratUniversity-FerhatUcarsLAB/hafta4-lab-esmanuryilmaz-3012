 /*
     * Ad Soyad: [Esmanur YILMAZ]
     * Ogrenci No: [250541033]
     * Tarih: [02.11.2025]
     * Aciklama: Gorev 1 - Ogrenci Bilgi Sistemi
     *
     * Bu program kullanicidan ogrenci bilgilerini alir ve
     * duzenli bir formatta ekrana yazdirir.
     *Biraz sonlarda kafam karıştı ve son kısmı tam yapamadım bir türlü.
     */

import java.util.Scanner;

    public class OgrenciBilgi {
        public static void main(String[] args) {
            // Scanner objesi olusturun
            Scanner input = new Scanner(System.in);
            System.out.println("\n=== OGRENCI BILGI SISTEMI ===");
            // Degisken tanimlamalari
            // String ad, soyad;
            System.out.println("Adinizi Girin");
            String ad = input.nextLine();
            System.out.println(ad);
            System.out.println("Soyadi Girin");
            String soyad = input.nextLine();
            System.out.println(soyad);
            System.out.printf("Ad Soyad: %s %s", ad, soyad);
            // int ogrenciNo, yas;
            System.out.println("Yasiniz:");
            int yas = input.nextInt();
            System.out.println(yas);
            System.out.println("Ogrenci Numaranız:");
            int ogrNo = input.nextInt();
            System.out.println(ogrNo);
            // gpa;
            System.out.println("GPA:");
            double gpa = input.nextDouble();
            System.out.println(gpa);{
                if (gpa < 1.8) {
                    System.out.println("KALDI"); // Eğer 1.8'den küçükse kaldı
                } else {
                    System.out.println("GECTI"); // Değilse (yani 1.8 veya daha büyükse) geçti
                }
            }
                // Scanner'i kapatin (önemli pratik)
            input.close();
        }
    }

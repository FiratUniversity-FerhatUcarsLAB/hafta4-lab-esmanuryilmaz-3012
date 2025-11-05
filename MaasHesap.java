     /*
     * Ad Soyad: [Esmanur YILMAZ]
     * Ogrenci No: [250541033]
     * Tarih: [06.11.2025]
     * Aciklama: Gorev 3 - Maas Hesaplama Sistemi
     * Bu program bir calisandan; adi-soyadi, aylik brut maasi,
     * haftalik calisma saati ve mesai saati gibi gerekli bilgileri alir 
     * ve toplam gelir, kesintiler, net maasi hesaplayip sonuclari
     * duzenli bir formatta ekrana yazdirir.
     */
     import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate; // Sistem tarihini almak için

/**
 * Görev 3: Maaş Hesaplama Sistemi (Zor)
 * Çalışanın maaş bilgilerini hesaplar ve profesyonel bir bordro formatında sunar.
 */
public class MaasHesap {

    // Özel Gereksinim: Tüm kesinti oranlarını sabit (final) olarak tanımlayın
    private static final double SGK_ORANI = 0.14;       // %14
    private static final double GELIR_VERGISI_ORANI = 0.15; // %15
    private static final double DAMGA_VERGISI_ORANI = 0.00759; // %0.759
    
    // Sabitler
    private static final int AYLIK_ORT_CALISMA_SAATI = 160;
    private static final double MESAI_KATSAYISI = 1.5;
    private static final int ORT_IS_GUNU = 22; // Günlük kazanç için varsayım

    public static void main(String[] args) {
        
        // Scanner'ı US yerel ayarına ayarlayarak ondalık ayırıcı olarak noktayı ('.') garanti altına alırız.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Kullanıcıdan Alınacak Bilgiler
        System.out.println("=== MAAS HESAPLAMA SISTEMI ===");
        
        System.out.print("Çalışanın adı ve soyadını girin: ");
        String adSoyad = scanner.nextLine();

        System.out.print("Aylık brüt maaşı girin (TL, örn: 15000.00): ");
        double brutMaas = scanner.nextDouble();

        System.out.print("Haftalık çalışma saatini girin (int, örn: 40): ");
        int haftalikCalismaSaati = scanner.nextInt();
        
        System.out.print("Bu aydaki mesai saati sayısını girin (int, örn: 10): ");
        int mesaiSaati = scanner.nextInt();

        scanner.close();

        // 1. Hesaplamalar - Toplam Gelir
        
        // Mesai ücreti = (Brüt Maaş / 160) × Mesai Saati × 1.5
        double saatlikBrutUcret = brutMaas / AYLIK_ORT_CALISMA_SAATI;
        double mesaiUcreti = saatlikBrutUcret * mesaiSaati * MESAI_KATSAYISI;
        
        double toplamGelir = brutMaas + mesaiUcreti;

        // 2. Hesaplamalar - Kesintiler
        
        // SGK Kesintisi: Toplam Gelirin %14'ü
        double sgkKesintisi = toplamGelir * SGK_ORANI;
        
        // Gelir Vergisi: Toplam Gelirin %15'i
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORANI;
        
        // Damga Vergisi: Toplam Gelirin %0.759'u
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORANI;
        
        // Toplam Kesinti: Tüm kesintilerin toplamı
        double toplamKesinti = sgkKesintisi + gelirVergisi + damgaVergisi;

        // 3. Hesaplamalar - Net Maaş
        double netMaas = toplamGelir - toplamKesinti;
        
        // 4. Hesaplamalar - İstatistikler
        
        // Kesinti oranı (yüzde olarak)
        double kesintiOraniYuzde = (toplamKesinti / toplamGelir) * 100;

        // Saatlik net kazanç (Ayda 4 hafta, Haftada 40 saat varsayımıyla toplam 160 saat üzerinden)
        // Burada basitçe aylık toplam çalışma saati 160 kabul edilir.
        double saatlikNetKazanc = netMaas / AYLIK_ORT_CALISMA_SAATI; 

        // Günlük net kazanç (22 iş günü varsayımıyla)
        double gunlukNetKazanc = netMaas / ORT_IS_GUNU; 

        // --- BORDRO ÇIKTISI (Profesyonel Format) ---
        
        // Sütun hizalamaları için format stringleri tanımlanır
        String formatBaslik = " %-25s : %10.2f TL%n";
        String formatKesinti = " %-25s : %10.2f TL%n";
        String formatIstatistik = " %-25s : %8.1f%% %n";
        String formatIstatistikSaat = " %-25s : %10.2f TL/saat%n";
        String formatIstatistikGun = " %-25s : %10.2f TL/gun%n";
        
        System.out.println("\n====================================");
        System.out.println("         MAAS BORDROSU");
        System.out.println("====================================");
        System.out.printf("Çalışan: %s%n", adSoyad);
        System.out.printf("Tarih: %s%n", LocalDate.now());
        System.out.println("------------------------------------");

        System.out.println("GELIRLER:");
        System.out.printf(formatBaslik, "Brüt Maaş", brutMaas);
        System.out.printf(formatBaslik, "Mesai Ücreti (" + mesaiSaati + " saat)", mesaiUcreti);
        System.out.println(" ------------------------");
        System.out.printf(formatBaslik, "TOPLAM GELIR", toplamGelir);
        System.out.println("------------------------------------");

        System.out.println("KESINTILER:");
        // Kesinti oranları yüzdelik olarak yazdırılırken, Damga Vergisi 0.8% şeklinde yuvarlanır (Örnek çıktıya uyum)
        System.out.printf(formatKesinti, String.format("SGK Kesintisi (%.1f%%)", SGK_ORANI * 100), sgkKesintisi);
        System.out.printf(formatKesinti, String.format("Gelir Vergisi (%.1f%%)", GELIR_VERGISI_ORANI * 100), gelirVergisi);
        System.out.printf(formatKesinti, String.format("Damga Vergisi (%.1f%%)", DAMGA_VERGISI_ORANI * 100), damgaVergisi);
        System.out.println(" ------------------------");
        System.out.printf(formatKesinti, "TOPLAM KESINTI", toplamKesinti);
        System.out.println("------------------------------------");

        System.out.printf("NET MAAS                 : %10.2f TL%n", netMaas);
        System.out.println("====================================");

        System.out.println("ISTATISTIKLER:");
        // Yüzde değerleri 1 ondalık basamakla gösterilir (%.1f%%)
        System.out.printf(formatIstatistik, "Kesinti Oranı", kesintiOraniYuzde);
        System.out.printf(formatIstatistikSaat, "Saatlik Net Kazanç", saatlikNetKazanc);
        System.out.printf(formatIstatistikGun, "Günlük Net Kazanç", gunlukNetKazanc);
        System.out.println("====================================");
    }
}

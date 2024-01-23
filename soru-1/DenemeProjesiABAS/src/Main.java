import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Siparis> siparisList = new ArrayList<Siparis>();
        Double toplamFiyat = 0.000;
        DecimalFormat df = new DecimalFormat("#0.000");
        int toplamMal = 0;
        Map<Integer,Double> malBazliToplamFiyatlar = new HashMap<Integer,Double>();
        Map<Integer,Integer> malBazliToplamMiktar = new HashMap<Integer,Integer>();
        Map<String,Integer> siparisBazliToplamMiktar = new TreeMap<String,Integer>();

        //DATA
        siparisList.add(new Siparis(1000,2000,12,100.51));
        siparisList.add(new Siparis(1000,2001,31,200));
        siparisList.add(new Siparis(1000,2002,22,150.86));
        siparisList.add(new Siparis(1000,2003,41,250));
        siparisList.add(new Siparis(1000,2004,55,244));

        siparisList.add(new Siparis(1001,2001,88,44.531));
        siparisList.add(new Siparis(1001,2002,121,88.11));
        siparisList.add(new Siparis(1001,2004,74,211));
        siparisList.add(new Siparis(1001,2002,14,88.11));

        siparisList.add(new Siparis(1002,2003,2,12.1));
        siparisList.add(new Siparis(1002,2004,3,22.3));
        siparisList.add(new Siparis(1002,2003,8,12.1));
        siparisList.add(new Siparis(1002,2002,16,94));
        siparisList.add(new Siparis(1002,2005,9,44.1));
        siparisList.add(new Siparis(1002,2006,19,90));

        for(Siparis sip : siparisList)
        {
            String keyForSiparis = sip.getSiparisNo()+"-"+sip.getMalNo();

            toplamFiyat += (sip.getMiktar() * sip.getBirimFiyat());
            toplamMal += sip.getMiktar();

            if(!malBazliToplamFiyatlar.containsKey(sip.getMalNo()))
            {
                malBazliToplamFiyatlar.put(sip.getMalNo(),(sip.getBirimFiyat()*sip.getMiktar()));
                malBazliToplamMiktar.put(sip.getMalNo(),sip.getMiktar());

            }
            else
            {
                malBazliToplamFiyatlar.put(sip.getMalNo(),malBazliToplamFiyatlar.get(sip.getMalNo())+(sip.getBirimFiyat()*sip.getMiktar()));
                malBazliToplamMiktar.put(sip.getMalNo(),malBazliToplamMiktar.get(sip.getMalNo())+sip.getMiktar());
            }

            if(!siparisBazliToplamMiktar.containsKey(keyForSiparis))
            {
                siparisBazliToplamMiktar.put(keyForSiparis,sip.getMiktar());
            }
            else
            {
                siparisBazliToplamMiktar.put(keyForSiparis,siparisBazliToplamMiktar.get(keyForSiparis)+sip.getMiktar());
            }

        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("1.a ) Üç siparişteki malların toplam tutarının çıktısını veren java kodu.");
        System.out.println("Toplam Tutar : "+df.format(toplamFiyat));

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("1.b ) Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.");
        System.out.println("Ortalama Fiyat : "+df.format(toplamFiyat/toplamMal));

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("1.c ) Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.");
        malBazliToplamFiyatlar.forEach((k,v) -> System.out.println("Mal No : "
                + k + " => Birim Fiyatı : " + df.format(v / malBazliToplamMiktar.get(k)) ));

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("1.d ) Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren java kodu.");
        siparisBazliToplamMiktar.forEach((k,v) -> System.out.println("Sipariş No - Mal No : "
                + k + " => Miktar : " + v));


    }
}
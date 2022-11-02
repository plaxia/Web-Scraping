package Task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        DBFuncs db = new DBFuncs();
        Connection conn = db.connect_to_db("selman", "root", "123456");
        for (int o = 1; o < 45; o++) {
            Document doc = Jsoup.connect("https://www.trendyol.com/sr?wb=102323%2C101849%2C103502%2C104964%2C107655&wc=103108&pi=" + o).timeout(100000).get();
            Elements tt = doc.getElementsByClass("prc-box-dscntd");
            Elements tit = doc.getElementsByClass("prdct-desc-cntnr-ttl-w two-line-text");
            Elements marka_isim = doc.getElementsByClass("prdct-desc-cntnr-ttl");
            Elements links = doc.select("div[class=p-card-chldrn-cntnr card-border]");
            String [] lnk=new String[24];
            Elements atag=links.select("a");
            for (int i = 1; i <12 ; i++) {
                lnk[i] = atag.get(i).attr("href");
            }
            System.out.println("linlinklinklink");
            for (int i = 0; i <12 ; i++) {
                System.out.println(lnk[i]);
            }
            System.out.println("linlinklinklink");

            String[] str = new String[tit.size()];
            String[] fiyat = new String[tt.size()];
            for (int i = 0; i < tit.size(); i++) {
                str[i] = tit.get(i).text();
            }

            for (int i = 0; i < tt.size(); i++) {
                fiyat[i] = tt.get(i).text();
            }

            String twoD[][] = new String[tit.size()][20];


            for (int i = 0; i < twoD.length; i++) {

                for (int l = 0; l < twoD[i].length; l++) {
                    twoD[i] = str[i].split(" ", str.length);
                }
            }


            String marka[] = new String[150];
            for (int i = 0; i < twoD.length; i++) {
                marka[i] = marka_isim.get(i).text();
            }
            String model[] = new String[150];
            for (int i = 0; i < twoD.length; i++) {
                model[i] = twoD[i][1];
                if (twoD[i][0].contains("ACERAspire")) {
                    model[i] = twoD[i][2];
                }
                if (twoD[i][0].contains("ASUSRog")) {
                    model[i] = twoD[i][1] + twoD[i][2];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Aspire")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Gaming")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Nitro") && twoD[i][2].contains("5") && twoD[i][2].contains("An")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("HP") && twoD[i][1].contains("250") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Thinkpad") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3] + twoD[i][4];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Legion") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Ideapad") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3] + twoD[i][4];
                }
            }
                String islemcitip[] = new String[150];
                System.out.println("islemci tipi:");

                for (int i = 0; i < twoD.length; i++) {
                    for (int j = 0; j < twoD[i].length; j++) {
                        if (twoD[i][j].contains("I5") || twoD[i][j].contains("i5") || twoD[i][j].contains("i7") || twoD[i][j].contains("I7")) {
                            islemcitip[i] = "Intel";
                        }
                        if (twoD[i][j].contains("Intel") || twoD[i][j].contains("Ryzen") || twoD[i][j].contains("M1"))
                            islemcitip[i] = twoD[i][j];
                    }
                }


            String ram[] = new String[150];
            System.out.println("Ram:");

            for (int i = 0; i < twoD.length; i++) {

                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("8GB") || twoD[i][j].equals("8gb") || twoD[i][j].equals("16gb") || twoD[i][j].equals("16") || twoD[i][j].equals("16GB") || twoD[i][j].equals("4gb") || twoD[i][j].equals("4GB")) {
                        ram[i] = twoD[i][j];
                    }
                }
            }
            String bellek[] = new String[150];
            System.out.println("Bellek boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("256GB") || twoD[i][j].equals("256gb") || twoD[i][j].equals("512gb") || twoD[i][j].equals("512") || twoD[i][j].equals("512GB") || twoD[i][j].equals("1TB") || twoD[i][j].equals("1tb") || twoD[i][j].equals("512ssd") || twoD[i][j].equals("128gb") || twoD[i][j].equals("128GB") || twoD[i][j].equals("128") || twoD[i][j].equals("1TB+128GB") || twoD[i][j].equals("256")) {
                        bellek[i] = twoD[i][j];
                    }
                }
            }


            String diskturu[] = new String[150];
            System.out.println("Bellek Tipi:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("SSD") || twoD[i][j].equals("HDD") || twoD[i][j].equals("ssd") || twoD[i][j].equals("hdd") || twoD[i][j].equals("512ssd") || twoD[i][j].equals("Ssd") || twoD[i][j].equals("Hdd")) {
                        diskturu[i] = twoD[i][j];
                    }
                }
            }
            String nesil[] = new String[150];
            System.out.println("Islemci :");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].contains("I5") || twoD[i][j].contains("I7") || twoD[i][j].contains("i5") || twoD[i][j].contains("i7") || twoD[i][j].equals("11") || twoD[i][j].contains("Ryzen5-5600h") || twoD[i][j].contains("5800hs") || twoD[i][j].contains("6800h") || twoD[i][j].contains("1165g7") || twoD[i][j].contains("N4500") || twoD[i][j].contains("N4020") || twoD[i][j].contains("5300u") || twoD[i][j].equals("M1") || twoD[i][j].equals("M2") || twoD[i][j].equals("M3") || twoD[i][j].equals("5500U") || twoD[i][j].contains("i3") || twoD[i][j].equals("I3") || twoD[i][j].contains("i9") || twoD[i][j].contains("I9") || twoD[i][j].contains("IntelCeleron-") || twoD[i][j].equals("3500u")) {
                        nesil[i] = twoD[i][j];
                    }
                }
            }

            String ekran_boyutu[] = new String[150];
            System.out.println("Ekran boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].contains("14''") || twoD[i][j].contains("17.3") || twoD[i][j].contains("15.6''") || twoD[i][j].contains("14\"") || twoD[i][j].contains("13\"") || twoD[i][j].contains("15.6\"") || twoD[i][j].contains("15,6\"") || twoD[i][j].contains("13''") || twoD[i][j].contains("15.6") || twoD[i][j].contains("11.6")) {
                        ekran_boyutu[i] = twoD[i][j];
                    }
                }
            }
            String isletim_sistemi[] = new String[150];
             System.out.println("Ekran boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {
                    if (twoD[i][j].contains("Apple")) {
                        isletim_sistemi[i] = "MACOS";
                    }
                    if (twoD[i][j].contains("Freedos") || twoD[i][j].contains("Fdos") || twoD[i][j].contains("W11") || twoD[i][j].contains("Windows") || twoD[i][j].contains("FREEDOS") || twoD[i][j].contains("W10") || twoD[i][j].contains("Win")) {
                        isletim_sistemi[i] = twoD[i][j];
                    }
                }
            }
            String [] site=new String[24];
            for (int i = 0; i < fiyat.length ; i++) {
                site[i]="trendyol";
            }

            for (int i = 0; i < 12; i++)
            {
                db.insertRow(conn, "yeni", marka[i], model[i], islemcitip[i], nesil[i], diskturu[i], bellek[i], ram[i], ekran_boyutu[i], isletim_sistemi[i], fiyat[i],site[i],lnk[i]);
            }
        }


        System.out.println("n11n1n1n1n1");
        for (int o = 1; o < 45; o++) {
            Document doc = Jsoup.connect("https://www.n11.com/bilgisayar?urt=Notebook&m=HP-Casper-Lenovo-Dell&pg=" + o).timeout(1000000000).get();
            Elements tit = doc.getElementsByClass("productName");
            Elements links = doc.select("div.pro ");
            Elements tt =doc.getElementsByTag("ins");
            Elements resim=doc.select("img.lazy cardImage ");

            String[] link = new String[links.size()];
            String[] resimler = new String[resim.size()];


            Elements atag = links.select("a");
            for (int i = 0; i < 24; i++) {

                link[i] = (atag.get(i).attr("href"));
            }
            System.out.println("**********");
            for (int i = 0; i < 24; i++) {

                System.out.println(resim.attr("src"));
            }
            System.out.println("**********");






            String[] str = new String[tit.size()];
            String[] fiyat = new String[tt.size()];
            String twoD[][] = new String[tit.size()][20];

            for (int i = 0; i < tit.size(); i++) {
                str[i] = tit.get(i).text();
            }

            for (int i = 0; i < tt.size(); i++) {
                System.out.println("fiyatfiyatfiyatfiyat");
                fiyat[i] = tt.get(i).text();
                System.out.println(fiyat[i]);
            }



            for (int i = 0; i < twoD.length; i++) {

                for (int l = 0; l < twoD[i].length; l++) {
                    twoD[i] = str[i].split(" ", str.length);
                }
            }


            String marka[] = new String[150];
             System.out.println("MarkaModel:");
            for (int i = 0; i < twoD.length; i++) {
                marka[i] = twoD[i][0];
            }
            String model[] = new String[150];
            System.out.println("Model no:");
            for (int i = 0; i < twoD.length; i++) {
                model[i] = twoD[i][1];
                if (twoD[i][0].contains("ACERAspire")) {
                    model[i] = twoD[i][2];
                }
                if (twoD[i][0].contains("ASUSRog")) {
                    model[i] = twoD[i][1] + twoD[i][2];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Aspire")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Gaming")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Nitro") && twoD[i][2].contains("5") && twoD[i][2].contains("An")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("HP") && twoD[i][1].contains("250") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Thinkpad") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3] + twoD[i][4];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Legion") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Ideapad") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3] + twoD[i][4];
                }
            }
            String islemcitip[] = new String[150];
            System.out.println("islemci tipi:");

            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {
                    if (twoD[i][j].contains("I5") || twoD[i][j].contains("i5") || twoD[i][j].contains("i7") || twoD[i][j].contains("I7")) {
                        islemcitip[i] = "Intel";
                    }
                    if (twoD[i][j].contains("Intel") || twoD[i][j].contains("Ryzen") || twoD[i][j].contains("M1"))
                        islemcitip[i] = twoD[i][j];

                }

            }


            String ram[] = new String[150];
            System.out.println("Ram:");

            for (int i = 0; i < twoD.length; i++) {

                for (int j = 0; j < twoD[i].length; j++) {

                    if ((twoD[i][j].equals("8") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("8") && twoD[i][j + 1].equals("gb")) || (twoD[i][j].equals("16") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("16") && twoD[i][j + 1].equals("gb")) || (twoD[i][j].equals("32") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("4") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("4") && twoD[i][j + 1].equals("gb"))) {
                        ram[i] = twoD[i][j];
                    }
                }
            }
            String bellek[] = new String[150];
             System.out.println("Bellek boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("256GB") || twoD[i][j].equals("256gb") || twoD[i][j].equals("512gb") || twoD[i][j].equals("512") || twoD[i][j].equals("512GB") || twoD[i][j].equals("1TB") || twoD[i][j].equals("1tb") || twoD[i][j].equals("512ssd") || twoD[i][j].equals("128gb") || twoD[i][j].equals("128GB") || twoD[i][j].equals("128") || twoD[i][j].equals("1TB+128GB") || twoD[i][j].equals("256")) {
                        bellek[i] = twoD[i][j];
                    }
                }

            }


            String diskturu[] = new String[150];
            System.out.println("Bellek Tipi:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("SSD") || twoD[i][j].equals("HDD") || twoD[i][j].equals("ssd") || twoD[i][j].equals("hdd") || twoD[i][j].equals("512ssd") || twoD[i][j].equals("Ssd") || twoD[i][j].equals("Hdd")) {
                        diskturu[i] = twoD[i][j];
                    }
                }
            }
            String nesil[] = new String[150];
          System.out.println("Islemci ve nesli:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].contains("I5") || twoD[i][j].contains("I7") || twoD[i][j].contains("i5") || twoD[i][j].contains("i7") || twoD[i][j].equals("11") || twoD[i][j].contains("Ryzen5-5600h") || twoD[i][j].contains("5800hs") || twoD[i][j].contains("6800h") || twoD[i][j].contains("1165g7") || twoD[i][j].contains("N4500") || twoD[i][j].contains("N4020") || twoD[i][j].contains("5300u") || twoD[i][j].equals("M1") || twoD[i][j].equals("M2") || twoD[i][j].equals("M3") || twoD[i][j].equals("5500U") || twoD[i][j].contains("i3") || twoD[i][j].equals("I3") || twoD[i][j].contains("i9") || twoD[i][j].contains("I9") || twoD[i][j].contains("IntelCeleron-") || twoD[i][j].equals("3500u")) {
                        nesil[i] = twoD[i][j];
                    }
                }
            }

            String ekran_boyutu[] = new String[150];
            System.out.println("Ekran boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].contains("14''") || twoD[i][j].contains("17.3") || twoD[i][j].contains("15.6''") || twoD[i][j].contains("14\"") || twoD[i][j].contains("13\"") || twoD[i][j].contains("15.6\"") || twoD[i][j].contains("15,6\"") || twoD[i][j].contains("13''") || twoD[i][j].contains("15.6") || twoD[i][j].contains("11.6")) {
                        ekran_boyutu[i] = twoD[i][j];
                    }
                }
            }
            String isletim_sistemi[] = new String[150];
             System.out.println("Ekran boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {
                    if (twoD[i][j].contains("Free")) {

                        isletim_sistemi[i] = "Freedos";
                    }
                    if (twoD[i][j].contains("Apple")) {
                        isletim_sistemi[i] = "MACOS";
                    }
                    if (twoD[i][j].contains("Freedos") || twoD[i][j].contains("Fdos") || twoD[i][j].contains("W11") || twoD[i][j].contains("Windows") || twoD[i][j].contains("FREEDOS") || twoD[i][j].contains("W10") || twoD[i][j].contains("W10P") || twoD[i][j].contains("W11P")) {
                        isletim_sistemi[i] = twoD[i][j];
                    }
                }
            }
            String[] site = new String[24];
            for (int i = 0; i < site.length ; i++) {

                site[i]="n11";
            }
            for (int i = 0; i <8 ; i++) {
                for (int j = 0; j <8 ; j++) {
                    System.out.println(twoD[i][j]);
                }
            }

            for (int i = 1; i < 12; i++)
            {
                db.insertRow(conn,"yeni",marka[i],model[i],islemcitip[i],nesil[i],diskturu[i],bellek[i],ram[i],ekran_boyutu[i],isletim_sistemi[i],fiyat[i],site[i],link[i]);
            }
        }


        System.out.println("amazonamazonamazonamazon");
        for (int o = 2; o < 10; o++) {
            Document doc = Jsoup.connect("https://www.vatanbilgisayar.com/lenovo-hp-dell-casper-acer-msi/notebook/?page="+o ).timeout(100000).get();
            Elements tit = doc.getElementsByClass("product-list__product-name");
            Elements links = doc.getElementsByClass("product-list__link");
            Elements tt =doc.getElementsByClass("product-list__price");
            //Elements resim=doc.select("img.lazy cardImage ");

           String[] link = new String[24];





            for (int i = 0; i <links.size(); i++)
            {

                    link[i] = links.get(i).attr("href");

            }
            System.out.println("---------");
            for (int i = 0; i <10 ; i++) {
                System.out.println(link[i]);
            }
            System.out.println("-------");






            String[] str = new String[tit.size()];
            String[] fiyat = new String[tt.size()];
            String twoD[][] = new String[tit.size()][20];

            for (int i = 0; i < tit.size(); i++) {
                str[i] = tit.get(i).text();
            }

            for (int i = 0; i < tt.size(); i++) {
                System.out.println("fiyatfiyatfiyatfiyat");
                fiyat[i] = tt.get(i).text();
                System.out.println(fiyat[i]);
            }



            for (int i = 0; i < twoD.length; i++) {

                for (int l = 0; l < twoD[i].length; l++) {
                    twoD[i] = str[i].split("-", str.length);
                }
            }


            String marka[] = new String[150];
            System.out.println("MarkaModel:");
            for (int i = 0; i < twoD.length; i++) {
                marka[i] = twoD[i][0];
            }
            String model[] = new String[150];
            System.out.println("Model no:");
            for (int i = 0; i < twoD.length; i++) {
                model[i] = twoD[i][1];
                if (twoD[i][0].contains("ACERAspire")) {
                    model[i] = twoD[i][2];
                }
                if (twoD[i][0].contains("ASUSRog")) {
                    model[i] = twoD[i][1] + twoD[i][2];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Aspire")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Gaming")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("ACER") && twoD[i][1].contains("Nitro") && twoD[i][2].contains("5") && twoD[i][2].contains("An")) {
                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("HP") && twoD[i][1].contains("250") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Thinkpad") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3] + twoD[i][4];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Legion") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3];
                }
                if (twoD[i][0].contains("Lenovo") && twoD[i][1].contains("Ideapad") && !twoD[i][2].equals(null) && !twoD[i][3].equals(null)) {

                    model[i] = twoD[i][1] + twoD[i][2] + twoD[i][3] + twoD[i][4];
                }
            }
            String islemcitip[] = new String[150];
            System.out.println("islemci tipi:");

            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {
                    if (twoD[i][j].contains("I5") || twoD[i][j].contains("i5") || twoD[i][j].contains("i7") || twoD[i][j].contains("I7")) {
                        islemcitip[i] = "Intel";
                    }
                    if (twoD[i][j].contains("Intel") || twoD[i][j].contains("Ryzen") || twoD[i][j].contains("M1"))
                        islemcitip[i] = twoD[i][j];

                }

            }


            String ram[] = new String[150];
            System.out.println("Ram:");

            for (int i = 0; i < twoD.length; i++) {

                for (int j = 0; j < twoD[i].length; j++) {

                    if ((twoD[i][j].equals("8") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("8") && twoD[i][j + 1].equals("gb")) || (twoD[i][j].equals("16") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("16") && twoD[i][j + 1].equals("gb")) || (twoD[i][j].equals("32") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("4") && twoD[i][j + 1].equals("GB")) || (twoD[i][j].equals("4") && twoD[i][j + 1].equals("gb"))) {
                        ram[i] = twoD[i][j];
                    }
                }
            }
            String bellek[] = new String[150];
            System.out.println("Bellek boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("256GB") || twoD[i][j].equals("256gb") || twoD[i][j].equals("512gb") || twoD[i][j].equals("512") || twoD[i][j].equals("512GB") || twoD[i][j].equals("1TB") || twoD[i][j].equals("1tb") || twoD[i][j].equals("512ssd") || twoD[i][j].equals("128gb") || twoD[i][j].equals("128GB") || twoD[i][j].equals("128") || twoD[i][j].equals("1TB+128GB") || twoD[i][j].equals("256")) {
                        bellek[i] = twoD[i][j];
                    }
                }

            }


            String diskturu[] = new String[150];
            System.out.println("Bellek Tipi:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].equals("SSD") || twoD[i][j].equals("HDD") || twoD[i][j].equals("ssd") || twoD[i][j].equals("hdd") || twoD[i][j].equals("512ssd") || twoD[i][j].equals("Ssd") || twoD[i][j].equals("Hdd")) {
                        diskturu[i] = twoD[i][j];
                    }
                }
            }
            String nesil[] = new String[150];
            System.out.println("Islemci ve nesli:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].contains("I5") || twoD[i][j].contains("I7") || twoD[i][j].contains("i5") || twoD[i][j].contains("i7") || twoD[i][j].equals("11") || twoD[i][j].contains("Ryzen5-5600h") || twoD[i][j].contains("5800hs") || twoD[i][j].contains("6800h") || twoD[i][j].contains("1165g7") || twoD[i][j].contains("N4500") || twoD[i][j].contains("N4020") || twoD[i][j].contains("5300u") || twoD[i][j].equals("M1") || twoD[i][j].equals("M2") || twoD[i][j].equals("M3") || twoD[i][j].equals("5500U") || twoD[i][j].contains("i3") || twoD[i][j].equals("I3") || twoD[i][j].contains("i9") || twoD[i][j].contains("I9") || twoD[i][j].contains("IntelCeleron-") || twoD[i][j].equals("3500u")) {
                        nesil[i] = twoD[i][j];
                    }
                }
            }

            String ekran_boyutu[] = new String[150];
            System.out.println("Ekran boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {

                    if (twoD[i][j].contains("14''") || twoD[i][j].contains("17.3") || twoD[i][j].contains("15.6''") || twoD[i][j].contains("14\"") || twoD[i][j].contains("13\"") || twoD[i][j].contains("15.6\"") || twoD[i][j].contains("15,6\"") || twoD[i][j].contains("13''") || twoD[i][j].contains("15.6") || twoD[i][j].contains("11.6")) {
                        ekran_boyutu[i] = twoD[i][j];
                    }
                }
            }
            String isletim_sistemi[] = new String[150];
            System.out.println("Ekran boyutu:");
            for (int i = 0; i < twoD.length; i++) {
                for (int j = 0; j < twoD[i].length; j++) {
                    if (twoD[i][j].contains("Free")) {

                        isletim_sistemi[i] = "Freedos";
                    }
                    if (twoD[i][j].contains("Apple")) {
                        isletim_sistemi[i] = "MACOS";
                    }
                    if (twoD[i][j].contains("Freedos") || twoD[i][j].contains("Fdos") || twoD[i][j].contains("W11") || twoD[i][j].contains("Windows") || twoD[i][j].contains("FREEDOS") || twoD[i][j].contains("W10") || twoD[i][j].contains("W10P") || twoD[i][j].contains("W11P")) {
                        isletim_sistemi[i] = twoD[i][j];
                    }
                }
            }
            String[] site = new String[24];
            for (int i = 0; i < site.length ; i++) {

                site[i]="Vatan";
            }
            for (int i = 0; i <twoD.length ; i++) {
                for (int j = 0; j <twoD[i].length ; j++) {
                    System.out.println(twoD[i][j]);
                }
            }

           for (int i = 1; i < 12; i++)
            {
                db.insertRow(conn,"yeni",marka[i],model[i],islemcitip[i],nesil[i],diskturu[i],bellek[i],ram[i],ekran_boyutu[i],isletim_sistemi[i],fiyat[i],site[i],link[i]);
            }
        }





    }
}


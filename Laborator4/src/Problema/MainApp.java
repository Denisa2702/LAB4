package Problema;

import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static void scrie(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object citeste(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws IOException {

        List<Echipament> lista=new ArrayList<Echipament>();
        Scanner my_scanner=new Scanner(System.in);
        BufferedReader flux_in=new BufferedReader(new FileReader("electronice.txt"));
        String linie;
        String[] inf;

        String status, mod_tiparire, format, sistem_operare;
        String den, zona_mag, rez, tip_mon;
        int nr_inv, ppm, p_car, p_ton, c_hdd;
        float pret, vit_proc;


        while((linie=flux_in.readLine())!=null)
        {
            inf=linie.split(";");
            den=inf[0];
            nr_inv= Integer.parseInt(inf[1]);
            pret= Float.parseFloat(inf[2]);
            zona_mag=inf[3];
            status=inf[4];

            if(linie.contains("imprimanta"))
            {
                ppm= Integer.parseInt(inf[6]);
                rez=inf[7];
                p_car= Integer.parseInt(inf[8]);
                mod_tiparire=inf[9];
                Imprimanta I=new Imprimanta(den, nr_inv, pret, zona_mag, Status.valueOf(status),ppm, rez, p_car, ModTiparire.valueOf(mod_tiparire));
                lista.add(I);
            }
            else
                if(linie.contains("copiator"))
                {
                    p_ton= Integer.parseInt(inf[6]);
                    format=inf[7];
                    Copiator C=new Copiator(den, nr_inv, pret, zona_mag, Status.valueOf(status), p_ton, Format.valueOf(format));
                    lista.add(C);
                }

                else
                    if(linie.contains("sistem de calcul"))
                    {
                        tip_mon=inf[6];
                        vit_proc= Float.parseFloat(inf[7]);
                        c_hdd= Integer.parseInt(inf[8]);
                        sistem_operare=inf[9];
                        SistemCalcul SC=new SistemCalcul(den, nr_inv, pret, zona_mag, Status.valueOf(status), tip_mon, vit_proc, c_hdd, SistemOperare.valueOf(sistem_operare));
                        lista.add(SC);
                    }
        }


        int opt;
        while(true)
        {
            System.out.println("0. Iesire");
            System.out.println("1. Afisarea tuturor echipamentelor");
            System.out.println("2. Afisarea imprimantelor");
            System.out.println("3. Afisarea copiatoarelor");
            System.out.println("4. Afisarea sistemelor de calcul");
            System.out.println("5. Modificarea starii unui echipament");
            System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println("7. Setarea unui format de copiere pentru un copiator");
            System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("9. Afisarea echipamentelor vandute");
            System.out.println("10. Metode statice???? pt serializare/deserializara colectiei de obiecte in fisierul echip.bin");

            System.out.print("\nAlegeti optiunea dorita: ");
            opt=my_scanner.nextInt();
            my_scanner.nextLine();

            switch (opt)
            {
                case 0:
                    System.exit(0);

                case 1:
                {
                    System.out.println("\n--Toate echipamentele--");
                    for(Echipament e:lista)
                        System.out.println(e.toString());
                    System.out.println();
                    break;
                }

                case 2:
                {
                    System.out.println("\n--IMPRIMANTE--");
                    for(Echipament e:lista)
                        if(e instanceof Imprimanta)
                            System.out.println(e.toString());
                    System.out.println();
                    break;
                }

                case 3:
                {
                    System.out.println("\n--COPIATOR--");
                    for(Echipament e:lista)
                        if(e instanceof Copiator)
                            System.out.println(e.toString());
                    System.out.println();
                    break;
                }

                case 4:
                {
                    System.out.println("\n--SISTEM DE CALCUL--");
                    for(Echipament e:lista)
                        if(e instanceof SistemCalcul)
                            System.out.println(e.toString());
                    System.out.println();
                    break;
                }

                case 5:
                {
                    System.out.println("Dati denumirea echipamentului: ");
                    String den_echipament=my_scanner.nextLine();
                    int ok=0;

                    for(Echipament e:lista) {
                        if (e.getDenumire().equals(den_echipament)) {
                            ok = 1;
                            System.out.println("Introduceti noua stare a echipamentului: ");
                            System.out.println("Alegeti una dintre urmatoarele: \n1.Achizitionat \n2.Expus \n3.Vandut");
                            int stare = my_scanner.nextInt();
                            my_scanner.nextLine();
                            if (stare == 1)
                                e.setStatus(Status.valueOf("achizitionat"));
                            else if (stare == 2)
                                e.setStatus(Status.valueOf("expus"));
                            else if (stare == 3)
                                e.setStatus(Status.valueOf("vandut"));
                            System.out.println("Starea a fost schimbata\n");
                        }
                    }
                    if(ok==0)
                        System.out.println("Nu exista un echipament cu acest nume!!!\n");
                    break;
                }

                case 6:
                {
                    System.out.println("Dati denumirea echipamentului: ");
                    String den_echipament=my_scanner.nextLine();
                    int ok=0;

                    for(Echipament e:lista) {
                        if (e instanceof Imprimanta)
                        {
                            if (e.getDenumire().equals(den_echipament)) {
                                ok = 1;
                                System.out.println("Introduceti noul mod de scriere: ");
                                System.out.println("Alegeti una dintre urmatoarele: \n1.Color \n2.Alb negru");
                                int mod = my_scanner.nextInt();
                                my_scanner.nextLine();
                                if (mod == 1)
                                    ((Imprimanta) e).setMod_tiparire(ModTiparire.valueOf("color"));
                                else if (mod == 2)
                                   ((Imprimanta) e).setMod_tiparire(ModTiparire.valueOf("alb_negru"));

                                System.out.println("Modul de scriere a fost schimbat\n");
                            }
                        }
                    }
                    if(ok==0)
                        System.out.println("Nu exista o imprimanta cu acest nume!!!\n");
                    break;
                }

                case 7:
                {
                    System.out.println("Dati denumirea echipamentului: ");
                    String den_echipament=my_scanner.nextLine();
                    int ok=0;

                    for(Echipament e:lista) {
                        if (e instanceof Copiator)
                        {
                            if (e.getDenumire().equals(den_echipament)) {
                                ok = 1;
                                System.out.println("Introduceti noul format: ");
                                System.out.println("Alegeti una dintre urmatoarele: \n1.A3 \n2.A4");
                                int mod = my_scanner.nextInt();
                                my_scanner.nextLine();
                                if (mod == 1)
                                    ((Copiator) e).setFormat(Format.valueOf("A3"));
                                else if (mod == 2)
                                    ((Copiator) e).setFormat(Format.valueOf("A4"));

                                System.out.println("Modul de scriere a fost schimbat\n");
                            }
                        }
                    }
                    if(ok==0)
                        System.out.println("Nu exista un copiator cu acest nume!!!\n");
                    break;
                }

                case 8:
                {
                    System.out.println("Dati denumirea echipamentului: ");
                    String den_echipament=my_scanner.nextLine();
                    int ok=0;

                    for(Echipament e:lista) {
                        if (e instanceof SistemCalcul)
                        {
                            if (e.getDenumire().equals(den_echipament)) {
                                ok = 1;
                                System.out.println("Introduceti noul format: ");
                                System.out.println("Alegeti una dintre urmatoarele: \n1.Windows \n2.Linux");
                                int mod = my_scanner.nextInt();
                                my_scanner.nextLine();
                                if (mod == 1)
                                    ((SistemCalcul) e).setSistem_operare(SistemOperare.valueOf("Windows"));
                                else if (mod == 2)
                                    ((SistemCalcul) e).setSistem_operare(SistemOperare.valueOf("Linux"));
                                System.out.println("Sistemul de operare a fost schimbat\n");
                            }
                        }
                    }
                    if(ok==0)
                        System.out.println("Nu exista un sistem de calcul cu acest nume!!!\n");
                    break;
                }

                case 9: {
                    System.out.println("--ECHIPAMENTELE VANDUTE--");
                    for (Echipament e : lista)
                        if(e.getStatus().equals(Status.valueOf("vandut")))
                            System.out.println(e.toString());
                    System.out.println();
                    break;
                }

                case 10:
                {
                    System.out.println("???\n");
                    for(Echipament e:lista)
                    {
                        scrie(e, "echip.bin"); //serializare
                    }
                    break;
                }

            }
        }



    }



}

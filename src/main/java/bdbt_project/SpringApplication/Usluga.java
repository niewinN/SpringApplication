package bdbt_project.SpringApplication;

public class Usluga {
    private int nr_uslugi;
    private String nazwa;
    private String opis;
    private int liczba_miejsc;
    private int nr_sauny;

    public Usluga(int nr_uslugi, String nazwa, String opis, int liczba_miejsc, int nr_sauny) {
        this.nr_uslugi = nr_uslugi;
        this.nazwa = nazwa;
        this.opis = opis;
        this.liczba_miejsc = liczba_miejsc;
        this.nr_sauny = nr_sauny;
    }

    public Usluga() {
    }

    public int getNr_uslugi() {
        return nr_uslugi;
    }

    public void setNr_uslugi(int nr_uslugi) {
        this.nr_uslugi = nr_uslugi;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getLiczba_miejsc() {
        return liczba_miejsc;
    }

    public void setLiczba_miejsc(int liczba_miejsc) {
        this.liczba_miejsc = liczba_miejsc;
    }

    public int getNr_sauny() {
        return nr_sauny;
    }

    public void setNr_sauny(int nr_sauny) {
        this.nr_sauny = nr_sauny;
    }

    @Override
    public String toString() {
        return "Usluga{" +
                "nr_uslugi=" + nr_uslugi +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                ", liczba_miejsc=" + liczba_miejsc +
                ", nr_sauny=" + nr_sauny +
                '}';
    }
}

package bdbt_project.SpringApplication;

public class Adres {
    private int nr_adresu;
    private String kraj;
    private String miasto;
    private String ulica;
    private String numer_budynku;
    private String kod_pocztowy;

    public Adres(int nr_adresu, String kraj, String miasto, String ulica, String numer_budynku, String kod_pocztowy) {
        this.nr_adresu = nr_adresu;
        this.kraj = kraj;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer_budynku = numer_budynku;
        this.kod_pocztowy = kod_pocztowy;
    }

    public Adres() {
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer_budynku() {
        return numer_budynku;
    }

    public void setNumer_budynku(String numer_budynku) {
        this.numer_budynku = numer_budynku;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nr_adresu=" + nr_adresu +
                ", kraj='" + kraj + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer_budynku='" + numer_budynku + '\'' +
                ", kod_pocztowy=" + kod_pocztowy +
                '}';
    }
}

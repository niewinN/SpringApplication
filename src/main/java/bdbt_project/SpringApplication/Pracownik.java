package bdbt_project.SpringApplication;


import java.sql.Date;

public class Pracownik {
    private int nr_pracownika;
    private String imie;
    private String drugie_imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String pesel;
    private String plec;
    private Date data_zatrudnienia;
    private int numer_telefonu;
    private String email;
    private int numer_konta;
    private int nr_sauny;
    private int nr_adresu;

    public Pracownik(int nr_pracownika, String imie, String drugie_imie, String nazwisko, Date data_urodzenia, String pesel, String plec,
                     Date data_zatrudnienia, int numer_telefonu, String email, int numer_konta, int nr_sauny, int nr_adresu) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.drugie_imie = drugie_imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.data_zatrudnienia = data_zatrudnienia;
        this.numer_telefonu = numer_telefonu;
        this.email = email;
        this.numer_konta = numer_konta;
        this.nr_sauny = nr_sauny;
        this.nr_adresu = nr_adresu;
    }

    public Pracownik() {
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugie_imie() {
        return drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.drugie_imie = drugie_imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public int getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(int numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumer_konta() {
        return numer_konta;
    }

    public void setNumer_konta(int numer_konta) {
        this.numer_konta = numer_konta;
    }

    public int getNr_sauny() {
        return nr_sauny;
    }

    public void setNr_sauny(int nr_sauny) {
        this.nr_sauny = nr_sauny;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", pesel=" + pesel +
                ", plec='" + plec + '\'' +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", numer_telefonu=" + numer_telefonu +
                ", email='" + email + '\'' +
                ", numer_konta=" + numer_konta +
                ", nr_sauny=" + nr_sauny +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}

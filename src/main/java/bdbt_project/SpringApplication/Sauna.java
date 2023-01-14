package bdbt_project.SpringApplication;

import java.sql.Date;

public class Sauna {
    private int nr_sauny;
    private String nazwa;
    private Date data_zalozenia;
    private int numer_telefonu;
    private String email;
    private int nr_adresu;

    public Sauna(int nr_sauny, String nazwa, Date data_zalozenia, int numer_telefonu, String email, int nr_adresu) {
        this.nr_sauny = nr_sauny;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.numer_telefonu = numer_telefonu;
        this.email = email;
        this.nr_adresu = nr_adresu;
    }

    public Sauna() {
    }

    public int getNr_sauny() {
        return nr_sauny;
    }

    public void setNr_sauny(int nr_sauny) {
        this.nr_sauny = nr_sauny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Date data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
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

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Sauna{" +
                "nr_sauny=" + nr_sauny +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + data_zalozenia +
                ", numer_telefonu=" + numer_telefonu +
                ", email='" + email + '\'' +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}

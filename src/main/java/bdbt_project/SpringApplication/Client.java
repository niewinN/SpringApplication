package bdbt_project.SpringApplication;

public class Client {
    private int nr_klienta;
    private int numer_telefonu;
    private String email;
    private int nr_sauny;
    private int nr_adresu;

    public Client() {
        this.nr_klienta = nr_klienta;
        this.numer_telefonu = numer_telefonu;
        this.email = email;
        this.nr_sauny = nr_sauny;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
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
        return "Client{" +
                "nr_klienta=" + nr_klienta +
                ", numer_telefonu=" + numer_telefonu +
                ", email='" + email + '\'' +
                ", nr_sauny=" + nr_sauny +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}


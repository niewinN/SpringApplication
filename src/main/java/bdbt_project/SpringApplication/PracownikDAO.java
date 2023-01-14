package bdbt_project.SpringApplication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class PracownikDAO {
    private JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return listPracownik;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("nr_pracownika", "imie", "drugie_imie", "nazwisko", "data_urodzenia",
                "pesel", "plec", "data_zatrudnienia", "numer_telefonu", "email", "numer_konta", "nr_sauny", "nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Pracownik get(int nr_pracownika) {
        Object[] args = {nr_pracownika};
        String sql = "SELECT * FROM PRACOWNICY WHERE nr_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return pracownik;
    }

    /* Update – aktualizacja danych */
    public void update(Pracownik pracownik) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, drugie_imie=:drugie_imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia," +
                " pesel=:pesel, plec=:plec, data_zatrudnienia=:data_zatrudnienia, numer_telefonu=:numer_telefonu, email=:email," +
                " numer_konta=:numer_konta, nr_sauny=:nr_sauny," +
                " nr_adresu=:nr_adresu WHERE nr_pracownika=:nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE nr_pracownika = ?";
        jdbcTemplate.update(sql, nr_pracownika);
    }

}

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
public class AdresDAO {
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";

        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return listAdres;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("nr_adresu", "kraj", "miasto", "ulica", "numer_budynku", "kod_pocztowy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Adres get(int nr_adresu) {
        Object[] args = {nr_adresu};
        String sql = "SELECT * FROM ADRESY WHERE nr_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return adres;
    }

    /* Update – aktualizacja danych */
    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET kraj=:kraj, miasto=:miasto, ulica=:ulica," +
                " numer_budynku=:numer_budynku, kod_pocztowy=:kod_pocztowy WHERE nr_adresu=:nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_adresu) {
        String sql = "DELETE FROM ADRESY WHERE nr_adresu = ?";
        jdbcTemplate.update(sql, nr_adresu);
    }

}


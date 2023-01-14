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
public class UslugaDAO {
    private JdbcTemplate jdbcTemplate;

    public UslugaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Usluga> list(){
        String sql = "SELECT * FROM USLUGI";

        List<Usluga> listUsluga = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usluga.class));

        return listUsluga;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Usluga usluga) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("uslugi").usingColumns("nr_uslugi", "nazwa", "opis", "liczba_miejsc", "nr_sauny");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Usluga get(int nr_uslugi) {
        Object[] args = {nr_uslugi};
        String sql = "SELECT * FROM USLUGI WHERE nr_uslugi = " + args[0];
        Usluga usluga = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Usluga.class));

        return usluga;
    }

    /* Update – aktualizacja danych */
    public void update(Usluga usluga) {
        String sql = "UPDATE USLUGI SET nazwa=:nazwa, opis=:opis, liczba_miejsc=:liczba_miejsc," +
                " nr_sauny=:nr_sauny WHERE nr_uslugi=:nr_uslugi";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_uslugi) {
        String sql = "DELETE FROM USLUGI WHERE nr_uslugi = ?";
        jdbcTemplate.update(sql, nr_uslugi);
    }

}

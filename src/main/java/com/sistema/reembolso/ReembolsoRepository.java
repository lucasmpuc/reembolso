package com.sistema.reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class ReembolsoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReembolsoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Reembolso save(Reembolso reembolso) {
        String sql = "INSERT INTO reembolso (descricao, data, valor, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, reembolso.getDescricao(), reembolso.getData(), reembolso.getValor(), reembolso.getStatus());
        return reembolso; // In a real scenario, you'd want to return the generated ID as well.
    }

    public List<Reembolso> findAll() {
        String sql = "SELECT * FROM reembolso";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Reembolso(rs.getLong("id"), rs.getString("descricao"), rs.getDouble("valor"), rs.getString("data"), rs.getString("status")));
    }

    // ... add other methods as necessary
}

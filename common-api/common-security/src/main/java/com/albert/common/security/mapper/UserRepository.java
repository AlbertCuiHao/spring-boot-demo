package com.albert.common.security.mapper;

import com.albert.common.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public UserEntity findUserEntityByUsername(String username) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        String sql = """
                SELECT id,
                       user_name,
                       user_password,
                       version_no,
                       to_char(create_time, 'yyyy-MM-dd hh24:MI:ss') create_time,
                       create_by,
                       to_char(update_time, 'yyyy-MM-dd hh24:MI:ss') update_time,
                       update_by
                FROM develop.sys_user
                WHERE user_name = :username
                """;
        return namedParameterJdbcTemplate.queryForObject(sql, map, (rs, rowNum) -> {
            UserEntity entity = new UserEntity();
            entity.setId(rs.getString("id"));
            entity.setUsername(rs.getString("user_name"));
            entity.setPassword(rs.getString("user_password"));
            entity.setVersion(rs.getLong("version_no"));
            entity.setCreateTime(getLocalDateTime(rs.getString("create_time")));
            entity.setCreateBy(rs.getString("create_by"));
            entity.setUpdateTime(getLocalDateTime(rs.getString("update_time")));
            entity.setUpdateBy(rs.getString("update_by"));
            return entity;
        });
    }

    public List<Map<String, Object>> findUserRoleAndAuthorityByUsername(String username) {
        String sql = """
                SELECT a.id,
                       a.user_name,
                       c.role_name security_name,
                       'ROLE'      security_type
                FROM develop.sys_user a,
                     develop.sys_user_role_link b,
                     develop.sys_role c
                WHERE a.id = b.user_id
                  AND b.role_id = c.id
                  AND a.user_name = ?
                UNION
                SELECT a.id,
                       a.user_name,
                       c.authority_name security_name,
                       'AUTHORITY'      security_type
                FROM develop.sys_user a,
                     develop.sys_user_authority_link b,
                     develop.sys_authority c
                WHERE a.id = b.user_id
                  AND b.authority_id = c.id
                  AND a.user_name = ?
                                """;
        return jdbcTemplate.queryForList(sql, username, username);
    }

    public LocalDateTime getLocalDateTime(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, dateTimeFormatter);
    }
}

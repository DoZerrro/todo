package com.zero.todo2.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {

    INSTANCE;

    private DataSource dataSource;

    ConnectionUtil() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            HikariConfig config = new HikariConfig();
            //데이터베이스 연결
            config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
            config.setUsername("webuser");
            config.setPassword("webuser");

            //hikariCP 기본설정
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.setMaximumPoolSize(200);

            dataSource = new HikariDataSource(config);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

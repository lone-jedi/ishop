package com.yarkin.ishop.utils.jdbc;

import com.yarkin.ishop.utils.jdbc.logger.StatisticDataSource;

import java.sql.Connection;

public class JdbcConnection {
    // ???
    public static final Connection CONNECTION = new StatisticDataSource().getConnection();
}

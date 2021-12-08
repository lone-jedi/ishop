package com.yarkin.ishop.utils.jdbc.logger;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.concurrent.Executor;

@Slf4j
public class StatisticConnection implements Connection {
    private final Connection connection;

    public StatisticConnection(Connection connection) throws SQLException {
        log.info("Connection OPENED:  " + connection.getMetaData().getURL());
        this.connection = connection;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        log.info("Prepared statement:  " + sql);
        return connection.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        log.info("Prepared call:  " + sql);
        return connection.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        log.info("Native SQL: " + sql);
        return connection.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        log.info("Set autocommit: " + autoCommit);
        connection.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        log.info("Commit");
        connection.commit();
    }

    @Override
    public void rollback() throws SQLException {
        log.info("Rollback");
        connection.rollback();
    }

    @Override
    public void close() throws SQLException {
        log.info("Connection CLOSED: " + connection.getMetaData().getURL());
        connection.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        log.info("Set read only: " + readOnly);
        connection.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return connection.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        log.info("Set catalog: " + catalog);
        connection.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        log.info("Set transactional isolation level: " + level);
        connection.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return connection.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        log.info("Warnings cleared");
        connection.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        log.info("Created statement with:\n\rresult type = " + resultSetType + "\n\rresult concurrency = "
                + resultSetConcurrency);
        return connection.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        log.info("Prepared statement " + sql + "\n\rresult type = " + resultSetType + "\n\rresult concurrency = "
                + resultSetConcurrency);
        return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        log.info("Prepared call " + sql + "\n\rresult type = " + resultSetType + "\n\rresult concurrency = "
                + resultSetConcurrency);
        return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return connection.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        log.info("Set type map");
        connection.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        log.info("Set holdability to " + holdability);
        connection.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return connection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        log.info("Set savepoint");
        return connection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        log.info("Set savepoint to " + name);
        return connection.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        log.info("Rollback savepoint " + savepoint.getSavepointName());
        connection.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        log.info("Release savepoint " + savepoint.getSavepointName());
        connection.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        log.info("Created statement with:\n\rresult set type = " + resultSetType + "\n\rresult set concurrency = "
                + resultSetConcurrency + "\n\rresult set holdability = " + resultSetHoldability);
        return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        log.info("Prepared statement " + sql + "\n\rresult type = " + resultSetType + "\n\rresult concurrency = "
                + resultSetConcurrency+ "\n\rresult set holdability = " + resultSetHoldability);
        return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        log.info("Prepared call " + sql + "\n\rresult type = " + resultSetType + "\n\rresult concurrency = "
                + resultSetConcurrency+ "\n\rresult set holdability = " + resultSetHoldability);
        return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        log.info("Prepared statement " + sql + "\n\rautogenerated keys = " + autoGeneratedKeys);
        return connection.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        StringJoiner stringJoiner = new StringJoiner(", ","{", "}");
        for (int columnIndex : columnIndexes) {
            stringJoiner.add(String.valueOf(columnIndex));
        }
        log.info("Prepared statement " + sql + "\n\rcolumn indexes = " + stringJoiner);
        return connection.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        StringJoiner stringJoiner = new StringJoiner(", ","{", "}");
        for(String columnName : columnNames) {
            stringJoiner.add(columnName);
        }
        log.info("Prepared statement " + sql + "\n\rcolumn names = " + stringJoiner);
        return connection.prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        log.info("Create Clob");
        return connection.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        log.info("Create Blob");
        return connection.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        log.info("Create NClob");
        return connection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        log.info("Create SQLXML");
        return connection.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return connection.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        log.info("Set client info: name=" + name + " value=" + value);
        connection.setClientInfo(name, value);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        log.info("Set client info");
        connection.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return connection.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return connection.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        log.info("Create array of " + typeName);
        return connection.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        log.info("Create struct " + typeName);
        return connection.createStruct(typeName, attributes);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        log.info("Set schema " + schema);
        connection.setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        log.info("Abort");
        connection.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        log.info("Set network timeout to " + milliseconds + "ms");
        connection.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return connection.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return connection.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return connection.isWrapperFor(iface);
    }
}

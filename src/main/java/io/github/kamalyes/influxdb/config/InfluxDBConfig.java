package io.github.kamalyes.influxdb.config;

import org.apache.jmeter.visualizers.backend.BackendListenerContext;
import lombok.Data;

@Data
public class InfluxDBConfig {

    public static final String DEFAULT_DATABASE = "jmeter";
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_RETENTION_POLICY = "autogen";
    public static final String DEFAULT_HTTP_SCHEME = "http";
    public static final int DEFAULT_PORT = 8086;

    public static final String KEY_INFLUXDB_HOST = "InfluxDBHost";
    public static final String KEY_INFLUXDB_DATABASE = "InfluxDBDatabase";
    public static final String KEY_INFLUXDB_PORT = "InfluxDBPort";
    public static final String KEY_INFLUXDB_USER = "InfluxDBUserName";
    public static final String KEY_INFLUXDB_PASSWORD = "InfluxDBPassword";
    public static final String KEY_INFLUXDB_RETENTION_POLICY = "InfluxRetentionPolicy";
    public static final String KEY_HTTP_SCHEME = "http";

    private String influxDBHost;
    private String influxDbUser;
    private String influxDbPassword;
    private String influxDatabase;
    private String influxRetentionPolicy;
    private int influxDBPort;
    private String influxHTTPScheme;

    public InfluxDBConfig(BackendListenerContext context) {
        String influxHttpScheme = context.getParameter(KEY_HTTP_SCHEME, DEFAULT_HTTP_SCHEME);
        String influxDbHost = context.getParameter(KEY_INFLUXDB_HOST, DEFAULT_HOST);
        int influxDbPort = context.getIntParameter(KEY_INFLUXDB_PORT, DEFAULT_PORT);
        String influxDBUserName = context.getParameter(KEY_INFLUXDB_USER);
        String influxDBPassword = context.getParameter(KEY_INFLUXDB_PASSWORD);
        String influxDBDatabase = context.getParameter(KEY_INFLUXDB_DATABASE, DEFAULT_DATABASE);
        String influxDBRetentionPolicy = context.getParameter(KEY_INFLUXDB_RETENTION_POLICY, DEFAULT_RETENTION_POLICY);

        setInfluxHTTPScheme(influxHttpScheme);
        setInfluxDBHost(influxDbHost);
        setInfluxDBPort(influxDbPort);
        setInfluxDatabase(influxDBDatabase);
        setInfluxDbUser(influxDBUserName);
        setInfluxDbPassword(influxDBPassword);
        setInfluxRetentionPolicy(influxDBRetentionPolicy);

    }

    /* Build InfluxDB URL */

    public String getInfluxDbUrl() {
        return influxHTTPScheme + "://" + influxDBHost + ":" + influxDBPort;
    }
}

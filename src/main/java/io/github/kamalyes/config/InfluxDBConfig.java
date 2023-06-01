package io.github.kamalyes.config;

import io.github.kamalyes.utils.Arguments;

import lombok.Data;

import org.apache.jmeter.visualizers.backend.BackendListenerContext;

/**
 * Configuration for influxDB.
 */
@Data
public class InfluxDBConfig {

    /**
     * Default bucket name.
     */
    public static final String DEFAULT_BUCKET = "jmeter";

    /**
     * Default influxdb url.
     */
    public static final String DEFAULT_INFLUXDB_URL = "http://localhost:8086/";

    /**
     * Default threshold error.
     */
    public static final int DEFAULT_THRESHOLD_ERROR = 5;

    /**
     * Default token.
     */
    public static final String DEFAULT_INFLUX_DB_TOKEN = "put token here";

    /**
     * Default organization.
     */
    public static final String DEFAULT_INFLUX_DB_ORG = "performance_testing";

    /**
     * Default batch size.
     */
    public static final int DEFAULT_INFLUX_DB_MAX_BATCH_SIZE = 2000;

    /**
     * Default flush interval.
     */
    public static final int DEFAULT_INFLUX_DB_FLUSH_INTERVAL = 4000;

    /**
     * Default response body length.
     */
    public static final int DEFAULT_RESPONSE_BODY_LENGTH = 2000;

    /**
     * Config key for influxdb url.
     */
    public static final String KEY_INFLUX_DB_URL = "influxDBUrl";

    /**
     * Config key for bucket.
     */
    public static final String KEY_INFLUX_DB_BUCKET = "influxDBBucket";

    /**
     * Config key for organization.
     */
    public static final String KEY_INFLUX_DB_ORG = "influxDBOrganization";

    /**
     * Config key for token.
     */
    public static final String KEY_INFLUX_DB_TOKEN = "influxDBToken";

    /**
     * Config key for batch size.
     */
    public static final String KEY_INFLUX_DB_MAX_BATCH_SIZE = "influxDBMaxBatchSize";

    /**
     * Config key for flush interval.
     */
    public static final String KEY_INFLUX_DB_FLUSH_INTERVAL = "influxDBFlushInterval";

    /**
     * Config key error threshold.
     */
    public static final String KEY_INFLUX_DB_THRESHOLD_ERROR = "influxDBThresholdError";

    /**
     * Config key to manage the response body length.
     */
    public static final String KEY_RESPONSE_BODY_LENGTH = "responseBodyLength";

    /**
     * InfluxDB URL.
     */
    private String influxDBUrl;

    /**
     * InfluxDB Token.
     */
    private String influxToken;

    /**
     * InfluxDB Organization.
     */
    private String influxOrganization;

    /**
     * InfluxDB database Bucket.
     */
    private String influxBucket;

    /**
     * InfluxDB database batch size.
     */
    private int influxdbBatchSize;

    /**
     * InfluxDB database flush interval.
     */
    private int influxdbFlushInterval;

    /**
     * Default protection to avoid OOM error.
     */
    private int influxdbThresholdError;

    /**
     * Response body length.
     */
    private int responseBodyLength;

    /**
     * Creates the new instance of {@link InfluxDBConfig}
     *
     * @param context the {@link BackendListenerContext}
     */
    public InfluxDBConfig(BackendListenerContext context) {
        String influxDBUrl = context.getParameter(KEY_INFLUX_DB_URL);
        Arguments.checkNonEmpty(influxDBUrl, KEY_INFLUX_DB_URL);
        String[] influxHTTPScheme = influxDBUrl.split("://", 2);
        Arguments.checkHTTPScheme(influxHTTPScheme[0]);
        this.setInfluxDBUrl(influxDBUrl);

        String influxToken = context.getParameter(KEY_INFLUX_DB_TOKEN);
        Arguments.checkNonEmpty(influxToken, KEY_INFLUX_DB_TOKEN);
        this.setInfluxToken(influxToken);

        String influxOrg = context.getParameter(KEY_INFLUX_DB_ORG);
        Arguments.checkNonEmpty(influxOrg, KEY_INFLUX_DB_ORG);
        this.setInfluxOrganization(influxOrg);

        String influxBucket = context.getParameter(KEY_INFLUX_DB_BUCKET);
        Arguments.checkNonEmpty(influxBucket, KEY_INFLUX_DB_BUCKET);
        this.setInfluxBucket(influxBucket);

        int influxdbBatchSize = context.getIntParameter(KEY_INFLUX_DB_MAX_BATCH_SIZE);
        Arguments.checkNotNegativeNumber(influxdbBatchSize, KEY_INFLUX_DB_MAX_BATCH_SIZE);
        this.setInfluxdbBatchSize(influxdbBatchSize);

        int influxdbFlushInterval = context.getIntParameter(KEY_INFLUX_DB_FLUSH_INTERVAL);
        Arguments.checkNotNegativeNumber(influxdbFlushInterval, KEY_INFLUX_DB_FLUSH_INTERVAL);
        this.setInfluxdbFlushInterval(influxdbFlushInterval);

        int influxdbThresholdError = context.getIntParameter(KEY_INFLUX_DB_THRESHOLD_ERROR,
                InfluxDBConfig.DEFAULT_THRESHOLD_ERROR);
        Arguments.checkNotNegativeNumber(influxdbThresholdError, KEY_INFLUX_DB_THRESHOLD_ERROR);
        this.setInfluxdbThresholdError(influxdbThresholdError);

        int responseBodyLength = context.getIntParameter(KEY_RESPONSE_BODY_LENGTH);
        Arguments.checkNotNegativeNumber(influxdbFlushInterval, KEY_RESPONSE_BODY_LENGTH);
        this.setResponseBodyLength(responseBodyLength);
    }
}

package io.github.kamalyes.jmeter.samplers;

import org.apache.jmeter.samplers.SampleResult;
import lombok.Data;

/**
 * The data object with parameters to create Result {@link com.influxdb.client.write.Point}.
 */
@Data
public class SampleResultPointContext {
    private long timeToSet;
    private SampleResult sampleResult;
    private String nodeName;
    private String runId;
    private String testName;
    private boolean errorBodyToBeSaved;
    private int responseBodyLength;
    private String samplerType;
}

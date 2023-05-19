package io.github.kamalyes.config;

/**
 * Constants (Tag, Field, Measurement) names for the virtual users measurement.
 */
public interface VirtualUsersMeasurement {

	/**
	 * Measurement name.
	 */
	String MEASUREMENT_NAME = "virtualUsers";

	/**
	 * Tags.
	 */
	interface Tags {
		/**
		 * Node name field
		 */
		String NODE_NAME = "nodeName";

		/**
		 * Test Name name field
		 */
		String TEST_NAME = "testName";

		/**
		 * Run Id field
		 */
		String RUN_ID = "runId";
	}

	/**
	 * Fields.
	 */
	interface Fields {
		/**
		 * Minimum active threads field.
		 */
		String MIN_ACTIVE_THREADS = "minActiveThreads";

		/**
		 * Maximum active threads field.
		 */
		String MAX_ACTIVE_THREADS = "maxActiveThreads";

		/**
		 * Mean active threads field.
		 */
		String MEAN_ACTIVE_THREADS = "meanActiveThreads";

		/**
		 * Started threads field.
		 */
		String STARTED_THREADS = "startedThreads";

		/**
		 * Finished threads field.
		 */
		String FINISHED_THREADS = "finishedThreads";
	}
}

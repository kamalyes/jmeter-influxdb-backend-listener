package io.github.kamalyes.config;

/**
 * Constants (Tag, Field, Measurement) names for the measurement that denotes
 * start and end points of a load test.
 */
public interface TestStartEndMeasurement {

	/**
	 * Measurement name.
	 */
	String MEASUREMENT_NAME = "testStartEnd";

	/**
	 * Tags.
	 *
	 */
	interface Tags {
		/**
		 * Start or End type tag.
		 */
		String TYPE = "type";

		/**
		 * Node name field.
		 */
		String NODE_NAME = "nodeName";

		/**
		 * tag use for a unique id for this particular execution (aka 'run') of a load
		 * test.
		 */
		String RUN_ID = "runId";

		/**
		 * Test name field.
		 */
		String TEST_NAME = "testName";
	}

	/**
	 * Fields.
	 */
	interface Fields {
		/**
		 * Test name field.
		 */
		String PLACEHOLDER = "placeholder";
	}

	/**
	 * Values.
	 */
	interface Values {
		/**
		 * Finished.
		 */

		String FINISHED = "finished";
		/**
		 * Started.
		 */
		String STARTED = "started";
	}
}

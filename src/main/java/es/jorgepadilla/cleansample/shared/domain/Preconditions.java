package es.jorgepadilla.cleansample.shared.domain;

import static org.apache.commons.lang3.StringUtils.isBlank;

public final class Preconditions {

	private Preconditions(){}

	public static <T> T checkNotNull(T value, String reason) {
		if (value == null) {
			throw new IllegalArgumentException(reason);
		}
		return value;
	}

	public static String checkNotBlank(String value, String reason) {
		if (isBlank(value)) {
			throw new IllegalArgumentException(reason);
		}
		return value;
	}


}

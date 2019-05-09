package org.webstilos.cleansample.model.util;

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


	public static String checkMaxCharacters(String value, int maxSize, String reason) {
		if (value.length() > maxSize) {
			throw new IllegalArgumentException(reason);
		}
		return value;
	}


}

package org.webstilos.cleansample.application.response;

import java.util.UUID;

public class ResourceIdResponse {

	private final String id;

	public ResourceIdResponse(UUID id) {
		this.id = id.toString();
	}

	public String getId() {
		return id;
	}
}

package es.jorgepadilla.cleansample.shared.application.response;

import java.util.UUID;

public abstract class ResourceIdResponse {

	private final String id;

	public ResourceIdResponse(UUID id) {
		this.id = id.toString();
	}

	public String getId() {
		return id;
	}
}

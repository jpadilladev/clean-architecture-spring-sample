package org.webstilos.cleansample.application.response.artist;

import org.webstilos.cleansample.model.artist.Artist;

public class ArtistResponse {

	private final String name;
	private final String birthday;
	private final String alias;

	public ArtistResponse(Artist artist) {
		this.name = artist.getName();
		this.birthday = artist.getBirthday().toString();
		this.alias = artist.getAlias().orElse(null);
	}

	public String getName() {
		return name;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAlias() {
		return alias;
	}
}

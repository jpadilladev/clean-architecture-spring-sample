package es.jorgepadilla.cleansample.artists.application.response;

import es.jorgepadilla.cleansample.artists.domain.artist.Artist;
import es.jorgepadilla.cleansample.shared.application.response.ResourceIdResponse;

public class ArtistResponse extends ResourceIdResponse {

	private final String name;
	private final String birthday;
	private final String alias;

	public ArtistResponse(Artist artist) {
		super(artist.getId());
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

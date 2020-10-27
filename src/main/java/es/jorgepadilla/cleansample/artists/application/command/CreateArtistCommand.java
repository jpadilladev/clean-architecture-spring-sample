package es.jorgepadilla.cleansample.artists.application.command;

import java.util.Optional;

public class CreateArtistCommand {

	private String name;

	private String birthday;

	private String alias;

	public String getName() {
		return name;
	}

	public CreateArtistCommand setName(String name) {
		this.name = name;
		return this;
	}

	public String getBirthday() {
		return birthday;
	}

	public CreateArtistCommand setBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}

	public Optional<String> getAlias() {
		return Optional.ofNullable(alias);
	}

	public CreateArtistCommand setAlias(String alias) {
		this.alias = alias;
		return this;
	}
}

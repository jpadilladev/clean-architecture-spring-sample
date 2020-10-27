package es.jorgepadilla.cleansample.artists.domain.artist;


import es.jorgepadilla.cleansample.shared.domain.Preconditions;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class Artist {

	private UUID id;
	private String name;
	private LocalDate birthday;
	private String alias;

	public Artist(String name, LocalDate birthday) {
		this.id = UUID.randomUUID();
		setName(name);
		setBirthday(birthday);
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Artist setName(String name) {
		this.name =  Preconditions.checkNotBlank(name, "Name can't be null");
		return this;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Artist setBirthday(LocalDate birthday) {
		this.birthday = Preconditions.checkNotNull(birthday, "Birthday can't be null");
		return this;
	}

	public Optional<String> getAlias() {
		return Optional.ofNullable(alias);
	}

	public Artist setAlias(String alias) {
		this.alias = alias;
		return this;
	}
}

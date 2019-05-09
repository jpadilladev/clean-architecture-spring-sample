package org.webstilos.cleansample.application.service;

import org.webstilos.cleansample.application.response.ResourceIdResponse;
import org.webstilos.cleansample.application.response.artist.ArtistResponse;
import org.webstilos.cleansample.application.response.command.CreateArtistCommand;
import org.webstilos.cleansample.model.artist.Artist;
import org.webstilos.cleansample.model.artist.ArtistRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.webstilos.cleansample.model.util.Preconditions.checkNotBlank;

@Named
public class ArtistApplicationService {

	private final ArtistRepository artistRepository;

	@Inject
	public ArtistApplicationService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}


	/**
	 * Use case, return all artists.
	 */
	public List<ArtistResponse> findAll() {
		return artistRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Artist::getBirthday))
				.map(ArtistResponse::new)
				.collect(Collectors.toList());
	}

	/**
	 * Creates and Saves a new Artist.
	 */
	public ResourceIdResponse create(CreateArtistCommand command) {
		String name = command.getName();
		LocalDate birthday = LocalDate.parse(checkNotBlank(command.getBirthday(), "Birthday can't be empty"));

		Artist artist = new Artist(name, birthday);
		artistRepository.save(artist);
		return new ResourceIdResponse(artist.getId());
	}
}

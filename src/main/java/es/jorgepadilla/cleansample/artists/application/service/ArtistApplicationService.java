package es.jorgepadilla.cleansample.artists.application.service;

import es.jorgepadilla.cleansample.shared.application.response.ResourceIdResponse;
import es.jorgepadilla.cleansample.artists.application.response.ArtistResponse;
import es.jorgepadilla.cleansample.artists.application.command.CreateArtistCommand;
import es.jorgepadilla.cleansample.artists.domain.artist.Artist;
import es.jorgepadilla.cleansample.artists.domain.artist.ArtistRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static es.jorgepadilla.cleansample.shared.domain.Preconditions.checkNotBlank;

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
	public ArtistResponse create(CreateArtistCommand command) {
		String name = command.getName();
		LocalDate birthday = LocalDate.parse(checkNotBlank(command.getBirthday(), "Birthday can't be empty"));

		Artist artist = new Artist(name, birthday);
		artistRepository.save(artist);
		return new ArtistResponse(artist);
	}
}

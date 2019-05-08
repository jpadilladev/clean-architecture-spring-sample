package org.webstilos.cleansample.application.service;

import org.webstilos.cleansample.application.response.artist.ArtistResponse;
import org.webstilos.cleansample.model.artist.Artist;
import org.webstilos.cleansample.model.artist.ArtistRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
}

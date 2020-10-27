package es.jorgepadilla.cleansample.artists.application.service;

import es.jorgepadilla.cleansample.artists.domain.artist.Artist;
import es.jorgepadilla.cleansample.artists.domain.artist.ArtistRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Populate a dummy Database.
 */
@Named
public class SamplePopulationService {

	private final ArtistRepository artistRepository;

	@Inject
	public SamplePopulationService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
		this.populateOnStartup();
	}

	private void populateOnStartup() {
		List<Artist> artists = createArtists();
		artists.forEach(artistRepository::save);
	}

	private List<Artist> createArtists() {
		return asList(
				new Artist("James Alan Hetfield", LocalDate.of(1963, Month.AUGUST, 3)).setAlias("James Hetfield"),
				new Artist("Mike Portnoy", LocalDate.of(1967, Month.APRIL, 20)),
				new Artist("Mat Heaffy", LocalDate.of(1986, Month.JANUARY, 26))
		);
	}


}

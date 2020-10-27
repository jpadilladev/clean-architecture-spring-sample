package es.jorgepadilla.cleansample.artists.domain.artist;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArtistTest {

	@Test
	public void givenNullName_whenNewArtist_thenThrowException() {
		String name = null;

		assertThatThrownBy(() -> new Artist(name, LocalDate.MAX))
				.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Name can't be null");

	}
}
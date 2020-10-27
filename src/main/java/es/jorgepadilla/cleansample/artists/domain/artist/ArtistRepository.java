package es.jorgepadilla.cleansample.artists.domain.artist;

import java.util.List;

public interface ArtistRepository {

	void save(Artist artist);

	List<Artist> findAll();

}

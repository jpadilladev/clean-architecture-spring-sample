package org.webstilos.cleansample.model.artist;

import java.util.List;

public interface ArtistRepository {

	void save(Artist artist);

	List<Artist> findAll();

}

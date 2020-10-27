package es.jorgepadilla.cleansample.artists.infrastructure.repository;

import org.springframework.stereotype.Repository;
import es.jorgepadilla.cleansample.artists.domain.artist.Artist;
import es.jorgepadilla.cleansample.artists.domain.artist.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryArtistRepository implements ArtistRepository {

	private final static Map<UUID, Artist> IN_MEMORY_DB = new ConcurrentHashMap<>();

	@Override
	public void save(Artist artist) {
		IN_MEMORY_DB.put(artist.getId(), artist);
	}

	@Override
	public List<Artist> findAll() {
		return new ArrayList<>(IN_MEMORY_DB.values());
	}


}

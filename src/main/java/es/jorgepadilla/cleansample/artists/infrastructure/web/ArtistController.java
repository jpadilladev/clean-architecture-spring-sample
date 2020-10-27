package es.jorgepadilla.cleansample.artists.infrastructure.web;

import es.jorgepadilla.cleansample.artists.application.command.CreateArtistCommand;
import es.jorgepadilla.cleansample.artists.application.response.ArtistResponse;
import es.jorgepadilla.cleansample.artists.application.service.ArtistApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

	private final ArtistApplicationService artistApplicationService;

	@Autowired
	public ArtistController(ArtistApplicationService artistApplicationService) {
		this.artistApplicationService = artistApplicationService;
	}

	@GetMapping("/artists")
	public List<ArtistResponse> artists() {
		return artistApplicationService.findAll();
	}

	@PostMapping("/artists")
	public ArtistResponse create(@RequestBody CreateArtistCommand command) {
		return artistApplicationService.create(command);
	}

}

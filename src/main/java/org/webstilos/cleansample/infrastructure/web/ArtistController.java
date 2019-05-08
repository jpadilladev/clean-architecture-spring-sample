package org.webstilos.cleansample.infrastructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webstilos.cleansample.application.response.artist.ArtistResponse;
import org.webstilos.cleansample.application.service.ArtistApplicationService;

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

}
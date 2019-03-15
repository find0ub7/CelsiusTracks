package br.com.ifood.challenge.celsiustracks.integration.spotify;

import br.com.ifood.challenge.celsiustracks.domain.spotify.CategoriesResource;
import br.com.ifood.challenge.celsiustracks.domain.spotify.PlaylistsResource;
import br.com.ifood.challenge.celsiustracks.domain.spotify.TracksResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpotifyIntegrationFallbackServiceImpl implements SpotifyIntegrationService {

    @Override
    public CategoriesResource getCategories(final Integer offset, final Integer limit) {
        log.warn("Fallback for SpotifyIntegration.getCategories");
        return new CategoriesResource(); //TODO implementar fallback
    }

    @Override
    public PlaylistsResource getPlaylistsByCategory(final String categoryId, final Integer offset, final Integer limit) {
        log.warn("Fallback for SpotifyIntegration.getPlaylistsByCategory");
        return new PlaylistsResource();  //TODO implementar fallback
    }

    @Override
    public TracksResource getTracksByPlaylist(final String playlistId, final Integer offset, final Integer limit) {
        log.warn("Fallback for SpotifyIntegration.getTracksByPlaylist");
        return new TracksResource();  //TODO implementar fallback
    }

}
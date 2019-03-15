package br.com.ifood.challenge.celsiustracks.service.impl;

import br.com.ifood.challenge.celsiustracks.domain.celsiustracks.CelsiusPlaylist;
import br.com.ifood.challenge.celsiustracks.domain.celsiustracks.PlaylistCategory;
import br.com.ifood.challenge.celsiustracks.domain.openweathermap.WeatherResource;
import br.com.ifood.challenge.celsiustracks.integration.openweathermap.OpenWeatherMapIntegrationService;
import br.com.ifood.challenge.celsiustracks.property.OpenWeatherMapProperties;
import br.com.ifood.challenge.celsiustracks.service.CelsiusTracksService;
import br.com.ifood.challenge.celsiustracks.service.FinderPlaylistCategoryByTemperatureService;
import br.com.ifood.challenge.celsiustracks.service.FinderPlaylistByCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CelsiusTracksServiceImpl implements CelsiusTracksService {

    private final OpenWeatherMapProperties openWeatherMapProperties;
    private final OpenWeatherMapIntegrationService openWeatherMapIntegrationService;
    private final FinderPlaylistCategoryByTemperatureService finderPlaylistCategoryByTemperatureService;
    private final FinderPlaylistByCategory finderPlaylistByCategory;

    @Override
    public List<CelsiusPlaylist> getTracksByCity(final String cityName, final Pageable page) {
        final String appId = openWeatherMapProperties.getAppId();
        final WeatherResource weather = openWeatherMapIntegrationService.getWeatherByCity(cityName, appId);
        return findCelsiusTracksByCategory(weather, page);
    }

    @Override
    public List<CelsiusPlaylist> getTracksByCoordinates(final Double latitude, final Double longitude, final Pageable page) {
        final String appId = openWeatherMapProperties.getAppId();
        final WeatherResource weather = openWeatherMapIntegrationService.getWeatherByCoordinates(latitude, longitude, appId);
        return findCelsiusTracksByCategory(weather, page);
    }

    private List<CelsiusPlaylist> findCelsiusTracksByCategory(final WeatherResource weather, final Pageable page) {
        final PlaylistCategory playlistCategory = finderPlaylistCategoryByTemperatureService.find(weather.getCurrentTemperature());
        return finderPlaylistByCategory.find(playlistCategory, page);
    }

}

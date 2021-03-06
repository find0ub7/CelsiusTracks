package br.com.ifood.challenge.celsiustracks.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlists {

    @JsonProperty("href")
    private String href;
    @JsonProperty("items")
    private List<PlaylistItem> items = null;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("next")
    private String next;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("total")
    private Integer total = 0;

    public List<String> getPlaylistId() {
        return ofNullable(items).orElse(emptyList())
                .stream()
                .map(PlaylistItem::getId)
                .collect(toList());
    }
}

package models.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PostResponse(
        @JsonProperty("title") String title,
        @JsonProperty("body") String body,
        @JsonProperty("tags") List<String> tags,
        @JsonProperty("reactions") Reactions reactions,
        @JsonProperty("userId") int userId,
        @JsonProperty("id") int id,
        @JsonProperty("views") int views
) {
    
}

package modulo.issue.mensagens

import com.fasterxml.jackson.annotation.JsonProperty

data class Event(
    @JsonProperty("action") val action: String,
    @JsonProperty("created_at") val createdAt: String,
    @JsonProperty("updated_at") val updatedAt: String
)
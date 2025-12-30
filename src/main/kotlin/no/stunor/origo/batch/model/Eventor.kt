package no.stunor.origo.batch.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("eventor")
data class Eventor (
        @Id var id: String = "",
        var name: String = "",
        var federation: String = "",
        var baseUrl: String = "",
        var eventorApiKey: String = ""
)
package no.stunor.origo.batch.config

import no.stunor.origo.batch.model.Organisation
import no.stunor.origo.batch.model.Region
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID

@Configuration
class JdbcConfiguration

interface UuidEntity {
    var id: UUID?
}

abstract class UuidGeneratingCallback<T : UuidEntity> : BeforeConvertCallback<T> {
    override fun onBeforeConvert(entity: T): T {
        if (entity.id == null) {
            entity.id = UUID.randomUUID()
        }
        return entity
    }
}

@Component
class RegionBeforeConvertCallback : UuidGeneratingCallback<Region>()

@Component
class OrganisationBeforeConvertCallback : UuidGeneratingCallback<Organisation>()

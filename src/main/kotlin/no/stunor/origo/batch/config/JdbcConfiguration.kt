package no.stunor.origo.batch.config

import no.stunor.origo.batch.model.Organisation
import no.stunor.origo.batch.model.Region
import no.stunor.origo.batch.model.UuidEntity
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID

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

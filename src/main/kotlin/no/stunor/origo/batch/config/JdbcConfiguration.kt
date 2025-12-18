package no.stunor.origo.batch.config

import no.stunor.origo.batch.model.Organisation
import no.stunor.origo.batch.model.Region
import no.stunor.origo.batch.model.UuidEntity
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID

/**
 * Abstract base class for Spring Data JDBC BeforeConvertCallback implementations
 * that automatically generate UUIDs for entities with null IDs.
 *
 * Spring Data JDBC does not support @GeneratedValue like JPA does, so UUID generation
 * must be handled manually. This callback intercepts entities before they are converted
 * to database operations and assigns a random UUID if the ID is null.
 *
 * @param T the entity type that implements UuidEntity
 */
abstract class UuidGeneratingCallback<T : UuidEntity> : BeforeConvertCallback<T> {
    override fun onBeforeConvert(entity: T): T {
        if (entity.id == null) {
            entity.id = UUID.randomUUID()
        }
        return entity
    }
}

/**
 * Callback for automatically generating UUIDs for Region entities before insert.
 */
@Component
class RegionBeforeConvertCallback : UuidGeneratingCallback<Region>()

/**
 * Callback for automatically generating UUIDs for Organisation entities before insert.
 */
@Component
class OrganisationBeforeConvertCallback : UuidGeneratingCallback<Organisation>()

package no.stunor.origo.batch.model

import java.util.UUID

/**
 * Interface for entities that use UUID as their primary key.
 * The id property is mutable to allow Spring Data JDBC callbacks to set it
 * and to enable explicit ID assignment when preserving existing entities during updates.
 */
interface UuidEntity {
    var id: UUID?
}

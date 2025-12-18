package no.stunor.origo.batch.config

import no.stunor.origo.batch.model.Organisation
import no.stunor.origo.batch.model.Region
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID

@Configuration
class JdbcConfiguration

@Component
class RegionBeforeConvertCallback : BeforeConvertCallback<Region> {
    override fun onBeforeConvert(region: Region): Region {
        if (region.id == null) {
            region.id = UUID.randomUUID()
        }
        return region
    }
}

@Component
class OrganisationBeforeConvertCallback : BeforeConvertCallback<Organisation> {
    override fun onBeforeConvert(organisation: Organisation): Organisation {
        if (organisation.id == null) {
            organisation.id = UUID.randomUUID()
        }
        return organisation
    }
}

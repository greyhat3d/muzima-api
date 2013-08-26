package com.muzima.api.model.resolver;

import com.muzima.search.api.util.StringUtil;

import java.io.IOException;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class DynamicCohortDataResolver extends BaseOpenmrsResolver {

    private static final String REPRESENTATION = "?v=custom:(definition.uuid,definition.name," +
            "members:(uuid,gender,birthdate,personName.givenName,personName.middleName,personName.familyName," +
            "patientIdentifier.identifier,patientIdentifier.identifierType.name))";

    /**
     * Return the full REST resource based on the parameters passed to the method.
     *
     * @param resourceParams the parameters of the resource to resolved.
     * @return full uri to the REST resource.
     */
    public String resolve(final Map<String, String> resourceParams) throws IOException {
        String uuid = resourceParams.get("uuid");
        if (StringUtil.isEmpty(uuid)) {
            throw new IOException("Resolver unable to find required parameter uuid!");
        }
        return getConfiguration().getServer() + "/ws/rest/v1/reportingrest/cohort/" + uuid + REPRESENTATION;
    }


}

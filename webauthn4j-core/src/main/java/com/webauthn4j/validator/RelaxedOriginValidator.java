/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.validator;

import com.webauthn4j.data.client.CollectedClientData;
import com.webauthn4j.data.client.Origin;
import com.webauthn4j.server.ServerProperty;
import com.webauthn4j.util.AssertUtil;
import com.webauthn4j.validator.exception.BadOriginException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

/**
 * Validates the specified {@link Origin} instance
 */
public class RelaxedOriginValidator extends OriginValidator {
    //~ Instance fields
    // ================================================================================================

    // ~ Methods
    // ========================================================================================================

    public void validate(@NonNull CollectedClientData collectedClientData, @NonNull ServerProperty serverProperty) {
        AssertUtil.notNull(collectedClientData, "collectedClientData must not be null");
        AssertUtil.notNull(serverProperty, "serverProperty must not be null");

        final Origin clientOrigin = collectedClientData.getOrigin();
        final Set<Origin> serverOrigins = serverProperty.getOrigins();

        for (Origin serverOrigin : serverOrigins) {
            if (clientOrigin != null && clientOrigin.matchesRelaxed(serverOrigin)) {
                return;
            }
        }

        throw new BadOriginException("The collectedClientData '" + clientOrigin + "' origin doesn't match any of the preconfigured server origin.");
    }
}

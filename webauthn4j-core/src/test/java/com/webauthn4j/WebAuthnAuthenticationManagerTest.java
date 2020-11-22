/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j;

import com.webauthn4j.converter.util.ObjectConverter;
import com.webauthn4j.validator.CustomAuthenticationValidator;
import com.webauthn4j.validator.OriginValidator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

class WebAuthnAuthenticationManagerTest {

    @Test
    void constructor_test() {
        ObjectConverter objectConverter = new ObjectConverter();
        List<CustomAuthenticationValidator> customAuthenticationValidators = Collections.emptyList();
        assertThatCode(WebAuthnAuthenticationManager::new).doesNotThrowAnyException();
        assertThatCode(() -> new WebAuthnAuthenticationManager(customAuthenticationValidators)).doesNotThrowAnyException();
        assertThatCode(() -> new WebAuthnAuthenticationManager(customAuthenticationValidators, new OriginValidator(), objectConverter)).doesNotThrowAnyException();
    }


}
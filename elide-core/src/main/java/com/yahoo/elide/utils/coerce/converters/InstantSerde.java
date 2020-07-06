/*
 * Copyright 2020, Yahoo Inc.
 * Licensed under the Apache License, Version 2.0
 * See LICENSE file in project root for terms.
 */
package com.yahoo.elide.utils.coerce.converters;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Convert an Instant to/from an ISO-8601 string representation.
 *
 * Uses the semantics of {@link java.time.format.DateTimeFormatter#ISO_INSTANT}
 */
@ElideTypeConverter(type = Instant.class, name = "Instant")
public class InstantSerde implements Serde<String, Instant> {
    @Override
    public Instant deserialize(final String value) {
        return Instant.from(
            DateTimeFormatter.ISO_INSTANT.parse(value)
        );
    }

    @Override
    public String serialize(final Instant value) {
        return DateTimeFormatter.ISO_INSTANT.format(value);
    }
}

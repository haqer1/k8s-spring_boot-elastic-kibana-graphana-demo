package com.adazes.k8s.demo.be.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

/**
 * Tip DTO.
 *
 * @param tip           tip of the day
 * @param learnMoreRef  (hyper-)reference to learn more
 *
 * @author  Resat SABIQ
 * @since   1.3.19
 */
public record TipDto(@NotNull String tip, @Nullable String learnMoreRef) {
    /**
     * Convenience constructor (e.g., for default config (defaulting {@link #learnMoreRef} to {@code null}))
     *
     * @param tip   the tip
     * @see TipDto#TipDto(String, String)
     */
    @SuppressWarnings("unused")
    public TipDto(@NotNull String tip) {
        this(tip, null);
    }
}

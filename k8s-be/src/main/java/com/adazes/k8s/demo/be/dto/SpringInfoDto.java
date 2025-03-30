package com.adazes.k8s.demo.be.dto;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

/**
 * Spring info DTO.
 *
 * @param version   Spring version
 * @param profiles  profile(s) active (optional)
 * @param springBootVersion Spring Boot version (optional)
 *
 * @author  Resat SABIQ
 * @since   1.3.19
 */
public record SpringInfoDto(@NotNull String version, String profiles, String springBootVersion) {
    public static final String DEFAULT_PROFILE = "(default)";

    /**
     * Defaults {@link #profiles} to {@link #DEFAULT_PROFILE} if blank.
     */
    public SpringInfoDto {
        if (StringUtils.isBlank(profiles))
            profiles = DEFAULT_PROFILE;
    }
}

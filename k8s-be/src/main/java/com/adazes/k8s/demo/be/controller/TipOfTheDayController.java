package com.adazes.k8s.demo.be.controller;

import com.adazes.k8s.demo.be.dto.TipDto;
import com.adazes.k8s.demo.be.util.MarkerPool;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A prototype of a ReST endpoint providing (tech) tip of the day.
 *
 * @author  Resat SABIQ
 * @since   1.3.19
 */
@RestController
@RequestMapping("tip")
@RefreshScope
@Slf4j
public class TipOfTheDayController {
    private final String tip, learnMoreRef;

    /**
     *
     * @param tip           the tip presently configured (auto-refreshable)
     * @param learnMoreRef  (hyper-)reference to learn more (optional)
     */
    public TipOfTheDayController(@Value("${k8s-demo.be.tip.summary}") @NonNull String tip
    , @Value("${k8s-demo.be.tip.learn-more-ref}") @Nullable String learnMoreRef) {
        this.tip = tip;
        this.learnMoreRef = learnMoreRef;
    }

    /**
     * Default mapping for the tip of the day. Logs an INFO message with {@link MarkerPool#GOOD_TO_KNOW} marker &amp;
     * remote address.
     *
     * @param req   request used to look up the remote address of requester
     *
     * @return  the tip
     */
    @GetMapping("")
    public TipDto getTip(HttpServletRequest req) {
        TipDto tipDto = new TipDto(tip, learnMoreRef);
        log.info(MarkerPool.GOOD_TO_KNOW, "Returning to {}: {}", req.getRemoteAddr(), tipDto);
        return tipDto;
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.ReportingCacheConfig
 *  it.sisal.reporting.wfit.util.QueryParams
 *  org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer
 *  org.springframework.cache.annotation.EnableCaching
 *  org.springframework.cache.concurrent.ConcurrentMapCacheManager
 *  org.springframework.stereotype.Component
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.util.QueryParams;
import java.util.List;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@EnableCaching
@Component
public class ReportingCacheConfig
implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(List.of(QueryParams.CACHE_NAME.getKey()));
    }
}


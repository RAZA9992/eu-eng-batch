/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManagerImpl
 *  it.sisal.reporting.wfit.util.QueryParams
 *  org.springframework.cache.Cache
 *  org.springframework.cache.Cache$ValueWrapper
 *  org.springframework.cache.concurrent.ConcurrentMapCacheManager
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service.cache;

import it.sisal.reporting.wfit.exception.ReportingBatchException;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.service.cache.ReportingCacheManager;
import it.sisal.reporting.wfit.util.QueryParams;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Service;

@Service
public class ReportingCacheManagerImpl
implements ReportingCacheManager {
    private final ConcurrentMapCacheManager cacheManager;
    private static final String KEY = "accountingWeek";

    public ReportingCacheManagerImpl(ConcurrentMapCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void put(AccountingWeek accountingWeek) {
        Cache cache = this.getCache();
        cache.put((Object)KEY, (Object)accountingWeek);
    }

    public AccountingWeek get() {
        Object object;
        Cache cache = this.getCache();
        Cache.ValueWrapper valueWrapper = cache.get((Object)KEY);
        if (null != valueWrapper && null != (object = valueWrapper.get())) {
            return (AccountingWeek)object;
        }
        throw new ReportingBatchException("Cache is empty!!");
    }

    public void delete() {
        Cache cache = this.getCache();
        cache.evictIfPresent((Object)KEY);
    }

    private Cache getCache() {
        Cache cache = this.cacheManager.getCache(QueryParams.CACHE_NAME.getKey());
        if (cache == null) {
            throw new ReportingBatchException("Cache is null!!");
        }
        return cache;
    }
}


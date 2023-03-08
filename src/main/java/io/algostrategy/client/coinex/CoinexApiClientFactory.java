package io.algostrategy.client.coinex;

import io.algostrategy.client.coinex.impl.CoinexApiAsyncRestClientImpl;
import io.algostrategy.client.coinex.impl.CoinexApiRestClientImpl;
import io.algostrategy.client.coinex.impl.CoinexApiService;
import io.algostrategy.client.coinex.impl.CoinexApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Coinex API client objects.
 */
public class CoinexApiClientFactory {

    private final CoinexApiServiceGenerator serviceGenerator;

    public CoinexApiClientFactory() {
        this.serviceGenerator = new CoinexApiServiceGenerator(new OkHttpClient());
    }

    public CoinexApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    public CoinexApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new CoinexApiServiceGenerator(newClient);
    }

    /**
     * New instance without authentication.
     *
     * @return the Coinex API client factory
     */
    public static CoinexApiClientFactory newInstance() {
        return new CoinexApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public CoinexApiRestClient newRestClient() {
        return new CoinexApiRestClientImpl(serviceGenerator.createService(CoinexApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public CoinexApiAsyncRestClient newAsyncRestClient() {
        return new CoinexApiAsyncRestClientImpl(serviceGenerator.createService(CoinexApiService.class));
    }
}

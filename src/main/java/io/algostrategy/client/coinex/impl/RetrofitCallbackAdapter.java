package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiError;
import io.algostrategy.client.coinex.exception.CoinexApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static io.algostrategy.client.coinex.impl.CoinexApiServiceGenerator.getCoinexApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                CoinexApiError apiError = getCoinexApiError(response);
                onFailure(call, new CoinexApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new CoinexApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof CoinexApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new CoinexApiException(t));
        }
    }
}

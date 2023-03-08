package io.algostrategy.client.coinex.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.algostrategy.client.coinex.CoinexApiError;
import io.algostrategy.client.coinex.exception.CoinexApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static io.algostrategy.client.coinex.constant.CoinexApiConstants.API_BASE_URL;

/**
 * Generates a Coinex API implementation based on @see {@link CoinexApiService}.
 */
public class CoinexApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, CoinexApiError> errorBodyConverter =
            (Converter<ResponseBody, CoinexApiError>) converterFactory.responseBodyConverter(
                    CoinexApiError.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public CoinexApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                CoinexApiError apiError = getCoinexApiError(response);
                throw new CoinexApiException(apiError);
            }
        } catch (IOException e) {
            throw new CoinexApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static CoinexApiError getCoinexApiError(Response<?> response) throws IOException, CoinexApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}

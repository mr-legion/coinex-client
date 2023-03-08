package io.algostrategy.client.coinex.exception;

import io.algostrategy.client.coinex.CoinexApiError;

/**
 * An exception which can occur while invoking methods of the Coinex API.
 */
public class CoinexApiException extends RuntimeException {

    private static final long serialVersionUID = 1781767934858486669L;

    private CoinexApiError error;

    public CoinexApiException(CoinexApiError error) {
        this.error = error;
    }

    public CoinexApiException() {
        super();
    }

    public CoinexApiException(String message) {
        super(message);
    }

    public CoinexApiException(Throwable cause) {
        super(cause);
    }

    public CoinexApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Coinex API.
     */
    public CoinexApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}

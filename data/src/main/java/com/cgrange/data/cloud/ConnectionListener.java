package com.cgrange.data.cloud;

/**
 * Created by Cristian on 22/07/2017.
 *
 * INTERFACE TO LISTEN TO "CALL" (NOT OBSERVABLES) CONNECTIONS' RESPONSES AND ERRORS
 */

public interface ConnectionListener<T> {
    void onResponse(T response);
    void onError(Throwable t);
}

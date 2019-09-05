package com.haoyue.api.service;

public interface Listener {
    void onSuccess(Object... args);

    void onFailure(Throwable cause);
}
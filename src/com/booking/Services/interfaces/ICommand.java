package com.booking.Services.interfaces;

public interface ICommand<T> {
    T execute();
}
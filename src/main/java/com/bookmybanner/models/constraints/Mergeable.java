package com.bookmybanner.models.constraints;

/**
 * Makes the object mergeable
 * Created by parthaprotimkonwar on 08/04/17.
 */
public interface Mergeable<T> {

    T merge(T other);
}

package calisthenics.interfaces;

import java.util.Collection;

public interface Reduction<A,T> {
    Listing<A> reduce(Collection<A> data, T element);
}

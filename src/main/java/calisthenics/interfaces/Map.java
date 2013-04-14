package calisthenics.interfaces;

import java.util.Collection;

public interface Map<A,B> {
    public Listing<B> map(Collection<A> data);
}

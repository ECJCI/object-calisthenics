package calisthenics.interfaces;

import java.util.Collection;

public interface Query<A> {
    Listing<A> query(Collection<A> data, Object element);
}

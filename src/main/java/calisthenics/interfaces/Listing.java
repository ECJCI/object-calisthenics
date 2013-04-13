package calisthenics.interfaces;

public interface Listing<T> {
    public boolean isListed(T element);
    public void add(T element);
    public boolean contains(T element);
    public Listing<T> query (Query<T> query, Object element);
}

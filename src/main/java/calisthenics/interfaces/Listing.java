package calisthenics.interfaces;

public interface Listing<T> {
    public boolean isListed(T element);
    public void add(T element);
    public boolean contains(T element);
    public <A> Listing<T> reduce(Reduction<T,A> reduction, A element);
    public <A> Listing<A> map(Map<T,A> map, Listing<T> data);
}

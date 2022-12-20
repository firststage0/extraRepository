package sample;

public interface Repository<T> {

    T find(Long id);
}

package service;

import java.util.ArrayList;
import java.util.UUID;

public interface BaseService<T>{
    T add (T t);
    boolean delete(T t);
    ArrayList<T> list(UUID id);
    ArrayList<T> list();

}

package com.sopra.aulas.dao;

import java.util.Collection;

public interface IDao<T> extends IGenericDao<T> {
	Collection<T> search(T elemento);
}

package com.sopra.aulas.dao;

import java.util.Collection;

public interface IGenericDao<T> {

	void insert(T elemento);

	T update(T elemento);

	void delete(T elemento);

	Collection<T> list();

}
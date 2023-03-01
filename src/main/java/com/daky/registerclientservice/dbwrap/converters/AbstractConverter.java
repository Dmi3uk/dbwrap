package com.daky.registerclientservice.dbwrap.converters;

public interface AbstractConverter<D, E> {
    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param entity
     * @return populatedData
     */
    D populateData(final E entity);

    /**
     * Method to map the front end customer object to the JPA customer entity.
     * @param data
     * @return populatedEntity
     */
    E populateEntity(D data);

}

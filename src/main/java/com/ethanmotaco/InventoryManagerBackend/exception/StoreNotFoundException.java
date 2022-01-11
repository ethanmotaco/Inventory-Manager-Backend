package com.ethanmotaco.InventoryManagerBackend.exception;

/**
 * @author Ethan Motaco
 *
 */
public class StoreNotFoundException extends RuntimeException{

	public StoreNotFoundException(String message) {
		super(message);
	}
}

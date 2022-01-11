/**
 * 
 */
package com.ethanmotaco.InventoryManagerBackend.exception;

/**
 * @author Ethan Motaco
 *
 */
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(String message) {
		super(message);
	}
}

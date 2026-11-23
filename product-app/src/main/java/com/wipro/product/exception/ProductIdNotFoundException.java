package com.wipro.product.exception;

public class ProductIdNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id;

    public ProductIdNotFoundException(int id) {
        // TODO Auto-generated constructor stub
        super("Product id not found for id : " + id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id " + id + " not found";
    }
}

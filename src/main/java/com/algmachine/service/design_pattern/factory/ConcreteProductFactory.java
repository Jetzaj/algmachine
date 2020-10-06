package com.algmachine.service.design_pattern.factory;

public class ConcreteProductFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}

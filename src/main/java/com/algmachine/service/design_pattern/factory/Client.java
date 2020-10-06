package com.algmachine.service.design_pattern.factory;

public class Client {
    private ProductFactory factory;

    public Client(ProductFactory factory) {
        this.factory = factory;
    }

    public void doSomething(){
        Product product = factory.createProduct();
        // TODO do something

    }

    public static void main(String[] args) {
        Client client = new Client(new ConcreteProductFactory());
        client.doSomething();
    }
}

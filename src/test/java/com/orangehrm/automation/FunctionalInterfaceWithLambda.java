package com.orangehrm.automation;

public class FunctionalInterfaceWithLambda {

    public static void main(String[]args)
    {
        Suzuki suzuki=new Suzuki() {

            public void engine() {
                System.out.println("800 cc engine of swift car");
            }


        };
            suzuki.engine();

            Suzuki suzuki1=()->{
                System.out.println("800 cc engine of swift car");
            };
            suzuki1.engine();

    }

}

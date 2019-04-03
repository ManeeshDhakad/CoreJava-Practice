package com.java.oops;

/* 
 https://www.geeksforgeeks.org/association-composition-aggregation-java/

In Aggregation, both the entries can survive individually which means ending one entity 
will not effect the other entity
Student-Department

In composition, both the entities are dependent on each other.
When there is a composition between two entities, the composed object cannot exist without the other entity.
Car-Engine

private final Engine engine; // Composition 
private Engine engine;     // Aggregation 
*/


public class CompositionAndAggregration {
	public static void main (String[] args)  { 
          
        // making an engine by creating  
        // an instance of Engine class. 
        Engine engine = new Engine(); 
          
        // Making a car with engine. 
        // so we are passing a engine  
        // instance as an argument while 
        // creating instace of Car. 
        Car car = new Car(engine); 
        car.move(); 
          
    } 
}

class Engine  
{ 
    // starting an engine. 
    public void work() 
    { 
          
        System.out.println("Engine of car has been started "); 
          
    } 
      
} 
  
final class Car  
{ 
      
    // For a car to move,  
    // it need to have a engine. 
    private final Engine engine; // Composition 
    //private Engine engine;     // Aggregation 
      
    Car(Engine engine) 
    { 
        this.engine = engine; 
    } 
      
    // car start moving by starting engine 
    public void move()  
    { 
          
        //if(engine != null) 
        { 
            engine.work(); 
            System.out.println("Car is moving "); 
        } 
    } 
} 

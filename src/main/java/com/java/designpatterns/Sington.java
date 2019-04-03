package com.java.designpatterns;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
Project usage : Loggers, Properties reading from resources
 */
class Singleton {

	private volatile static Singleton _instance;

	private Singleton() {
		// preventing Singleton object instantiation from outside
	}

	/*
	 * 1st version: creates multiple instance if two thread access
	 * this method simultaneously
	 */

	public static Singleton getInstance() {
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}

	/*
	 * 2nd version : this definitely thread-safe and only
	 * creates one instance of Singleton on concurrent environment
	 * but unnecessarily expensive due to cost of synchronization
	 * at every call.
	 */

	public static synchronized Singleton getInstanceTS() {
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}

	/*
	 * 3rd version : An implementation of double checked locking of Singleton.
	 * Intention is to minimize cost of synchronization and  improve performance,
	 * by only locking critical section of code, the code which creates
 instance of Singleton class.
	 * By the way this is still broken, if we don't make _instance volatile,
 as another thread can
	 * see a half initialized instance of Singleton.
	 */

	public static Singleton getInstanceDC() {
		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null) {
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
}


// Enum Singleton is best when using serialization and thrad safety
enum EnumSingleton {

    INSTANCE;
    
    public static void doSomething(){
        //do something
    }
}


// Serialize singleton
class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}
    
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
    
    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }
    
    protected Object readResolve() {
        return SingletonHelper.instance;
    }
}



/*
How to break singleton 
======================
It can break if the class is Serializable
It can break if its 'Clonable`
You can break by Reflection (I believe)
it can break ff multiple classloaders are loaded the class

How do you solve rule breakers?
===============================
It is much safer to do eager initialization
To prevent deserializing to create new object you may override readResolve() method in your class and throw exception
To prevent cloning, you may overrride clone() and throw CloneNotSupported exception
To escape for reflective instantion, we can add check in the constructor and throw exception.
 */
class SingletonBreakingSolution {

	// Multiple class loader problem solution
    private static final SingletonBreakingSolution INSTANCE = new SingletonBreakingSolution();

    // Resolve reflection issue
    private SingletonBreakingSolution() {
        // Check if we already have an instance
        if (INSTANCE != null) {
           throw new IllegalStateException("Singleton" +
             " instance already created.");
        }
    }
    
    public static final SingletonBreakingSolution getInstance() {
        return INSTANCE;
    }
    
    // Resolve Serialization issue
    private Object readResolve() throws ObjectStreamException         {
            return INSTANCE;
    }
    
    // Resolve Multiple class loader issue
    private Object writeReplace() throws ObjectStreamException {
            return INSTANCE;
    }
    
    // Resolve Object cloning issue
    public Object clone() throws CloneNotSupportedException {
        // return INSTANCE
        throw new CloneNotSupportedException();
    }
}
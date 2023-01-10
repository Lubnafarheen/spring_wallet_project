package org.lubna.dao.sequencer;

public class CustomerIdSequencer {

    private static long sequencer = 0;

    public static long nextId(){
        return ++sequencer;
    }
}

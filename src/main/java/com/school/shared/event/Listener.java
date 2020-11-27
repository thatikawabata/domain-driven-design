package com.school.shared.event;

public abstract class Listener {

    public void process(Event event){
        if(this.shouldProcess(event)){
            this.reactTo(event);
        }
    }

    protected abstract void reactTo(Event event);
    protected abstract boolean shouldProcess(Event event);
}

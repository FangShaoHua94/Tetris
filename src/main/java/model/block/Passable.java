package model.block;

public interface Passable {

    default boolean passable(){
        return true;
    }
}

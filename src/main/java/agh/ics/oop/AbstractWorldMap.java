package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected List<Animal> animalsList = new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    protected Map<Vector2d, Grass> grasses = new HashMap<Vector2d, Grass>();

    protected final MapVisualizer visualize = new MapVisualizer(this);


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!animals.containsKey(position));
    }
    @Override
    public String toString() {
        Set<Vector2d> animals_set = this.animals.keySet();
        Set<Vector2d> grasses_set = this.grasses.keySet();
        Vector2d vectorR = new Vector2d(0,0);
        Vector2d vectorL = new Vector2d(0,0);
        for (Vector2d vector : animals_set) {
            vectorR = vectorR.upperRight(vector);
            vectorL = vectorL.lowerLeft(vector);
        }
        for (Vector2d vector : grasses_set) {
            vectorR = vectorR.upperRight(vector);
            vectorL = vectorL.lowerLeft(vector);
        }
        return this.visualize.draw(vectorL,vectorR);
    }
    public Vector2d getLowerLeftDrawLimit(){
        Set<Vector2d> animals_set = this.animals.keySet();
        Set<Vector2d> grasses_set = this.grasses.keySet();
        Vector2d vectorL = new Vector2d(0,0);
        for (Vector2d vector : animals_set) {
            vectorL = vectorL.lowerLeft(vector);
        }
        for (Vector2d vector : grasses_set) {
            vectorL = vectorL.lowerLeft(vector);
        }
        return vectorL;
    }
    public Vector2d getUpperRightDrawLimit(){
        Set<Vector2d> animals_set = this.animals.keySet();
        Set<Vector2d> grasses_set = this.grasses.keySet();
        Vector2d vectorR = new Vector2d(0,0);
        for (Vector2d vector : animals_set) {
            vectorR = vectorR.upperRight(vector);
        }
        for (Vector2d vector : grasses_set) {
            vectorR = vectorR.upperRight(vector);
        }
        return vectorR;
    }
    @Override
    public boolean place(Animal animal) {
        if(this.animals.get(animal.getPosition()) != null){
//            return false;
            throw new IllegalArgumentException(animal.getPosition()+ " is already occupied");
        }
        this.animalsList.add(animal);
        this.animals.put(animal.getPosition(),animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.get(position) != null || this.grasses.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.animals.get(position) != null){
            return this.animals.get(position);
        }
        if(this.grasses.get(position) != null){
            return this.grasses.get(position);
        }
        return null;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            Animal a = animals.remove(oldPosition);
            animals.put(newPosition, a);
        }
    }
    public List<Animal> getAnimals(){
        return this.animalsList;
    }
}

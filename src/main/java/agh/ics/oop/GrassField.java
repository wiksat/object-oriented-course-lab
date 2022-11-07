package agh.ics.oop;
import java.lang.Math;
public class GrassField extends AbstractWorldMap {
    private final int maxX;
    private final int maxY;

    public GrassField(int grass){
        this.maxX = (int)Math.sqrt(grass*10);
        this.maxY = (int)Math.sqrt(grass*10);
        for (int i = 0; i < grass; i++){
            int randx = (int)(Math.random()*(this.maxX +1));
            int randy = (int)(Math.random()*(this.maxY +1));
            Grass grasss = new Grass(new Vector2d(randx,randy));
            this.grasses.add(grasss);
            this.mapElements.add(grasss);
        }
    }
    @Override
    public String toString() {
        Vector2d vectorR = new Vector2d(0,0);
        Vector2d vectorL = new Vector2d(0,0);
        for (IMapElement element : this.mapElements) {
            vectorR = vectorR.upperRight(element.getPosition());
            vectorL = vectorL.lowerLeft(element.getPosition());
        }
        return this.visualize.draw(vectorL,vectorR);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }
}

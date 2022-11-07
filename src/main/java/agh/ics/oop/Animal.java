package agh.ics.oop;

public class Animal extends AbstractWorldMapElement  {

    private MapDirection direction=MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    Animal(IWorldMap map){
        this.map=map;
    }
    Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;
    }
    public Vector2d getPosition() {
        return this.position;
    }
    public String getA(){
        return position+" "+direction;
    }
    public String toString(){
        return switch(direction) {
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }
    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }
    public void move(MoveDirection direction){
        if(direction==MoveDirection.RIGHT){
            this.direction=this.direction.next();
        } else if (direction==MoveDirection.LEFT) {
            this.direction=this.direction.previous();
        }
        else if (direction==MoveDirection.FORWARD) {
            Vector2d temp=this.direction.toUnitVector();
            Vector2d beforeTest=this.position.add(temp);
//            if (beforeTest.x<=4 && beforeTest.y<=4 && beforeTest.x>=0 && beforeTest.y>=0){
//                this.position=beforeTest;
//            }
            if (map.canMoveTo(beforeTest)) {
                this.position=beforeTest;
            }
        }
        else if (direction==MoveDirection.BACKWARD) {
            Vector2d temp=this.direction.toUnitVector();
            Vector2d beforeTest=this.position.subtract(temp);
//            if (beforeTest.x<=4 && beforeTest.y<=4 && beforeTest.x>=0 && beforeTest.y>=0){
//                this.position=beforeTest;
//            }
            if (map.canMoveTo(beforeTest)) {
                this.position=beforeTest;
            }
        }
    }
}

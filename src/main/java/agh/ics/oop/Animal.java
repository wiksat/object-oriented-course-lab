package agh.ics.oop;

public class Animal {
    private MapDirection direction=MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return position.toString()+" "+direction.toString();
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
//            this.position=this.position.add(temp);
            Vector2d beforeTest=this.position.add(temp);
            if (beforeTest.x<=4 && beforeTest.y<=4 && beforeTest.x>=0 && beforeTest.y>=0){
                this.position=beforeTest;
            }

        }
        else if (direction==MoveDirection.BACKWARD) {
            Vector2d temp=this.direction.toUnitVector();
//            this.position=this.position.subtract(temp);

            Vector2d beforeTest=this.position.subtract(temp);
            if (beforeTest.x<=4 && beforeTest.y<=4 && beforeTest.x>=0 && beforeTest.y>=0){
                this.position=beforeTest;
            }
        }
    }
}

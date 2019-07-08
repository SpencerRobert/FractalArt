import java.util.*;
import java.io.*;

public class CurrentPointInfo {
private double x;
private double y;
private double drawingDirection;
private double drawingLength;

public CurrentPointInfo(double x,double y,double drawingDirection,double drawingLength) {
this.x=x;
this.y=y;
this.drawingDirection=drawingDirection;
this.drawingLength=drawingLength;
}

public double getX() {
return this.x;
}

public double getY() {
return this.y;
}

public void setX(double x) {
this.x=x;
}

public void setY(double y) {
this.y=y;
}

public double getCurrentDrawingDirection() {
return this.drawingDirection;
}

public void setCurrentDrawingDirection(double drawingDirection) {
this.drawingDirection=drawingDirection;
}

public double getCurrentLength() {
return this.drawingLength;
}

public void setCurrentLength(double drawingLength) {
this.drawingLength=drawingLength;
}

}

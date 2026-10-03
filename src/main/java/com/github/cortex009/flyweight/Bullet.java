package com.github.cortex009.flyweight;

public class Bullet {
    private double directionX;
    private double directionY;
    private double directionZ;

    private double speed;

    private double currentX;
    private double currentY;
    private double currentZ;

    private double targetX;
    private double targetY;
    private double targetZ;
    private final BulletType type;

    public Bullet(BulletType newType,
                  double directionX, double directionY, double directionZ,
                  double speed,
                  double currentX, double currentY, double currentZ,
                  double targetX, double targetY, double targetZ){
        this.type = newType;
        this.directionX = directionX;
        this.directionY = directionY;
        this.directionZ = directionZ;
        this.speed = speed;
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentZ = currentZ;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
    }

    //    MOVEMENT
    public void move(double deltaX,double deltaY,double deltaZ){
        this.currentX+=deltaX;
        this.currentY+=deltaY;
        this.currentZ+=deltaZ;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public double getCurrentZ() {
        return currentZ;
    }

    public BulletType getType() {
        return type;
    }
    @Override
    public String toString(){
        return "Bullet { "+
                " type = "+type.getColor()+
                ", speed = "+speed+
                ", pos = ("+currentX+", "+currentY+", "+currentZ+")"+
                ", target = ("+targetX+", "+targetY+", "+targetX+")"+'}';
    }
}

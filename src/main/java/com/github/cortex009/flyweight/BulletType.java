package com.github.cortex009.flyweight;

public class BulletType {
    private final String color;
    private final double weight;
    private final double radius;
    private final int maxDamage;
    private final int maxRange;
    private final byte[] image;

    public BulletType(String newColor, double newWeight,double newRadius,
                      int newMaxDamage, int newMaxRange, byte[] newImage){
        this.color = newColor;
        this.weight = newWeight;
        this.radius = newRadius;
        this.maxDamage = newMaxDamage;
        this.maxRange = newMaxRange;
        this.image = newImage;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public byte[] getImage() {
        return image;
    }
    @Override
    public String toString(){
        return "Bullet Type {"+ "color ='" +color +'\''
                + ", weight = " +weight+
                ", radius = "+radius+
                ", max-damage = "+ maxDamage+
                ", max-range = "+ maxRange+
                ", image - size = "+(image!=null ? image.length:0)
                +" bytes "+'}';
    }
}

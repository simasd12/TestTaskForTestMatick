import java.util.ArrayList;

import static java.lang.Math.sqrt;

class Square{
    private String name;
    double side;
    private String color;
    Square(String n, double s, String c){
        this.name = n;
        this.side =s;
        this.color =c;
    }
    String getName(){
        return name;
    }
    Double getArea(){
         return side * side;
    }
    String getColor(){
        return color;
    }

    void Output(){
        System.out.println( "Фигура: " + getName()+ ", площадь: " + getArea() + " кв. ед." + ", цвет: "+ getColor()+ ", длина диагонали: " + UniqueMethod() + " ед.");
    }
    String UniqueMethod(){
        return String.format("%.2f", side * sqrt(2)); // Формула диагонали квадрата
    }
}

class Triangle extends Square{
    double height;
    Triangle(String n, double s, String c, double h) {
        super( n, s, c );
        this.height = h;
    }

    void Output(){
        System.out.println( "Фигура: " + getName()+ ", площадь: " + getArea() + " кв. ед." + ", цвет: "+ getColor()+ ", длина гипотенузы: " + UniqueMethod() + " ед.");
    }
    String UniqueMethod(){
        return String.format("%.2f", sqrt(side*height)); // Формула гипотенузы, где h - высота и вторая сторона
    }
    Double getArea(){
        return side * height * 0.5;
    }
}

class Circle extends Square{
    Circle(String n, double s, String c) {
        super( n, s, c );
    }

    void Output(){
        System.out.println( "Фигура: " + getName()+ ", площадь: " + getAreaC() + " кв. ед." + ", цвет: "+ getColor()+ ", радиус: " + UniqueMethod() + " ед.");
    }
    String UniqueMethod(){
        return String.format("%.2f", side / 2); // Формула радиуса
    }
    private String getAreaC(){
        return String.format("%.2f", (3.14 * side) / 2);
    }
}

class Trapezoid extends Triangle{
    private double sideSecond;
    Trapezoid(String n, double s, String c, double h, double s2) {
        super( n, s, c, h );
        this.sideSecond = s2;
    }

    void Output(){
        System.out.println( "Фигура: " + getName()+ ", площадь: " + getArea() + " кв. ед." + ", цвет: "+ getColor()+ ", средняя линия: " + UniqueMethodTP() + " ед.");
    }
    private Double UniqueMethodTP(){
        return (sideSecond+side)/2; // Формула средней линии трапеции
    }
    Double getArea(){
        return UniqueMethodTP() * height;
    }
}

public class Main{


    public static void main(String[] args) {

        ArrayList <Square> squares = new ArrayList<>();
        ArrayList <Triangle> triangles = new ArrayList<>();
        ArrayList <Circle> circles = new ArrayList<>();
        ArrayList <Trapezoid> trapezoids = new ArrayList<>();

        int rnd = 3 + (int) (Math.random() * 15);
        int couter=0;

        String[] Colors = {"черный", "синий", "красный", "оранжевый", "фиолетовый"};

        for ( int i =0; i< rnd; i++){
            squares.add( new Square( "квадрат", i+rnd,  Colors[couter]) );
            triangles.add( new Triangle( "треугольник", 2*i + rnd, Colors[couter], 2*i + rnd + 3));
            circles.add( new Circle( "круг", 3*i + rnd, Colors[couter]));
            trapezoids.add(new Trapezoid( "трапеция", 4*i + rnd, Colors[couter], 4*i + rnd + 2, 3*i + rnd + 3));
            couter++;
            if(couter>4){
                couter=0;
            }
        }

        for(Square s: squares){
            s.Output();
        }
        System.out.println( "---------------------------" );
        for(Triangle t: triangles){
            t.Output();
        }
        System.out.println( "---------------------------" );
        for(Circle c: circles){
            c.Output();
        }
        System.out.println( "---------------------------" );
        for(Trapezoid tp: trapezoids){
            tp.Output();
        }

    }
}

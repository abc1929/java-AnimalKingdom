public abstract class Animal {
    public String name;
    public int yearNamed;
    public int ID;

    public void eat(){
        System.out.println("food");
    }
    public abstract String move();
    public abstract String reproduce();
    public abstract String breathe();

    public Animal(String name, int yearNamed) {

        this.name = name;
        this.yearNamed = yearNamed;
    }
}


class Mammal extends Animal {

    public Mammal(String name, int yearNamed) {
        super(name, yearNamed);
    }



    @Override
    public String move() {
        return "walk";
    }

    @Override
    public String reproduce() {
        return "live births";
    }

    @Override
    public String breathe() {
        return "lungs";
    }
}





class Bird extends Animal {

    public Bird(String name, int yearNamed) {
        super(name, yearNamed);
    }



    @Override
    public String move() {
        return "fly";
    }

    @Override
    public String reproduce() {
        return "eggs";
    }

    @Override
    public String breathe() {
        return "lungs";
    }
}



class Fish extends Animal {

    public Fish(String name, int yearNamed) {
        super(name, yearNamed);
    }



    @Override
    public String move() {
        return "swim";
    }

    @Override
    public String reproduce() {
        return "eggs";
    }

    @Override
    public String breathe() {
        return "gills";
    }
}

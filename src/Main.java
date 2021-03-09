import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    // List all the animals in descending order by year named
    // List all the animals alphabetically
    // List all the animals order by how they move
    // List only those animals the breath with lungs
    // List only those animals that breath with lungs and were named in 1758
    // List only those animals that lay eggs and breath with lungs
    // List alphabetically only those animals that were named in 1758

    // For the list of animals, list alphabetically those animals that are mammals.
    
    
    static void printArrayList(List<Animal> animals){
        System.out.print("[");
        for (int i = 0; i < animals.toArray().length; i++) {
            if(i==0){
                System.out.println("Animals{"+"id="+animals.get(i).ID+", name='"+animals.get(i).name+"', yearNamed="+animals.get(i).yearNamed+"}");
                continue;
            }
            System.out.println(", Animals{"+"id="+animals.get(i).ID+", name='"+animals.get(i).name+"', yearNamed="+animals.get(i).yearNamed+"}");

        }

        
        System.out.println("]");
    }


    static void printAllInfoForList(List<Animal> animals){

        for (var i:animals
             ) {
            System.out.println(i.name+" "+i.reproduce()+ " "+i.move()+" "+i.breathe()+" "+i.yearNamed);
        }

    }


    public static void main(String[] args) {

        String[] MammalsNames = {"Panda","Zebra","Koala","Sloth","Armadillo","Raccoon","Bigfoot"};
        int[] MammalsYearsNamed =  {1869,1778,1816,1804,1758,1758,2021};
        String[] BirdsNames = {"Pigeon","Peacock","Toucan","Parrot","Swan"};
        int[] BirdsYearsNamed =  {1837,1821,1758,1824,1758};
        String[] FishNames = {"Salmon","Catfish","Perch"};
        int[] FishYearsNamed =  {1758,1817,1758};


        List<Animal> animals = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < MammalsNames.length; i++) {
             Mammal temp = new Mammal(MammalsNames[i],MammalsYearsNamed[i]);
             temp.ID=count;
             count++;
            animals.add(temp);
        }
        for (int i = 0; i < BirdsNames.length; i++) {
             Bird temp = new Bird(BirdsNames[i],BirdsYearsNamed[i]);
             temp.ID=count;
             count++;
            animals.add(temp);
        }
        for (int i = 0; i < FishNames.length; i++) {
             Fish temp = new Fish(FishNames[i],FishYearsNamed[i]);
             temp.ID=count;
             count++;
            animals.add(temp);
        }


        System.out.println("*** List all the animals in descending order by year named ***");
        animals.sort((a,b) -> b.yearNamed-a.yearNamed);
        printArrayList(animals);
        System.out.println("\n");

        System.out.println("*** List all the animals alphabetically ***");
        animals.sort(Comparator.comparing(a -> a.name));
        printArrayList(animals);
        System.out.println("\n");

        System.out.println("*** List all the animals order by how they move ***");
        animals.sort(Comparator.comparing(a -> a.move()));
        printArrayList(animals);
        System.out.println("\n");

        System.out.println("*** List only those animals the breath with lungs ***");
        var temp = animals.stream().filter(i -> (i.breathe()=="lungs")).collect(Collectors.toList());
        printAllInfoForList(temp);
        System.out.println("\n");


        System.out.println("*** List only those animals that breath with lungs and were named in 1758 ***");
        temp = animals.stream().filter(i -> (i.breathe()=="lungs" && i.yearNamed==1758)).collect(Collectors.toList());
        printAllInfoForList(temp);
        System.out.println("\n");


        System.out.println("*** List only those animals that lay eggs and breath with lungs ***");
        temp = animals.stream().filter(i -> (i.reproduce().equals("eggs") && i.breathe().equals("lungs"))).collect(Collectors.toList());
        printAllInfoForList(temp);
        System.out.println("\n");


        System.out.println("*** List alphabetically only those animals that were named in 1758 ***");
        var temp2 =  animals.stream().filter(i -> (i.yearNamed==1758)).collect(Collectors.toList());
        temp2.sort((a,b) -> a.name.compareTo(b.name));
        printAllInfoForList(temp2);
        System.out.println("\n");

        System.out.println("*** For the list of animals, list alphabetically those animals that are mammals ***");
        var temp3 =  animals.stream().filter(i -> (i instanceof Mammal)).collect(Collectors.toList());
        temp3.sort((a,b) -> a.name.compareTo(b.name));
        printAllInfoForList(temp3);
        System.out.println("\n");

    }
}

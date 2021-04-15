import java.util.*;

public class Navi {
    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("Bratislava", List.of("Trencin", "Lucenec"));
        map.put("Trencin", List.of("Bratislava", "Lucenec", "Liptovsky Mikulas"));
        map.put("Lucenec", List.of("Bratislava", "Trencin", "Liptovsky Mikulas", "Kosice"));
        map.put("Liptovsky Mikulas", List.of("Trencin", "Lucenec", "Poprad"));
        map.put("Poprad", List.of("Presov", "Liptovsky Mikulas"));
        map.put("Presov", List.of("Poprad", "Rimavska Sobota"));
        map.put("Rimavska Sobota", List.of("Presov", "Kosice"));
        map.put("Kosice", List.of("Rimavska Sobota", "Lucenec"));

        HashMap<String, Integer> visited = new HashMap<>();
        String start = "Trencin";
        String finish = "Rimavska Sobota";
        ArrayList<String> toVisit = new ArrayList<>();
        toVisit.add(start);
        int wave = 0;
        while (!toVisit.isEmpty()) { //pokial nieje zoznam prazdny
            System.out.println("Vlna: " + wave);
            ArrayList<String> newToVisit = new ArrayList<>(); //pridavame mesta, do kt.sa vieme dostat zo "city"
            System.out.println("Ideme prechadzat: " + toVisit);
            for (String city : toVisit) {
                System.out.println("Prave prechadzame: " + city);
                visited.put(city, wave);     //pridame navstivene mesto
                if (city.equals(finish)) {
                    toVisit.clear(); //vynuluje zoznam miest,kt chceme prejst - skonci while
                    break;
                }
                for (String newCity : map.get(city)) { //prehladava zoznamy naviazane ku kazdemu mestu
                    System.out.println("Mozeme sa dostat do: " + newCity);
                    if (!visited.containsKey(newCity) && !toVisit.contains(newCity)) {
                        newToVisit.add(newCity);
                        System.out.println("Pridane");
                    } else System.out.println("Nepridane");
                }
            }
            toVisit = newToVisit;
            System.out.println("Budeme prechadzat: " + toVisit);
            wave++;
        }
        System.out.println("Ste v cieli :)");
        System.out.println(visited);
        ArrayList<String> path = new ArrayList<>();
        String city = finish;
        wave--;
        while (wave > 0) {
            path.add(city);
            for (String newCity : map.get(city)) {
                if (visited.containsKey(newCity) && visited.get(newCity) == wave - 1) {
                    city = newCity;
                    break;
                }
            }
            wave--;
        }
        path.add(start);
        Collections.reverse(path); //otocime prvky v Arrayliste
        System.out.println(path);
    }
}


import java.util.HashMap;
import java.util.List;

public class Test {
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

        String start = "Trencin";
        String finish = "Rimavska Sobota";
        System.out.println(Navi.findPath(map,start,finish));
    }
}

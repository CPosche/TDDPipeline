import java.util.ArrayList;
import java.util.List;

public class Greetings {

    public String greet(Object name) {
        if (name instanceof String) {
            if (((String) name).toUpperCase().equals(name)) {
                return "HELLO " + name + "!";
            } else {
                return "Hello " + name;
            }
        } else if (name instanceof String[]) {
            ArrayList<String> names = new ArrayList<>(List.of(((String[]) name)));
            ArrayList<String> shoutNames = new ArrayList<>();
            ArrayList<String> seperated = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).toUpperCase().equals(names.get(i))) {
                    shoutNames.add(names.get(i));
                    names.remove(names.get(i));
                    i--;
                } else if (names.get(i).contains(",")) {
                    if (names.get(i).contains("\"")) {
                        StringBuilder sb = new StringBuilder(names.get(i));
                        sb.deleteCharAt(names.get(i).length() - 1);
                        sb.deleteCharAt(0);
                        names.set(i, sb.toString());
                    } else {
                        seperated.addAll(List.of(names.get(i).split(", ")));
                        names.remove(names.get(i));
                        i--;

                    }
                }
            }
            names.addAll(seperated);
            StringBuilder sb = new StringBuilder();
            sb.append("Hello ");
            for (int i = 0; i < names.size(); i++) {
                if (names.size() > 2) {
                    if (i != names.size() - 1) {
                        if (i == names.size() - 2) {
                            sb.append(names.get(i));
                            sb.append(" and ");
                        } else {
                            sb.append(names.get(i));
                            sb.append(", ");
                        }
                    } else {
                        sb.append(names.get(i));
                    }
                } else {
                    if (i != names.size() - 1) {
                        sb.append(names.get(i));
                        sb.append(" and ");
                    } else {
                        sb.append(names.get(i));
                    }
                }
            }
            for (String s : shoutNames) {
                sb.append(". AND HELLO ").append(s).append("!");
            }
            return sb.toString();
        } else {
            return "Hello my friend.";
        }
    }
}

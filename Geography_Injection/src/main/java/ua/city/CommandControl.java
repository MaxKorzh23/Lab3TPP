package ua.city;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandControl {
    private ContinentExp continentExp = new ContinentExp();
    private GeographyRegionExp geographyRegionExp = new GeographyRegionExp();
    private StateExp stateExp = new StateExp();

    public void executeCommand(String command) {
        if (command.startsWith("insert continent")) {
            // Команда для добавления нового континента
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String name = matcher.group(1);
                continentExp.insertContinent(name);
                System.out.println("Inserted continent successfully.");
            } else {
                System.out.println("Invalid insert continent command format.");
            }
        } else if (command.startsWith("update continent")) {
            // Команда для обновления названия континента
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                continentExp.updateContinent(id, newName);
                System.out.println("Updated continent successfully.");
            } else {
                System.out.println("Invalid update continent command format.");
            }
        } else if (command.startsWith("delete continent")) {
            // Команда для удаления континента
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                continentExp.deleteContinent(id);
                System.out.println("Deleted continent successfully.");
            } else {
                System.out.println("Invalid delete continent command format.");
            }
        } else if (command.startsWith("read continent")) {
            // Команда для читання всіх континентів
            continentExp.getAllContinents();

        } else if (command.startsWith("insert region")) {
            // Команда для додавання нового регіону
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String name = matcher.group(1);
                geographyRegionExp.insertGeographyRegion(name);
                System.out.println("Inserted geography region successfully.");
            } else {
                System.out.println("Invalid insert region command format.");
            }
        } else if (command.startsWith("update region")) {
            // Команда для оновлення назви регіону
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                geographyRegionExp.updateGeographyRegion(id, newName);
                System.out.println("Updated geography region successfully.");
            } else {
                System.out.println("Invalid update region command format.");
            }
        } else if (command.startsWith("delete region")) {
            // Команда для видалення регіону
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                geographyRegionExp.deleteGeographyRegion(id);
                System.out.println("Deleted geography region successfully.");
            } else {
                System.out.println("Invalid delete region command format.");
            }
        } else if (command.startsWith("read region")) {
            // Команда для читання всіх регіонів
            geographyRegionExp.getAllGeographyRegions();

       } else if (command.startsWith("insert state")) {
            // Команда для додавання держави
            Pattern pattern = Pattern.compile("name='(.+?)', area='(\\d{2}:\\d{2}:\\d{2})'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String name = matcher.group(1);
                 String area = matcher.group(2);
                stateExp.insertState(name, area);
                System.out.println("Inserted state successfully.");
            } else {
                System.out.println("Invalid insert state command format.");
            }
        } else if (command.startsWith("update state")) {
            // Команда для оновлення назви або площі держави
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'(?:, area='(\\d{2}:\\d{2}:\\d{2})')?");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                String newArea = matcher.group(3); // Может быть null
                if (newArea != null) {
                    stateExp.updateState(id, newName, newArea);
                } else {
                    stateExp.updateStateName(id, newName);
                }
                System.out.println("Updated state successfully.");
            } else {
                System.out.println("Invalid update state command format.");
            }
        } else if (command.startsWith("delete state")) {
            // Команда для видалення держави
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                stateExp.deleteState(id);
                System.out.println("Deleted state successfully.");
            } else {
                System.out.println("Invalid delete state command format.");
            }
        } else if (command.startsWith("read state")) {
            // Команда для читання всіх держав
            stateExp.getAllStates();

        } else {
            System.out.println("Unknown command. Please try again.");
        }
    }
}

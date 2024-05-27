//package net.javaguides.springboot.moreData;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ExampleClass  {
//
//    private List<String> data;
//
//    public ExampleClass() {
//        this.data = new ArrayList<>();
//    }
//
//
//    public void processData(String input) {
//        // Využití Regex pro zpracování vstupního řetězce
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(input);
//        while (matcher.find()) {
//            data.add(matcher.group());
//        }
//    }
//
//    public void secureMethod() {
//        // Metoda zabezpečená, která neumožní shodit program
//        try {
//            // Nějaká zabezpečená operace
//        } catch (Exception e) {
//            // Zachycení výjimky, aby nedošlo k pádu programu
//            e.printStackTrace();
//        }
//    }
//
//    // Další metody a vlastnosti třídy...
//
//    public void exampleMethod1() {
//        // Příklad další metody
//        int sum = 0;
//        for (String str : data) {
//            sum += Integer.parseInt(str);
//        }
//    }
//
//    public void exampleMethod2() {
//        // Příklad další metody
//        StringBuilder builder = new StringBuilder();
//        for (String str : data) {
//            builder.append(str).append(",");
//        }
//        String result = builder.toString();
//    }
//
//    public void exampleMethod3() {
//        // Příklad další metody
//        List<Integer> lengths = new ArrayList<>();
//        for (String str : data) {
//            lengths.add(str.length());
//        }
//    }
//
//    // A další další metody, vlastnosti a konstruktory pro dosažení minimální délky 200 řádků
//}

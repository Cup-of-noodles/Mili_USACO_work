import java.util.*;
import java.io.*;
//import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\milij\\School CS work 25-26\\shedletskyTits\\tittes\\src\\cowsCrossing.txt");
        //System.out.println(); 
        cowsCrossing(file);
    }
    

    public static int[][] largestLocal(int[][] grid) {
        int[][] toReturn = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < grid.length; i += ()){

        }

        return toReturn;
    }




    public static void cowsCrossing(File file) throws FileNotFoundException{
        int toReturn = 0;

        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();

        Set<String> alreadySeen = new HashSet<>();

        for (int i = 0; i < line.length() - 1; i += 2){
            
            //System.out.println(line.charAt(i) != line.charAt(i + 1));
            if (line.charAt(i) != line.charAt(i + 1) && !alreadySeen.contains(line.substring(i, i + 2))){
                
                alreadySeen.add(line.substring(i, i + 2));
                //System.out.println("kill youself");
                //System.out.println(line.substring(i, i + 2));
            }
            else if(line.charAt(i) != line.charAt(i + 1) && alreadySeen.contains(line.substring(i, i + 2))){
                toReturn++;
            }
        }

        System.out.println(toReturn);
    }



    public static void threeLogos(File file){
        
        int area = 0;

        int length = 0;
        ArrayList<int[]> pairs = new ArrayList<>();

       try (Scanner scanner = new Scanner(file)) {
            
            // Loop runs as long as there is another line to read
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                Scanner christine = new Scanner(line);
                christine.useDelimiter(" ");
            
                
                while (christine.hasNext()){

                    int first = Integer.parseInt(christine.next());
                    int second = Integer.parseInt(christine.next());
                    pairs.add(new int[] {first, second});
                    area += (first * second);
                }
                
                
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file could not be found.");
            e.printStackTrace();
        }
        if (Math.sqrt( Double.valueOf(area) )  % 1 != 0){
            System.out.println("fuck you"); return;
        }
        else{
            String chars = "ABC";
            int numberJesus = (int) Math.sqrt(Double.valueOf(area));

            for (int i = 0; i < chars.length(); i++){
                int prod = pairs.get(i)[0] * pairs.get(i)[1];
                int sideln = prod / numberJesus;
                //System.out.println(sideln);

                for (int y = 0; y < sideln; y++){
                    for (int z = 0; z < numberJesus; z++){
                        System.out.print(chars.charAt(i) + " ");
                    }
                    System.out.println();
                }
            }
        }
        
        
    }

    

    
    



    public static void sumOf2Numbers(File file) {
        int i = 0;
        int suppposedSum = 0;
        int length = 0;
        int[] twoNumbs = new int[] {-1,-1};

       try (Scanner scanner = new Scanner(file)) {
            
            // Loop runs as long as there is another line to read
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                if (i == 0){
                    //potentialMoos = Integer.parseInt(line);
                    Scanner scany = new Scanner(line);

                    scany.useDelimiter(" ");
                    int x = 0;
                    while (scany.hasNext()){
                        String current = scany.next();
                        //System.out.println(current + " " + x);
                        if (x == 0){
                            length = Integer.parseInt(current);
                        }
                        if (x == 1){
                            suppposedSum = Integer.parseInt(current);
                        }
                        x++;
                    }
                    scany.close();
                    //System.out.println(suppposedSum);

                }
                else{
                    for (int x = 0; x < length * 2; x += 2){
                        //System.out.println();
                        for (int y = 0; y < length * 2; y += 2){
                            if (y != x && x + y == suppposedSum){
                                twoNumbs[0] = x/2;
                                twoNumbs[1] = y/2;
                            }
                        }
                    }
                }
                
                i++;
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file could not be found.");
            e.printStackTrace();
        }

         if (twoNumbs[0] == -1){
            System.out.println("FUCK YOU");
         }
         else{
            
            System.out.println(twoNumbs[0] + " " + twoNumbs[1]);
         }
    }


    public char repeatedCharacter(String s) {
        
        Map<Character, Integer> moeletsky = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if (!(moeletsky.containsKey(s.charAt(i)))){
                moeletsky.put(s.charAt(i), 1);
            }
            else {
                int count = moeletsky.get(s.charAt(i));
                 moeletsky.remove(s.charAt(i));
                 moeletsky.put(s.charAt(i),count + 1);
                // if it now appears twice
                 if (moeletsky.get(s.charAt(i)) == 2){
                    return s.charAt(i);
                 }
            }

        }
        
        return 'a';
    }


    public static int maxFrequencyElements(int[] nums) {
        int maxOccurences = 0;
        int numOfMaxOccurences = 0;
        Map<Integer, Integer> numsAndOccurences = new HashMap<>();

        //get frequencies of the numbers
        for (int i = 0; i < nums.length; i++){
            //if nums and occurences doesnt have the key, then add it in with ONE occurence
            if (!(numsAndOccurences.containsKey(nums[i]))){
                numsAndOccurences.put(nums[i], 1);
            }
            //otherwise, update the frequency of this alreaddy ofund number
            else{
                 int count = numsAndOccurences.get(nums[i]);
                 numsAndOccurences.remove(nums[i]);
                 numsAndOccurences.put(nums[i],count + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : numsAndOccurences.entrySet()) {
            //System.out.println(entry.getKey() + ": " + entry.getValue());
            if (entry.getValue() > maxOccurences){
                
                maxOccurences = entry.getValue();
                //wipe number of max occuerences
                numOfMaxOccurences = 0;

            }
            //if this value
            if (entry.getValue() == maxOccurences){
                numOfMaxOccurences++;
            }

        }
        
        return numOfMaxOccurences;
    }

    public static int percentageLetter(String s, char letter) {
        double brighteyes = 0;
        double temu = 0;

        
        for (int i = 0; i < s.length(); i++){
            
            if (s.charAt(i) == letter){
                temu++;
                brighteyes = temu / s.length();
            }

        }
        System.out.println(brighteyes);
        return (int) (brighteyes * 10);
    }


       
}

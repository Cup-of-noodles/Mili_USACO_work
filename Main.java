import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws FileNotFoundException {
        File file = new File("input");
        bovineShuffle(file);

    }
    //solution for this problem
    //https://usaco.org/index.php?page=viewproblem2&cpid=760
    public static void bovineShuffle(File file)throws FileNotFoundException{



        int i = 1;
        ArrayList<Integer> indices = new ArrayList<>();
        ArrayList<String> items = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Scanner gay = new Scanner(line);
                gay.useDelimiter(" ");

                if (i == 2){
                    while (gay.hasNext()){
                        indices.add(Integer.parseInt(gay.next()));
                    }
                }

                else if (i == 3) {
                    while (gay.hasNext()) {
                        items.add(gay.next());
                    }
                }
                i++;
            }
        }

        String[] finalDisplay = new String[indices.size()];

        for (int c = 0; c < indices.size(); c++){
            finalDisplay[indices.get(c) - 1] = items.get(c);
        }

        for (String item : finalDisplay){
            System.out.println(item);
        }
    }


    //DO NOT DELETE
    public static int lostCow(int x, int y){
        int distance = 0;
        int position = 0;

        int i = 1;
        int mult = 1;

        while (!(position >= y)){
            position = x + (mult) * i;
            System.out.println(distance);

            if (i > 1){
                distance += Math.abs((position) - (x + (-1 * mult) * (i/2)));
            }
            else {
                distance += i;
            }
            i *= 2;
            mult *= -1;
        }

        if (position > y){
            distance -= (position - y);
        }
        return distance;
    }



}

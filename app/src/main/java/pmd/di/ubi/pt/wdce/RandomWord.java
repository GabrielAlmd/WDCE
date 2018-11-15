package pmd.di.ubi.pt.wdce;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class RandomWord {

    public String selectRadomWordFromFile() throws FileNotFoundException{

        Scanner s = new Scanner(new File("WDCE\\app\\src\\main\\java\\pmd\\di\\ubi\\pt\\wdce\\wordlist.txt"));
        ArrayList<String> listS = new ArrayList<String>();

        while (s.hasNextLine())
            listS.add(s.nextLine());


        //gera um numero random
        int index = (int) (Math.random() * listS.size());
        //manda o que esta no index x da lista

        String palavra = listS.get(index);
        System.out.println(palavra);

        return (palavra);
    }

}

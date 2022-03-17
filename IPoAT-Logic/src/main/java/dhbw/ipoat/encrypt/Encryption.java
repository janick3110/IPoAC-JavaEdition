package dhbw.ipoat.encrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to encrypt a string with the award-winning matrix encryption
 */
public abstract class Encryption {
    private static final int[][] encryptingArray = new int[16][16];
    private static final int chunkSize = 16;
    private static final int seedLength = 2048;

    private static void setupEncryptingArray(){
        int counter = 0;

        for (int i = 0; i < encryptingArray.length; i++) {
            for (int j = 0; j < encryptingArray.length; j++) {
                encryptingArray[i][j] = counter;
                counter++;
            }
        }
    }

    public static String doEncryption(String string, int seed){
        setupEncryptingArray();

        StringBuilder output = new StringBuilder();
        int counter = 0;
        char c;


        for (char character:string.toCharArray()
             ) {
            if (counter%chunkSize==0){
                String seedString = generateSeed(seed);
                swapAxis(true,seedString);
                swapAxis(false,seedString);
                output.append(seedString);
            }
            counter++;
            for (int x = 0; x < encryptingArray.length; x++) {
                for (int y = 0; y < encryptingArray.length; y++) {
                    c = (char) encryptingArray[x][y];
                    if (c == character){
                        output.append(String.format("%02d", x)).append(String.format("%02d", y));
                    }
                }
            }

        }
        return output.toString();
    }

    public static String doDecrypting(String encryptedText){
        setupEncryptingArray();

        StringBuilder output = new StringBuilder();


        List<String> seeds = new ArrayList<>();
        List<String> encodedText = new ArrayList<>();
        int seedOffset = seedLength * 2;
        int chunkOffset = chunkSize * 4;

        String txt = encryptedText;

        while (!txt.equals("")){
            seeds.add(txt.substring(0,seedOffset));
            encodedText.add(txt.substring(seedOffset, seedOffset + chunkOffset));
            txt = txt.substring(seedOffset+chunkOffset);
        }


        for (int i = 0; i < seeds.size(); i++) {
            swapAxis(true, seeds.get(i));
            swapAxis(false, seeds.get(i));

            String textToDecrypt = encodedText.get(i);
            while(!textToDecrypt.equals("")){
                output.append(decryptCharacter(textToDecrypt.substring(0,4)));
                textToDecrypt = textToDecrypt.substring(4);

            }
        }

        return output.toString();
    }

    private static char decryptCharacter(String segment){
        int x = Integer.parseInt(segment.substring(0,2));
        int y = Integer.parseInt(segment.substring(2,4));
        char output = (char) encryptingArray[x][y];
        return output;
    }

    private static String generateSeed(int seed){
        StringBuilder output = new StringBuilder();
        Random generator = new Random(seed);
        for (int i = 0; i < seedLength; i++) {
            int random = (int) Math.abs((generator.nextFloat() * ((encryptingArray.length-1) - 1)) + 1);
            output.append(String.format("%02d", random));
        }
        return output.toString();
    }

    private static void swapAxis(boolean horizontal, String seed){

        for (int i = 0; i < seed.length(); i += 2) {
            String temp = seed.substring(i,i+2);
            int axisVal = Integer.parseInt(temp);

            if (axisVal > 0 && axisVal < encryptingArray.length){
                if (horizontal){
                    int[] tempArray = encryptingArray[axisVal-1];
                    encryptingArray[axisVal - 1] = encryptingArray[axisVal+1];
                    encryptingArray[axisVal + 1] = tempArray;
                } else{
                    int[] tempArray = new int[encryptingArray.length];
                    for (int j = 0; j < encryptingArray.length; j++) {
                        tempArray[j] = encryptingArray[j][axisVal - 1];
                    }

                    for (int j = 0; j < encryptingArray.length; j++) {
                        encryptingArray[j][axisVal - 1] = encryptingArray[j][axisVal + 1];
                        encryptingArray[j][axisVal + 1] = tempArray[j];
                    }

                }
            }
        }
    }


}

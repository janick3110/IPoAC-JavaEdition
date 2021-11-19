package dhbw.ipoac.encrypt;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to encrypt a string with the award-winning matrix encryption
 */
public abstract class Encryption {
    private static final int[][] encryptingArray = new int[16][16];
    private static final int chunkSize = 16;
    private static final int seedLength = 2048;

    public static void setupEncryptingArray(){
        int counter = 0;

        for (int i = 0; i < encryptingArray.length; i++) {
            for (int j = 0; j < encryptingArray.length; j++) {
                encryptingArray[i][j] = counter;
                counter++;
            }
        }



        //buildOutput();
        //doEncryption(text);
        //doDecrypting(doEncryption(text));
    }

    public static String doEncryption(String string){
        setupEncryptingArray();
        //generate every 16 Chars a new seed
        //swap axis
        //apply to text
        StringBuilder output = new StringBuilder();
        int counter = 0;
        char c;


        for (char character:string.toCharArray()
             ) {
            if (counter%chunkSize==0){
                String seed = generateSeed();
                swapAxis(true,seed);
                swapAxis(false,seed);
                output.append(seed);
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
        //buildOutput();
        return output.toString();
    }

    public static String doDecrypting(String encryptedText){
        setupEncryptingArray();

        StringBuilder output = new StringBuilder();


        List<String> seeds = new ArrayList<>();
        List<String> encodedText = new ArrayList<>();
        int seedOffset = seedLength * 2;
        int chunkOffset = chunkSize * 4;

        //05021406
        String txt = encryptedText;

        while (!txt.equals("")){
            if (txt.length() < seedOffset + chunkOffset){
                seeds.add(txt.substring(0,seedOffset));
                encodedText.add(txt.substring(seedOffset));
                break;
            } else{
                seeds.add(txt.substring(0,seedOffset));
                encodedText.add(txt.substring(seedOffset, seedOffset + chunkOffset));
            }
            txt = txt.substring(seedOffset+chunkOffset);
        }

        /*for (String seedVal:seeds
             ) {
            swapAxis(true,seedVal);
            swapAxis(false,seedVal);
        }*/
        //buildOutput();

        StringBuilder bob = new StringBuilder();
        for (String s:encodedText
             ) {
            bob.append(s);
        }

        for (int i = 0; i < seeds.size(); i++) {
            swapAxis(true, seeds.get(i));
            swapAxis(false, seeds.get(i));

            String textToDecrypt = encodedText.get(i);
            while(!textToDecrypt.equals("")){
                if (textToDecrypt.length() < 4){
                    output.append(decryptCharacter(textToDecrypt));
                    textToDecrypt = "";
                } else{
                    output.append(decryptCharacter(textToDecrypt.substring(0,4)));
                    textToDecrypt = textToDecrypt.substring(4);
                }

            }
        }


        /*for (char c: encryptedText.toCharArray()
             ) {
            if (seed && counter == seedLength * 2){
                seed = false;
                swapAxis(true,seedTxt.toString());
                swapAxis(false,seedTxt.toString());
                seedTxt.setLength(0);
                counter = 0;
            } else if(seed && counter < seedLength * 2){
                seedTxt.append(c);
                counter++;
            } else if (!seed && counter == chunkSize * 6){
                counter = 0;
                seed = true;
            } else if(!seed && counter < chunkSize * 6){
                encryption.append(c);
                counter++;

            }


        }*/


        return output.toString();
    }

    private static char decryptCharacter(String segment){
        int x = Integer.parseInt(segment.substring(0,2));
        int y = Integer.parseInt(segment.substring(2,4));
        //System.out.println(x + "|" + y);
        char output = (char) encryptingArray[x][y];
        return output;
    }

    private static String generateSeed(){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < seedLength; i++) {
            int random = (int) ((Math.random() * ((encryptingArray.length-1) - 1)) + 1);
            output.append(String.format("%02d", random));
        }
        //05021406
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

    private static void buildOutput(){
        String output = "";
        for (int[] ints : encryptingArray) {
            String line = "";
            for (int j = 0; j < encryptingArray.length; j++) {
                line += "[" + String.format("%03d", ints[j]) + "|" + Character.toString(ints[j]) + "]";
            }
            line += "\n";
            output += line;
        }
        System.out.println("Ausgabe: " + output);
    }

}

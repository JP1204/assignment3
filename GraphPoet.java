/* EE422C Assignment #3 submission by
 * <Jimmy Phan>
 * <jp54694>
 */

package assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.*;

public class GraphPoet {


    /**
     *
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */

    private Map<String, Vertex<String>> map;    // holds vertices

    public GraphPoet(File corpus) throws IOException {

        /* Read in the File and place into graph here */
        Scanner scan = new Scanner(corpus);
        ArrayList<ArrayList<String>> sentences = new ArrayList<>();

        // add all words into ArrayList
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            ArrayList<String> sentence = new ArrayList<>();
            String[] sentence_arr = line.split(" ");
            for(String word : sentence_arr){
                sentence.add(word);
            }
            sentences.add(sentence);
        }
/*
        for(ArrayList<String> sentence : sentences){
            for(String word : sentence){
                System.out.println(word);
            }
        }
*/
        // place all words into a hashmap to construct affinity graph
        // only one vertex for each word
        map = new HashMap<>();
        for(ArrayList<String> sentence : sentences){
            for(int i = 0; i < sentence.size(); i++){
                int lastWord = sentence.size()-1;
                String word = sentence.get(i);

                if(!map.containsKey(word)){
                    Vertex<String> v = new Vertex<>(word);

                    // update edges
                    Map edges = v.getEdges();
                    if(i != lastWord){  // last word has no outgoing edge
                        String nextWord = sentence.get(i+1);
                        System.out.println(word + " -> " + nextWord);

                        edges.put(nextWord, 1);
                    }
                    v.setEdges(edges);

                    // enter vertex into hashmap
                    map.put(word, v);
                }
                else{
                    // update weights on edges if vertex already exists
                    Vertex v = map.get(word);

                    Map edges = v.getEdges();
                    if(i != lastWord) {
                        String nextWord = sentence.get(i+1);
                        // System.out.println(word + " -> " + nextWord);
                        if(edges.containsKey(nextWord)) {
                            // increment weight
                            edges.put(nextWord, (Integer) edges.get(word) + 1);
                        }
                        else{
                            System.out.println("putting next word + " + nextWord);
                            edges.put(nextWord, 1);
                        }
                    }
                    v.setEdges(edges);
                    map.put(word, v);
                }
            }
        }

        System.out.println();
        for(Vertex vertex : map.values()){
            System.out.println("word is : " + vertex.getName());
            Map edges = vertex.getEdges();
            edges.forEach((k, v) -> System.out.println("weights: " + k + " " + v));
        }



    }

    /**
     * Generate a poem.
     *
     * @param input File from which to create the poem
     * @return poem (as described above)
     */
    public String poem(File input) throws IOException {

        /* Read in input and use graph to complete poem */
        String poem = "";
        System.out.println("\nIn the poem function");

        Scanner scan = new Scanner(input);
        ArrayList<ArrayList<String>> sentences = new ArrayList<>();

        // add all words into ArrayList
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            ArrayList<String> sentence = new ArrayList<>();
            String[] sentence_arr = line.split(" ");
            for(String word : sentence_arr){
                sentence.add(word);
            }
            sentences.add(sentence);
        }


        return poem;
    }

}

package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AhoCorasick {
    TrieNode root;

    public AhoCorasick (String... words) {
        root = new TrieNode();

        for (String word : words){
            insert(word);
        }
        setupSuffixLinks(null, root);
    }

    private void insert(String word){
        TrieNode node = root;
        int i=0;
        for (; i<word.length()-1; i++){
            char c = word.charAt(i);
            int index = getIndexOf(c);
            if (node.letters[index] == null){
                node.letters[index] = new TrieNode(c);
            }
            node = node.letters[index];
        }
        char c = word.charAt(i);
        node.letters[getIndexOf(c)] = new TrieNode(c, word);
    }

    private void setupSuffixLinks(TrieNode parent, TrieNode node){
        if (node == null){
            return;
        }
        else if (node == root){
            node.suffixLink = root;
        }
        else {
            node.suffixLink = getSuffixLink(parent, node.data);
        }
        for (TrieNode letter : getNullFilteredChildren(node)) {
            setupSuffixLinks(node, letter);
        }
    }

    private TrieNode getSuffixLink(TrieNode parent, char nodeData){
        TrieNode suffixLink = parent.suffixLink.letters[getIndexOf(nodeData)];
        return parent==root || suffixLink==null ? root : suffixLink;
    }

    private static int getIndexOf(char c){
        return c-'a';
    }

    private static TrieNode[] getNullFilteredChildren(TrieNode node){
        return Arrays.stream(node.letters)
                .filter(Objects::nonNull)
                .toArray(TrieNode[]::new);
    }

    public void printTrie(){
        TrieNode node = root;
        printTrie(node);
    }

    private void printTrie(TrieNode node){
        if (node.letters.length != 0){
            printLetters(node);
        }
        printTrie(getNullFilteredChildren(node));
    }

    private void printTrie(TrieNode[] nodes){
        for (TrieNode node : nodes){
            printTrie(node);
        }
    }

    private void printLetters(TrieNode node){
        System.out.print(node.data+"->");
        Arrays.stream(getNullFilteredChildren(node)).forEach(System.out::print);
        System.out.println();
    }

    public Set<String> process (String phrase){
        Set<String> foundWords = new HashSet<>();

        TrieNode node = root;
        int index;
        for (int i=0; i<phrase.length();) {
            index = getIndexOf(phrase.charAt(i));

            if(node.letters[index]!=null){
                node = node.letters[index];
            }
            else if (node.suffixLink.letters[index]!=null){
                node = node.suffixLink.letters[index];
            }

            i++;
            if (node.isOutput){
                foundWords.add(node.word);
            }
        }

        return foundWords;
    }

    public static void main(String[] args) {
        String[] words = {"urvashi", "yo", "honey", "huzur"};
        AhoCorasick ahoCorasick = new AhoCorasick(words);
        ahoCorasick.printTrie();

        System.out.print(ahoCorasick.process("honeyourvashishigh"));
    }

    private static class TrieNode{
        char data;
        TrieNode[] letters;
        boolean isOutput;
        TrieNode suffixLink;
        TrieNode outputLink;
        String word;

        private static final String trieString = "(%c,%b,%s,*%c)";

        TrieNode(){
            data = '$';
            letters = new TrieNode[26];
            isOutput = false;
            suffixLink = null;
            outputLink = null;
            word = null;
        }

        TrieNode(char data){
            this.data = data;
            letters = new TrieNode[26];
            isOutput = false;
            suffixLink = null;
            word = null;
            outputLink = null;
        }

        TrieNode(char data, String word){
            this.data = data;
            letters = new TrieNode[26];
            isOutput = true;
            suffixLink = null;
            outputLink = null;
            this.word = word;
        }

        @Override
        public String toString() {
            return String.format(trieString, data, isOutput, word, suffixLink.data);
        }
    }
}

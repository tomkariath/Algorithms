package dataStructures;

import java.util.HashMap;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char character : word.toCharArray()){
            if (currentNode.characterMap.get(character) == null){
                currentNode.characterMap.put(character, new TrieNode());
            }

            currentNode = currentNode.characterMap.get(character);
        }

        currentNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char character : word.toCharArray()){
            if (currentNode.characterMap.get(character) == null){
                return false;
            }

            currentNode = currentNode.characterMap.get(character);
        }

        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char character : prefix.toCharArray()){
            if (currentNode.characterMap.get(character) == null){
                return false;
            }

            currentNode = currentNode.characterMap.get(character);
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class TrieNode {
    HashMap<Character, TrieNode> characterMap;
    boolean isWord;

    public TrieNode() {
        characterMap = new HashMap<>();
        isWord = false;
    }
}

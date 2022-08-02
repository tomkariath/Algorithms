package dataStructures;

public class ArrayTrie {

    Node root;

    public ArrayTrie(){
        root = new Node();
    }

    public void insert(String word){
        Node currentNode = root;

        for (char a : word.toCharArray()){
            if (currentNode.getAlphabetNode(a) == null){
                currentNode.setAlphabetNode(a, new Node());
            }

            currentNode = currentNode.getAlphabetNode(a);
        }

        currentNode.isWord = true;
    }

    public boolean search(String word){
        Node currentNode = root;

        for (char a : word.toCharArray()){
            if (currentNode.getAlphabetNode(a) == null){
                return false;
            }

            currentNode = currentNode.getAlphabetNode(a);
        }

        return currentNode.isWord;
    }

    public boolean startsWith(String word){
        Node currentNode = root;

        for (char a : word.toCharArray()){
            if (currentNode.getAlphabetNode(a) == null){
                return false;
            }

            currentNode = currentNode.getAlphabetNode(a);
        }

        return true;
    }

    private static class Node {
        Node[] alphabets;
        boolean isWord;

        public Node(){
            alphabets = new Node[26];
            isWord = false;
        }

        private Node getAlphabetNode(char a){
            return alphabets[a - 'a'];
        }

        private void setAlphabetNode(char a, Node node){
            alphabets[a - 'a'] = node;
        }
    }

    public static void main(String[] args) {
        ArrayTrie trie = new ArrayTrie();
        trie.insert("apple");
        trie.insert("security");
        trie.insert("academy");
        System.out.println(trie.search("apple")); //true
        System.out.println(trie.search("app")); // false - Not a word
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); //true
        System.out.println(trie.search("secure")); //false
        System.out.println(trie.search("security")); //true
        System.out.println(trie.startsWith("aca")); //true
    }
}
